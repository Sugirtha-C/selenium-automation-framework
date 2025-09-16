# Project Title

Home Loan EMI Calculator Automation using TestNG 

## Description

This project is designed to automate the Loan EMI Calculation using TestNG on the provided URL. 
It covers functionality for calculating the loan EMI with both valid and invalid inputs, and verifying the calculated EMI amount as the output.


## Installation Instructions

### Prerequisites

- Java
- Maven
- TestNG
- Apache POI
- Aventstack dependencies
- URL: https://emicalculator.net/

### Setup

1. Include all necessary dependencies in the `pom.xml` file.
2. Create the framework for the main source code, test source code, and test resources.

## Usage Instructions

### Running Tests

- The Home Loan EMI Calculation with valid and invalid inputs provided from Data Provider - using TestNG
- Use the test data sheet present under src/test/resources/testdata to update test data values as required.
- The test suite is ready to be used to run all the tests together.


### Test Cases

- **Home Loan Calculation**: Contains cases to calculate the Home loan EMI using TestNG. 
  - Case 1: Home Loan EMi calculation with Tenure as Months
  - Case 2: Home Loan EMi calculation with Tenure as Years
  - Case 3: Home Loan EMi calculation with Interest rate values
  - Case 4: Home Loan EMi calculation when browser is refreshed.


## Configuration

### Configuration Files

- `src/main/java/utilities`:
  - ExcelFile for test data input
  - Data Providers setup
  - Screenshot utilities


- `src/test/`:
  - Contains test cases
  - Folder for test reports
  - Folder for screenshots

### Environment Variables

No specific environment variables are required.

## Test Data

- Available in src/test/resources/testdata

## Project Structure

- `src/main/java/`
  - Config
        - Browser
        - ConfigReader
  - Pages
        - HomeLoanCalc for home loan page objects
              
  - Steps
        -Common Steps: To be used to access generic methofs
        - HomeLoanCalc Steps:This is specific to methods related to home loan calculation only
        
  - utilities                      
        - ExcelFile for test data input
        - Data Providers setup
        -Screenshot utility
 
 - `src/main/resources/`
 
    -config.properties 
        - property file to save variables with values which can be modified later here directly if required
        
- `src/test/java/`

  - Listeners
    -For writing test results to a file    
 
  - TestNgTests
        - Loan EMI CalculatorTests
          
- `src/test/resources`:
  - Screenshots, test data and test reports

## Contributing

Author: Sugirtha Chandrasekaran: For HomeLoan EMiCalculator Module

## Additional Information

- Explore validating other reports and graphs on the page.



