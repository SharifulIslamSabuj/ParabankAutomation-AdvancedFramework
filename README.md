# 📌 ParabankAutomation-AdvancedFramework

## 🚀 Overview

ParabankAutomation-AdvancedFramework is a scalable Selenium automation framework built using Java, Selenium WebDriver, TestNG, and Gradle.

It follows Page Object Model (POM) design pattern and includes advanced real-world automation features such as:

- ThreadLocal WebDriver for parallel execution
- ExtentReports integration for reporting
- Data-driven testing using Apache POI (Excel)
- Reusable utility and framework components

This framework is designed for real-world QA automation practice, interview preparation, and portfolio demonstration using the ParaBank demo application.

---

## 🧰 Tech Stack

- Java
- Selenium WebDriver 4
- TestNG
- Gradle
- ExtentReports 5
- Apache POI (Excel Data Driven Testing)
- WebDriverManager
- SLF4J Logging
- Lorem Ipsum Generator

---

## 🏗️ Framework Architecture

```text
com.parabank.parasoft
├── pages
│   ├── BasePage
│   ├── LoginPage
│   ├── RegisterPage
│   ├── OverviewPage
│   ├── OpenNewAccountPage
│   ├── RequestLoanPage
│   └── UpdateProfilePage
│
├── test
│   ├── BaseTest
│   ├── LoginTest
│   └── RegisterTest
│
├── report
│   ├── TestListener
│   ├── ReportManager
│   └── ReportTestManager
│
└── util
    ├── DriverManager
    └── ParaBankUtil

📁 Project Structure

src
└── test
    ├── java
    │   └── com.parabank.parasoft
    │       ├── pages
    │       ├── test
    │       ├── report
    │       └── util
    │
    └── resources
        ├── config.properties
        ├── data/ddt.xlsx
        └── testng.xml

⚡ Key Features

✅ Framework Design
Page Object Model (POM)
Clean separation of layers
Reusable base components

🔥 Parallel Execution Ready
ThreadLocal WebDriver implementation
TestNG parallel execution support
Fully thread-safe test execution

📊 Reporting
ExtentReports integration
Step-level logging
Screenshot capture on failure

📂 Data Driven Testing
Excel-based test data (Apache POI)
TestNG DataProvider integration

🌐 Cross Browser Support
Chrome
Firefox
Edge
Safari
Headless execution

🧪 Test Coverage
Login Functionality
User Registration (Hard Data + Dynamic Data + DDT)
Open New Account
Loan Request Process
Profile Update


▶️ How to Run

1️⃣ Clone Repository
git clone https://github.com/your-username/ParabankAutomation-AdvancedFramework.git

2️⃣ Import Project
Open IntelliJ IDEA / Eclipse
Import as Gradle Project

3️⃣ Configure Environment
baseUrl=https://parabank.parasoft.com/parabank/
username=sqa
password=sqa
browserName=chrome

4️⃣ Run Tests

Using Gradle:
./gradlew clean test
Using TestNG:
testng.xml

🧪 Parallel Execution
<suite name="ParaBank Suite" parallel="tests" thread-count="3">

📊 Reports

After execution, report is generated at:
/build/extentReport/Report.html

Includes:
Test execution status
Step-by-step logs
Failure screenshots

📸 Screenshots

Stored at:
/build/screenshots/

👨‍💻 Author
Md. Shariful Islam
SQA Automation Engineer
(Java | Selenium | TestNG | API Testing)

📌 Note

This project is built for:

Learning advanced automation framework design
Portfolio demonstration
QA interview preparation
