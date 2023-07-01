package Tests;

import Base.BaseTest;
import Pages.AccordianPage;
import Pages.HomepagePage;
import Pages.WidgetsPage;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordianTest extends BaseTest {

    public HomepagePage homepagePage;
    public WidgetsPage widgetsPage;
    public AccordianPage accordianPage;

    @BeforeMethod
    public void pageSetUp1() {
        widgetsPage = new WidgetsPage();
        homepagePage = new HomepagePage();
        accordianPage = new AccordianPage();
        driver.get(homeURL);
        homepagePage.clickOnWidgets();

        for (int i = 0; i < widgetsPage.buttons.size(); i++) {
            if (widgetsPage.buttons.get(i).getText().equals("Accordian")) {
                scrollIntoView(widgetsPage.buttons.get(i));
                break;
            }

        }
        widgetsPage.clickOnAccordianButton();
    }

    @Test
    public void verifyThatWhatIsLoremIpsumSectionIsOpenWhenUserGetsToAccordianPage() {
        String expectedURL = excelReader.getStringData("URL", 1, 3);
        waitForVisibility(accordianPage.whatIsLoremIpsumContent);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(accordianPage.whatIsLoremIpsumContent.isDisplayed());

    }

    @Test
    public void verifyThatUserCanCloseWhatIsLoremIpsumSection() {
        accordianPage.clickOnWhatIsLoremIpsumHeader();
        String expectedURL = excelReader.getStringData("URL", 1, 3);
        waitForInvisibility(accordianPage.whatIsLoremIpsumContent);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertFalse(accordianPage.whatIsLoremIpsumContent.isDisplayed());
    }

    @Test
    public void verifyThatUserCanOpenWhereDoesItComeFromSection() {
        scrollIntoView(accordianPage.whatIsLoremIpsumContent);
        accordianPage.clickOnWhatIsLoremIpsumHeader(); //closing first section

        scrollIntoView(accordianPage.whereDoesItComeFromContent);
        accordianPage.clickOnWhereDoesItComeFromHeader();
        String expectedURL = excelReader.getStringData("URL", 1, 3);
        scrollIntoView(accordianPage.whereDoesItComeFromContent);
        waitForVisibility(accordianPage.whereDoesItComeFromContent);
        scrollIntoView(accordianPage.whereDoesItComeFromContent);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(accordianPage.whereDoesItComeFromContent.isDisplayed());
    }

    @Test
    public void verifyThatUserCanOpenWhyDoWeUseItSection() throws InterruptedException {
        String expectedURL = excelReader.getStringData("URL", 1, 3);
        Thread.sleep(2000);
        scrollIntoView(accordianPage.whatIsLoremIpsumHeader);
        waitForVisibility(accordianPage.whatIsLoremIpsumHeader);
        accordianPage.clickOnWhatIsLoremIpsumHeader(); //closing first section

        scrollIntoView(accordianPage.whyDoWeUseItHeader);
        waitForVisibility(accordianPage.whyDoWeUseItHeader);
        accordianPage.clickOnWhyDoWeUseItHeader();

        Thread.sleep(2000);

        scrollIntoView(accordianPage.whyDoWeUseItHeader);
        waitForVisibility((accordianPage.whyDoWeUseItContent));

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(accordianPage.whyDoWeUseItContent.isDisplayed());
    }

    @Test
    public void verifyThatTwoSectionsCannotBeOpenedSimultaneously() {
        accordianPage.clickOnWhatIsLoremIpsumHeader(); //closing automatically opened section
        waitForInvisibility(accordianPage.whatIsLoremIpsumContent);
        Assert.assertFalse(accordianPage.whatIsLoremIpsumContent.isDisplayed());

        accordianPage.clickOnWhatIsLoremIpsumHeader(); //opening it again
        waitForVisibility(accordianPage.whatIsLoremIpsumContent);
        Assert.assertTrue(accordianPage.whatIsLoremIpsumContent.isDisplayed());

        accordianPage.clickOnWhereDoesItComeFromHeader();
        scrollIntoView(accordianPage.whereDoesItComeFromContent);
        waitForVisibility(accordianPage.whereDoesItComeFromContent);
        Assert.assertTrue(accordianPage.whereDoesItComeFromContent.isDisplayed());

        scrollIntoView(accordianPage.whatIsLoremIpsumHeader);
        waitForVisibility(accordianPage.whatIsLoremIpsumHeader);
        waitForInvisibility(accordianPage.whatIsLoremIpsumContent);
        Assert.assertFalse(accordianPage.whatIsLoremIpsumContent.isDisplayed());
    }

}
