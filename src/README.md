# Selenium Test Project README

## Overview
This Selenium test project is designed to automate testing of the website "https://www.saucedemo.com/v1/". It contains test cases for various scenarios, including user login, shopping cart functionality, and the checkout process.

## Prerequisites
Before running the tests, make sure you have the following prerequisites installed and set up on your system:

- Java Development Kit (JDK)
- Maven (for managing project dependencies)
- WebDriverManager for managing WebDriver binaries
- Google Chrome and ChromeDriver (for running tests in Chrome)
- TestNG for test execution
- ExcelReader for reading test data from an Excel file

## Project Structure
The project is organized into different packages:

- `Base` package contains the `BaseTest` class that sets up the WebDriver, initializes page objects, and provides common methods for test cases.
- `Pages` package contains page object classes for various pages of the website.
- `ExcelReader` is used to read test data from an Excel file.

## Test Cases
Test cases are divided into separate classes based on their functionality. The primary test classes are:

- `LoginTest` for testing user login functionality.
- `HomepageTest` for verifying various features on the homepage.
- `CartTest` for testing the shopping cart and checkout functionality.
- `CheckoutTest` for testing the checkout process.
- `CheckoutStepTwoTest` for the second step of the checkout process.
- `CheckoutCompleteTest` for verifying the completion of the purchase.

## Setup
1. Clone this project to your local machine.
2. Ensure you have the necessary prerequisites installed and configured.
3. Set up your project's dependencies using Maven.
4. Update the path to your Excel test data file in the `BaseTest` class.

## Running Tests
You can run the tests using TestNG. The test suite is preconfigured to execute all the test classes.

To run the tests, you can use your IDE's TestNG integration or execute the test suite from the command line.
