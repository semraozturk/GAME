
Exercise Project Explanation:

For this exercise,
1. I created a new project using Maven and Java.
2. I created a CUCUMBER BDD framework from scratch for this exercise to prevent any issues such as compatibility, missing dependencies etc.    I hope this way, the evaluator can simply clone the repo and run the test. Also, I wanted to show you how exactly I would do this task in a real work environment.
3. In this project, I used Selenium, Cucumber,and Junit for assertions.
4. I created one test scenario in a feature file located at src/test/resources/Features.
4. To trigger the automation, I created the CucumberRunner class in the runners package. Please find the CucumberRunner class inside  runners package and run the class to start test execution.
5. Please also go to the "FindFakeGoldPage" located at src/test/java/com/automation/pages/FindFakeGoldPage.java to see the code implementations for the automation.   

Exercise Approach Explanation:

I started by placing the first element(0) in the left box and then compared this one with all the other numbers one by one through a for-loop. So, my approach was to use the first element as a basis to compare as exact weights were not given.
To reduce test execution time, I put "break" keyword in the loop to terminate it as soon as the fake gold bar number is found. After this, I looked at the operator in the result to find out if 0 is less or more than the number on the right because 0 could be the fake one as well. Then, I used ternary as a final step to determine the fake gold bar number based on operator seen in the last weighing.


How to run the test:
	Please run the CucumberRunner class located at src/test/java/com/automation/runners/CucumberRunner.java


