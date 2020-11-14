## **Serenity BDD Framework project**

This is the simplest possible build script setup for Serenity BDD using Java.

This is a very minimal sample project done on Amazon site as example, using JUnit and Serenity BDD in Java. You can use this project as a quick starting point for your own projects.

#### Get the code
Git:
git clone https://github.com/lienngo1985/serenitybdd-framework.git

#### Run First Test
###### Use Maven
Open a command window and run:
mvn clean verify

###### Run From IDE
Change desired browser in src\test\resources\serenity.conf
Run the test in src\test\java\net\serenitybdd\screenplay\amazon\integration

#### Viewing the reports
Both of the commands provided above will produce a Serenity test report in the target/site/serenity directory. Go take a look!
