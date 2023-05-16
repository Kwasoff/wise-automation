package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        WebElement radioMaleButton = driver.findElement(By.id("male"));
        System.out.println(radioMaleButton.getAttribute("type"));
        System.out.println("Male Radiobutton Before click: " + radioMaleButton.isSelected());
        radioMaleButton.click();
        System.out.println("Male Radiobutton After click: " + radioMaleButton.isSelected());
        WebElement radioFemaleButton = driver.findElement(By.id("female"));
        System.out.println("Female Radiobutton Before click: " + radioFemaleButton.isSelected());
        radioFemaleButton.click();
        System.out.println("Female Radiobutton After click: " + radioFemaleButton.isSelected());
        System.out.println("Male Radiobutton After Female click: " + radioMaleButton.isSelected());
        System.out.println();

        WebElement automationCheckBox = driver.findElement(By.className("Automation"));
        System.out.println("Automation Checkbox Before click: " + automationCheckBox.isSelected());
        automationCheckBox.click();
        System.out.println("Automation Checkbox After click: " + automationCheckBox.isSelected());
        WebElement performanceCheckBox = driver.findElement(By.className("Performance"));
        System.out.println("Performance Checkbox Before click: " + performanceCheckBox.isSelected());
        performanceCheckBox.click();
        System.out.println("Performance Checkbox After click: " + performanceCheckBox.isSelected());
        System.out.println("Automation Checkbox After Performance click: " + automationCheckBox.isSelected());

        WebElement sendKeyBar = driver.findElement(By.id("fname"));
        sendKeyBar.sendKeys("Jack");






    }
}
