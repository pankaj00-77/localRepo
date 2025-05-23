package rahualshettyacademy.objectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahualshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;




    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    //Page factory
//    List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css = ".mb-3")
    List<WebElement> products;
    @FindBy(css = ".ng-animating")
    WebElement waitToDisappear;

    By product=By.cssSelector(".mb-3");
    By addproduct =By.cssSelector(".card-body button:last-of-type");
    By tostMessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList(){
        waitForElementAppear(product);
        return products;
    }

    public WebElement getProductByName(String productName){
        WebElement prod =	getProductList().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }
    public void addProductToCart  (String productName) throws InterruptedException {
        WebElement prod= getProductByName(productName);
        prod.findElement(addproduct).click();
        waitForElementAppear(tostMessage);
        waitForElementToDisappear(waitToDisappear);



    }


    public void addProductToCard(String productName) {
    }
}
