package ru.stqa.pft.addressbook;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UserResetPasword  extends TestBase{
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUserResetPasword() throws Exception {
    wd.get("https://cpattest.qa.cpat.com/admin/login");
    wd.findElement(By.name("username")).click();
    wd.findElement(By.name("username")).clear();
    wd.findElement(By.name("username")).sendKeys("anaautomation@gmail.com");
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("123456");
    wd.findElement(By.xpath("//div[@id='header-login']/div[2]/button")).click();
    wd.findElement(By.linkText("Users")).click();
    wd.findElement(By.xpath("//div/div/input")).click();
    wd.findElement(By.xpath("//div/div/input")).clear();
    wd.findElement(By.xpath("//div/div/input")).sendKeys("ananew");
    wd.findElement(By.xpath("//div[@id='dashboard-users']/div[2]/table/tbody/tr/td[3]")).click();
    wd.findElement(By.xpath("//div[5]/button[2]")).click();
    wd.findElement(By.xpath("(//input[@type='password'])[5]")).click();
    wd.findElement(By.xpath("(//input[@type='password'])[5]")).clear();
    wd.findElement(By.xpath("(//input[@type='password'])[5]")).sendKeys("123456");
    wd.findElement(By.xpath("(//input[@type='password'])[6]")).click();
    wd.findElement(By.xpath("(//input[@type='password'])[6]")).clear();
    wd.findElement(By.xpath("(//input[@type='password'])[6]")).sendKeys("123456");
    wd.findElement(By.xpath("(//button[@type='button'])[10]")).click();
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
