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


    @Step("Clicar No Gênero")
    public void selectGender(){
        gender.click();
    }

    @Step ("Preencher Primeiro Nome")
    public void fillFirstName (String informedFirstName) {
        firstName.sendKeys(informedFirstName);
    }

    @Step("Preencher Último Nome")
    public void fillLastName(String informedLastName){
        lastName.sendKeys(informedLastName);
    }

    @Step("Preencher Senha")
    public void fillNewPasswd(String informedPassword){
        newPasswd.sendKeys(informedPassword);
    }

    @Step("Selecionar Dia Do Aniversário")
    public void selectDayBirth(){
        dayBirth.sendKeys("24");
    }

    @Step("Selecionar Mês De aniversário")
    public void selectMonthBirth(){
        monthBirth.sendKeys("June");
    }

    @Step("Selecionar Ano De Nascimento")
    public void selectYearBirth(){
        yearBirth.sendKeys("1984");
    }

    @Step ("Preencher Endereço")
    public void fillAdress(){
        adress.sendKeys("Elm Street, 195");
    }


    @Step ("Preencher Cidade")
    public void fillNewCity(String informedCity){
        city.sendKeys(informedCity);
    }

    @Step("Selecionar Estado")
    public void selectNewState (){
        state.sendKeys("Utah");
    }

    @Step("Preencher CEP")
    public void fillNewZipcode(String informedZipCode){
        zipcode.sendKeys(informedZipCode);
    }

    @Step("Preencher Número De Telefone Para Contato")
    public void fillMobilePhoneNumber(String informedPhoneNumber){
        mobilePhoneNumber.sendKeys(informedPhoneNumber);
    }

    @Step("Clicar no botão Register")
    public void clickRegisterBtn(){
        btnSubmitAccount.click();
    }

    @Step("Método para Preencher o Formulário com Dados  válidos")
    public void fillFormWithValidRequiredFields (){
        selectGender();
        fillFirstName("Aurora");
        fillLastName("Boreal");
        fillNewPasswd("12345");
        selectDayBirth();
        selectMonthBirth();
        selectYearBirth();
        fillAdress();
        fillNewCity("Springfield");
        selectNewState();
        fillNewZipcode("12345");
        fillMobilePhoneNumber("999999999");
    }

    @Step("Método Para Preencher O Formulário Com Dados Inválidos")
    public void wrongFillFormWithValidRequiredFields (){
        selectGender();
        fillFirstName("1");
        fillLastName("1");
        fillNewPasswd("1");
        selectDayBirth();
        selectMonthBirth();
        selectYearBirth();
        fillAdress();/* Ele toma como correto qualquer caractere inserido neste campo, sendo ele alfanumérico ou especial,
        por isso mantive o endereço correto. Não deveria ser setado como campo obrigatório, ou ter os parâmetros de validação
        alterados*/
        fillNewCity("1");
        selectNewState();
        fillNewZipcode("1");
        fillMobilePhoneNumber("a");
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

    @Step("Retornar mensagem de erro")
    public String getErrorMessageText() {
        return errorMessage.getText();
    }

}

