package edu.rit.swen253.page.youtube;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.SeleniumUtils;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object for the YouTube video page
 */
public class YouTubeVideoPage extends AbstractPage {

    public YouTubeVideoPage() {
        PageFactory.initElements(SeleniumUtils.getDriver(), this);
    }

    /**
     * Method to get the page title.
     */
    public String getPageTitle() {
        return SeleniumUtils.getDriver().getTitle();
    }
}
