package pageObjects;

import elementMapper.NewAccountPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import utils.Browser;


public class NewAccountPage extends NewAccountPageElementMapper {

    public NewAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Clicar no Gênero")
    public void selectGender(){
        gender.click();
            }

    @Step ("Preencher Primeiro Nome")
    public void fillFirstName () {
        firstName.sendKeys("Aurora");
    }

    @Step("Preencher Último Nome")
    public void fillLastName(){
        lastName.sendKeys("Boreal");
    }

    @Step("Preencher Senha")
    public void fillNewPasswd(){
        newPasswd.sendKeys("12345");
    }

    @Step("Selecionar dia do Aniversário")
    public void selectDayBirth(){
        dayBirth.sendKeys("24");
    }

    @Step("Selecionar mês de aniversário")
    public void selectMonthBirth(){
        monthBirth.sendKeys("06");
    }

    @Step("Selecionar Ano de Nascimento")
    public void selectYearBirth(){
        yearBirth.sendKeys("1984");
    }

    @Step ("Preencher Endereço")
    public void fillAdress(){
        adress.sendKeys("Elm Street, 195");
    }

    @Step ("Preencher Cidade")
    public void selectNewCity(){
        city.sendKeys("Spingrifield");
    }

    @Step("Selecionar Estado")
    public void selectNewState (){
        state.sendKeys("Utah");
    }

    @Step("Preencher CEP")
    public void fillNewZipcode(){
        zipcode.sendKeys("12345");
    }

    @Step("Preencher telefone para contato")
    public void fillMobilePhoneNumber(){
        mobilePhoneNumber.sendKeys("999999999");
    }

    @Step("Clicar no botão Register")
    public void clickRegisterBtn(){
        btnSubmitAccount.click();
    }

    @Step ("Validar CREATE AN ACCOUNT")
    public boolean isCreationFormPresent(){
        try{
            Browser.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));
            return true;
        }catch(Exception E){
            return false;
        }
    }

}
