package rahulshettyacademy.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahualshettyacademy.objectpage.*;
import rahulshettyacademy.TestComponents.BaseTest;

import java.io.IOException;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test
    public void SubmitOrder() throws IOException {
        // TODO Auto-generated method stub

        String productName = "ZARA COAT 3";



        ProductCatalogue productCatalogue = landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpopcon22");
        //        landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpopcon22");


        List<WebElement> products= productCatalogue.getProductList();
        productCatalogue.addProductToCard(productName);
        CartPage cartPage = productCatalogue.gotoCartPage();

        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }



}
