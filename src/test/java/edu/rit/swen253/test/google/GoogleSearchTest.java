package edu.rit.swen253.test.google;

import edu.rit.swen253.page.google.GoogleHomePage;
import edu.rit.swen253.page.google.GoogleSearchResultsPage;
import edu.rit.swen253.utils.SeleniumUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import edu.rit.swen253.test.AbstractWebTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

@TestMethodOrder(OrderAnnotation.class)
public class GoogleSearchTest extends AbstractWebTest {

    @Test
    public void testSearchAndNavigate() {
        // Navigate to Google home page
        GoogleHomePage homePage = SeleniumUtils.navigateToPage("https://www.google.com", GoogleHomePage::new);
        
        // Enter the search text and submit
        GoogleSearchResultsPage resultsPage = homePage.enterSearchText("page object model").submitSearch();
        
        // Log and print search results
        resultsPage.logResults();
        
        // Click the first search result
        resultsPage.clickFirstResult();
        
        // Validate navigation to the expected page by checking part of the URL
        assertTrue(SeleniumUtils.getCurrentUrl().contains("selenium.dev/documentation/test_practices/encouraged/page_object_models"), 
                   "Navigation to expected page failed.");
    }
}
