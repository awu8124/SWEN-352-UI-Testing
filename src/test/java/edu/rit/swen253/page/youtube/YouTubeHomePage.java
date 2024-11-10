package edu.rit.swen253.page.youtube;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTubeHomePage extends AbstractPage {

    @FindBy(name = "search_query")
    private WebElement searchInput;

    @FindBy(id = "search-icon-legacy")
    private WebElement searchButton;

    public YouTubeHomePage() {
        SeleniumUtils.getDriver().get("https://www.youtube.com");
    }

    /**
     * Method to search for a term on YouTube
     * 
     * @param searchTerm the term to search for
     */
    public void search(String searchTerm) {
        searchInput.sendKeys(searchTerm);
        searchButton.click();
    }
}
