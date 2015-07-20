package test;

import Page.LicenseTermsPage;
import Page.LingvoLeoHomePageNotLoggedIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestData;

import static org.testng.Assert.assertEquals;


import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver driver;
    LingvoLeoHomePageNotLoggedIn homePage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(LingvoLeoHomePageNotLoggedIn.homePage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new LingvoLeoHomePageNotLoggedIn(driver);
    }

    @Test
    public void checkLIcenseTermsPage() {
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
