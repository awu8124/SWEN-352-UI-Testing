package edu.rit.swen253.test.youtube;

import edu.rit.swen253.page.youtube.YouTubeHomePage;
import edu.rit.swen253.page.youtube.YouTubeSearchResultsPage;
import edu.rit.swen253.test.AbstractWebTest;
import edu.rit.swen253.utils.SeleniumUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class YouTubeSearchTest extends AbstractWebTest {

    @Test
    @Order(1)
    public void testSearchAndNavigate() {
        WebDriver driver = SeleniumUtils.getDriver();

        // Navigate to YouTube and create YouTubeHomePage
        YouTubeHomePage homePage = navigateToPage("https://www.youtube.com", YouTubeHomePage::new);
        PageFactory.initElements(driver, homePage);

        // Perform the search
        homePage.search("page object model");

        // Create YouTubeSearchResultsPage after search is performed
        YouTubeSearchResultsPage resultsPage = assertNewPage(YouTubeSearchResultsPage::new);
        PageFactory.initElements(driver, resultsPage);

        // Log results and click the first result
        resultsPage.logResults();
        resultsPage.clickFirstResult();

        // Wait to makee sure the page loads before continuing
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Page Object"));

        // Validate navigation successs by checking if the page title contains
        // part of the expected title
        String pageTitle = driver.getTitle();
        if (!pageTitle.toLowerCase().contains("page object")) {
            throw new AssertionError("The page title does not contain 'Page Object'. Actual title: " + pageTitle);
        }
    }
}
