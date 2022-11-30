package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class LoginTest extends Utilities {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //* Enter valid username
        sendTextToElement(By.name("username"), "jollysmiths");

        //* Enter valid password
        sendTextToElement(By.name("password"), "jolly123");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        //* Verify the ‘Accounts Overview’ text is display
        verifyText(By.xpath("//h1[contains(text(),'Accounts Overview')]"), "Accounts Overview");

    }

    @Test
    public void verifyTheErrorMessage() {
        //* Enter invalid username
        sendTextToElement(By.name("username"), "");

        //* Enter valid password
        sendTextToElement(By.name("password"), "jolly123");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        //* Verify the error message ‘The username and password could not be verified.’
        verifyText(By.xpath("//p[@class='error'][text()='Please enter a username and password.']"),"Please enter a username and password.");
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //* Enter Invalid username
        sendTextToElement(By.name("username"), "jollysmiths");

        //* Enter valid password
        sendTextToElement(By.name("password"), "jolly123");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        //* Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));

        //* Verify the text ‘Customer Login’
        verifyText(By.xpath("//h2[contains(text(),'Customer Login')]"), "Customer Login");

    }

    @After
    public void tearDown() {
       closeBrowser();
    }

}
