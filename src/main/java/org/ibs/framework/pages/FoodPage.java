package org.ibs.framework.pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Arkadiy_Alaverdyan
 * Стартовая страница приложения
 */
public class FoodPage extends BasePage {

    public FoodPage openProductList() {

        WebElement tittleProductsList = driverManager.getDriver().findElement(By.xpath("//h5"));
        Assertions.assertEquals("Список товаров", tittleProductsList.getText(),"Не перешли на страницу");
        return this;
    }
    public FoodPage clickAddButton()
    {

        WebElement additionButton = driverManager.getDriver().findElement(By.xpath("//button[@data-target = '#editModal']"));
        additionButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
    public FoodPage checkAddModalBox(String name, String type)
    {

        WebElement nameInputForm = driverManager.getDriver().findElement(By.xpath("//input[@id = 'name']"));
        nameInputForm.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        nameInputForm.sendKeys(name);
        Assertions.assertEquals(name, nameInputForm.getDomProperty("value"), "Форма наименования не заполнилась");


        WebElement typeInputForm = driverManager.getDriver().findElement(By.xpath("//select[@id = 'type']"));
        typeInputForm.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement fruitOption =driverManager.getDriver().findElement(By.xpath(String.format("//option[@value = '%s']", type)));
        fruitOption.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(type, typeInputForm.getDomProperty("value"), "Некорректный тип товара");

        return this;
    }
    public FoodPage clickExoticBox(String box)
    {
        WebElement checkboxExotic = driverManager.getDriver().findElement(By.xpath( String.format("//input[@id = '%s']", box)));
        checkboxExotic.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("true", checkboxExotic.getDomProperty("checked"), "Чекбокс не выставлен");
        return this;
    }
    public FoodPage clickSaveButton()
    {

        WebElement saveButton = driverManager.getDriver().findElement(By.xpath("//button[@id = 'save']"));
        saveButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    private WebElement bananaRecording = null;
    public FoodPage checkRecordSave(String name, String type, String box)
    {

        WebElement navBar = driverManager.getDriver().findElement(By.xpath("//a[@id = 'navbarDropdown']"));
        navBar.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try
        {

            bananaRecording = driverManager.getDriver().findElement(By.xpath(String.format("//tr[td= '%s' and td = '%s' and td ='%s']", name, type, box)));
        } catch(Exception e) {

        }
        if(bananaRecording == null) {
            Assertions.assertFalse(true, "Запись не найдена");
        }
        return this;
    }
    public FoodPage  checkResetRecord()
    {
        WebElement resetButton = driverManager.getDriver().findElement(By.xpath("//a[@id = 'reset']"));
        resetButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
