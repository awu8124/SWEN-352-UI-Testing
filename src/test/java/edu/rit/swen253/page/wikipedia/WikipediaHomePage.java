package edu.rit.swen253.page.wikipedia;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.page.PageFactory;
import edu.rit.swen253.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikipediaHomePage extends AbstractPage {

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    public WikipediaHomePage() {
        SeleniumUtils.getDriver().get("https://www.wikipedia.org/");
        // Wait for video page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Wikipedia"));
    }

    public void enterSearchPhrase(String phrase){
        searchInput.sendKeys(phrase);
        searchInput.sendKeys(Keys.RETURN);    
    }

  }
  
