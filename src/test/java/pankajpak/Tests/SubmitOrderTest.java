package pankajpak.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pankajpack.objectpage.*;
import pankajpak.TestComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

     String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
        // TODO Auto-generated method stub





        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
        System.out.println("Logging in with email: " + input.get("email"));


        //        landingPage.loginApplication("rajpal1996kumar@gmail.com","POPpopcon22");
        List<WebElement> products= productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("productName"));
        CartPage cartPage = productCatalogue.gotoCartPage();

        Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

    @Test(dependsOnMethods = {"SubmitOrder"})
    public void orderHistoryTest(HashMap<String,String> input){
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
        System.out.println("Logging in with email: " + input.get("email"));


        OrderPage orderPage= productCatalogue.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(input.get("productName")));

    }

    @DataProvider
    public Object[][] getData() throws IOException {

//        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\ src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");


        //        HashMap<String ,String > map = new HashMap<String,String>();
//        map.put("email","rajpal1996kumar@gmail.com");
//        map.put("password","POPpopcon22");
//        map.put("productName","ZARA COAT 3");
//        HashMap<String ,String > map1 = new HashMap<String,String>();
//        map1.put("email","panaraju@gmail.com");
//        map1.put("password","PANApana2@");
//        map1.put("productName","ADIDAS ORIGINAL");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }



}
