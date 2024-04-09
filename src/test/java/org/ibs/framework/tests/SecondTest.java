package org.ibs.framework.tests;

import org.junit.jupiter.api.Test;
import org.ibs.framework.basetestsclass.BaseTests;

public class SecondTest extends BaseTests {

    @Test
    void fruitTest() {
        app.getHomePage()
                .openProductList()
                .clickAddButton()
                .openAddModalBox()
                .checkAddModalBox("Картофель","VEGETABLE")
                .clickSaveButton()
                .checkRecordSave("Картофель","Овощ", "false")
                .checkResetRecord();

    }
}