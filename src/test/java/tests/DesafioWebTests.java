package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewAccountPage;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@Feature("Testes Site de Ecommerce - Desafio Web")
public class DesafioWebTests  extends BaseTests{
    @Test
    @Story("Ser direcionado para página de criação de nova conta:")
    public void testNewAccountPage() throws Exception {
        HomePage home = new HomePage();
        LoginPage newLogin = new LoginPage();
        NewAccountPage newAccount = new NewAccountPage();


        //Clicar no botão Login da Home
        home.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");

        //Preencher e-mail para criação de nova conta
        newLogin.fillEmailAdress();
        System.out.println("Preencheu o e-mail.");

        //Clicar no botão Create an Account
        newLogin.clickBtnCreateAnAccount();
        System.out.println("Clicou no botão Create Account.");


        //Ser Direcionado para a página de criação de nova conta
        assertTrue(newAccount.isCreationFormPresent());
        System.out.println("Direcionou corretamente para página de New Account.");

    }





    @Test
    @Story("Tentar ser direcionado à página de criação de conta sem preencher e-mail:")
    public void testNewAccountWithNullEmail() throws Exception {
        HomePage home = new HomePage();
        LoginPage newLogin = new LoginPage();
        String invalidEmailErrorMessage = "Invalid email address.";

        //Ser Direcionado para página de login
        home.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");


        //Clicar no botão Create an Account sem preenchar e-mail
        newLogin.clickBtnCreateAnAccount();
        System.out.println("Clicou no botão Create Account.");

        //Validar se irá direcionar para página de criação de conta com o campo e-mail vazio
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        assertEquals(invalidEmailErrorMessage, newLogin.getErrorMessageText());
        System.out.println("Não permitiu o direcionamento para a página de criação de nova conta sem preenchimento" +
                " adequado do campo de e-mail.");

    }






    @Test
    @Story("Tentar direcionamento para página de criação de conta utilizando e-mail em formato inválido:")
    public void testNewAccountWithInvalidEmail() throws Exception {
        HomePage home = new HomePage();
        LoginPage newLogin = new LoginPage();
        String invalidEmailErrorMessage = "Invalid email address.";

        //Ser Direcionado para página de login
        home.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");

        //Prencher campo de e-mail com endereço em formato inválido
        newLogin.fillInvalidEmailAdress();
        System.out.println("Preencheu o campo com e-mail inválido.");

        //Clicar no botão Create an Account
        newLogin.clickBtnCreateAnAccount();
        System.out.println("Clicou no botão Create Account.");

        //Validar se irá direcionar para página de criação de conta utilizando um e-mail em formato invalido.
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        assertEquals(invalidEmailErrorMessage, newLogin.getErrorMessageText());

        System.out.println("Não permitiu o direcionamento para página de criação de nova conta" +
                " utilizando um endereço de  e-mail em formato inválido.");

    }






