# 📌 ParabankAutomation-AdvancedFramework

## 🚀 Overview

ParabankAutomation-AdvancedFramework is a Selenium automation framework built using Java, Selenium WebDriver, TestNG, and Gradle, targeting the ParaBank demo application.

It follows the Page Object Model (POM) design pattern and includes:

- ThreadLocal WebDriver management for thread-safe parallel execution
- ExtentReports integration for HTML reporting
- Data-driven testing using Apache POI (Excel)
- Reusable page object and utility components

This project is built for QA automation practice, interview preparation, and portfolio demonstration.

---

## 🧰 Tech Stack

- Java
- Selenium WebDriver 4
- TestNG
- Gradle
- ExtentReports 5 (primary HTML report)
- Apache POI (Excel-driven data tests)
- WebDriverManager
- Allure TestNG (raw result capture only — see Reporting section below)
- Lorem Ipsum Generator (dynamic test data)

---

## 🏗️ Framework Architecture

```text
com.parabank.parasoft
├── pages
│   ├── Page
│   ├── BasePage
│   ├── LoginPage
│   ├── RegisterPage
│   ├── OverviewPage
│   ├── OpenNewAccountPage
│   ├── OpenedAccountPage
│   ├── RequestLoanPage
│   ├── ApprovedLoanPage
│   └── UpdateProfilePage
│
├── test
│   ├── BaseTest
│   ├── LoginTest
│   └── RegisterTest
│
├── report
│   ├── ReportManager
│   ├── ReportTestManager
│   └── TestListener
│
└── util
    ├── DriverManager
    └── ParaBankUtil
```

---

## 📁 Project Structure

```text
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
```

---

## ⚡ Key Features

### Framework Design
- Page Object Model (POM) with fluent, chainable page methods
- Clean separation of pages, tests, reporting, and utilities

### Parallel Execution
- ThreadLocal-based WebDriver management (`DriverManager`)
- TestNG parallel execution (`parallel="tests"`, `thread-count="3"` in `testng.xml`)

### Reporting
- ExtentReports: step-level logs and failure screenshots embedded per test
- Allure: raw result files generated on every run (see Reporting section below)

### Data-Driven Testing
- Excel-based test data via Apache POI
- TestNG `@DataProvider` integration
- Dynamically generated data via Lorem Ipsum

### Cross-Browser Support
- Chrome, Firefox, Edge, Safari
- Headless Chrome and headless Firefox

### Test Reliability
- TestNG retry analyzer (`RetryAnalyzer` + `RetryAnnotationTransformer`): automatically retries a failed test once, applied globally with no per-test annotation needed
- Retry attempts are logged to both console output and ExtentReports — a retried test is never silently reported as a clean single-attempt pass

### CI/CD
- GitHub Actions workflow runs automatically on push and pull request to `main`
- Currently executes `LoginTest` only, in headless Chrome — the full suite is not yet included (see Roadmap below)

---

## 🧪 Test Coverage

**Implemented and covered by automated tests:**

| Area | Test Class | Scenarios |
|---|---|---|
| Login | `LoginTest` | Page title verification, step-by-step login flow, business-method login flow |
| Registration | `RegisterTest` | Hardcoded data, dynamically generated data (Lorem Ipsum), Excel data-driven registration, negative case (missing username) |

**Page objects implemented but not yet covered by tests:**

`OpenNewAccountPage`, `RequestLoanPage`, `UpdateProfilePage`, `OpenedAccountPage`, and `ApprovedLoanPage` exist and model the Open New Account, Loan Request, and Profile Update flows, but no test classes currently exercise them. Test coverage for these flows is planned for a later phase (see Roadmap below).

---

## ▶️ How to Run

### 1. Clone Repository
```bash
git clone https://github.com/SharifulIslamSabuj/ParabankAutomation-AdvancedFramework.git
```

### 2. Import Project
Open in IntelliJ IDEA / Eclipse and import as a Gradle project.

### 3. Configure Environment
Edit `src/test/resources/config.properties`:
```properties
baseUrl=https://parabank.parasoft.com/parabank/
username=sqa
password=sqa
browserName=chrome
```

### 4. Run Tests
Using Gradle:
```bash
./gradlew clean test
```
Using TestNG directly: run `src/test/resources/testng.xml`

---

## 🔀 Parallel Execution

Configured in `testng.xml`:
```xml
<suite name="ParaBank Parallel Suite" parallel="tests" thread-count="3">
```

---

## 📊 Reporting

Two reporting mechanisms are present in this project, at different levels of maturity:

- **ExtentReports (primary, fully configured):** generates a full HTML report at `build/extentReport/Report.html`, including test execution status, step-by-step logs, and embedded failure screenshots.
- **Allure (raw results only):** the `allure-testng` dependency automatically captures raw result/container JSON files into `/allure-results/` during every test run. HTML report generation (`allure generate` / `allure serve`) and CI publishing are **not configured yet** — planned for a later phase.

---

## 📸 Screenshots

On test failure, screenshots are saved to `/build/screenshots/` and are also embedded directly into the ExtentReports HTML report.

---

## 🤖 CI/CD

A GitHub Actions workflow (`.github/workflows/ci.yml`) runs automatically on every push and pull request to `main`:

- JDK 17, with Gradle dependency caching
- Executes `LoginTest` only, using headless Chrome (`-DbrowserName=headlessChrome`)
- Does not yet run `RegisterTest` or the full suite — deliberately scoped down while the live ParaBank demo's registration flow is monitored for stability

Expanding CI to run the full suite is tracked in the Roadmap below.

---

## 🗺️ Roadmap

Planned for future phases:
- Test coverage for Open New Account, Loan Request, and Profile Update flows
- Allure HTML report generation and CI publishing
- Expanding CI to run the full test suite, not just `LoginTest`

---

## 👨‍💻 Author

Md. Shariful Islam
SQA Automation Engineer
(Java | Selenium | TestNG | API Testing)

---

## 📌 Note

This project is built for:

- Learning advanced automation framework design
- Portfolio demonstration
- QA interview preparation
