package org.ibs.framework.managers;

import org.ibs.framework.pages.FoodPage;



/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private FoodPage homePage;


    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link FoodPage}
     *
     * @return StartPage
     */
    public FoodPage getHomePage() {
        if (homePage == null) {
            homePage = new FoodPage();
        }
        return homePage;
    }
}
