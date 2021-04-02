package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPageElementMapper {

    @FindBy (css = "#cart_summary .product-name")
    public WebElement productNameCart;

}
