package rahualshettyacademy.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahualshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;



    public CartPage(WebDriver driver){
        super(driver);

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;
    @FindBy(css =".totalRow button" )
    WebElement checkoutEle;


    public Boolean verifyProductDisplay(String productName){
        Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckoutPage goToCheckout(){
        checkoutEle.click();
        return new CheckoutPage(driver);

    }
}
