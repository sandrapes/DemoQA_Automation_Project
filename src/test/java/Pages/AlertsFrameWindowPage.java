package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertsFrameWindowPage extends BaseTest {

    public AlertsFrameWindowPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "item-4")
    public List<WebElement> items;

    //---------------------------------------

    public void selectModalDialogs() {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().equals("Modal Dialogs")) {
                scrollIntoView(items.get(i));
                items.get(i).click();
                break;
            }
        }
    }
}
