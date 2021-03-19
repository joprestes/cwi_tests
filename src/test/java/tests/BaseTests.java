package tests;

import org.junit.After;
import org.junit.Before;
import utils.Browser;
import utils.Utils;

public class BaseTests {
    @Before
    public void setup(){
        Browser.loadpage(Utils.getBaseUrl());
    }

    @After
    public void tearDowm(){
        Browser.close();
    }
}
