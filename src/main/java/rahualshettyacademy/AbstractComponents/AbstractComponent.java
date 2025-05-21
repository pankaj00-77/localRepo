package rahualshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahualshettyacademy.objectpage.CartPage;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    public AbstractComponent(WebDriver driver) {

            this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "[routerLink*='cart']")
    WebElement cartHeader;
    public void waitForElementAppear(By findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
    }

        public void waitForElementToDisappear(WebElement ele) {
//        Thread.sleep(4000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOf(ele));
        }
    public void waitForWebElementAppear(WebElement findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findby));
    }

    public CartPage gotoCartPage(){
        cartHeader.click();

        return new CartPage(driver);
    }

}
