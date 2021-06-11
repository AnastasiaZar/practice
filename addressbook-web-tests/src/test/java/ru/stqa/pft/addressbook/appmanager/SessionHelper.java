package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver wd;

    public SessionHelper(WebDriver wd) {
        this.wd = wd;
    }
    public void login(String username, String password) {
        wd.get("https://cpattest.qa.cpat.com/admin/login");
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys(username);
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.xpath("//div[@id='header-login']/div[2]/button")).click();
        NavigationHelper.clickuserstab();

    }

}
