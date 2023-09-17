package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContentPage extends BasePage {

    String CONTENT_TITLE = ".article__title";
    String CONTENT_LINKS = ".article-container a";


    public ContentPage(WebDriver driver) {
        super(driver);
    }

    public String getBrowserTitle()
    {
        return getDriver().getTitle();
    }


    public String getContentTitle()
    {
      return findElement(By.cssSelector(CONTENT_TITLE)).getText();

    }

    public List<WebElement> getLinksList() {

        return findElements(By.cssSelector(CONTENT_LINKS));
    }

    public List<String> getLinksArrayList()
    {
        List<WebElement> contentLinks = getLinksList();
        List<String> urlList = new ArrayList<String>();
        for (WebElement element : contentLinks)
        {
            String url = element.getAttribute("href");
            urlList.add(url);
        }

        return urlList;
    }




}
