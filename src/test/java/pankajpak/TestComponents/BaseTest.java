package pankajpak.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pankajpack.objectpage.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static org.apache.commons.io.FileUtils.readFileToString;

public class BaseTest {
    public static WebDriver driver;
//    private LandingPage landingPage;

    public LandingPage landingPage;

    public static WebDriver initializeDriver() throws IOException {

        //properties class
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Pankaj\\eclipse-workspace\\SeleniumFramewor\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
        prop.load(file);
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
//        else if (browserName.equalsIgnoreCase("edge")) {
//            WebDriverManager.chromedriver().setup();
//             driver = new ChromeDriver();
//
//        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return null;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);


        return System.getProperty("user.dir" + "//reports//" + testCaseName + ".png");
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
//        System.out.println("Initializing driver...");
        initializeDriver();
//        System.out.println("Driver initialized: " + (driver != null));
        landingPage = new LandingPage(driver);
//        System.out.println("Landing page object created");

        landingPage.gotoURL();
//        System.out.println("Navigated to URL");
        return landingPage;


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string
        String jsonContent = readFileToString(new File(filePath), StandardCharsets.UTF_8);

        //string to hash map-jackson Data bind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

}
