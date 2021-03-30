package pageObjects;

import elementMapper.HomePageElemetMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.assertTrue;

public class HomePage extends HomePageElemetMapper {

    public HomePage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step ("Clicou em Sign in e direcionou para página de login.")
    public void clickBtnLogin(){
        login.click();
    }

    @Step ("Clicar no botão Search")
    public void clickSearch_query_top(){
        search_query_top.click();

    }

    public void sendKeysSearch_query_top (String keys) {
        search_query_top.sendKeys(keys);

    }

    public void clickSubmit_search (){
        submit_search.click();

    }

    @Step ("Método para realizar uma pesquisa")
    public void doSearch(String quest){
        clickSearch_query_top();
        sendKeysSearch_query_top(quest);
        clickSubmit_search();

    }

    @Step ("Clicar no Menu T-Shirts")
    public void clickCategoryTShirts () {
        menuTShirts.click();


    }
    @Step("Método para ser direcionado para página de Login")
    public void redirectLoginPage(){
        clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().
                concat("/index.php?controller=authentication&back=my-account")));
        System.out.println("Clicou em Sign in e direcionou para página de Login.");
    }
}
