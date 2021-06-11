package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private static WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public static void clickuserstab() {
        wd.findElement(By.linkText("Users")).click();
    }
}
