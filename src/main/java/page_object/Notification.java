package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notification {
    ChromeDriver driver;
    WebDriverWait waiter;

    public Notification(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.waiter = wait;
    }

    private final By notificationMassage = By.className("ant-notification-notice-message");
    public WebElement getNotificationLocator(){
        return driver.findElement(notificationMassage);
    }
    public String getNotificationSuccessMessage(){
        waiter.until(ExpectedConditions.textToBePresentInElement(getNotificationLocator(),"Student Successfully added"));
        return getNotificationLocator().getText();
    }
}

