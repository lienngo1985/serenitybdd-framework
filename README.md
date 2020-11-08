#First Steps with Serenity BDD

##Java 8
(http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed.

##An Integrated Development Environment
You will need a modern IDE to work with Java.  IntelliJ or Eclipse.

##A Build Tool
You will also need a build tool, either Gradle or Maven, to run your tests and generate your reports.
Make sure you have either [Gradle 3.x or higher](http://www.gradle.org/downloads) or [Maven 3.3.x or higher](https://maven.apache.org/download.cgi) installed.

##Getting Started
The quickest way to create a new project is to take one of the starter projects on Github. You can find the starter project for JUnit at 
(https://github.com/serenity-bdd/serenity-junit-starter).

##You can clone this repository:
git clone https://github.com/serenity-bdd/serenity-junit-starter.git
cd serenity-junit-starter

Or simply [download a zip file from here] (https://github.com/serenity-bdd/serenity-junit-starter/archive/master.zip).

If you are using Maven, you can also create a new project using one of the Serenity [Maven Archetypes](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html).

##So far so good?
The starter project comes with a demo test that you can run. From the command line, run either
$ mvn clean verify
or
$gradle clean test
This should produce something like the following:
gradle clean testStarting a Gradle Daemon (subsequent builds will be faster)

#2. Maven Dependencies
To make use of Serenity with JUnit, we should include serenity-core and serenity-junit in the pom.xml:

<dependency>
    <groupId>net.serenity-bdd</groupId>
    <artifactId>serenity-core</artifactId>
    <version>1.2.5-rc.11</version>
</dependency>
<dependency>
    <groupId>net.serenity-bdd</groupId>
    <artifactId>serenity-junit</artifactId>
    <version>1.2.5-rc.11</version>
</dependency>

We also need serenity-maven-plugin to have reports aggregated from test results:

<plugin>
    <groupId>net.serenity-bdd.maven.plugins</groupId>
    <artifactId>serenity-maven-plugin</artifactId>
    <version>1.2.5-rc.6</version>
    <executions>
        <execution>
            <id>serenity-reports</id>
            <phase>post-integration-test</phase>
            <goals>
                <goal>aggregate</goal>
            </goals>
        </execution>
    </executions>
</plugin>

If we want Serenity to generate reports even if there's a test failure, add the following to the pom.xml:

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.20</version>
    <configuration>
        <testFailureIgnore>true</testFailureIgnore>
    </configuration>
</plugin>

#3. WebDriver Configuration
Reference: https://serenity-bdd.github.io/theserenitybook/latest/web-testing-in-serenity.html
Using the serenity.properties file
webdriver.driver=chrome
webdriver.gecko.driver=/path/to/my/geckodriver
webdriver.chrome.driver=/path/to/my/chromedriver
Create a serenity.conf file, which uses the Typesafe Config notation, and add this to your classpath (for example in src/test/resources).
drivers {
  windows {
    webdriver.chrome.driver = src/test/resources/webdriver/windows/chromedriver.exe
    webdriver.gecko.driver = src/test/resources/webdriver/windows/geckodriver.exe
  }
  mac {
    webdriver.chrome.driver = src/test/resources/webdriver/mac/chromedriver
    webdriver.gecko.driver = src/test/resources/webdriver/mac/geckodriver
  }
  linux {
    webdriver.chrome.driver = src/test/resources/webdriver/linux/chromedriver
    webdriver.gecko.driver = src/test/resources/webdriver/linux/geckodriver
  }
}
Using the command line
For Maven, use the -D option
mvn clean verify -Dwebdriver.driver=firefox
For Gradle, use the -P option:
gradle clean test -Pwebdriver.driver=firefox
Using the @Managed annotation
@Managed(driver = "firefox")
WebDriver driver;

#4. Screenplay Pattern
Using screenplay pattern with adding depency to pom.xml
<dependency>
   <groupId>net.serenity-bdd</groupId>
   <artifactId>serenity-screenplay</artifactId>
   <version>${serenity.version}</version>
   <scope>test</scope>
</dependency>
<dependency>
   <groupId>net.serenity-bdd</groupId>
   <artifactId>serenity-screenplay-webdriver</artifactId>
   <version>2.1.0</version>
</dependency>


