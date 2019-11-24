import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends  BaseTest {
    private By loginButton = By.cssSelector("[data-testid=\"loginSubmit\"]");


    @Test
    public void LoginEmptyEmailPasswordTest () {
        clickToLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Empty email or password");

    }

    @Test(priority = 1)
    public void IncorrectEmailAndPasswordTest () {

        setEmailField("testin@gmail.com");

        setPasswordField("incorrectPassword");

        clickToLoginButton();

        String errorMessage = getErrorMessage();

        Assert.assertEquals(errorMessage, "Wrong email or password.");

    }

    public void clickToLoginButton(){
//        WebElement login_button = driver.findElement(By.cssSelector("[data-testid=\"loginSubmit\"]"));
        WebElement login_button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid=\"loginSubmit\"]")));
        login_button.click();
    }

    public void setEmailField(String email){
//        WebElement emailField = driver.findElement(By.cssSelector("#email"));
        WebElement emailField = findElement("#email");
        emailField.sendKeys(email);
    }

    public void setPasswordField(String password){
//        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        WebElement passwordField = findElement("#password");
        passwordField.sendKeys(password);
    }

    public String getErrorMessage() {
//        WebElement uiErrorMessage = findElement(".ui.error.message p"); //driver.findElement(By.cssSelector(".ui.error.message p"));
        WebElement uiErrorMessage = findElement(".ui.error.message p");
        String errorMessagetext = uiErrorMessage.getText();
        return errorMessagetext;
    }

    public WebElement findElement(String cssLocator) {
//        return driver.findElement(By.cssSelector(cssLocator));
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssLocator)));
    }



}
