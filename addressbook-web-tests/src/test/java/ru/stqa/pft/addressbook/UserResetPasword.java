package ru.stqa.pft.addressbook;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UserResetPasword  extends TestBase{



  @Test
  public void testUserResetPasword() throws Exception {

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





}
