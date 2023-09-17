package test;

import base.BaseTest;
import base.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import page.ContentPage;
import page.HomePage;

import java.util.ArrayList;
import java.util.List;

public class TechCrunchTest extends BaseTest {

    static HomePage homePage;
    static ContentPage contentPage;

    @Before
    public void before() {

        homePage = new HomePage(getDriver());
        contentPage = new ContentPage(getDriver());

    }

    @Test
    public void TestTechCrunch() throws InterruptedException {

        Logger.info("1. Navigate to the Tech Crunch website");
        homePage.navigateHomePage();
        homePage.analyzeLog();
        Logger.info("Navigated to the website successfully!");

        Logger.info("2. Check the each news has an author and image in the Latest News List");

        List<WebElement> latestNews = homePage.getLatestNewsList();
        List<WebElement> authors = homePage.getAuthorsList();
        List<WebElement> images = homePage.getNewsImageList();

        System.out.println(latestNews.size());
        System.out.println(authors.get(19).getText());

        for (int i =0; i< latestNews.size(); i++)
        {
            Assert.assertTrue("Author not found for a news article.", authors.get(i).isDisplayed());
            Assert.assertTrue("Image not found for a news article.", images.get(i).isDisplayed());
        }

        Logger.info("Author and image in the news checked successfully!");

        Logger.info("3. Click one of news from “The Latest News” list and verify browser title is the same with content title");
        homePage.clickLatestNews(5);
        String contentTitle = contentPage.getContentTitle();
        String browserTitle = contentPage.getBrowserTitle();

        String newBrowserTitle = browserTitle.substring(0,browserTitle.length()-13);

        Assert.assertEquals("Browser title doesn't match the content title.", newBrowserTitle, contentTitle );
        Logger.info("The content title and browser title are the same checked successfully!");

        System.out.println(newBrowserTitle);
        System.out.println(contentTitle);
        System.out.println(browserTitle);


        System.out.println(contentPage.getLinksArrayList());















        /*
        for (WebElement news : latestNews) {
            WebElement author = news.findElement(By.cssSelector(".river-byline__authors"));
            WebElement image = news.findElement(By.cssSelector(".post-block__media"));

            Assert.assertTrue("Author not found for a news article.", author.isDisplayed());
            Assert.assertTrue("Image not found for a news article.", image.isDisplayed());

         */

         tearDown();

        }

    }



