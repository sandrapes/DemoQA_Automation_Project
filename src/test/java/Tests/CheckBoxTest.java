package Tests;

import Base.BaseTest;
import Pages.CheckBoxPage;
import Pages.ElementsPage;
import Pages.HomepagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    public HomepagePage homepagePage;
    public ElementsPage elementsPage;
    public CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get(homeURL);
        homepagePage = new HomepagePage();
        elementsPage = new ElementsPage();
        checkBoxPage = new CheckBoxPage();
    }

    @Test (priority = 10)
    public void VerifyThatUserCanSelectAllOptions() throws InterruptedException {
        homepagePage.clickOnElements();
        elementsPage.clickOnCheckBoxButton();
        checkBoxPage.clickOnToggleArrowHome();
        checkBoxPage.markHomeCheckbox();
        String expectedResult = excelReader.getStringData("Check Box", 1, 0);

        Assert.assertEquals(checkBoxPage.verificationText.getText(), expectedResult);

        for (int i = 0; i < checkBoxPage.markedBoxes.size(); i++) {
            Assert.assertTrue(elementIsPresent(checkBoxPage.markedBoxes.get(i)));
        }

        Assert.assertEquals(checkBoxPage.markedBoxes.size(), 4);


    }

    @Test(priority = 20)
    public void verifyThatUserCanSelectOnlyOneOptionFormTheList() {
        homepagePage.clickOnElements();
        elementsPage.clickOnCheckBoxButton();
        checkBoxPage.clickOnToggleArrowHome();
        checkBoxPage.clickOnToggleArrowDesktop();
        checkBoxPage.markNotesCheckbox();
        String expectedResult = excelReader.getStringData("Check Box", 1, 1);

        Assert.assertEquals(checkBoxPage.verificationText.getText(), expectedResult);

        for (int i = 0; i < checkBoxPage.markedBoxes.size(); i++) {
                Assert.assertTrue(elementIsPresent(checkBoxPage.markedBoxes.get(i)));
        }

        Assert.assertEquals(checkBoxPage.markedBoxes.size(), 1);

    }



}
