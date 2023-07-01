package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest{

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;

    //---------------

    public void clickOnElements() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Elements")) {
                cards.get(i).click();
                break;
            }
        }
    }


    public void clickOnAlertsFrameWindows() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Alerts, Frame & Windows")) {
                cards.get(i).click();
                break;
            }
        }
    }

    public void clickOnWidgets() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Widgets")) {
                cards.get(i).click();
                break;
            }
        }
    }



}
