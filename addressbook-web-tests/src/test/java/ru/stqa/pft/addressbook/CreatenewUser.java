package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreatenewUser {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreatenewUser() throws Exception {
    driver.get("https://cpattest.qa.cpat.com/admin/login");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("anaautomation@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.xpath("//div[@id='header-login']/div[2]/button")).click();
    driver.findElement(By.linkText("Users")).click();
    driver.findElement(By.xpath("//div[@id='dashboard-users']/div/div[4]/button")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("ana");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("automation");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("auto1@gmail.com");
    driver.findElement(By.xpath("//div[@id='position-selector']/select")).click();
    new Select(driver.findElement(By.xpath("//div[@id='position-selector']/select"))).selectByVisibleText("Content Developer");
    driver.findElement(By.xpath("//option[@value='8: Object']")).click();
    driver.findElement(By.xpath("//body[@id='theBody']/modal[2]/div/div/modal-body/div/ul/li[4]/div/div")).click();
    driver.findElement(By.xpath("//body[@id='theBody']/modal[2]/div/div/modal-body/div/ul/li[4]/div/div[2]/div/label")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
