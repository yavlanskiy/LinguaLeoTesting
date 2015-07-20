package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = ".l-dropmenu-all")
    WebElement selectElem;

    @FindBy(xpath = "//li[@class= \"logout-li\"]/a")
    private WebElement exitButton;

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void logOut() {
        selectElem.click();
        exitButton.click();
    }
}
