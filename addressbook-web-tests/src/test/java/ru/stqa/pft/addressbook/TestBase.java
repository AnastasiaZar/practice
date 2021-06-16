package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      wd.get("https://cpattest.qa.cpat.com/admin/login");
      login("anaautomation@gmail.com", "123456");
    }

    private void login(String username, String password) {
      wd.findElement(By.name("username")).clear();
      wd.findElement(By.name("username")).sendKeys(username);
      wd.findElement(By.name("password")).click();
      wd.findElement(By.name("password")).clear();
      wd.findElement(By.name("password")).sendKeys(password);
      wd.findElement(By.xpath("//div[@id='header-login']/div[2]/button")).click();
    }

    protected void submitNewuserdata() {
      wd.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    }

    protected void fillnewUsersdata(NewUsersData newUsersData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(newUsersData.getNewusersfirstname());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(newUsersData.getNewuserslastname());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(newUsersData.getNewusersemail());
      wd.findElement(By.xpath("//div[@id='position-selector']/select")).click();
      new Select(wd.findElement(By.xpath("//div[@id='position-selector']/select"))).selectByVisibleText("Content Developer");
      wd.findElement(By.xpath("//li[4]/div/div")).click();
      wd.findElement(By.xpath("//li[4]/div/div[2]/div/label")).click();
    }

    protected void addnewUser() {
      wd.findElement(By.xpath("//div[@id='dashboard-users']/div/div[4]/button")).click();
    }

    protected void gotoUserstab() {
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

    protected void resetpassword() {
      wd.findElement(By.xpath("(//input[@type='password'])[5]")).click();
      wd.findElement(By.xpath("(//input[@type='password'])[5]")).clear();
      wd.findElement(By.xpath("(//input[@type='password'])[5]")).sendKeys("123456");
      wd.findElement(By.xpath("(//input[@type='password'])[6]")).click();
      wd.findElement(By.xpath("(//input[@type='password'])[6]")).clear();
      wd.findElement(By.xpath("(//input[@type='password'])[6]")).sendKeys("123456");
      wd.findElement(By.xpath("(//button[@type='button'])[10]")).click();
    }

    protected void usersearch() {
      wd.findElement(By.linkText("Users")).click();
      wd.findElement(By.xpath("//div/div/input")).click();
      wd.findElement(By.xpath("//div/div/input")).clear();
      wd.findElement(By.xpath("//div/div/input")).sendKeys("ananew");
      wd.findElement(By.xpath("//div[@id='dashboard-users']/div[2]/table/tbody/tr/td[3]")).click();
      wd.findElement(By.xpath("//div[5]/button[2]")).click();
    }
}
