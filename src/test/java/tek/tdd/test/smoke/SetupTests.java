package tek.tdd.test.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.pages.Homepage;

public class SetupTests extends BaseUITests {
    @Test
    public void testRetailLogo(){

        // No need to create here since it it created under login page
       /*  Homepage homepage= new Homepage();

        */
        boolean isDisplayed= isElementDisplayed(homepage.topNavLogo);

        Assert.assertTrue(isDisplayed,"Top left corner Logo should displayed always");

    }
    @Test
    public void validateLoginButtonIsEnabled(){
        // Navigate to retail app and make sure Sign in button is enabled.
        // No need to create here since it it created under login page
       //  Homepage homePage= new Homepage();
        boolean isSignInButtonEnabled= isElementEnabled(homepage.signInButton);
        Assert.assertTrue(isSignInButtonEnabled,"Sign in button should be enabled all time");

    }

}
