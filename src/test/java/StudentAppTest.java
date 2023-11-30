import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.add_student.AddStudentPage;
import page_object.add_student.MainPage;
import page_object.add_student.Notifications;
import utils.LocalDriverManager;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.ConfigurationProperties.getConfiguration;
import static utils.LocalDriverManager.closeDriver;

@Slf4j
public class StudentAppTest {

    WebDriver driver = LocalDriverManager.getInstance();
    Faker fakeData;
    WebDriverWait wait;
    MainPage mainPage;
    AddStudentPage addStudentPage;
    Notifications notifications;

    @BeforeMethod
    public void beforeTest() {
        driver = LocalDriverManager.getInstance();
        wait = new WebDriverWait(driver, ofSeconds(getConfiguration().getLong("wait.time")));
        fakeData = new Faker();
        mainPage = new MainPage();
        addStudentPage = new AddStudentPage();
        notifications = new Notifications(wait);
    }

    @Test(invocationCount = 2)
    public void createStudentTest() {
        driver.manage().timeouts().implicitlyWait(ofSeconds(getConfiguration().getLong("wait.time")));

        logger.info("Will open now: " + getConfiguration().getString("app.url"));
        driver.get(getConfiguration().getString("app.url"));

        mainPage.openAddStudentForm();

        addStudentPage.setNameField(fakeData.name().fullName());
        addStudentPage.setMailField(fakeData.internet().emailAddress());
        addStudentPage.setGender("female");
        addStudentPage.submitStudent();

        assertThat(notifications.getNotificationSuccessMessage()).isEqualTo("Student successfully added");
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}


