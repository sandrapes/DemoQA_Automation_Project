package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomepagePage;
import Pages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    public HomepagePage homepagePage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get(homeURL);
        homepagePage = new HomepagePage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();
    }

    @Test (priority = 10)
    public void verifyThatUserCanSubmitValidInfoInTextBox() {
        homepagePage.clickOnElements();
        elementsPage.clickOnTextBoxButton();
        String fullName = excelReader.getStringData("Text Box", 1, 0);
        String email = excelReader.getStringData("Text Box", 1, 1);
        String currentAddress = excelReader.getStringData("Text Box", 1, 2);
        String permanentAddress = excelReader.getStringData("Text Box", 1, 3);

        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);

        scrollIntoView(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();

        String expectedNameVerification = excelReader.getStringData("Text Box", 4, 0);
        String expectedEmailVerification = excelReader.getStringData("Text Box", 4, 1);
        String expectedCurrentAddressVerification = excelReader.getStringData("Text Box", 4, 2);
        String expectedPermanentAddressVerification = excelReader.getStringData("Text Box", 4, 3);

        Assert.assertEquals(textBoxPage.fullNameVerification.getText(), expectedNameVerification);
        Assert.assertEquals(textBoxPage.emailVerification.getText(), expectedEmailVerification);
        Assert.assertEquals(textBoxPage.currentAddressText(), expectedCurrentAddressVerification);
        Assert.assertEquals(textBoxPage.permanentAddressText(), expectedPermanentAddressVerification);

    }

    @Test (priority = 20)
    public void verifyThatUserCannotSubmitInfoWithInvalidEmailAddressFormatInTextBox() {
        homepagePage.clickOnElements();
        elementsPage.clickOnTextBoxButton();
        String fullName = excelReader.getStringData("Text Box", 1, 0);
        String invalidEmail = excelReader.getStringData("Text Box", 1, 5);
        String currentAddress = excelReader.getStringData("Text Box", 1, 2);
        String permanentAddress = excelReader.getStringData("Text Box", 1, 3);

        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmail(invalidEmail);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);

        scrollIntoView(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();

        Assert.assertFalse(elementIsPresent(textBoxPage.fullNameVerification));
        Assert.assertFalse(elementIsPresent(textBoxPage.emailVerification));
        Assert.assertFalse(elementIsPresent(textBoxPage.currentAddressElementVerify));
        Assert.assertFalse(elementIsPresent(textBoxPage.permanentAddressElementVerify));

    }

}
