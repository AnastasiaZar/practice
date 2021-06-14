package ru.stqa.pft.addressbook;



import org.testng.annotations.*;


public class NewUserCreation extends TestBase {


  @Test
  public void testCreatenewUser() throws Exception {
    gotoUserstab();
    addnewUser();
    fillnewUsersdata(new NewUsersData("ana", "automation", "auto1@gmail.com"));
    submitNewuserdata();
  }


}
