package pageObjects;

import elementMapper.CategoryPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CategoryPage extends CategoryPageElementMapper {

    public CategoryPage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    public boolean isPageTShirts(){
        return getAuthentionPageTShirts().contains("T-SHIRTS");
    }

    public String getAuthentionPageTShirts (){
        return nameCategoryTShirts.getText();

    }

    public void clickSelectProduct() {
        BasePage.mouseOver(productNameCategory);
        buttonMoreAddToProductPage.click();

    }

    public String getProductNameCategory (){
        return productNameCategory.getText();

    }
}
