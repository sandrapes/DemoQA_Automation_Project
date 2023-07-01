package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".rct-collapse.rct-collapse-btn")
    public List<WebElement> toggleArrow;

    @FindBy(className = "rct-checkbox")
    public List<WebElement> checkbox;

    @FindBy(id = "result")
    public WebElement verificationText;

    @FindBy(css = ".rct-icon.rct-icon-check")
    public List<WebElement> markedBoxes;

    @FindBy(className = "rct-title")
    public List<WebElement> elements;


    //-------------------------------------------



    public void clickOnToggleArrowHome() {
        for (int i = 0; i < toggleArrow.size(); i++) {
            toggleArrow.get(0).click();
            break;
        }
    }

    public void clickOnToggleArrowDesktop() {
        for (int i = 0; i < toggleArrow.size(); i++) {
            toggleArrow.get(1).click();
            break;
        }
    }

    public void markHomeCheckbox() {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals("Home")) {
                elements.get(i).click();
                break;
            }
        }
    }


    public void markNotesCheckbox() {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals("Notes")) {
                elements.get(i).click();
                break;
            }
        }

    }






}
