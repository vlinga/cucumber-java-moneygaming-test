package stepdefination;


import io.cucumber.java.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Base;

public class Hooks extends Base {

    @After
    public void closebrowser() {
        Base.closeBrowser();
    }

}
