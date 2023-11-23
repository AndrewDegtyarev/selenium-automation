import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import page_object.AddStudentPage;
import page_object.MainPage;
import page_object.Notification;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static java.time.Duration.ofSeconds;
import static utils.ConfigurationProperties.getConfiguration;
@Slf4j

public class StudentAppTest {
    Faker fakeData = new Faker();
    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, ofSeconds(getConfiguration().getLong("wait.time")));
    MainPage mainPage = new MainPage(driver);
    AddStudentPage addStudentPage = new AddStudentPage(driver);
    Notification notification = new Notification(driver, wait);





    @Test
    public void createStudentTest(){

        driver.manage()
                .timeouts()
                .implicitlyWait
                        (ofSeconds(getConfiguration().getLong("wait.time")));

        logger.info("Will open now:" + getConfiguration().getString("app.url"));

        driver.get(getConfiguration().getString("app.url"));
//        WebElement addStudentButton = driver.findElement(By.id("addStudentButton"));
//        addStudentButton.click();
        mainPage.openAddStudentForm();


//        WebElement nameInputField = driver.findElement(By.id("name"));
//        nameInputField.sendKeys(fakeData.name().fullName());

        addStudentPage.setNameField(fakeData.name().fullName());

//        WebElement emailInputField = driver.findElement(By.id("email"));
//        emailInputField.sendKeys(fakeData.internet().emailAddress());

        addStudentPage.setEmailField(fakeData.internet().emailAddress());

//        driver.findElement(By.id("gender")).click();
//        driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[text()='MALE']")).click();

        addStudentPage.setGender("MALE");

//        WebElement buttonElement = driver.findElement(By.xpath("//span[text()='Submit']//parent::button"));
//        buttonElement.click();

//        WebElement notification = driver.findElement(By.className("ant-notification-notice-message"));
//        wait.until(ExpectedConditions.textToBePresentInElement(notification, "Student successfully added"));

//        notification.getNotificationLocator();

        Assertions.assertThat(notification.getNotificationLocator().getText()).isEqualTo("Student successfully added");



    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
