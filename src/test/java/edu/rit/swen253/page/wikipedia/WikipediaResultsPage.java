package edu.rit.swen253.page.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.SeleniumUtils;
import java.util.List;

public class WikipediaResultsPage extends AbstractPage{
    
    @FindBy(css = "div.mw-search-result-heading > a")
    private List<WebElement> searchResults;

    public WikipediaResultsPage() {
        PageFactory.initElements(SeleniumUtils.getDriver(), this);
    }

    /* Method to click the first result on the page
     */
    public void clickFirstResult() {
        if (!searchResults.isEmpty()) {
            searchResults.get(0).click();
        } else {
            System.out.println("No search results available");
        }
    }

    /*
     * Method to log the results of the search. Takes the title and URL of each result.
     */
    public void  logResults(){
        for (WebElement result : searchResults) {
            try {
                String title = result.getText();
                String url = result.getAttribute("href");
                System.out.println("Title: " + title + ", URL: " + url);
            } catch (RuntimeException e) {
                System.out.println("Error finding Wikipedia title or URL for a result: " + e.getMessage());
            }
        }
    }

    
}
