package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainPage {

    ChromeDriver driver;

//    public MainPage(ChromeDriver driver) {
//        this.driver = driver;


    private final By addStudentButton = By.id("addStudentButton");

    public MainPage(ChromeDriver driver) {
    }

    public void openAddStudentForm (){
        driver.findElement(addStudentButton).click();

    }
}
