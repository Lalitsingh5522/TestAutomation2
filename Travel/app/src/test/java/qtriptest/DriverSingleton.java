package qtriptest;

import java.net.MalformedURLException;
import java.net.URL;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSingleton {
    public static RemoteWebDriver driver;
    public static String lastGeneratedUserName;
    public static ExtentTest test;
    public static ExtentReports report;

    @BeforeSuite(alwaysRun = true)

    public static void startTest() throws MalformedURLException
    {
        
    
    // public static void createDriver() throws MalformedURLException 
    // {
        // Launch Browser using Zalenium

        System.out.println("Launching browser....");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
        report = new ExtentReports(System.getProperty("user.dir/app/src")+"/ExtentUserReport.html");
        driver.manage().window().maximize();
        System.out.println("createDriver()");
        test = report.startTest("DriverSingleton");
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        
    // }
    }

    @AfterSuite(alwaysRun = true)
    public static void close()
    {
        System.out.println("Closing browser....");
        driver.close();
        report.endTest(test);
        report.flush();
    }
        
    }
