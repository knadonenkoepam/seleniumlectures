package pages;

import driverutils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchPage {

    WaitActions waitActions;
    WebDriver webDriver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;
    @FindBy(xpath = "//li[@class='sbct']")
    private List<WebElement> suggestionList;

    public SearchPage(WebDriver webDriver1) {
        PageFactory.initElements(webDriver1, this);
        waitActions = new WaitActions(webDriver1);
    }

    public void searchText(String textToSearch) {
        searchInput.sendKeys(textToSearch);
    }

    public void verifyFirstSuggestion(String correctText) {
        waitForSuggestionsToAppear();
        assertEquals(correctText, suggestionList.get(0).getText());
    }

    private void waitForSuggestionsToAppear() {
        waitActions.waitUntilCondition(ex -> suggestionList.size() != 1);
    }

}
