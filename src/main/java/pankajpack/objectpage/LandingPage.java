package pankajpack.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pankajpack.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
    WebDriver driver;




    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
//    WebElement userEmail = driver.findElement(By.id("userEmail"));
//    driver.findElement(By.id("userPassword")).sendKeys("POPpopcon22");
//driver.findElement(By.id("login")).click();

    //Page factory
    @FindBy(id = "userEmail")
    WebElement emailField;

    @FindBy(id = "userPassword")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement submitButton;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCatalogue loginApplication(String userEmail, String password){
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(password);
        submitButton.click();
        ProductCatalogue productCatalogue; //ye humne es liye likha hai kyoki login page ke bad productCatalogue page hi khulna hai to es loginApplication method ke through hi open kr lena jada acha hai ese test.java folder main object baar baar likhna nhi padega
        productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }
    public String getErrorMessage(){
        waitForWebElementAppear(errorMessage);
            return errorMessage.getText();
    }

    public void gotoURL() {
        driver.get("https://rahulshettyacademy.com/client");
    }

}
