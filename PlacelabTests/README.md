# qamp-resources
QAmp code resources

QAmp Test Automation Setup

Before you start with this setup make sure that java is installed and you are familiar with git.

1. Maven
    * [Install Maven](https://maven.apache.org/install.html)

    * Check that maven is installed
    ```
    $ mvn --version
    ```
    * After Java and Maven are installed pull the example code from github and build it using:
    ```
    $ mvn clean install
    ```

2. Selenium and TestNG

* Check that Selenium and TestNG dependencies are added to pom.xml:


### Running Tests

Run tests:
	```
	$ mvn clean verify -Pserial
	```