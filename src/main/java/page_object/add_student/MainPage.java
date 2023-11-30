package page_object.add_student;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LocalDriverManager;

public class MainPage {

    WebDriver driver = LocalDriverManager.getInstance();

    private final By addStudentButton = By.id("addStudentButton");

    public void openAddStudentForm() {
        driver.findElement(addStudentButton).click();
    }
}
