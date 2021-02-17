
Exercise Project Explanation:

For this exercise,
1. I created a new project using Maven and Java.
2. I created a CUCUMBER BDD framework from scratch for this exercise to prevent any issues such as compatibility, missing dependencies etc.    This way, the evaluator can simply clone the repo and run the test. Also, I wanted to show you how exactly I would do this task in a real    work environment.
3. In this project, I used Selenium, Cucumber,and Junit with Java.
4. To trigger the automation, I created the CucumberRunner class in the runners package, which is all you need to execute the test.


Exercise Approach Explanation:

I started by placing the first element(0) in the left box and then compared this one with all the other numbers one by one through a for-loop. So, my approach was to use the first element as a basis to compare as exact weights were not given.
To reduce test execution time, I put "break" keyword in the loop to terminate it as soon as the fake gold bar number is found. After this, I looked at the operator in the result to find out which one is less or more because 0 could be the fake one as well. That is why I used ternary to find out if the element in the right or left box is the fake one based on the operator in the result box.


How to run the test:
	Please run the CucumberRunner class located at src/test/java/com/automation/runners/CucumberRunner.java


