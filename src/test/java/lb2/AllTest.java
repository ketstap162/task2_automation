package lb2;

import lb2.conf.ConfProperties;
import lb2.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;


class AllTest {
    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CategoryPage categoryPage;
    private CartPage cartPage;

    @BeforeEach
    public void init() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        homePage = new HomePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("homePage"));
    }

    @AfterEach
    public void tearDown() {homePage.getDriver().quit();}

    @Test
    public void homePageContainsPostForSales_1() {
        String text = ConfProperties.getProperty("salesPost_1");
        List<String> listSalesPost = new ArrayList<>();
        homePage.getNamesSalesPost().forEach(webElement -> listSalesPost.add(webElement.getText()));
        listSalesPost.forEach(System.out::println);
        assertTrue(listSalesPost.contains(text));
    }

    @Test
    public void homePageContainsPostForSales_2() {
        String text = ConfProperties.getProperty("salesPost_2");
        List<String> listSalesPost = new ArrayList<>();
        homePage.getNamesSalesPost().forEach(webElement -> listSalesPost.add(webElement.getText()));
        listSalesPost.forEach(System.out::println);
        assertTrue(listSalesPost.contains(text));
    }

    @Test
    public void searchProduct() {
        String text = ConfProperties.getProperty("searchProduct");
        homePage.enterTextIntoSearchBar(text);
        String actual = homePage.clickSearch().getTextOfResultSearch();
        assertEquals(text, actual);
    }





    @Test
    public void isListOfProductsNoEmpty() {
        homePage.enterTextIntoSearchBar(ConfProperties.getProperty("searchProduct"));
        searchPage =  homePage.clickSearch();
        List<WebElement> products = searchPage.getListOfProduct();
        assertFalse(products.isEmpty());
    }

    @Test
    public void listOfProductsMoreThan10nPage() {
        homePage.enterTextIntoSearchBar(ConfProperties.getProperty("searchProduct"));
        searchPage = homePage.clickSearch();
        List<WebElement> products = searchPage.getListOfProduct();
        assertTrue(products.size() > 10);
    }


    @Test
    public void getAsinProduct() throws InterruptedException {
        productPage = homePage.getCategoryPageOfElectronics().getProductByName(ConfProperties.getProperty("productName"));
        assertEquals(ConfProperties.getProperty("priceOfProduct"), productPage.getAsinOfProduct());
    }

    @Test
    public void getReleaseDate() throws InterruptedException {
        productPage = homePage.getCategoryPageOfElectronics().getProductByName(ConfProperties.getProperty("productName"));
        assertEquals(ConfProperties.getProperty("releaseDate"), productPage.getReleaseDate());

    }

    @Test
    public void getNameProduct() throws InterruptedException {
        productPage = homePage.getCategoryPageOfElectronics().getProductByName(ConfProperties.getProperty("productName"));
        assertEquals(ConfProperties.getProperty("productName"), productPage.getNameProduct());
    }

    @Test
    void getStatusCart() {
        cartPage = homePage.getCartPage();
        assertEquals(ConfProperties.getProperty("statusCart"), cartPage.getStatusCart());
    }

    @Test
    void getLocatorSigIn() {
        cartPage = homePage.getCartPage();
        assertEquals(ConfProperties.getProperty("signIn"), cartPage.getLocatorSigIn());
    }

    @Test
    void getLocatorSignUp() {
        cartPage = homePage.getCartPage();
        assertEquals(ConfProperties.getProperty("signUp"), cartPage.getLocatorSignUp());
    }
}
