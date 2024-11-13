package edu.rit.swen253.page.google;

import edu.rit.swen253.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import edu.rit.swen253.page.AbstractPage;

public class GoogleHomePage extends AbstractPage {

    private static final By SEARCH_FIELD = By.name("q");

    public GoogleHomePage enterSearchText(String searchText) {
        WebElement searchField = SeleniumUtils.getDriver().findElement(SEARCH_FIELD);
        searchField.sendKeys(searchText);
        return this;
    }

    public GoogleSearchResultsPage submitSearch() {
        SeleniumUtils.getDriver().findElement(SEARCH_FIELD).submit();
        return new GoogleSearchResultsPage();
    }
}
