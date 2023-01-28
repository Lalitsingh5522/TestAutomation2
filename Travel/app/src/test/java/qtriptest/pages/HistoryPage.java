
package qtriptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HistoryPage {

    RemoteWebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/reservations/";
    String trans;

    public HistoryPage(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToHistory()
    {
        if(!this.driver.getCurrentUrl().equals(url))
        this.driver.get(this.url);
    }

    public void CaptureTransId() throws InterruptedException
    {
       String trans = driver.findElement(By.xpath("//th[@scope = 'row']")).getText();
        driver.findElement(By.xpath("//button[text()='Cancel']")).click();
        
        Thread.sleep(8000);
    }

    public boolean reservationHistory()
    {
        try
        {
            driver.findElement(By.xpath("//button[text()='Cancel']")).click();
        }
        catch(Exception e)
        {
            return true;
        }

        return false;
    }
}