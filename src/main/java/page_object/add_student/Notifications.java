package page_object.add_student;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalDriverManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class Notifications {
    WebDriver driver = LocalDriverManager.getInstance();
    WebDriverWait waiter;

    public Notifications(WebDriverWait wait) {
        this.waiter = wait;
    }

    private final By notificationMessage = By.className("ant-notification-notice-message");

    public WebElement getNotificationLocator() {
        return driver.findElement(notificationMessage);
    }

    public String getNotificationSuccessMessage() {
        waiter.until(textToBePresentInElement(getNotificationLocator(), "Student successfully added"));
        return getNotificationLocator().getText();
    }
}
