
# Selenium Automation Framework (BDD + TestNG)

##  Overview
This project demonstrates a scalable automation framework built using Selenium WebDriver, Cucumber (BDD), and TestNG.

---
## Framework Structure

```text
src/main/java
├── base
│   └── DriverFactory (WebDriver management)
├── config
│   └── ConfigReader (properties handling)
├── pages
│   └── Page classes (POM)
├── utils
│   └── Utilities (WaitUtil, JsonUtil, ScreenshotUtil, ExtentManager)

src/test/java
├── stepdefinitions
│   └── Cucumber step definitions
├── tests
│   └── TestNG test classes
├── hooks
│   └── Setup and teardown

src/test/resources
├── features
│   └── Feature files (BDD scenarios)
├── testdata
│   └── JSON test data
```

## ⚙️ Configuration

Update `config.properties`:


browser=chrome; 
url=https://www.automationexercise.com/
---

## How to Run

### Run BDD Tests:
- Execute `TestRunner` class

### Run TestNG Tests:
- Run `RegistrationTest.java`

---

## Key Concepts Implemented

- Page Object Model (POM)
- Data-driven testing (JSON & DataProvider)
- Separation of concerns (test vs framework)
- Reusable utilities
- Exception handling & reporting
- Dynamic element handling
- Browser-level validation handling

---

## Learning Highlights

- Difference between BDD and TestNG execution
- Handling browser validations using `validationMessage`
- Using ThreadLocal for parallel execution
- Integrating reporting with automation frameworks
- Combining structured test data with UI automation

---

## Future Enhancements

- API automation using RestAssured
- Integration of UI + API validation
- Database validation layer
- CI/CD integration (Jenkins/GitHub Actions)

---

##  Author

**Sugirtha Chandrasekaran**  
Senior QA Engineer | Test Automation | Data Validation
