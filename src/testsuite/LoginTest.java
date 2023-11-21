package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShuoldLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password is invalid!”
 */

public class LoginTest extends BaseTest {
    static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter the User Name in  User Name field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");


        //Enter the password to password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword!");


        //Click on Login button
        driver.findElement(By.className("radius")).click();
        //driver.findElement(By.xpath("//i[@class ='fa fa-2x fa-sign-in']")).click();


        //Verify the text "Secure Area"
        String excepted = "Secure Area";
        String actual = driver.findElement(By.xpath("//div[@class ='example']//h2[text() = ' Secure Area']")).getText();
        System.out.println(actual);
        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter the Invalid User Name in User Name field
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith1");

        //Enter the valid Password in Password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword");

        //Click on Login Button
        driver.findElement(By.className("radius")).click();
        //driver.findElement(By.xpath("//i[@class ='fa fa-2x fa-sign-in']")).click();

        //Verify the Error message
        String expectedText = "Your username is invalid!\n×";
        String actualText = driver.findElement(By.id("flash")).getText();
        //String actualText = driver.findElement(By.xpath("//div[@id = 'flash']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter the valid User Name in User Name field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");

        //Enter the Invalid Password in Password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword");

        //Click on Login Button
        driver.findElement(By.className("radius")).click();
        //driver.findElement(By.xpath("//i[@class ='fa fa-2x fa-sign-in']")).click();

        //Verify the Error message
        String expectedText = "Your password is invalid!\n×";
        String actualText = driver.findElement(By.id("flash")).getText();
        //String actualText = driver.findElement(By.xpath("//div[@id = 'flash']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}


