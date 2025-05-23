package rahulshettyacademy.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahualshettyacademy.objectpage.CartPage;
import rahualshettyacademy.objectpage.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

import java.io.IOException;
import java.util.List;

class ErrorValidation extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() throws IOException {
        // TODO Auto-generated method stub

        String productName = "ZARA COAT 3";


         landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpocon22");
        //        landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpopcon22");
//        Assert.assertEquals("Incorrect email or password".contains(landingPage.getErrorMessage()));
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());






    }
    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {
        // TODO Auto-generated method stub

        String productName = "ZARA COAT 3";


        ProductCatalogue productCatalogue = landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpopcon22");
        //        landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpopcon22");


        List<WebElement> products= productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.gotoCartPage();
        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);



    }



}
