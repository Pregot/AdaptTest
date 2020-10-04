import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static WebDriver driver;
    private Base

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://sportmaster.dk/");
        driver.manage().window().maximize();
        
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
