package guru;

import com.github.javafaker.Faker;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PaymentGatewayPage;
import utilities.Config;
import utilities.Driver;

public class PaymentGateway {

    PaymentGatewayPage paymentGatewayPage = new PaymentGatewayPage();

    @BeforeClass
    public static void classBefore(){
        System.out.println("One time in the beginning");
    }

    @AfterClass
    public  static void classAfter(){
        System.out.println("One time in the end");
    }

    @Before
    public void testSetupBefore(){
        Driver.getDriver().get(Config.getValue("guruPaymentGateURL"));

    }

    @Test
    public void getElephant(){
        paymentGatewayPage.buyNowBtn.click();
        Faker faker = new Faker();
        paymentGatewayPage.cardNumberInput.sendKeys(faker.business().creditCardNumber());
        paymentGatewayPage.selectMonth("08");
        paymentGatewayPage.selectYear("2021");
        paymentGatewayPage.cvvInput.sendKeys("550");
        paymentGatewayPage.payBtn.click();
        String actualResult = paymentGatewayPage.paymentSuccessfullMessageGetText();
        String expected = "Payment successfull!";

        Assert.assertEquals(expected,actualResult);

    }

    @Test
    public void creditLimitTest(){
        Driver.getDriver().findElement(By.linkText("Check Credit Card Limit")).click();
        Driver.getDriver().findElement(By.id("card_nmuber")).sendKeys("4652550807147753");
        Driver.getDriver().findElement(By.xpath("//input[@class='button special']")).click();
        String amountBeforePurchase = Driver.getDriver().findElement(By.xpath("//h4/span")).getText();
        double amountBefore = Double.parseDouble(amountBeforePurchase);

        Driver.getDriver().findElement(By.xpath("(//*[.='Guru99 Payment Gateway'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("//input")).click();
        Driver.getDriver().findElement(By.id("card_nmuber")).sendKeys("4652550807147753");
        WebElement month = Driver.getDriver().findElement(By.id("month"));
        Select select1 = new Select(month);
        select1.selectByVisibleText("08");
        WebElement year = Driver.getDriver().findElement(By.id("year"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("2021");
        Driver.getDriver().findElement(By.id("cvv_code")).sendKeys("550");
        Driver.getDriver().findElement(By.xpath("//input[@name='submit']")).click();
        Driver.getDriver().findElement(By.xpath("(//a[.='Check Credit Card Limit'])[1]")).click();
        Driver.getDriver().findElement(By.id("card_nmuber")).sendKeys("4652550807147753");
        Driver.getDriver().findElement(By.xpath("//input[@class='button special']")).click();
        String amountAfterPurchase = Driver.getDriver().findElement(By.xpath("//h4/span")).getText();
        double amountAfter = Double.parseDouble(amountAfterPurchase);

        Assert.assertTrue(amountAfter + 20 == amountBefore);
    }

    @After
    public void testSetupAfter(){
        Driver.quit();

    }








    }








