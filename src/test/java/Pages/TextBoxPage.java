package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage extends BaseTest {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "name")
    public WebElement fullNameVerification;

    @FindBy(id = "email")
    public WebElement emailVerification;

    @FindBy(id = "currentAddress")
    public List<WebElement> currentAddress;

    @FindBy(id = "permanentAddress")
    public List<WebElement> permanentAddress;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")
    public WebElement currentAddressElementVerify;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")
    public WebElement permanentAddressElementVerify;

    //------------------------------------------------------

    public void insertFullName(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void insertEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress) {
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }

    public void insertPermanentAddress(String permanentAddress) {
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public String permanentAddressText() {
        String expected = "";
        for (int i = 0; i < permanentAddress.size(); i++) {
            expected = permanentAddress.get(1).getText();
        }
        return expected;
    }

    public String currentAddressText() {
        String expected = "";
        for (int i = 0; i < currentAddress.size(); i++) {
            expected = currentAddress.get(1).getText();
        }
        return expected;
    }


}
