package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LicenseTermsPage {

    private WebDriver driver;

    public LicenseTermsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
}
