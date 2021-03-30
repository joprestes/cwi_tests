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

    @FindBy(id="uniform-days")
    public WebElement dayBirth;

    @FindBy (id = "uniform-months")
    public WebElement monthBirth;

    @FindBy (id = "uniform-years")
    public WebElement yearBirth;

    @FindBy(css=".form-group #address1")
    public WebElement adress;

    @FindBy(css=".form-group #city")
    public WebElement city;

    @FindBy(id = "uniform-id_state")
    public WebElement state;

    @FindBy (id = " form-control uniform-input text")
    public WebElement zipcode;

    @FindBy (css = ".form-group #phone_mobile")
    public WebElement mobilePhoneNumber;

    @FindBy (css = "#submitAccount.btn")
    public WebElement btnSubmitAccount;
}
