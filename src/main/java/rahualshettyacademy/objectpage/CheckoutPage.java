package rahualshettyacademy.objectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahualshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;
    @FindBy(css = ".btnn")
    WebElement submit;
    @FindBy(xpath = "//button[2]")
    WebElement selectCountry;
    By result = By.cssSelector(".ta-results");

    public void selectCountry(String countryName){
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();



        selectCountry.click();
    }
    public ConfirmationPage submitOrder(){
        submit.click();
        return new ConfirmationPage(driver);
    }




}
