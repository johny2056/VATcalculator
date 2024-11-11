# VAT Calculator Tests
This project contains automated functional tests for the online VAT calculator at [http://www.calkoo.com/?lang=3&page=8](http://www.calkoo.com/?lang=3&page=8). The tests are written in Java using the Selenium, TestNG and Cucumber frameworks, following the Page Object Model (POM) design pattern.

## Prerequisites
- Java JDK 11 or higher
- Maven
- Google Chrome browser

## Running the Tests
1. clone the repository
   ```
   git clone https://github.com/johny2056/VATcalculator.git
   cd VATcalculator
   ```
2. install dependencies from pom file and run tests
   ```
   mvn clean install
   ```
3. run only tests
   ```
   mvn test
   ```

## Test case description
- TC1 - Basic VAT Calculation verifies correct gross and VAT amounts for a valid net input and VAT rate.
- TC5 - Negative Value Input confirms that a negative net amount prompts an error message.

## Contact
For any questions or issues, please contact jan.sliacky@gmail.com
