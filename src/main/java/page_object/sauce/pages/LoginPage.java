package page_object.sauce.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LocalDriverManager;

import static org.openqa.selenium.support.How.*;

public class LoginPage {

    private final WebDriver driver = LocalDriverManager.getInstance();

    public LoginPage() {
        WebDriver driver = LocalDriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = XPATH, xpath = "//input[@data-test='username']")
    WebElement usernameField;
    @FindBy(how = ID, id = "password")
    WebElement passwordField;
    @FindBy(how = NAME, name = "login-button")
    WebElement loginButton;
    @Getter
    @FindBy(how = XPATH, xpath = "//h3[@data-test='error']")
    WebElement errorMessage;
    public void authorize(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}