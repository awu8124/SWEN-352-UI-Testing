package edu.rit.swen253.page.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.SeleniumUtils;

import java.util.List;

/**
 * Page object for the YouTube search results page
 */
public class YouTubeSearchResultsPage extends AbstractPage {

    @FindBy(tagName = "ytd-video-renderer")
    private List<WebElement> videoResults;

    public YouTubeSearchResultsPage() {
        PageFactory.initElements(SeleniumUtils.getDriver(), this);
    }

    /**
     * Method to log all the search results' titles and URLs
     * 
     * @throws RuntimeException if an error occurs while finding the title or URL of
     *                          a result
     */
    public void logResults() {
        for (WebElement result : videoResults) {
            try {
                WebElement titleElement = result.findElement(By.id("video-title"));
                String title = titleElement.getText();
                String url = titleElement.getAttribute("href");
                System.out.println("Title: " + title + ", URL: " + url);
            } catch (RuntimeException e) {
                System.out.println("Error finding video title or URL for a result: " + e.getMessage());
            }
        }
    }

    /**
     * Method to click on the first search result
     * 
     * @throws RuntimeException if no search results are available to click on
     */
    public void clickFirstResult() {
        if (!videoResults.isEmpty()) {
            videoResults.get(0).click();
        } else {
            throw new RuntimeException("No search results available to click on.");
        }
    }
}