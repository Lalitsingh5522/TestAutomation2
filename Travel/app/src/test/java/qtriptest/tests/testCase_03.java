package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class testCase_03 extends DriverSingleton{

    @Test(description = "Verify registration happens correctly", priority = 3, groups = "Booking and Cancellation Flow",dataProvider = "fetchDataTC3",dataProviderClass=DP.class)
    public void TestCase03(String Username, String Password,String City,String advn,String prsn,String Date,String noOfPerson) throws InterruptedException
    {
        RemoteWebDriver driver = DriverSingleton.driver;

        //registering user
        // RegisterPage rp = new RegisterPage(driver);
        // rp.navigateToRegisterPage();
        // rp.registerUser(Username, Password, false);
        // String lastUsername = rp.lastGeneratedUsername;

        //logging user
        LoginPage lp = new LoginPage(driver);
        lp.navigateToLoginPage();
        lp.PerformLogin(Username, Password);

        //searching for addvanture

        HomePage hp = new HomePage(driver);
        hp.PerformSearch(City);

        AdventurePage ap = new AdventurePage(driver);
        ap.filterSearch("6-12 Hours", "Cycling Routes");
        ap.selectAdvn(advn);
        
        AdventureDetailsPage adp = new AdventureDetailsPage(driver);
        adp.FillAdvantureForm(prsn, noOfPerson,Date);

        HistoryPage hist = new HistoryPage(driver);
        hist.navigateToHistory();
        Thread.sleep(10000);
        hist.CaptureTransId();
        driver.navigate().refresh();
        Thread.sleep(3000);
        boolean status = hist.reservationHistory();

        Assert.assertTrue(status,"history not deleted");

        if(status==true)
        test.log(LogStatus.PASS, "TestCase03 Passed");
        else
        test.log(LogStatus.FAIL, "TestCase03 Fail");


    }
}
