package qtriptest.tests;

import qtriptest.pages.LoginPage;
import qtriptest.DriverSingleton;
import qtriptest.DP;
import static org.testng.Assert.*;
import java.net.MalformedURLException;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class testCase_01 extends DriverSingleton{


    /*
     * Testcase01: Verify a new user can successfully register
     */
    @Test(description = "Verify Login happens correctly", priority = 1, groups = "Login Flow",dataProvider = "fetchDataTC1",dataProviderClass=DP.class)
    // @Parameters({ "TC1_Username", "TC1_Password" })
    public void TestCase01(@Optional("testUser") String TC1_Username, @Optional("abc@123") String TC1_Password)
            throws InterruptedException, MalformedURLException {

        RemoteWebDriver driver;
        
        // DriverSingleton.createDriver();
        driver = DriverSingleton.driver;
        
        
        // Visit the Registration page and register a new user

        //start register

        // RegisterPage registration = new RegisterPage(driver);
        // registration.navigateToRegisterPage();
        // status = registration.registerUser(TC1_Username, TC1_Password, false);
        // // assertTrue(status, "Failed to register new user");

        // // Save the last generated username
        // String lastGeneratedUserName = registration.lastGeneratedUsername;

        //end register

        // Visit the login page and login with the previuosly registered user
        LoginPage login = new LoginPage(driver);
        login.navigateToLoginPage();
        
        // status = login.PerformLogin(lastGeneratedUserName, TC1_Password);
        Boolean status = login.PerformLogin(TC1_Username, TC1_Password);

        assertTrue(status, "Failed to login with registered user");
        // // Visit the home page and log out the logged in user
        // Home home = new Home(driver);
        // status = home.PerformLogout();
        if(status==true)
        test.log(LogStatus.PASS, "TestCase01 Passed");
        else
        test.log(LogStatus.FAIL, "TestCase01 Fail");
    }

    

}
