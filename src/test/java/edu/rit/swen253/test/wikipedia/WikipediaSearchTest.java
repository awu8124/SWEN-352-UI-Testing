package edu.rit.swen253.test.wikipedia;

import edu.rit.swen253.page.wikipedia.WikipediaHomePage;
import edu.rit.swen253.page.wikipedia.WikipediaResultsPage;
import edu.rit.swen253.utils.SeleniumUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import edu.rit.swen253.test.AbstractWebTest;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Disabled;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WikipediaSearchTest extends AbstractWebTest {
    
    @Test
    public void testSearchAndNavigate() {
        WebDriver driver = SeleniumUtils.getDriver();
        
        WikipediaHomePage homePage = new WikipediaHomePage();
        homePage.enterSearchPhrase("page object model");
        
        WikipediaResultsPage resultsPage = new WikipediaResultsPage();
        
        resultsPage.logResults();
        resultsPage.clickFirstResult();
        
        // Validate navigation to the expected page
        boolean isCorrectPage = driver.getCurrentUrl().contains("Page_object_model");
        assertTrue(isCorrectPage, "Failed to navigate to the expected page");
    }
}
