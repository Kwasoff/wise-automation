package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class YoutubeMusic {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://music.youtube.com");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement play = driver.findElement(By.xpath("//yt-formatted-string[@title='Unstoppable']"));
        play.click();
        Thread.sleep(15000);
        WebElement nextSongButton = driver.findElement(By.xpath("//tp-yt-paper-icon-button[@class='next-button style-scope ytmusic-player-bar']"));
        nextSongButton.click();
        Thread.sleep(15000);
        nextSongButton.click();
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//tp-yt-paper-icon-button[@class='search-icon style-scope ytmusic-search-box']"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement searchBar = driver.findElement(By.xpath("//input[@class='style-scope ytmusic-search-box']"));
        searchBar.click();
        Thread.sleep(3000);
        searchBar.sendKeys("Bury tomorrow - black flame (official video)");
        Thread.sleep(3000);
        searchBar.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement playBuryTomorrow = driver.findElement(By.xpath("//button[@aria-label='PLAY ALL']"));
        playBuryTomorrow.click();
        Thread.sleep(15000);
        driver.quit();




    }
}
