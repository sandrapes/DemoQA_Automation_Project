package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalDialogsTest extends BaseTest {

    public HomepagePage homepagePage;
    public AlertsFrameWindowPage alertsFrameWindowPage;
    public ModalDialogsPage modalDialogsPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get(homeURL);
        homepagePage = new HomepagePage();
        alertsFrameWindowPage = new AlertsFrameWindowPage();
        modalDialogsPage = new ModalDialogsPage();
    }

    @Test (priority = 10)
    public void verifyThatAllElementsArePresent() {
        homepagePage.clickOnAlertsFrameWindows();
        alertsFrameWindowPage.selectModalDialogs();

        Assert.assertTrue(modalDialogsPage.header.isDisplayed());
        Assert.assertTrue(elementIsPresent(modalDialogsPage.smallModalButton));
        Assert.assertTrue(elementIsPresent(modalDialogsPage.largeModalButton));

    }

    @Test (priority = 20)
    public void verifyThatUserCanOpenSmallModalDialog() {
        homepagePage.clickOnAlertsFrameWindows();
        alertsFrameWindowPage.selectModalDialogs();
        modalDialogsPage.clickOnSmallModalButton();
        String expectedHeader = excelReader.getStringData("Modal Dialogs", 1, 0);
        String expectedText = excelReader.getStringData("Modal Dialogs", 1, 1);

        waitForVisibility(modalDialogsPage.smallModalCloseButton);
        Assert.assertTrue(modalDialogsPage.smallModalCloseButton.isDisplayed());
        Assert.assertEquals(modalDialogsPage.smallModalHeader.getText(), expectedHeader);
        Assert.assertEquals(modalDialogsPage.modalText.getText(), expectedText);

    }

    @Test (priority = 30)
    public void verifyThatUserCanCloseSmallModalDialog() {
        homepagePage.clickOnAlertsFrameWindows();
        alertsFrameWindowPage.selectModalDialogs();
        modalDialogsPage.clickOnSmallModalButton();
        modalDialogsPage.closeSmallModal();

        Assert.assertTrue(modalDialogsPage.smallModalButton.isDisplayed());
        Assert.assertTrue(modalDialogsPage.largeModalButton.isDisplayed());
    }

    @Test (priority = 40)
    public void verifyThatUserCanOpenLargeModalDialog() {
        homepagePage.clickOnAlertsFrameWindows();
        alertsFrameWindowPage.selectModalDialogs();
        modalDialogsPage.clickOnLargeModalButton();
        String expectedHeader = excelReader.getStringData("Modal Dialogs", 1, 2);
        String expectedText = excelReader.getStringData("Modal Dialogs", 1, 3);

        waitForVisibility(modalDialogsPage.largeModalCloseButton);
        Assert.assertTrue(modalDialogsPage.largeModalCloseButton.isDisplayed());
        Assert.assertEquals(modalDialogsPage.largeModalHeader.getText(), expectedHeader);
        Assert.assertEquals(modalDialogsPage.modalText.getText(), expectedText);
    }

    @Test (priority = 50)
    public void verifyThatUserCanCloseLargeModalDialog() {
        homepagePage.clickOnAlertsFrameWindows();
        alertsFrameWindowPage.selectModalDialogs();
        modalDialogsPage.clickOnLargeModalButton();
        modalDialogsPage.closeLargeModal();

        Assert.assertTrue(modalDialogsPage.smallModalButton.isDisplayed());
        Assert.assertTrue(modalDialogsPage.largeModalButton.isDisplayed());
    }


}
