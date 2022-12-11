package lb2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;

public class HomePage {
    private final WebDriver driver;

    By searchLocator = By.id("twotabsearchtextbox");
    By searchButtonLocator = By.id("nav-search-submit-button");
    By nameSalesPost = By.className("a-cardui-header");
    By cartLocator = By.xpath("//a[@id='nav-cart']");
    By electronicsLocator = By.cssSelector("#COrL-Jj2DEq6BK9lEmW9yw > div.a-cardui-footer > a");

    public HomePage(WebDriver driver) { this.driver = driver;}
    public WebDriver getDriver() {return driver;}

    public void enterTextIntoSearchBar(String text) {
        driver.findElement(searchLocator).sendKeys(text);
    }
    public SearchPage clickSearch() {
        driver.findElement(searchButtonLocator).click();
        return new SearchPage(driver);
    }

    public List<WebElement> getNamesSalesPost() {
        return driver.findElements(nameSalesPost);
    }

    public CartPage getCartPage() {
        driver.findElement(cartLocator).click();
        return new CartPage(driver);
    }

    public CategoryPage getCategoryPageOfElectronics() {
//        return new CategoryPage(driver.get("https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_Electronics_1x._SY304_CB432774322_.jpg");)
        driver.findElement(electronicsLocator).click();
        return new CategoryPage(driver);
    }
}
