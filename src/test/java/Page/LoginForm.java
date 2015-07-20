package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForm {

    private WebDriver driver;

    @FindBy(className = "login-bl")
    WebElement loginForm;

    @FindBy(id = "landingPopupEmailSign")
    private WebElement emailField;

    @FindBy(id = "landingPopupPasswordSign")
    private WebElement passField;

    @FindBy(id = "landingPopupBtnSign")
    private WebElement buttonSubmit;

    @FindBy(id = "landingPopupForget")
    private WebElement forgotPassButton;

    @FindBy(id = "landingPopupClose")
    private WebElement closeButton;


    public LoginForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSubmitButton() {
        buttonSubmit.click();
    }

    public void setRegistrationData(String eMail, String pass) {
        clearField();
        emailField.sendKeys(eMail);
        passField.sendKeys(pass);
        clickSubmitButton();    }

    public void clickForgotButton() {
        forgotPassButton.click();
    }

    public void clearField() {
        emailField.clear();
        passField.clear();
    }

    public void closeTitle() {
        closeButton.click();
    }
}
