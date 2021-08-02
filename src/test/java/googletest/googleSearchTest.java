package googletest;

import org.junit.Test;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.List;

public class googleSearchTest extends BaseTest {

    @Test
    public void testGoogleSearch() {

        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.searchText("yandex.ru");
        searchPage.verifyFirstSuggestion("yandex.ru");

    }

}
