package ru.stqa.pft.addressbook;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    JavascriptExecutor js;
    public WebDriver driver;
    private Map<String, Object> vars;

    @Before
    public void setUp() {
      System.setProperty("webdriver.gecko.driver","C:\\gecko\\geckodriver.exe");
      driver = new FirefoxDriver();
      js = (JavascriptExecutor) driver;
      vars = new HashMap<String, Object>();
      login("admin", "secret");
    }

    private void login(String username, String password) {
      driver.get("http://localhost/addressbook/");
      driver.manage().window().setSize(new Dimension(1079, 695));
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    @After
    public void tearDown() {
      driver.quit();
    }

    protected void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupFields(GroupData groupData) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void initNewGroup() {
      driver.findElement(By.name("new")).click();
    }

    protected void goToGroups() {
      driver.findElement(By.linkText("groups")).click();
    }

    protected void deleteSelectedGroups() {
      driver.findElement(By.cssSelector("input:nth-child(8)")).click();
    }

    protected void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
    }
}
