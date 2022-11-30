package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class RegisterTest extends Utilities {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }


    @Test
    public void verifyThatSigningUpPageDisplay() {
        //* click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //* Verify the text ‘Signing up is easy!’
        verifyText(By.xpath("//h1[contains(text(),'Signing up is easy!')]"), "Signing up is easy!");
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {
        //* click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //* Enter First name
        sendTextToElement(By.id("customer.firstName"), "Jolly");

        //* Enter Last name
        sendTextToElement(By.id("customer.lastName"), "Smith");

        //* Enter Address
        Thread.sleep(3000);
        sendTextToElement(By.id("customer.address.street"), "12,Procter Close");

        //* Enter City
        sendTextToElement(By.id("customer.address.city"), "Coventry");

        //* Enter State
        sendTextToElement(By.id("customer.address.state"), "UK");

        //* Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "C2 GGW");

        //* Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "9876543212");

        //* Enter SSN
        sendTextToElement(By.id("customer.ssn"), "123456");

        //* Enter Username
        sendTextToElement(By.id("customer.username"), "jollysmith");

        //* Enter Password
        sendTextToElement(By.id("customer.password"), "jolly123");

        //* Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), "jolly123");

        //* Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        //* Verify the text 'Your account was created successfully. You are now logged in.’
        Thread.sleep(2000);
        verifyText(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"), "Your account was created successfully. You are now logged in.");

    }

    @After
    public void teardown(){
        closeBrowser();
    }

}
