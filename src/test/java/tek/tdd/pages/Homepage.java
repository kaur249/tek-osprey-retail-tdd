package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class Homepage extends SeleniumUtilities {

    public Homepage(){

        PageFactory.initElements(getDriver(),this);
    }

    // driver.findElement(By.className("className"))
    @FindBy(className = "top-nav__logo")
    public WebElement topNavLogo;

    @FindBy(id= "signinLink") // locator used was by id
    public WebElement signInButton;

    @FindBy(id= "logoutBtn")
    public WebElement logoutButton;
}
