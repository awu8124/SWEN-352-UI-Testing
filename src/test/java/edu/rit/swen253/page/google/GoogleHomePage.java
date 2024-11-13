package edu.rit.swen253.page.google;

import edu.rit.swen253.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import edu.rit.swen253.page.AbstractPage;


public class GoogleHomePage extends AbstractPage {

    private static final By SEARCH_FIELD = By.name("q");

    /**
     * Enters a search term into Google's search input field.
     *
     * @param searchText The text to be searched.
     * @return This GoogleHomePage instance, allowing method chaining.
     */
    public GoogleHomePage enterSearchText(String searchText) {
        WebElement searchField = SeleniumUtils.getDriver().findElement(SEARCH_FIELD);
        searchField.sendKeys(searchText);
        return this;
    }

    /**
     * Submits the search query entered into Google's search field.
     *
     * @return A GoogleSearchResultsPage object representing the search results page.
     */
    public GoogleSearchResultsPage submitSearch() {
        SeleniumUtils.getDriver().findElement(SEARCH_FIELD).submit();
        return new GoogleSearchResultsPage();
    }
}
