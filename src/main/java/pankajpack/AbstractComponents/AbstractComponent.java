package pankajpack.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pankajpack.objectpage.CartPage;
import pankajpack.objectpage.OrderPage;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    public pankajpack.objectpage.OrderPage OrderPage;
    public pankajpack.objectpage.CartPage CartPage;

    public AbstractComponent(WebDriver driver) {

            this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "[routerLink*='cart']")
    WebElement cartHeader;
    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElementAppear(By findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
    }

        public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(1000);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.invisibilityOf(ele));
        }
    public void waitForWebElementAppear(WebElement findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findby));
    }

    public CartPage gotoCartPage(){
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    public OrderPage goToOrderPage(){
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);

        return orderPage;
    }

}
