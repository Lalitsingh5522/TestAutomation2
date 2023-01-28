package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase_02 extends DriverSingleton{
    
    @Test(description = "Verify search happens correctly",priority = 2,groups = "Search and Filter flow",dataProvider = "fetchDataTC2",dataProviderClass=DP.class)
    public void TestCase02(String city,String Category, String Duration, String a, String b) throws InterruptedException
    {
        RemoteWebDriver driver;

        driver = DriverSingleton.driver;

        HomePage hp = new HomePage(driver);

        hp.navigateToHomePage();

        hp.PerformSearch(city);
        boolean status = hp.HomefilterSearch(Duration, Category);

        Assert.assertTrue(status,"Filters not applied");

        if(status==true)
        test.log(LogStatus.PASS, "TestCase02 Passed");
        else
        test.log(LogStatus.FAIL, "TestCase02 Fail");

    }
}
