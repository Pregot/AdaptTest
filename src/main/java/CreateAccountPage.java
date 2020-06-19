
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CreateAccountPage extends BasePage {
    // SportsMaster locators
    @FindBy(xpath = "//div[@class = 'UserLoginBlock__link']/a")
    private WebElement SignUpButton;
    @FindBy(id = "firstName")
    private WebElement firstname;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "*//div[@class = 'UserRegistrationFormFields__gender']//div[2]")
    private WebElement genderM;
    @FindBy(id = "termsAcceptance")
    private WebElement termsAcceptance;
    @FindBy(className = "ButtonProxy")
    private WebElement submitButton;
    @FindBy(xpath = "*//div[6]//div//div//div/a")
    private WebElement okayButton;
    @FindBy(xpath = "//div[5]//div/div//a[@class = 'sportmaster-modal__quit']")
    private WebElement exitWelcomeUserPopup;
    @FindBy(className = "UserProfileSectionsHeadline--logout")
    private WebElement logoutButton;
    // SportsMaster locators
    Actions builder = new Actions(driver);
    private String randomemail = "";
    private String usserspassword = "GSMPGDSG85!";
    WebDriverWait wait = new WebDriverWait(driver, 5);
    HomePage objHomePage = new HomePage(driver);
    // gmail locators
    @FindBy(id = "login")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@class='sbut']")
    private WebElement submitEmail;
    @FindBy(xpath = "//tr//td[3]")
    private WebElement clickOnActivateYourMembership;

    // gmail locators
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage clickSignUpButton() {
        SignUpButton.click();
        return this;
    }

    public void fillTheRegistrationForm() {
        Random r = new Random();
        for (int i = 0; i < 8; i++) {
            randomemail += (char) (r.nextInt(25) + 97);
        }
        Action seriesOfActions = builder.sendKeys(firstname, "Justas")
                .sendKeys(lastName, "Monkevičius")
                .sendKeys(email, randomemail + "@yopmail.com")
                .sendKeys(password, usserspassword).click(genderM)
                .click(termsAcceptance).click(submitButton)
                .build();
        seriesOfActions.perform();
    }

    public CreateAccountPage clickOkayButton() {
        okayButton.click();
        return this;
    }

    public CreateAccountPage createEmailAndCheckInbox() throws InterruptedException {
        // waiting to receive a email
        Thread.sleep(60000);
        driver.navigate().to("http://www.yopmail.com/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        emailInput.sendKeys(randomemail);
        submitEmail.click();
        driver.switchTo().frame("ifmail");
        clickOnActivateYourMembership.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public CreateAccountPage logoutAndConnectAgain() {
        exitWelcomeUserPopup.click();
        logoutButton.click();
        objHomePage.clickSignInButton();
        email.sendKeys(randomemail + "@yopmail.com");
        password.sendKeys(usserspassword);
        submitButton.click();
        return this;
    }
}
