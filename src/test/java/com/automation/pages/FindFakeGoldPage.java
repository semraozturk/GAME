package com.automation.pages;

import com.automation.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class FindFakeGoldPage {

    public FindFakeGoldPage() { PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy ( id = "left_0") private WebElement firstLeftBox;
    @FindBy ( id = "right_0") private WebElement firstRightBox;
    @FindBy ( css = "#reset") private WebElement resultBox;

    private static String resultSign;
    private static String fakeGoldBarNumber;

    public void findFakeGoldBarNumber(){
        clickButton("Reset");   //just to make sure the grid is empty before starting
        fakeGoldBarNumber = "0";
        enterTextIntoWebElement(firstLeftBox, fakeGoldBarNumber);

        for(int i= 1; i <= 8 ; i++){
            enterTextIntoWebElement(firstRightBox,String.valueOf(i));
            clickButton("Weigh");
            resultSign = resultBox.getText();
            if(!resultSign.equals("=")){
                fakeGoldBarNumber = String.valueOf(i);
                break;
            }
        }

        fakeGoldBarNumber = resultSign.equals("<") ? "0" : fakeGoldBarNumber;
        System.out.println("Found the bar that weighs less than the others! The fake bar is number  " + fakeGoldBarNumber);
    }

    public void clickOnFakeGoldBarNumber(){
        clickButton(fakeGoldBarNumber);
    }

    public void validateResult(){
        Alert alert = Driver.getDriver().switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("alertMessage = " + alertMessage);
        alert.accept();
        List<String> weighings = Driver.getDriver().findElements(By.xpath("//li"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println("Weighings:" );
        weighings.forEach(System.out::println);

        Assert.assertEquals("Alert message verification failed!","Yay! You find it!",alertMessage);
    }

    public void clickButton(String text){
        Driver.getDriver().findElement(By.xpath("//button[.='" + text + "']")).click();
    }

    public void enterTextIntoWebElement(WebElement element, String number){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(number);
    }






}
