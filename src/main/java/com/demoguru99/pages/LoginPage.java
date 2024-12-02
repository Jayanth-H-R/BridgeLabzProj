package com.demoguru99.pages;

import com.demoguru99.basepage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BaseClass {
    WebDriver driver ;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    public WebElement emailTextField;
    @FindBy(id = "passwd")
    public WebElement passwordTextField;
    @FindBy(id="SubmitLogin")
    public WebElement submitButton;

    @FindBy(xpath = "//a[text()='Forgot your password?']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//h3[text()='Successfully Logged in...']")
    public WebElement sucessMessage;

    public String login() throws IOException {
       emailTextField.sendKeys(fileUtils.readData("email"));
       passwordTextField.sendKeys(fileUtils.readData("pwd"));
       submitButton.submit();
       return sucessMessage.getText();
    }



}
