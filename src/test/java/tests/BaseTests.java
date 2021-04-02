package tests;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

public class BaseTests {
    @Before
    public void setup(){
        Browser.loadpage(Utils.getBaseUrl());
    }

    @After
    public void tearDowm(){
        Browser.print();
        Browser.close();
    }

}
