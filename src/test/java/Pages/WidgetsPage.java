package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WidgetsPage extends BaseTest {

    public WidgetsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-light" )
    public List<WebElement> buttons;

    public void clickOnAccordianButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Accordian")) {
                buttons.get(i).click();
                break;
            }

        }
    }
}
