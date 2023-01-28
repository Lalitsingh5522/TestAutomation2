package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase_04 extends DriverSingleton{

    @Test(description = "Verify multiple registration happens correctly", priority = 4, groups = "Reliability Flow",dataProvider = "fetchDataTC4",dataProviderClass=DP.class)
    public void TestCase04(String Username, String Password,String dataset1,String dataset2 ,String dataset3) throws InterruptedException
    {
      RemoteWebDriver driver = DriverSingleton.driver;
      String[] DummyArr = {dataset1,dataset2,dataset3};

      for(int i=0;i<3;i++)
      {
        String[] arr = DummyArr[i].split(";");
         //logging user
         LoginPage lp = new LoginPage(driver);
         lp.navigateToLoginPage();
         lp.PerformLogin(Username, Password);
 
         //searching for addvanture
 
         HomePage hp = new HomePage(driver);
         hp.PerformSearch(arr[0]);
 
         AdventurePage ap = new AdventurePage(driver);
         ap.filterSearch("6-12 Hours", "Cycling Routes");
         ap.selectAdvn(arr[1]);
         
         AdventureDetailsPage adp = new AdventureDetailsPage(driver);
         adp.FillAdvantureForm(arr[2], arr[4],arr[3]);
 
         HistoryPage hist = new HistoryPage(driver);
         hist.navigateToHistory();
         Thread.sleep(10000);
 
         hist.CaptureTransId();
         
         driver.navigate().refresh();
         Thread.sleep(3000);
         boolean status = hist.reservationHistory();
 
         Assert.assertTrue(status,"history not deleted");

        if(status==true)
        test.log(LogStatus.PASS, "TestCase04 Passed");
        else
        test.log(LogStatus.FAIL, "TestCase04 Fail");

      }

        

       

        

    }
    
}
