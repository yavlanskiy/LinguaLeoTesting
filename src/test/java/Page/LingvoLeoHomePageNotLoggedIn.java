package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;

public class LingvoLeoHomePageNotLoggedIn {

    private WebDriver driver;
    public static String homePage = "https://lingualeo.com/ru/";

    @FindBy(id = "headEnterBtn")
    WebElement loginButton;

    @FindBy(id = "registerFormEmail")
    WebElement registerFormEmail;

    @FindBy(id = "registerFormPassword")
    WebElement registerFormPassword;

    @FindBy(id = "registerFormBtn")
    WebElement registerFormBtn;

    @FindBy(id = "btnSocVkBig")
    private WebElement vkButton;

    @FindBy(id = "registerFormAgree")
    private WebElement licenseTerms;

    public LingvoLeoHomePageNotLoggedIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToMainPage(){
        driver.get(LingvoLeoHomePageNotLoggedIn.homePage);
    }

    public LicenseTermsPage clickLicenseTerms(){
        licenseTerms.click();
        return new LicenseTermsPage(driver);
    }

    public LoginForm clickEnterButton() {
        loginButton.click();
        return new LoginForm(driver);
    }

    public LoginForm clickRegistrationButton() {
        registerFormBtn.click();
        return null;
    }

    public void registrationUser(String eMail, String login){
        registerFormEmail.clear();
        registerFormEmail.sendKeys(eMail);
        registerFormPassword.clear();
        registerFormPassword.sendKeys(login);
        clickRegistrationButton();
    }

    public void registrationUser(TestData user){
        registerFormEmail.clear();
        registerFormEmail.sendKeys(user.getUserEmail());
        registerFormPassword.clear();
        registerFormPassword.sendKeys(user.getUserPass());
        registerFormBtn.click();
    }

}
