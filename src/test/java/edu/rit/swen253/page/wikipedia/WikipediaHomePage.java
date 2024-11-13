package edu.rit.swen253.page.wikipedia;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaHomePage extends AbstractPage {

    @FindBy(name = "search")
    private WebElement searchInput;

    private WebDriver driver;
    private WebDriverWait wait;

    public WikipediaHomePage() {
        this.driver = SeleniumUtils.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.wikipedia.org/");
        PageFactory.initElements(driver, this); // Initialize elements
    }

    /**
     * Method to search a phrase on Wikipedia
     * 
     * @param phrase the term to search for
     */
    public void enterSearchPhrase(String phrase) {
        wait.until(ExpectedConditions.visibilityOf(searchInput)); // Wait for searchInput to be visible
        searchInput.sendKeys(phrase);
        searchInput.sendKeys(Keys.RETURN);
    }
}
