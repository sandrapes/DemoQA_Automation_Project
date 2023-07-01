package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage extends BaseTest {

    public ModalDialogsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".pattern-backgound.playgound-header")
    public WebElement header;

    @FindBy(id = "showSmallModal")
    public WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    public WebElement largeModalButton;

    @FindBy(id = "closeSmallModal")
    public WebElement smallModalCloseButton;

    @FindBy(id = "closeLargeModal")
    public WebElement largeModalCloseButton;

    @FindBy(id = "example-modal-sizes-title-sm")
    public WebElement smallModalHeader;

    @FindBy(className = "modal-body")
    public WebElement modalText;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement largeModalHeader;

    public void clickOnSmallModalButton() {
        smallModalButton.click();
    }

    public void clickOnLargeModalButton() {
        largeModalButton.click();
    }

    public void closeSmallModal() {
        smallModalCloseButton.click();
    }

    public void closeLargeModal() {
        largeModalCloseButton.click();
    }
}
