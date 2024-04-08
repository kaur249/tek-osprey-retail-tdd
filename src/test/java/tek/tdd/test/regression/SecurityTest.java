package tek.tdd.test.regression;

import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.pages.Homepage;
import tek.tdd.pages.LoginPage;

public class SecurityTest extends BaseUITests {
    // Making sure logout button is available


    @DataProvider(name = "validCredentials") /// gave information for Mansoor
    public String[][] validCredentialProvider() {
        String[][] data = {
                {"mohammad_osprey@tekschool.us", "12345678Ab@"},
                {"Mansoor@gmail.com" , "Ruya@2014"}
        };
        return data;
    }

    @Test(dataProvider = "validCredentials")
    public void validLoginWithValidCredentials(String username, String password) {
        /* Navigate to sign in page and sing in with valid username and password.
        Validate user successfully signed in.
        Homepage homePage = new Homepage();

         */
        clickOnElement(homepage.signInButton);

       //  LoginPage loginPage = new LoginPage(); (no need since added on login page)

        loginPage.doLogin(username, password);
        /* sendText(loginPage.emailInput, username);
        sendText(loginPage.passwordInput,password);
        clickOnElement(loginPage.loginButton);

         */

        /* sendText(loginPage.emailInput, "kaur1234@gmail.com");
        sendText(loginPage.passwordInput, "Tek@2023");
        clickOnElement(loginPage.loginButton);

         */

        boolean isLogoutBtnDisplayed = isElementDisplayed(homepage.logoutButton);

        Assert.assertTrue(isLogoutBtnDisplayed, "After Success login, Logout button should display in home page");
    }
        @Test(dataProvider = "negativeTestData")
        public void validateLoginWithInvalidCredentials(
                String username,
                String password,
                String expectedErrorMessage
        ){
        // Homepage homePage= new Homepage();   no need
            clickOnElement(homepage.signInButton);

            // LoginPage loginPage = new LoginPage();// no need

            loginPage.doLogin(username, password);
            /*sendText(loginPage.emailInput,email);
            sendText(loginPage.passwordInput,password);
            clickOnElement(loginPage.loginButton);

             */

            /*
            sendText(loginPage.emailInput, "wrong@email.com");
            sendText(loginPage.passwordInput, "Tek@2023");
            clickOnElement(loginPage.loginButton);

             */

            String actualErrorMessage= getElementText(loginPage.errorMessage);
            Assert.assertEquals(actualErrorMessage,expectedErrorMessage,
                    "Error Message should Display");
    }

    @DataProvider(name="negativeTestData")
    private String[][] negativeTestData(){
        String [][] data= {
                {"wrong@email.com","Tek@2023","Wrong Password or username.try again\""},
                {"kaur1234@gmail.com","invalid@Password","Wrong Password or username.try again"},
                {"wrong@email.com","invalid@Password","Wrong Password or username.try again"}

        };
        return data;

    }
}