    @Test
    @Story("Tentar direcionamento para página de criação de conta utilizando e-mail já cadastrado:")
    public void testNewAccountWithEmailAlreadyRegistered() throws Exception {
        HomePage home = new HomePage();
        LoginPage newLogin = new LoginPage();
        String emailAlreadyRegisteredMessage ="An account using this email address has already been registered" +
                ". Please enter a valid password or request a new one.";

        //Ser Direcionado para página de login
        home.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");

        //Prencher campo de e-mail com endereço de email já cadastrado.
        newLogin.fillEmailAlreadyRegistered();
        System.out.println("Preencheu o campo com e-mail já cadastrado.");

        //Clicar no botão Create an Account
        newLogin.clickBtnCreateAnAccount();
        System.out.println("Clicou no botão Create Account.");

        //Validar se irá direcionar para página de criação de conta uma vez que foi inserido um e-mail já cadastrado.
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));

        assertEquals(emailAlreadyRegisteredMessage, newLogin.getErrorMessageText());
        System.out.println("Não permitiu o direcionamento para a página de criação de nova conta" +
                " utilizando um endereço de  e-mail já registrado.");

    }






    @Test
    @Story("Tentar realizar cadastro com campos obrigatórios em branco:")
    public void testNewAccountWithoutAnyRequiredField() throws Exception {
        HomePage home = new HomePage();
        LoginPage newLogin = new LoginPage();
        NewAccountPage newAccount = new NewAccountPage();
        String messageErrorNullFields = "There are 8 errors";


        //Clicar no botão Login da Home
        home.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");

        //Preencher e-mail para criação de nova conta
        newLogin.fillEmailAdress();
        System.out.println("Preencheu o e-mail.");

        //Clicar no botão Create an Account
        newLogin.clickBtnCreateAnAccount();
        System.out.println("Clicou no botão Create Account.");

        //Ser Direcionado para a página de criação de nova conta
        assertTrue(newAccount.isCreationFormPresent());
        System.out.println("Direcionou corretamente para página de New Account.");

        //Clicar em Register
        newAccount.clickRegisterBtn();
        System.out.println("Clicou no no Botão Register");

        //Validar se continuamos na página de criação de conta e se exibiu a mensagem de erro.
        assertTrue(newAccount.isCreationFormPresent());
        assertTrue(newAccount.getErrorMessageText().contains(messageErrorNullFields));
        System.out.println("Não permitiu o registro sem o preenchimento dos campos obrigatórios, e exibiu a mensagem de erro.");

    }






    @Test
    @Story("Efetuar cadastro com campos obrigatórios preenchidos corretamente:")
    public void testNewAccountWithAllRequiredField() throws Exception {
        HomePage home = new HomePage();
        LoginPage newLogin = new LoginPage();
        NewAccountPage newAccount = new NewAccountPage();


        //Clicar no botão Login da Home
        home.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");

        //Preencher e-mail para criação de nova conta
        newLogin.fillEmailAdress();
        System.out.println("Preencheu o e-mail.");

        //Clicar no botão Create an Account
        newLogin.clickBtnCreateAnAccount();
        System.out.println("Clicou no botão Create Account");

        //Ser Direcionado para a página de criação de nova conta
        assertTrue(newAccount.isCreationFormPresent());
        System.out.println("Direcionou corretamente para página de New Account.");

        //Preencher Campos Obrigatórios
        newAccount.fillFormWithValidRequiredFields();
        System.out.println("Preencheu o formulário com dados válidos.");


        //Clicar em Register
        newAccount.clickRegisterBtn();
        System.out.println("Clicou no Botão Register.");

        //Validar se foi direcionado para My Account Page
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()
                .concat("/index.php?controller=my-account")));
        System.out.println("Validou a url de minha conta.");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText()
                .contains("MY ACCOUNT"));
        System.out.println("Criou a conta corretamente.");

    }






    @Test
    @Story("Efetuar cadastro com campos obrigatórios preenchidos incorretamente:")
    public void testNewAccountWithWrongAllRequiredField() throws Exception {
        HomePage home = new HomePage();
        LoginPage newLogin = new LoginPage();
        NewAccountPage newAccount = new NewAccountPage();
        String messageErrorFields = "There are 5 errors";


        //Clicar no botão Login da Home
        home.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");

        //Preencher e-mail para criação de nova conta
        newLogin.fillEmailAdress();
        System.out.println("Preencheu o e-mail.");

        //Clicar no botão Create an Account
        newLogin.clickBtnCreateAnAccount();
        System.out.println("Clicou no botão Create Account.");

        //Ser Direcionado para a página de criação de nova conta
        assertTrue(newAccount.isCreationFormPresent());
        System.out.println("Direcionou corretamente para página de New Account.");

        //Preencher Campos Obrigatórios
        newAccount.wrongFillFormWithValidRequiredFields();
        System.out.println("Preencheu o formulário com dados inválidos.");

        //Clicar em Register
        newAccount.clickRegisterBtn();
        System.out.println("Clicou no Botão Register.");

        //Validar se permaneceu na mesma página e apresentou mensagem de erro
        assertTrue(newAccount.isCreationFormPresent());
        assertTrue(newAccount.getErrorMessageText().contains(messageErrorFields));
        System.out.println(" Não permitiu a criação de conta com preenchimento de dados inválidos nos campos obrigatórios," +
                "mensagem de erro.");

    }
}
