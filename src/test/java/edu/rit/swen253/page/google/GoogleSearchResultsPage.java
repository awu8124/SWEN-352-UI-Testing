package edu.rit.swen253.page.google;

import edu.rit.swen253.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.logging.Logger;
import edu.rit.swen253.page.AbstractPage;


public class GoogleSearchResultsPage extends AbstractPage {
    private static final By RESULTS = By.cssSelector("div.g");
    private static final Logger logger = Logger.getLogger(GoogleSearchResultsPage.class.getName());

    /**
     * Logs each search result's title and URL.
     * Prints the title and URL to the console and logs 
     * If any results are missing elements, they are skipped
     */
    public void logResults() {
        List<WebElement> results = SeleniumUtils.getDriver().findElements(RESULTS);
        for (WebElement result : results) {
            try {
                String title = result.findElement(By.tagName("h3")).getText();
                String url = result.findElement(By.tagName("a")).getAttribute("href");
                logger.info("Title: " + title + ", URL: " + url);
                
                // Print the result to console for verification
                System.out.println("Title: " + title + ", URL: " + url);
            } catch (Exception e) {
                System.out.println("A result was skipped due to missing elements.");
            }
        }
    }

    /**
     * Clicks on the first search result link.
     */
    public void clickFirstResult() {
        SeleniumUtils.getDriver().findElements(RESULTS).get(0).findElement(By.tagName("a")).click();
    }
}
