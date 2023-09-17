package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    String HOME_PAGE_URL = "https://techcrunch.com/";
    String LATESTS_NEWS = ".post-block.post-block--unread";
    String AUTHORS = ".river-byline__authors";
    String IMAGES = ".post-block__media" ;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateHomePage() {
        getDriver().get(HOME_PAGE_URL);
    }

    public List<WebElement> getLatestNewsList() {

        return findElements(By.cssSelector(LATESTS_NEWS));
    }

    public List<WebElement> getAuthorsList() {

        return findElements(By.cssSelector(AUTHORS));
    }

    public List<WebElement> getNewsImageList() {

        return findElements(By.cssSelector(IMAGES));
    }

    public void clickLatestNews(int index)
    {
        List<WebElement> latestNews = getLatestNewsList();
        if (index >= 0 && index < latestNews.size()) {

            clickElements(By.cssSelector(LATESTS_NEWS), index);
        }
    }
}
