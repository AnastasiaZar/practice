package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewUser extends TestData {

  @Test
  public void testCreatenewUser() throws Exception {

    addnewuser();
    fillinnewuserdata(new UserData("ana", "automation", "auto1@gmail.com"));
    wd.findElement(By.xpath("//option[@value='8: Object']")).click();
    selectadminlevel();
    selectgroup();
    createnewuser();
  }


}
