
# Automation Web Selenium Cucumber

This project is an end-to-end test automation framework using Selenium WebDriver, Cucumber, and Cucumber-HTML for web application testing. It also integrates with GitHub Actions for CI/CD.

## Features
- Automated web testing using Selenium WebDriver.
- BDD-style test scenarios using Cucumber.
- Supports parallel execution and integrates with GitHub Actions for continuous integration.
- Customizable test reports with Cucumber-HTML or other plugins.

## Prerequisites
To run this project, ensure you have the following installed on your system:
- Java JDK 11+
- Maven 3+
- Git- Chrome WebDriver or GeckoDriver (for Firefox)

## Setup
- Clone the repository:
  ```
  git clone https://github.com/your-repo/automation-web-selenium-cucumber.git
  cd automation-web-selenium-cucumber
  ```

- Install dependencies:
  The project uses Maven for dependency management. Run the following command to install dependencies:
  ```
  mvn clean install
  ```

- Set up WebDriver:
  Ensure that the appropriate WebDriver (ChromeDriver/GeckoDriver) is installed and accessible in your system's PATH.
  Alternatively, you can configure the driver in the `src/test/resources/config.properties` file:
  ```
  browser=chrome
  driverPath=/path/to/chromedriver
  ```

## Running Tests
### Run All Tests
![gifTestResult](https://github.com/user-attachments/assets/76876cb5-80c2-4de4-821f-1702e9285ee2)
To run all tests, use the following command:
```
mvn clean test
```

### Run Specific Scenario
To run a specific scenario, use the Cucumber tag feature:
```
mvn clean test -Dcucumber.options="--tags @yourTag"
```

### Run in Headless Mode
You can also run the tests in headless mode (no browser UI) by setting the environment variable headless=true:
```
mvn clean test -Dheadless=true
```

## GitHub Actions CI Integration
The project is integrated with GitHub Actions for Continuous Integration (CI). To manually trigger a workflow, you can go to the Actions tab in your repository, select the workflow, and click on Run workflow.
![image](https://github.com/user-attachments/assets/2e5e3b14-3dc4-4e89-baf2-3b347a2243a9)

```
name: Run Selenium Tests Manually

on:
  workflow_dispatch:

jobs:
  run-tests:
    runs-on: ubuntu-latest

    services:
      selenium:
        image: selenium/standalone-chrome:latest
        ports:
          - 4444:4444

    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Download test file
        run: |
          mkdir -p src/file
          curl -o src/file/jne.pdf https://example.com/path-to-file/jne.pdf

      - name: Set file permissions
        run: chmod 755 src/file/jne.pdf

      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          distribution: 'adopt'
          java-version: '11'

      - name: Cache Maven packages
        uses: actions/cache@v2
        with:
          path: ~/.m2
          key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            ${{ runner.os }}-maven-

      - name: Run tests
        run: mvn clean install -DskipTests=false
```

## Folder Structure
```
automation-web-selenium-cucumber/
│
├── src/
│   ├── file/
│   └── test/
│       ├── java/
│       │   └── stepDefinitions/     # Step definitions for Cucumber tests
│       │   └── pageObjects/         # Element definitions and how they interact
│       │   └── runner/              # Bootstrap for using cucumber
│       ├── resources/
│       │   ├── features/            # Cucumber feature files
│       │   └── config.properties    # Test configuration file
│
├── .github/workflows/               # GitHub Actions workflow files
├── pom.xml                          # Maven Project Object Model file
└── README.md                        # Project Documentation
```

## Test Reports
<img width="665" alt="Screen Shot 2024-09-25 at 09 11 52" src="https://github.com/user-attachments/assets/7327f65c-339d-4560-9906-642c281739f5">
After running the tests, the results will be generated in the `target/cucumber-reports.html` folder. You can customize the reports in the `pom.xml` by configuring the reporting plugin of your choice (e.g., Surefire or Cucumber Reports).

## Contributing
- Fork the repository.
- Create a new branch (`git checkout -b feature/my-feature`).
- Make your changes and commit them (`git commit -m 'Add some feature'`).
- Push to the branch (`git push origin feature/my-feature`).
- Create a pull request.
