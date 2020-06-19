import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAccountTest extends BaseTest {
    HomePage objHomePage = new HomePage(driver);
    CreateAccountPage objCreateAccountPage = new CreateAccountPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, 5);

    @Test
    public void createAccountAndCheckIfaUserCanLoginTest() throws InterruptedException {
        objHomePage.clickAcceptButton().clickSignInButton();
        objCreateAccountPage.clickSignUpButton().fillTheRegistrationForm();
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("*//div//h5")),
                "Velkommen som medlem af Klub SPORTMASTER!")));
        objCreateAccountPage.clickOkayButton().createEmailAndCheckInbox().logoutAndConnectAgain();
        assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("UserProfileGreetings__text")),
                "Hej Justas, velkommen til din profil")));
    }
}
