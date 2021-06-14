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

public class TestData {
    protected WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      login("anaautomation@gmail.com", "123456");
    }

    private void login(String username, String password) {
      wd.get("https://cpattest.qa.cpat.com/admin/login");
      wd.findElement(By.name("username")).clear();
      wd.findElement(By.name("username")).sendKeys(username);
      wd.findElement(By.name("password")).click();
      wd.findElement(By.name("password")).clear();
      wd.findElement(By.name("password")).sendKeys(password);
      wd.findElement(By.xpath("//div[@id='header-login']/div[2]/button")).click();
      wd.findElement(By.linkText("Users")).click();
    }

    protected void addnewuser() {
      wd.findElement(By.xpath("//div[@id='dashboard-users']/div/div[4]/button")).click();
    }

    protected void createnewuser() {
      wd.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    }

    protected void selectgroup() {
      wd.findElement(By.xpath("//body[@id='theBody']/modal[2]/div/div/modal-body/div/ul/li[4]/div/div[2]/div/label")).click();
    }

    protected void selectadminlevel() {
      wd.findElement(By.xpath("//body[@id='theBody']/modal[2]/div/div/modal-body/div/ul/li[4]/div/div")).click();
    }

    protected void fillinnewuserdata(UserData userData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(userData.getUserfirstname());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(userData.getUserlastname());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(userData.getUseremail());
      wd.findElement(By.xpath("//div[@id='position-selector']/select")).click();
      new Select(wd.findElement(By.xpath("//div[@id='position-selector']/select"))).selectByVisibleText("Content Developer");
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
