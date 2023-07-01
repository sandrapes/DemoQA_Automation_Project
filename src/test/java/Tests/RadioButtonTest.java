package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomepagePage;
import Pages.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    public HomepagePage homepagePage;
    public ElementsPage elementsPage;
    public RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        elementsPage = new ElementsPage();
        radioButtonPage = new RadioButtonPage();
        driver.get(homeURL);
    }

    @Test(priority = 10)
    public void verifyThatAllElementsArePresent() {
        homepagePage.clickOnElements();
        elementsPage.clickOnRadioButtonButton();
        String expectedHeader = excelReader.getStringData("Radio Button", 0, 2);

        Assert.assertEquals(radioButtonPage.header.getText(), expectedHeader);

        for (int i = 0; i < radioButtonPage.yesImpressiveButtonsDisplayed.size(); i++) {
            Assert.assertTrue(elementIsPresent(radioButtonPage.yesImpressiveButtonsDisplayed.get(i)));

        }

        Assert.assertTrue(elementIsPresent(radioButtonPage.noButtonDisplayed));

    }

    @Test(priority = 20)
    public void verifyThatUserCanSelectYesRadioButon() {
        homepagePage.clickOnElements();
        elementsPage.clickOnRadioButtonButton();
        radioButtonPage.selectButton(radioButtonPage.yesButton);
        String expectedText = excelReader.getStringData("Radio Button", 0, 0);

        Assert.assertEquals(radioButtonPage.textDisplayed.getText(), expectedText);
        Assert.assertTrue(radioButtonPage.yesButton.isSelected());

    }

    @Test (priority = 30)
    public void verifyThatUserCanSelectImpressiveRadioButon() {
        homepagePage.clickOnElements();
        elementsPage.clickOnRadioButtonButton();
        radioButtonPage.selectButton(radioButtonPage.impressiveButton);
        String expectedText = excelReader.getStringData("Radio Button", 0, 1);

        Assert.assertEquals(radioButtonPage.textDisplayed.getText(), expectedText);
        Assert.assertTrue(radioButtonPage.impressiveButton.isSelected());

    }

    @Test (priority = 40)
    public void verifyThatUserCannotSelectNoRadioButon() {
        homepagePage.clickOnElements();
        elementsPage.clickOnRadioButtonButton();
        radioButtonPage.selectButton(radioButtonPage.noButton);
        String expectedURL = excelReader.getStringData("URL", 1, 1);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertFalse(elementIsPresent(radioButtonPage.textDisplayed));
        Assert.assertFalse(radioButtonPage.noButton.isEnabled());

    }

    @Test
    public void verifyThatUserCannotSelectTwoButtonsAtTheSameTime() {
        homepagePage.clickOnElements();
        elementsPage.clickOnRadioButtonButton();
        radioButtonPage.selectButton(radioButtonPage.yesButton);
        radioButtonPage.selectButton(radioButtonPage.impressiveButton);

        Assert.assertTrue(radioButtonPage.impressiveButton.isSelected());
        Assert.assertFalse(radioButtonPage.yesButton.isSelected());
    }


}
