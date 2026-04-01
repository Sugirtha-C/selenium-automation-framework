# Selenium Automation Projects

## Overview

This repository contains Selenium WebDriver automation work, including **practice exercises** and **three key projects**:

1. **Selenium Automation (BDD + TestNG Framework)**

   * Scalable automation framework built using **Selenium WebDriver, Cucumber (BDD), and TestNG**
   * Well-structured architecture with clear separation of concerns:

     * `base` → WebDriver management using DriverFactory
     * `config` → Configuration handling via ConfigReader
     * `pages` → Page Object Model (POM) implementation
     * `utils` → Reusable utilities (WaitUtil, JsonUtil, ScreenshotUtil, ExtentReports)
     * `stepdefinitions` → Cucumber step definitions
     * `tests` → TestNG test classes
     * `hooks` → Setup and teardown logic
     * `features` → BDD feature files
     * `testdata` → JSON-based test data
   * Supports both **BDD execution (Cucumber)** and **TestNG execution**
   * Implements:

     * Page Object Model (POM)
     * Data-driven testing (JSON & DataProvider)
     * ThreadLocal for parallel execution
     * Exception handling and reporting
     * Dynamic element handling and browser validation handling
   * 📂 [Project Code](./selenium_automation)

2. **EMI Calculator (Capstone Project)**

   * Automated EMI calculator website
   * Framework built using **Selenium WebDriver + TestNG + Page Object Model (POM)**
   * Data-driven with Excel; screenshots captured on failure
   * 📂 [Project Code](./emi_calculator_capstone)

3. **Parabank Website (Hackathon Project)**

   * Automated online banking workflows
   * Hybrid framework using **TestNG + Cucumber (BDD)**
   * Includes feature files, POM classes, step definitions, utilities
   * 📂 [Project Code](./Parabank_Hackathon)

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Cucumber (BDD)
* Excel Utilities
* JSON Data Handling
* TestNG Listeners

## Structure

* `/practice` → training and practice scripts
* `/selenium_automation` → BDD + TestNG automation framework
* `/emi_calculator_capstone` → Capstone project
* `/parabank_hackathon` → Hackathon project

---
