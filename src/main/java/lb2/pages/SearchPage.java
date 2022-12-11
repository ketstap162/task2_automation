package lb2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchPage {
    private final WebDriver driver;

    By resultSearch = By.xpath("//span[@class='a-color-state a-text-bold']");
    By productListSearchResult = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextOfResultSearch() { return driver.findElement(resultSearch).getText().replace("\"", "");}


    public List<WebElement> getListOfProduct() {return driver.findElements(productListSearchResult);}



}
