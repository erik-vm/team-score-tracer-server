package com.team5.teamscoretrackerserver.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;


public class TeamServiceAutomatedTest {

    private WebDriver webDriver;


    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void openGoogle() throws InterruptedException {
        boolean testFail = true;
        driver.get("http://localhost:3000/");

        //Wait for the page to load
        Thread.sleep(10000);
        //counting the teams
        String countTeams = "//div[@class='teams']/div[@class='team']";
        Long rowCount = driver.findElements(By.xpath(countTeams)).stream().count();

        // +1 to compare with the final team count
        rowCount += 1;

        //adding a team
        WebElement input = driver.findElement(By.xpath("//button[@class='description']"));
//        Thread.sleep(10000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.click();
        Long rowCount2 = driver.findElements(By.xpath(countTeams)).stream().count();
//        Thread.sleep(10000);
        //checking if the new team was added
        if (rowCount.equals(rowCount2)) {
//            Thread.sleep(10000);
            testFail = false;
        }

        Thread.sleep(10000);
        if (testFail)
//            Thread.sleep(10000);
            fail("Team add doesn't work");
    }


    WebDriver driver = new ChromeDriver();

}
