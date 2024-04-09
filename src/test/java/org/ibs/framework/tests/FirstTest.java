package org.ibs.framework.tests;

import org.junit.jupiter.api.Test;
import org.ibs.framework.basetestsclass.BaseTests;

public class FirstTest extends BaseTests {

    @Test
    void fruitTest() {
        app.getHomePage()
                .openProductList()
                .clickAddButton()
                .openAddModalBox()
                .checkAddModalBox("Банан","FRUIT")
                .clickExoticBox("exotic")
                .clickSaveButton()
                .checkRecordSave("Банан","Фрукт", "true")
                .checkResetRecord();

    }
}
