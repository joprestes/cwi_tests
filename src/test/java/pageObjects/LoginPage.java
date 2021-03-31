package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Browser;

import java.util.Random;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step ("Preencheu o e-mail.")
    public void fillEmail (){
        email.sendKeys("meuemail@gmail.com");

    }

    @Step ("Prencheu a senha.")
    public void fillPasswd (){
        passwd.sendKeys("12345");

    }

    @Step ("Clicou em Sign in!")
    public void clickBtnSubmitLogin (){
        SubmitLogin.click();
    }



    // Passos para criação de nova conta

    @Step ("Preencheu Email Adress")
    public void fillEmailAdress(){
        Random random = new Random();
        int x = random.nextInt(999);
        String newEmailAdress = "cwiteste" + x + "@gmail.com";
        newEmail.sendKeys(newEmailAdress);
    }

    @Step("Clicou no botão New Account")
    public void clickBtnCreateAnAccount (){
        createAnAccount.click();
    }

    @Step("Preencheu Email com formato inválido")
    public void fillInvalidEmailAdress(){
        newEmail.sendKeys("invalidemail");
    }

    @Step("Preencheu com e-mail já existente")
    public void fillEmailAlreadyRegistered(){
        newEmail.sendKeys("meuemail@gmail.com");
    }
    @Step("Retornar mensagem de erro")
    public String getErrorMessageText (){
        return errorLabel.getText();
    }









}
