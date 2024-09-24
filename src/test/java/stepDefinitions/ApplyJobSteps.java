package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.ApplyJobPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyJobSteps {

    WebDriver driver;
    ApplyJobPage applyJobPage;

    @Given("User is on the Main page")
    public void user_is_on_the_main_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://theforest.ai/careers/qa-engineer");
        driver.manage().window().maximize();
        applyJobPage = new ApplyJobPage(driver);
    }

    @When("User click Apply now")
    public void user_click_apply_now() {
        applyJobPage.clickApply();
    }

    @And("User fulfill with {string} Personal data")
    public void user_fulfill_with_personal_data(String condition) {
        applyJobPage.fillPersonalData(condition);
    }

    @And("User upload CV")
    public void user_upload_cv() {
        applyJobPage.uploadCV();
    }

    @And("User add cover letter")
    public void user_add_cover_letter() {
        applyJobPage.fillCoverLetter();
    }

    @And("User submit the application")
    public void user_submit_the_application() {
        applyJobPage.submitApplication();
    }

    @And("Application submitted successfully")
    public void application_submitted_successfully() {
        applyJobPage.backToMainPage();
    }
}
