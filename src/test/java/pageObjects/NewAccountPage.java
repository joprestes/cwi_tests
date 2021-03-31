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
    public void fillFirstName () {
        firstName.sendKeys("Aurora");
    }

    @Step("Preencher Primeiro Nome Com Caractetes Inválidos")
    public void wrongFillFirstName () {
        firstName.sendKeys("1");
    }

    @Step("Preencher Último Nome")
    public void fillLastName(){
        lastName.sendKeys("Boreal");
    }

    @Step("Preencher Último Nome Com Caractetes Inválidos")
    public void wrongFillLastName(){
        lastName.sendKeys("1");
    }

    @Step("Preencher Senha")
    public void fillNewPasswd(){
        newPasswd.sendKeys("12345");
    }

    @Step("Preencher Senha Com Número De Caracteres Inferior Ao Mínimo Aceito")
    public void wrongFillNewPasswd(){
        newPasswd.sendKeys("1");
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
    public void fillNewCity(){
        city.sendKeys("Spingrifield");
    }

    @Step ("Preencher Cidade Com Caracteres Inválidos")
    public void wrongFillNewCity(){
        city.sendKeys("1");
    }

    @Step("Selecionar Estado")
    public void selectNewState (){
        state.sendKeys("Utah");
    }

    @Step("Preencher CEP")
    public void fillNewZipcode(){
        zipcode.sendKeys("12345");
    }

    @Step("Preencher CEP Com Número De Caracteres Inferior Ao Mínimo Aceito")
    public void wrongFillNewZipcode(){
        zipcode.sendKeys("1");
    }

    @Step("Preencher Número De Telefone Para Contato")
    public void fillMobilePhoneNumber(){
        mobilePhoneNumber.sendKeys("999999999");
    }

    @Step("Preencher Número De Telefone Com Caracteres Insuficientes")
    public void wrongFillMobilePhoneNumber(){
        mobilePhoneNumber.sendKeys("a");
    }

    @Step("Clicar no botão Register")
    public void clickRegisterBtn(){
        btnSubmitAccount.click();
    }

    @Step("Método para Preencher o Formulário com Dados  válidos")
    public void fillFormWithValidRequiredFields (){
        selectGender();
        fillFirstName();
        fillLastName();
        fillNewPasswd();
        selectDayBirth();
        selectMonthBirth();
        selectYearBirth();
        fillAdress();
        fillNewCity();
        selectNewState();
        fillNewZipcode();
        fillMobilePhoneNumber();
    }

    @Step("Método Para Preencher O Formulário Com Dados Inválidos")
    public void wrongFillFormWithValidRequiredFields (){
        selectGender();
        wrongFillFirstName();
        wrongFillLastName();
        wrongFillNewPasswd();
        selectDayBirth();
        selectMonthBirth();
        selectYearBirth();
        fillAdress();/* Ele toma como correto qualquer caractere inserido neste campo, sendo ele alfanumérico ou especial,
        por isso mantive o endereço correto. Não deveria ser setado como campo obrigatório*/
        wrongFillNewCity();
        selectNewState();
        wrongFillNewZipcode();
        wrongFillMobilePhoneNumber();
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
