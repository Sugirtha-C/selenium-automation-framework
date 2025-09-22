# EMI Calculator – Capstone Project

## 📌 Overview
Automated testing of the **EMI Calculator web application** using a custom framework built on **Selenium WebDriver + TestNG + Page Object Model (POM)**.  

## 🛠️ Tech Stack
- Java  
- Selenium WebDriver  
- TestNG  
- Page Object Model (POM)  
- Excel for test data  
- TestNG Listeners for reports/screenshots  

## 🚀 Features
- **Data-driven testing**: inputs (loan amount, interest, tenure) from Excel.  
- **Page Object Model**: reusable, modular design.  
- **TestNG annotations** for setup/teardown.  
- **Automatic screenshots** on failure.  
- Centralized test reports generated after execution.  

## 📂 Structure
- `/pages` → Page Object classes (locators, actions)  
- `/tests` → Test classes with TestNG annotations  
- `/utils` → Excel reader + config utilities  
- `/screenshots` → Captured on failure  

## 🔗 How to Run
1. Clone repo.  
2. Import into Eclipse/IntelliJ.  
3. Run via TestNG XML suite file.  

---
