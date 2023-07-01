package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BaseTest {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "doubleClickBtn")
    public WebElement doubleClickMeButton;

    @FindBy (id = "rightClickBtn")
    public WebElement rightClickMeButton;

    @FindBy (css = ".btn.btn-primary")
    public List<WebElement> buttons;

    @FindBy (id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    @FindBy (id = "rightClickMessage")
    public WebElement righClickMessage;

    @FindBy (id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    public void clickOnDoubleClickMeButton() {
        doubleClickMeButton.click();
    }

    public void clickOnRightClickMeButton() {
        rightClickMeButton.click();
    }

    public void clickOnClickMeButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Click Me")) {
                buttons.get(i).click();
                break;
            }

        }
    }


}
