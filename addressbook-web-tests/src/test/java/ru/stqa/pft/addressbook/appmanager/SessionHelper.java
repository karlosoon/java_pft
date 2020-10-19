package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver driver) {
        super(driver);

    }

    public void login(String username, String password) {
      driver.get("http://localhost/addressbook/");
      driver.manage().window().maximize();
      type(By.name("user"), username);
      type(By.name("pass"), password);
      click(By.cssSelector("input:nth-child(7)"));
    }
}
