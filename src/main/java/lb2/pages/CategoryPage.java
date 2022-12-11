package lb2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class CategoryPage {

    private final WebDriver driver;

    private By productListSearchResult = By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']");

    public CategoryPage(WebDriver driver) {this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getListOfProduct() {return driver.findElements(productListSearchResult);}


    public ProductPage getProductByName(String  name) {
        if(isProductByName(name)) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            getListOfProduct().stream().filter(webElement -> webElement.getText().equals(name)).findFirst().get().click();
            return new ProductPage(driver);
        }
        else return null;
    }

    public boolean isProductByName(String  name) {
        return getListOfProduct().stream().anyMatch(webElement -> webElement.getText().equals(name));
    }
}
