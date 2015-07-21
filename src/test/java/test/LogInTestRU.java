package test;

import Page.MainPage;
import Page.LingvoLeoHomePageNotLoggedIn;
import Page.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LogInTestRU {

    private WebDriver driver;
    LingvoLeoHomePageNotLoggedIn home;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(LingvoLeoHomePageNotLoggedIn.homePage);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        home = new LingvoLeoHomePageNotLoggedIn(driver);
    }

    @Test
    //заполнение пустыми полями
    public void regidtrationEmpty() {
        LoginForm loginForm = home.clickEnterButton();
        loginForm.clearField();
        loginForm.setRegistrationData("", "");
        assertEquals("Это поле должно быть заполнено",
                driver.findElement(By.cssSelector("ul.error_list > li"))
                        .getText());
        home.goToMainPage();
    }

    @Test
    //заполнение логина полей
    public void regidtrationEmail() {
        LoginForm loginForm = home.clickEnterButton();
        loginForm.clearField();
        loginForm.setRegistrationData("test.yav@gmail.com", "");
        assertEquals("Это поле должно быть заполнено",
                driver.findElement(By.cssSelector("ul.error_list > li"))
                        .getText());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        home.goToMainPage();
    }

    @Test
    //заполнение  пароля
    public void regidtrationPass() {
        LoginForm loginForm = home.clickEnterButton();
        loginForm.clearField();
        loginForm.setRegistrationData("", "test198993");
        assertEquals("Это поле должно быть заполнено",
                driver.findElement(By.cssSelector("ul.error_list > li"))
                        .getText());
        home.goToMainPage();
    }

    @Test
    //Заполнение правильным логином и паролем
    public void regidtrationValidAccount() {
        LoginForm loginForm = home.clickEnterButton();
        loginForm.clearField();
        loginForm.setRegistrationData("test.yav@gmail.com", "test198993");
        assertEquals("Моя цель",
                driver.findElement(By.cssSelector("h2.dash-aside__title")).
                        getText());
        MainPage mainPage = new MainPage(driver);
        mainPage.logOut();
    }

    //Язабыл пароль
    @Test
    public void forgotPass() {
        LoginForm loginForm = home.clickEnterButton();
        loginForm.clickForgotButton();
        assertEquals("Я забыл пароль!",
                driver.findElement(By.xpath("//div[@class = \"au-head__title\"]")).getText());
        home.goToMainPage();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
