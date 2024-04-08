package tek.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.pages.Homepage;
import tek.tdd.pages.LoginPage;
import tek.tdd.utilities.SeleniumUtilities;

@Listeners({ExtentITestListenerAdapter.class})
public class BaseUITests extends SeleniumUtilities{
    // Homepage on instant level
    public Homepage homepage;

    // initialize
    public LoginPage loginPage;

    @BeforeMethod
    public void initiateTestMethod(){
        super.openBrowser();

        //Pages need initialized driver so after opening browser we Create Objects.
        // Since there are local, above we are adding the public home page
        // it will initialize new object of the test
        homepage= new Homepage();
        loginPage= new LoginPage();
    }
    @AfterMethod
    public void endTestMethod(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE){
            TakesScreenshot takesScreenshot= (TakesScreenshot) getDriver();
            String screenshot= takesScreenshot.getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest()
                    .fail("Test Failed Taking Screen Shot",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot)
                                    .build());
    }
        super.quitBrowser();
    }

}
