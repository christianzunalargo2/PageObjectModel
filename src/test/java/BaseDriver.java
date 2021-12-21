import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseDriver {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setUpDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    @BeforeMethod
    @Parameters({"url"})
    public void setUp(String url) {
        driver.get(url);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
