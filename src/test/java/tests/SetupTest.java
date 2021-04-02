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

import static org.junit.Assert.*;/*

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
    public void testAccessCategoryTshirts() {
        //Iniciar as páginas

        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();


        //Clicar na categoria Tshirts

        home.clickCategoryTShirts();

        //Validar se ao clicar na categoria T_Shirts ocorreu o direcionamento correto
        assertTrue(category.isPageTShirts());

    }





    @Test
    @Story("Ser direcionado à Página do Produto")
    public void testViewProductPage() {
        //Acessar a categoria T Shirts
        testAccessCategoryTshirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em More e direcionar para a página do Produto
        category.clickSelectProduct();

        //Verificar se o produto está na página de detalhes do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));

    }





    @Test
    @Story("Adicionar um produto ao carrinho")

    public void testAddProductToCartPage() {
        //Acessara página de produto
        testViewProductPage();

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //Salva nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de adicionar ao carrinho
        pdp.clickButtonAddToCart();

        //Clicar no botão Proceed to checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        //Validação do nome do produto no carrinho
        assertTrue(cart.getProductNameCart().equals(nameProductPDP));

    }





}*/
