package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyJobPage {
    WebDriver driver;

    By txtEmail = By.id("email");
    By txtFullName = By.id("name");
    By txtRegionCode = By.id("code");
    By fileInput = By.id("fileInput");
    By txtPhoneNumber = By.id("phone");
    By txtCoverLetter = By.id("additionalMessage");
    By txtJobTitle = By.xpath("//div[@data-testid='jobTitle-card']");
    By txtErrorPhone = By.xpath("//span[text()='Invalid phone number']");
    By btnSubmit = By.xpath("//button[@data-testid='apply-job-next-2']");
    By btnApplyNow = By.xpath("//button[@data-testid='apply-now-button']");
    By btnNextUploadCV = By.xpath("//button[@data-testid='apply-job-next-1']");
    By btnNextPersonalData = By.xpath("//button[@data-testid='apply-job-next-0']");
    By txtErrorEmail = By.xpath("//span[text()='Please input the correct email format.']");

    public ApplyJobPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickApply() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement buttonApplyNow = wait.until(ExpectedConditions.visibilityOfElementLocated(btnApplyNow));
        Assert.assertTrue("Button Apply is not displayed", buttonApplyNow.isDisplayed());

        buttonApplyNow.click();
    }

    public void fillPersonalData(String condition) {
        String email = "rll.roses@yopmail.com";
        String phoneNumber = "89870199281";

        if (!condition.equals("Valid")) {
            email = "haha";
            phoneNumber = "haha";
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement fieldFullName = wait.until(ExpectedConditions.visibilityOfElementLocated(txtFullName));
        Assert.assertTrue("Field Full Name is not displayed", fieldFullName.isDisplayed());
        fieldFullName.sendKeys("Rose");

        WebElement fieldEmail = driver.findElement(txtEmail);
        fieldEmail.sendKeys(email);

        WebElement fieldRegion = driver.findElement(txtRegionCode);
        fieldRegion.sendKeys("+62");
        
        WebElement fieldPhone = driver.findElement(txtPhoneNumber);
        fieldPhone.sendKeys(phoneNumber);

        driver.findElement(btnNextPersonalData).click();

        if (!condition.equals("Valid")) {
            WebElement errorEmail = driver.findElement(txtErrorEmail);
            WebElement errorPhone = driver.findElement(txtErrorPhone);

            Assert.assertTrue("Error Email is not displayed", errorEmail.isDisplayed());
            Assert.assertTrue("Error Phone is not displayed", errorPhone.isDisplayed());

            driver.quit();
        }
    }

    public void uploadCV() {
        driver.findElement(fileInput).sendKeys("/Users/ralali/Local/irwan/selember/src/file/jne.pdf");
        driver.findElement(btnNextUploadCV).click();
    }

    public void fillCoverLetter() {
        WebElement coverLetter = driver.findElement(txtCoverLetter);
        Assert.assertTrue("Cover letter is not displayed", coverLetter.isDisplayed());

        coverLetter.sendKeys("Lorem Ipsum dolor sit amet adipiscum...");
    }

    public void submitApplication() {
        driver.findElement(btnSubmit).click();
    }

    public void backToMainPage() {
        WebElement jobTitle = driver.findElement(txtJobTitle);
        Assert.assertTrue("Job Title is not displayed", jobTitle.isDisplayed());

        driver.quit();
    }
}
