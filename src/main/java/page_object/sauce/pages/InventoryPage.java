package page_object.sauce.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.LocalDriverManager;

import java.util.List;

public class InventoryPage {

    private final WebDriver driver = LocalDriverManager.getInstance();

    public InventoryPage() {
        WebDriver driver = LocalDriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }
    @Getter
    @FindBy(how = How.CLASS_NAME, className = "inventory_item")
    private List<WebElement> inventoryItems;
}