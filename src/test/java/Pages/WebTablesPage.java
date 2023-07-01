package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchBox")
    public WebElement searchBox;

    @FindBy(id = "basic-addon2")
    public WebElement searchButton;
    
    @FindBy(className = "rt-tr-group")
    public List<WebElement> users;

    @FindBy(id = "delete-record-1")
    public WebElement deleteButton1;

    @FindBy(id = "delete-record-2")
    public WebElement deleteButton2;

    @FindBy(id = "delete-record-3")
    public WebElement deleteButton3;

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "edit-record-1")
    public WebElement editButton1;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;


    //--------------------------------------

    public void insertName(String name) {
        searchBox.clear();
        searchBox.sendKeys(name);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }


    public void deleteALlUsers() {
        deleteButton1.click();
        deleteButton2.click();
        deleteButton3.click();
    }

    public void deleteUser() {
        deleteButton1.click();
    }

    public void addUser(String name, String surname, String email, String age, String salary, String department) {
        addButton.click();
        firstNameField.clear();
        firstNameField.sendKeys(name);
        lastNameField.clear();
        lastNameField.sendKeys(surname);
        emailField.clear();
        emailField.sendKeys(email);
        ageField.clear();
        ageField.sendKeys(age);
        salaryField.clear();
        salaryField.sendKeys(salary);
        departmentField.clear();
        departmentField.sendKeys(department);
        submitButton.click();
    }

    public void clickOnEditButton() {
        editButton1.click();
    }

    public void editUser(String name, String surname, String email) {
        firstNameField.clear();
        firstNameField.sendKeys(name);
        lastNameField.clear();
        lastNameField.sendKeys(surname);
        emailField.clear();
        emailField.sendKeys(email);
        submitButton.click();

    }




}






