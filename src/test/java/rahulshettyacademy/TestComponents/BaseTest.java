package rahulshettyacademy.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import rahualshettyacademy.objectpage.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public LandingPage landingPage;
    public static void initializeDriver() throws IOException {

        //properties class
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Pankaj\\eclipse-workspace\\SeleniumFramewor\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
        prop.load(file);
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();

        }
        else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
@BeforeMethod
    public LandingPage launchApplication() throws IOException {
         initializeDriver();
         landingPage = new LandingPage(driver);
        landingPage.gotoURL();
        return landingPage;


    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
