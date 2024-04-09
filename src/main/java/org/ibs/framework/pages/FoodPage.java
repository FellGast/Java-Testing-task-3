package org.ibs.framework.pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Arkadiy_Alaverdyan
 * Стартовая страница приложения
 */
public class FoodPage extends BasePage {

    @FindBy(xpath = "//h5")
    private WebElement tittleProductsList;
    @FindBy(xpath = "//button[@data-target = '#editModal']")
    private WebElement additionButton;



    /**
     * Закрытия сообщения cookies
     *
     * @return HomePage - т.е. остаемся на этой странице
     */
    public FoodPage openProductList() {
        Assertions.assertEquals("Список товаров", tittleProductsList.getText(), "Не перешли на страницу");
        return this;
    }
    public FoodPage clickAddButton()
    {
        waitUtilElementToBeClickable(additionButton).click();
        return this;
    }
    public FoodPage openAddModalBox()
    {
        WebElement tittleAdditionForm = null;
        try
        {
            tittleAdditionForm = driverManager.getDriver().findElement(By.xpath("//div[@class = 'modal-backdrop fade show']"));
        } catch(Exception e) {

        }

        if(tittleAdditionForm == null) {
            Assertions.assertFalse(true, "Форма добавления не открылась");
        }
        return this;
    }
    public FoodPage checkAddModalBox()
    {
        WebElement nameInputForm = driverManager.getDriver().findElement(By.xpath("//input[@id = 'name']"));
        nameInputForm.click();
        nameInputForm.sendKeys("Банан");
        Assertions.assertEquals("Банан", nameInputForm.getDomProperty("value"), "Форма наименования не заполнилась");


        WebElement typeInputForm = driverManager.getDriver().findElement(By.xpath("//select[@id = 'type']"));
        typeInputForm.click();
        WebElement fruitOption =driverManager.getDriver().findElement(By.xpath("//option[@value = 'FRUIT']"));
        fruitOption.click();
        Assertions.assertEquals("FRUIT", typeInputForm.getDomProperty("value"), "Некорректный тип товара");


        WebElement checkboxExotic = driverManager.getDriver().findElement(By.xpath("//input[@id = 'exotic']"));
        checkboxExotic.click();
        Assertions.assertEquals("true", checkboxExotic.getDomProperty("checked"), "Чекбокс не выставлен");

        return this;
    }
    public FoodPage clickSaveButton()
    {
        WebElement navBar = driverManager.getDriver().findElement(By.xpath("//a[@id = 'navbarDropdown']"));
        navBar.click();
        return this;
    }
    private WebElement bananaRecording = null;
    public FoodPage checkRecordSave()
    {
        try
        {
            bananaRecording = driverManager.getDriver().findElement(By.xpath("//tr[td= 'Банан' and td = 'Фрукт' and td ='true']"));
        } catch(Exception e) {

        }
        if(bananaRecording == null) {
            Assertions.assertFalse(true, "Запись не найдена");
        }
        return this;
    }
    public FoodPage checkResetRecord()
    {
        WebElement resetButton = driverManager.getDriver().findElement(By.xpath("//a[@id = 'reset']"));
        resetButton.click();

        if (bananaRecording != null) {
            try {
                Assertions.assertFalse(bananaRecording.isDisplayed(), "Запись не была удалена");
            } catch (Exception e) {

            }
        } else {
            throw new RuntimeException("Элемент не найден");
        }
        return this;
    }
}
