package pankajpak.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pankajpack.objectpage.CartPage;
import pankajpack.objectpage.ProductCatalogue;
import pankajpak.TestComponents.BaseTest;
import pankajpak.TestComponents.Retry;

import java.io.IOException;
import java.util.List;

class ErrorValidation extends BaseTest {

    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException {
        // TODO Auto-generated method stub

        String productName = "ZARA COAT 3";


         landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpcon22");
        //        landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpopcon22");
//        Assert.assertEquals("Incorrect email or password".contains(landingPage.getErrorMessage()));
        Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());






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
