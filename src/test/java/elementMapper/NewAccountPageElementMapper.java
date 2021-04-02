package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountPageElementMapper {
    @FindBy(id = "id_gender2")
    public WebElement gender;

    @FindBy (css = ".form-group #customer_firstname")
    public WebElement firstName;

    @FindBy (css=".form-group #customer_lastname")
    public WebElement lastName;

    @FindBy (css=".form-group #passwd" )
    public WebElement newPasswd;

    @FindBy(id="days")
    public WebElement dayBirth;

    @FindBy (id = "months")
    public WebElement monthBirth;

    @FindBy (id = "years")
    public WebElement yearBirth;

    @FindBy(css=".form-group #address1")
    public WebElement adress;

    @FindBy(css=".form-group #city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy (id = "postcode")
    public WebElement zipcode;

    @FindBy (id = "phone_mobile")
    public WebElement mobilePhoneNumber;

    @FindBy (css = "#submitAccount.btn")
    public WebElement btnSubmitAccount;

    @FindBy (css = ".alert.alert-danger")
    public WebElement errorMessage;
}
