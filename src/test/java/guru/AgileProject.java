package guru;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import pages.AgileProjectPage;
import pages.GuruHomePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class AgileProject {

    GuruHomePage guruHomePage = new GuruHomePage();
    AgileProjectPage agileProjectPage = new AgileProjectPage();

    @Test
    public void login(){
        Driver.getDriver().get(Config.getValue("guruURL"));
        Driver.getDriver().findElement(By.linkText("Agile Project")).click();
        String id = Driver.getDriver().findElement(By.xpath("//ol/li[1]")).getText().substring(9);
        String pas = Driver.getDriver().findElement(By.xpath("//ol/li[2]")).getText().substring(11);
        Driver.getDriver().findElement(By.name("uid")).sendKeys(id);
        Driver.getDriver().findElement(By.name("password")).sendKeys(pas);
        Driver.getDriver().findElement(By.name("btnLogin")).click();
        ApplicationFlow.pause(500);
        String expect = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";
        Assert.assertEquals("Login functionality failed",expect,Driver.getDriver().getCurrentUrl());
            // the message from assert pups up only when assert failed
           }

           @Test
           public void logout(){
               Driver.getDriver().get(Config.getValue("guruURL"));
               Driver.getDriver().findElement(By.linkText("Agile Project")).click();
               String id = Driver.getDriver().findElement(By.xpath("//ol/li[1]")).getText().substring(9);
               String pas = Driver.getDriver().findElement(By.xpath("//ol/li[2]")).getText().substring(11);
               Driver.getDriver().findElement(By.name("uid")).sendKeys(id);
               Driver.getDriver().findElement(By.name("password")).sendKeys(pas);
               Driver.getDriver().findElement(By.name("btnLogin")).click();
               ApplicationFlow.pause(500);
               String expect = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";
               Assert.assertEquals("Login functionality failed",expect,Driver.getDriver().getCurrentUrl());
               Driver.getDriver().findElement(By.linkText("Log out")).click();
               Alert alert = Driver.getDriver().switchTo().alert();
               String expectedMessage = "You Have Succesfully Logged Out!!";
               String actualMessage = alert.getText();
               Assert.assertEquals("Messages don't match", actualMessage, expectedMessage);
               alert.accept();
               String expUrl = "https://demo.guru99.com/Agile_Project/Agi_V1/index.php";
               Assert.assertEquals("URL failed", expUrl, Driver.getDriver().getCurrentUrl());
           }

          @Test
           public void pomTest(){
        Driver.getDriver().get(Config.getValue("guruURL"));

               guruHomePage.agileProjectLink.click();
               String userId = agileProjectPage.userIdAccess.getText().substring(9);
               String password = agileProjectPage.userPasswordAccess.getText().substring(11);
               agileProjectPage.userID.sendKeys(userId);
               agileProjectPage.password.sendKeys(password);
               agileProjectPage.loginBtn.click();
               ApplicationFlow.pause(500);
               String expectedUrl = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php" ;
               Assert.assertEquals("URL failed", expectedUrl, Driver.getDriver().getCurrentUrl());

           }

           @Test
           public void logoutPom(){
        Driver.getDriver().get(Config.getValue("guruURL"));
        guruHomePage.agileProjectLink.click();
               String userId = agileProjectPage.userIdAccess.getText().substring(9);
               String password = agileProjectPage.userPasswordAccess.getText().substring(11);
               agileProjectPage.login(userId,password);
               agileProjectPage.logoutButton.click();
               Alert alert = Driver.getDriver().switchTo().alert();
               String expectedMessage = "You Have Succesfully Logged Out!!";
               Assert.assertEquals("Alert message failed", expectedMessage, alert.getText());
                alert.accept();
           }

    @After
    public void afterSettings(){
        Driver.quit();
    }
















}
