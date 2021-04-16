package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Login extends Base {

    By joinNow = By.xpath("//a[@class='newUser green']");
    By title = By.name("map(title)");
    By firstName = By.name("map(firstName)");
    By surName = By.name("map(lastName)");
    By checkBox = By.name("map(terms)");
    By joinNowReg = By.xpath("//*[@id=\"form\"]");
    By dobElement = By.cssSelector("label[for=dob]");

    public void launchwebsite() {

        super.Visit("https://moneygaming.qa.gameaccount.com/");
    }


    public void joinNow() {

        super.click(joinNow);
    }


    public void selectTitle(String option) {

        Select select = new Select((driver.findElement(title)));

        super.selectElementFromDropdownByType(select, option);
    }


    public void enterFirstname(String firstname) {

        super.SendText(firstName, firstname);
    }

    public void surName(String surname) {

        super.SendText(surName, surname);
    }

    public void selectCheckbox() {
        super.checkCheckbox(checkBox);
    }

    public void joinNowReg() {

        super.click(joinNowReg);
    }

    public void validateMessage(String errormsg) {
        super.getElementText(dobElement, errormsg);
    }
}