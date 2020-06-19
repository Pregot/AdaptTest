import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    @FindBy(className = "coi-banner__accept")
    private WebElement acceptButton;
    @FindBy(xpath = "//div[@class = 'HeaderUser']/a")
    private WebElement SignInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickAcceptButton() {
        acceptButton.click();
        return this;
    }

    public HomePage clickSignInButton() {
        SignInButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }
}
