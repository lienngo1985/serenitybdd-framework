## **Serenity BDD Framework project**

This is the simplest possible build script setup for Serenity BDD using Java.

This is a very minimal sample project done on Amazon site, using JUnit and Serenity BDD in Java. You can use this project as a quick starting point for your own projects.

### Get Prepared
- **Java** (http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed.
- **An Integrated Development Environment**. You will need a modern IDE to work with Java.  IntelliJ or Eclipse.
- **A Build Tool**. You will also need a build tool, I used Maven, to run your tests and generate your reports.
Make sure you have [Maven 3.3.x or higher](https://maven.apache.org/download.cgi) installed.

### Usage
- **Supported Platforms** - Windows, Mac
- **Supported Platforms** - Chrome (version 86), Firefox (latest version)
**Known Issues on macOS 10.15 (Catalina)** - Due to the requirement from Apple that all programs must be notarized, geckodriver will not work on Catalina if you manually download it through another notarized program, such as Firefox.

### Get the code
Git:
git clone https://github.com/lienngo1985/serenitybdd-framework.git

### Run First Test
###### Use Maven
Open a command window and run:
mvn clean verify

###### Run From IDE
- Change desired browser in src\test\resources\serenity.conf
- Run the test in src\test\java\net\serenitybdd\screenplay\amazon\integration

### Viewing the reports
Both of the commands provided above will produce a Serenity test report in the target/site/serenity directory. Go take a look!
