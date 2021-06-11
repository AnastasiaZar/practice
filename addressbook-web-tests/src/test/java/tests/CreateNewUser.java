package tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import module.UserData;

public class CreateNewUser extends TestBase {

  @Test
  public void testCreatenewUser() throws Exception {

    app.getGroupHelper().addnewuser();
    app.getGroupHelper().fillinnewuserdata(new UserData("ana", "automation", "auto1@gmail.com"));
    app.getGroupHelper().wd.findElement(By.xpath("//option[@value='8: Object']")).click();
    app.getGroupHelper().selectadminlevel();
    app.getGroupHelper().selectgroup();
    app.getGroupHelper().createnewuser();
  }


}
