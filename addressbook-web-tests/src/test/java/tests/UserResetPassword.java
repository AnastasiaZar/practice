package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.logindata;


public class UserResetPassword extends TestBase {
  private WebDriver dw;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    dw = new FirefoxDriver();
    dw.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  public void login(logindata logindata) {
    dw.get("https://cpattest.qa.cpat.com/admin/login");
    dw.findElement(By.name("username")).click();
    dw.findElement(By.name("username")).clear();
    dw.findElement(By.name("username")).sendKeys(logindata.getUsername());
    dw.findElement(By.name("password")).click();
    dw.findElement(By.name("password")).clear();
    dw.findElement(By.name("password")).sendKeys(logindata.getPassword());
    dw.findElement(By.xpath("//div[@id='header-login']/div[2]/button")).click();
  }

  @Test
  public void testUserResetPassword() throws Exception {
    login(new logindata("anaautomation@gmail.com", "123456"));
    clickuserstab(By.linkText("Users"));
    resetpassword("123456");
  }

  public void resetpassword(String resetpassword) {
    dw.findElement(By.xpath("//div/div/input")).click();
    dw.findElement(By.xpath("//div/div/input")).clear();
    dw.findElement(By.xpath("//div/div/input")).sendKeys("ananew");
    dw.findElement(By.xpath("//div[@id='dashboard-users']/div[2]/table/tbody/tr/td[3]")).click();
    dw.findElement(By.xpath("//div[5]/button[2]")).click();
    dw.findElement(By.xpath("(//input[@type='password'])[5]")).click();
    dw.findElement(By.xpath("(//input[@type='password'])[5]")).clear();
    dw.findElement(By.xpath("(//input[@type='password'])[5]")).sendKeys(resetpassword);
    dw.findElement(By.xpath("(//input[@type='password'])[6]")).click();
    dw.findElement(By.xpath("(//input[@type='password'])[6]")).clear();
    dw.findElement(By.xpath("(//input[@type='password'])[6]")).sendKeys(resetpassword);
    dw.findElement(By.xpath("(//button[@type='button'])[10]")).click();
  }

  public void clickuserstab(By users) {
    dw.findElement(users).click();
  }


  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    dw.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      dw.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      dw.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
