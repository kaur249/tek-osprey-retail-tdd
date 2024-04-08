package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

import java.util.List;

public class LoginPage extends SeleniumUtilities {

    public LoginPage(){
        /*Initialize current session of Driver to all the element
        of the page
         */
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(name="email")
    public WebElement emailInput;

    @FindBy(name= "password")
    public WebElement passwordInput;

     @FindBy(id="loginBtn")
    public WebElement loginButton;

     @FindBy(xpath = "//div[@class='error']")
     public WebElement errorMessage;

    //If the Locator return more than 1 Elements
    @FindBy(tagName = "a")
    public List<WebElement> anchorElements;

    // this is free hand, we can create another variable or constructor, can use maintability or useability
    public void doLogin(String username, String password){
        sendText(emailInput, username);
        sendText(passwordInput, password);
        clickOnElement(loginButton);

    }
}
