package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserTestCases {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("anaautomation@gmail.com", "123456");
    }

    private void login(String username, String password) {
        wd.get("https://cpattest.qa.cpat.com/admin/login");
        clickuserstab(By.name("username"));
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys(username);
        clickuserstab(By.name("password"));
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.xpath("//div[@id='header-login']/div[2]/button")).click();
    }

    @Test
    public void testUserCreation() throws Exception {
        clickuserstab(By.name("username"));
        addnewuser();
        fillinnewuserinformation(new newuserdata("ana", "new", "ananew@yahoo.com"));
        createnewuser();
    }

    private void createnewuser() {
        wd.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    }

    private void fillinnewuserinformation(newuserdata newuserdata) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(newuserdata.getUserfirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(newuserdata.getUserlastname());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(newuserdata.getUseremail());
    }

    private void addnewuser() {
        wd.findElement(By.xpath("//div[@id='dashboard-users']/div/div[4]/button")).click();
    }

    private void clickuserstab(By username) {
        wd.findElement(By.linkText("Users")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
