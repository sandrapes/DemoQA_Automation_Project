package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccordianPage extends BaseTest {

    public AccordianPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "section1Heading")
    public WebElement whatIsLoremIpsumHeader;

    @FindBy(id = "section2Heading")
    public WebElement whereDoesItComeFromHeader;

    @FindBy(id = "section3Heading")
    public WebElement whyDoWeUseItHeader;

    @FindBy(id = "section1Content")
    public WebElement whatIsLoremIpsumContent;

    @FindBy(id = "section2Content")
    public WebElement whereDoesItComeFromContent;

    @FindBy(id = "section3Content")
    public WebElement whyDoWeUseItContent;

    //----------------------------------------

    public void clickOnWhatIsLoremIpsumHeader() {
        whatIsLoremIpsumHeader.click();
    }

    public void clickOnWhereDoesItComeFromHeader() {
        whereDoesItComeFromHeader.click();
    }

    public void clickOnWhyDoWeUseItHeader() {
        whyDoWeUseItHeader.click();
    }


}
