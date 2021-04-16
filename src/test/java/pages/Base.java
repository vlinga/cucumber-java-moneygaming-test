package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;
    public static WebElement element;
    protected WebDriverWait wait;
    private String lastWinHandle;

    public Base() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream((
                    "src/main/config.properties"));
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    /**
     * Method to close browser
     */
    public static void closeBrowser() {
        driver.close();
    }

    /**
     * Method to open browser
     *
     * @param url : URL
     */
    public void Visit(String url) {
        driver.get(url);
    }

    public void SendText(By by_locator, String text) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).sendKeys(text);
    }

    /**
     * Method to click element
     *
     * @param by_locator : to locate the element
     */
    public void click(By by_locator) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).click();
    }


    /**
     * Method to select element from Dropdown by type
     *
     * @param select_list : Select : Select variable
     * @param option      : String : Option to select
     */
    public void selectElementFromDropdownByType(Select select_list, String option) {
        select_list.selectByValue(option);
    }

    /**
     * Method to check check-box
     *
     * @param by_locator : By : Locator type (id, name, class, xpath, css)
     */
    public void checkCheckbox(By by_locator) {
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
        if (!checkbox.isSelected())
            checkbox.click();
    }

    /**
     * Method to get element text
     *
     * @param by_locator : By : Locator type (id, name, class, xpath, css)
     * @param errorMsg
     */
    public void getElementText(By by_locator, String errorMsg) {
        SoftAssert softAssert = new SoftAssert();
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
        softAssert.assertEquals(errorMsg, element.getText());
        softAssert.assertAll();
    }

}


