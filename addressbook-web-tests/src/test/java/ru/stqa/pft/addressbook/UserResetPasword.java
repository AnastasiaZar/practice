package ru.stqa.pft.addressbook;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UserResetPasword  extends TestBase{



  @Test
  public void testUserResetPasword() throws Exception {

    usersearch();
    resetpassword();
  }


}
