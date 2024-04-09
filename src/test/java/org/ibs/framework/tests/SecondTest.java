package org.ibs.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SecondTest {

    @Test
    void vegetableTest() {
        System.setProperty("webdriver.chromedriver.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
        driver.manage().window().maximize();

        driver.get("http://localhost:8080/food");

        WebElement tittleProductsList = driver.findElement(By.xpath("//h5"));
        Assertions.assertEquals("Список товаров", tittleProductsList.getText(),"Не перешли на страницу");

        WebElement additionButton = driver.findElement(By.xpath("//button[@data-target = '#editModal']"));
        additionButton.click();

        WebElement nameInputForm = driver.findElement(By.xpath("//input[@id = 'name']"));
        nameInputForm.click();
        nameInputForm.sendKeys("Картофель");

        WebElement typeInputForm = driver.findElement(By.xpath("//select[@id = 'type']"));
        typeInputForm.click();

        WebElement fruitOption = driver.findElement(By.xpath("//option[@value = 'VEGETABLE']"));
        fruitOption.click();

        WebElement saveButton = driver.findElement(By.xpath("//button[@id = 'save']"));
        saveButton.click();

        WebElement navBar = driver.findElement(By.xpath("//a[@id = 'navbarDropdown']"));
        navBar.click();

        WebElement resetButton = driver.findElement(By.xpath("//a[@id = 'reset']"));
        resetButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

}
