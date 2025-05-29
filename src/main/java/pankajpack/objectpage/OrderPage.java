package pankajpack.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pankajpack.AbstractComponents.AbstractComponent;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;



    public OrderPage(WebDriver driver){
        super(driver);

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;
    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> productNames;


    public Boolean verifyOrderDisplay(String productName){
        boolean match;
        match = productNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

}
