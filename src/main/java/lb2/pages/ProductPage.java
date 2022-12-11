package lb2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private final WebDriver driver;

    @FindBy(id = "productTitle")
    WebElement nameProduct;

    @FindBy(xpath = "//*[@id=\"productDetails_detailBullets_sections1\"]/tbody/tr[1]/td")
    WebElement asin;

    @FindBy(xpath = "//*[@id=\"productDetails_detailBullets_sections1\"]/tbody/tr[2]/td")
    WebElement releaseDate;

    public ProductPage(WebDriver driver) {this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getNameProduct() {return nameProduct.getText();}

    public String getAsinOfProduct() {return  asin.getText();}

    public String getReleaseDate() {return  releaseDate.getText();}
}
