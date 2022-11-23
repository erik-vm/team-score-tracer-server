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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TeamServiceAutomatedTest {

    WebDriver driver = new ChromeDriver();


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
    void addTeamTest() throws InterruptedException {
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

        input.click();

        //Count the elements in the teams div only when the new team is added
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(10000);
// It should be made with the expression below but not working for now
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='team'][position() = $rowCount]")));

        Long rowCount2 = driver.findElements(By.xpath(countTeams)).stream().count();
        System.out.println(rowCount2);
        assertEquals(rowCount, rowCount2);

        //checking if the new team was added
    }




}
