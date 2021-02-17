package com.automation.stepDefinitions;

import com.automation.pages.FindFakeGoldPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FakeGold_StepDefinitions {
    FindFakeGoldPage findFakeGoldPage = new FindFakeGoldPage();


    @When("user weighs bars and finds the one weighing less than others")
    public void user_weighs_bars_and_finds_the_one_weighing_less_than_others() {
        findFakeGoldPage.findFakeGoldBarNumber();
    }

    @When("clicks on the number of the fake bar in the numbers box")
    public void clicks_on_the_number_of_the_fake_bar_in_the_numbers_box() {
        findFakeGoldPage.clickOnFakeGoldBarNumber();
    }

    @Then("user should see \"Yay! You find it!” message on the screen")
    public void user_should_see_yay_you_find_it_message_on_the_screen() {
        findFakeGoldPage.validateResult();
    }





}
