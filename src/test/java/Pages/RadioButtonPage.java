package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "yesRadio")
    public WebElement yesButton;

    @FindBy(id = "impressiveRadio")
    public WebElement impressiveButton;

    @FindBy(id = "noRadio")
    public WebElement noButton;

    @FindBy(className = "mt-3")
    public WebElement textDisplayed;

    @FindBy(css = ".pattern-backgound.playgound-header")
    public WebElement header;

    @FindBy(css = ".custom-control.custom-radio.custom-control-inline")
    public List<WebElement> yesImpressiveButtonsDisplayed;

    @FindBy(css = ".custom-control.disabled.custom-radio.custom-control-inline")
    public WebElement noButtonDisplayed;

}
