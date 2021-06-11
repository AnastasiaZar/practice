package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import module.UserData;

public class GroupHelper {
    public WebDriver wd;

    public GroupHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void addnewuser() {
       wd.findElement(By.xpath("//div[@id='dashboard-users']/div/div[4]/button")).click();
     }

    public void createnewuser() {
       wd.findElement(By.xpath("(//button[@type='button'])[5]")).click();
     }

    public void selectgroup() {
       wd.findElement(By.xpath("//body[@id='theBody']/modal[2]/div/div/modal-body/div/ul/li[4]/div/div[2]/div/label")).click();
     }

    public void selectadminlevel() {
       wd.findElement(By.xpath("//body[@id='theBody']/modal[2]/div/div/modal-body/div/ul/li[4]/div/div")).click();
     }

    public void fillinnewuserdata(UserData userData) {
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
}
