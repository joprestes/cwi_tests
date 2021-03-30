package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    public WebElement email;

    public WebElement passwd;

    public WebElement SubmitLogin;

    @FindBy (css = ".form-group #email_create")
    public WebElement newEmail;

    @FindBy (css=".submit #SubmitCreate")
    public WebElement createAnAccount;




}
