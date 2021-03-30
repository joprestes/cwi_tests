package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

@Feature("Testes Site de Ecommerce")
public class SetupTest extends BaseTests {

    @Test
    @Story("Abrir o Site")
    public void testOpeningBrowserAndLoadPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a URL!");

    }

    @Test
    @Story("Realizar o Login")
    public void testLogin() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();


        //Clicar no botão Login da Home
        home.clickBtnLogin();

        //Verificação se ao clicar no botão Login na home ocorreu o
        // direcionamento para a página de login
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de login.");

        //Realizar Login
        login.fillEmail();
        System.out.println("Preencheu o e-mail.");
        login.fillPasswd();
        System.out.println("Prencheu a senha.");
        login.clickBtnSubmitLogin();
        System.out.println("Clicou em Sign in!");

        //Verificar o direcionamento para a minha conta ao realizar o login
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()
                .concat("/index.php?controller=my-account")));
        System.out.println("Validou a url de minha conta.");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText()
                .contains("MY ACCOUNT"));
        System.out.println("Validou minha conta no site.");


    }

    @Test
    @Story("Pesquisar o termo 'Dress'")
    public void testSearch() {

        String quest = "DRESS";
        String questResultQtd = "7";

        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a pesquisa


        home.doSearch(quest);
        System.out.println("Clicou em pesquisa, preencheu 'dress' e submeteu a pesquisa!");

        //Validar a pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""), quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));

    }

    @Test
    @Story("Acessar a página de Categoria T-Shirts")
    public void testAcessCategoryTshirts() {
        //Iniciar as páginas

        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();


        //Clicar na categoria Tshirts

        home.clickCategoryTShirts();

        //Validar se ao clicar na categoria T_Shirts ocorreu o direcionamento correto
        assertTrue(category.isPageTShirts());

    }

    @Test
    @Story("Adicionar um produto ao carrinho")
    public void testAddProductToProductPage (){
        //Acessar a categoria T Shirts
        testAcessCategoryTshirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em More e direcionar para a página do Produto
        category.clickProductAddToProductPage();

        //Verificar se o produto está na página de detalhes do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));

    }

    @Test
    @Story("Ser direcionado à Página do Carrinho")

    public void  testAddProductToCartPage () {
        //Acessara página de produto
        testAddProductToProductPage();

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //Salva nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de adicionar ao carrinho
        pdp.clickButtonAddToCart ();

        //Clicar no botão Proceed to checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        //Validação do nome do produto no carrinho
        assertTrue(cart.getProductNameCart().equals(nameProductPDP));
        }

    @Test
    @Story("Ser Direcionado para página de criação de nova conta")
    public void testNewAccount () throws Exception {
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

        /*newAccount.waitForCreationFormLoad();
        Tentei utilizar waitFor, mas mesmo carregando o elemento, ainda não conseguia capturar a url corretamente,
        optei por utilizar o Thread.sleep
        Thread.sleep(3000);
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("#account-creation"));*/

        //Ser Direcionado para a página de criação de nova conta
        assertTrue(newAccount.isCreationFormPresent());
        System.out.println("Direcionou corretamente para página de New Account.");
    }

        @Test
        @Story("Tentar ser direcionado à página de criação de contqa sem preencher e-mail")

        public void testNewAccountWithNullEmail () throws Exception {
            HomePage home = new HomePage();
            LoginPage newLogin = new LoginPage();

            //Ser Direcionado para página de login
            home.clickBtnLogin();
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                    concat("/index.php?controller=authentication&back=my-account")));
            System.out.println("Clicou em Sign in e direcionou para página de Login.");


            //Clicar no botão Create an Account sem preenchar e-mail
            newLogin.clickBtnCreateAnAccount();
            System.out.println("Clicou no botão Create Account");

            //Validar se irá direcionar para página de criação de conta com o campo e-mail vazio
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                    concat("/index.php?controller=authentication&back=my-account")));
            System.out.println("Não permitiu o direcionamento para de conta sem preenchimento de E-mail");


        }

        @Test
        @Story("Tentar direcionamento para página de criação de conta utilizando e-mail em formato inválido")

        public void testNewAccountWithInvalidEmail () throws Exception {
            HomePage home = new HomePage();
            LoginPage newLogin = new LoginPage();

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
            System.out.println("Clicou no botão Create Account");

            //Validar se irá direcionar para página de criação de conta com o campo e-mail vazio
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                    concat("/index.php?controller=authentication&back=my-account")));
            System.out.println("Não permitiu o direcionamento para de conta com preenchimento de E-mail em formato inválido");

        }

        @Test
        @Step ("Tentar direcionamento para página de criação de conta utilizando e-mail já cadastrado")
        public void testNewAccountWithEmailAlreadyRegistered () throws Exception {
            HomePage home = new HomePage();
            LoginPage newLogin = new LoginPage();

            //Ser Direcionado para página de login
            home.clickBtnLogin();
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                    concat("/index.php?controller=authentication&back=my-account")));
            System.out.println("Clicou em Sign in e direcionou para página de Login.");

            //Prencher campo de e-mail com endereço em formato inválido
            newLogin.fillEmailAlreadyRegistered();
            System.out.println("Preencheu o campo com e-mail inválido.");

            //Clicar no botão Create an Account
            newLogin.clickBtnCreateAnAccount();
            System.out.println("Clicou no botão Create Account");

            //Validar se irá direcionar para página de criação de conta com o campo e-mail vazio
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                    concat("/index.php?controller=authentication&back=my-account")));
            System.out.println("Não permitiu o direcionamento para de conta utilizando e-mail já registrado");

        }

        @Test
        @Step ("Tentar Realizar Cadastro Com Campos Obrigatórios em Branco")
        public void testNewAccountWithoutRequiredField () throws Exception {
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

            //Clicar em Register
            newAccount.clickRegisterBtn();
            System.out.println("Clicou no no Botão Register");

            //Validar se continuamos na página de criação de conta.
            assertTrue(newAccount.isCreationFormPresent());
            System.out.println("Não permitiu o registro sem o preenchimento dos campos obrigatórios");

        }





}
