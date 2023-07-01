package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;
import Pages.ElementsPage;
import Pages.HomepagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    public ElementsPage elementsPage;
    public HomepagePage homepagePage;
    public ButtonsPage buttonsPage;

    @BeforeMethod
    public void pageSetUp1() {
        elementsPage = new ElementsPage();
        homepagePage = new HomepagePage();
        buttonsPage = new ButtonsPage();
        driver.get(homeURL);
    }

    @Test (priority = 30)
    public void userCanClickOnClickMeButton() {
        homepagePage.clickOnElements();
        elementsPage.clickOnButtonsButton();
        buttonsPage.clickOnClickMeButton();
        String expectedResult = excelReader.getStringData("Buttons", 1, 0);
        String expectedURL = excelReader.getStringData("URL", 1, 2);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(), expectedResult);
    }

    @Test (priority = 20)
    public void userCanRightClickOnRightClickMeButton() {
        homepagePage.clickOnElements();
        elementsPage.clickOnButtonsButton();
        rightClick(buttonsPage.rightClickMeButton);
        String expectedResult = excelReader.getStringData("Buttons", 2, 0);
        String expectedURL = excelReader.getStringData("URL", 1, 2);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(buttonsPage.righClickMessage.getText(), expectedResult);
    }

    @Test (priority = 10)
    public void userCanDoubleClickOnDoubleClickMeButton() {
        homepagePage.clickOnElements();
        elementsPage.clickOnButtonsButton();
        doubleClick(buttonsPage.doubleClickMeButton);
        String expectedResult = excelReader.getStringData("Buttons", 3, 0);
        String expectedURL = excelReader.getStringData("URL", 1, 2);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), expectedResult);
    }

    @Test (priority = 40)
    public void userCannotClickOnDoubleClickMeButton() {
        homepagePage.clickOnElements();
        elementsPage.clickOnButtonsButton();
        buttonsPage.clickOnDoubleClickMeButton();

        String expectedURL = excelReader.getStringData("URL", 1, 2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertFalse(elementIsPresent(buttonsPage.doubleClickMessage));
    }

    @Test (priority = 50)
    public void userCannotClickOnRightClickMeButton() {
        homepagePage.clickOnElements();
        elementsPage.clickOnButtonsButton();
        buttonsPage.clickOnRightClickMeButton();
        String expectedURL = excelReader.getStringData("URL", 1, 2);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertFalse(elementIsPresent(buttonsPage.righClickMessage));
    }
}
