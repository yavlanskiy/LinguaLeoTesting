package test;

import Page.LicenseTermsPage;
import Page.LinguaLeoHomePageNotLoggedIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestData;

import static org.testng.Assert.assertEquals;


import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver driver;
    LinguaLeoHomePageNotLoggedIn homePage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(LinguaLeoHomePageNotLoggedIn.homePage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new LinguaLeoHomePageNotLoggedIn(driver);
    }

    @Test
    public void checkLIncenseTermsPage() {
        LicenseTermsPage termsPage = homePage.clickLicenseTerms();
    }

    @Test
    public void registrationRandomUser() {
        TestData user = new TestData().setRandomUser();
        homePage.registrationUser(user);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
