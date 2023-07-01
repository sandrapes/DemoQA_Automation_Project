package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends BaseTest {

    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-light" )
    public List<WebElement> buttons;

    public void clickOnTextBoxButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Text Box")) {
                buttons.get(i).click();
                break;
            }

        }
    }

    public void clickOnCheckBoxButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Check Box")) {
                buttons.get(i).click();
                break;
            }

        }
    }

    public void clickOnRadioButtonButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Radio Button")) {
                buttons.get(i).click();
                break;
            }

        }
    }

    public void clickOnWebTablesButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Web Tables")) {
                buttons.get(i).click();
                break;
            }

        }
    }

    public void clickOnButtonsButton() {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Buttons")) {
                buttons.get(i).click();
                break;
            }

        }
    }


}
