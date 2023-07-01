package Tests;

import Base.BaseTest;
import Pages.ElementsPage;
import Pages.HomepagePage;
import Pages.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    public HomepagePage homepagePage;
    public ElementsPage elementsPage;
    public WebTablesPage webTablesPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get(homeURL);
        homepagePage = new HomepagePage();
        elementsPage = new ElementsPage();
        webTablesPage = new WebTablesPage();
        homepagePage.clickOnElements();
        elementsPage.clickOnWebTablesButton();
    }

    @Test (priority = 10)
    public void verifyThatUserCanFindRegisteredUsers() {
        String name = excelReader.getStringData("Web Tables", 1, 0);
        webTablesPage.deleteALlUsers();
        webTablesPage.addUser("Marko", "Markovic", "marko@example.com", "49", "1000", "Finance");
        webTablesPage.addUser("Darko", "Darkovic", "markodarko@example.com", "15", "9000", "Economy");
        webTablesPage.addUser("Stana", "Markovski", "stankovic@example.com", "25", "8000", "Business");
        webTablesPage.insertName(name);
        webTablesPage.clickOnSearchButton();

        for (int i = 0; i < webTablesPage.users.size(); i++) {
            boolean contains = false;
            if (webTablesPage.users.get(i).getText().isBlank()) {
                break;
            }
            else {
                if (webTablesPage.users.get(i).getText().contains(name)) {
                    contains = true;
                }
                Assert.assertTrue(contains);
            }
        }
    }

    @Test (priority = 20)
    public void verifyThatUserCanDeleteUsers() {
        webTablesPage.deleteALlUsers();
        webTablesPage.addUser("Marko", "Markovic", "marko@example.com", "49", "1000", "Finance");

        webTablesPage.deleteUser();

        for (int i = 0; i < webTablesPage.users.size(); i++) {
            Assert.assertTrue(webTablesPage.users.get(i).getText().isBlank());
        }
        Assert.assertFalse(elementIsPresent(webTablesPage.deleteButton1));
        Assert.assertFalse(elementIsPresent(webTablesPage.deleteButton2));
        Assert.assertFalse(elementIsPresent(webTablesPage.deleteButton3));
    }

    @Test (priority = 30)
    public void verifyThatUserCanAddUsers() {
        webTablesPage.deleteALlUsers();
        webTablesPage.addUser("Marko", "Markovic", "marko@example.com", "49", "1000", "Finance");
        String name = excelReader.getStringData("Web Tables", 1, 0);

        for (int i = 0; i < webTablesPage.users.size(); i++) {
            boolean contains = false;
            if (webTablesPage.users.get(i).getText().isBlank()) {
                break;
            }
            else {
                if (webTablesPage.users.get(i).getText().contains(name)) {
                    contains = true;
                }
                Assert.assertTrue(contains);
            }
        }

        int numberOfRegisteredUsers = 0;
        for (int i = 0; i < webTablesPage.users.size(); i++) {
            if (!webTablesPage.users.get(i).getText().isBlank()) {
                numberOfRegisteredUsers++;
            }

        }
        int expectedRegisteredUsers = 1;
       Assert.assertEquals(numberOfRegisteredUsers, expectedRegisteredUsers);

    }

    @Test (priority = 40)
    public void verifyThatUserCanEditUsers() {
        webTablesPage.deleteALlUsers();
        webTablesPage.addUser("Marko", "Markovic", "marko@example.com", "49", "1000", "Finance");
        webTablesPage.clickOnEditButton();
        webTablesPage.editUser("Mirko", "Mirkovic", "mirko@example.com");


        for (int i = 0; i < webTablesPage.users.size(); i++) {
            boolean contains = false;
            if (webTablesPage.users.get(i).getText().isBlank()) {
                break;
            }
            else {
                if ( webTablesPage.users.get(i).getText().contains("Mirko") && webTablesPage.users.get(i).getText().contains("Mirkovic") && webTablesPage.users.get(i).getText().contains("mirko@example.com")) {
                    contains = true;
                }
                Assert.assertTrue(contains);
            }
        }

        int numberOfRegisteredUsers = 0;
        for (int i = 0; i < webTablesPage.users.size(); i++) {
            if (!webTablesPage.users.get(i).getText().isBlank()) {
                numberOfRegisteredUsers++;
            }
        }
        int expectedRegisteredUsers = 1;

        Assert.assertEquals(numberOfRegisteredUsers, expectedRegisteredUsers);
    }





}
