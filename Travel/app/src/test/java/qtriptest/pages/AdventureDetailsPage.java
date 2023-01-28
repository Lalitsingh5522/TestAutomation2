
package qtriptest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AdventureDetailsPage 
{
    RemoteWebDriver driver;

    public AdventureDetailsPage(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public void FillAdvantureForm(String Username, String noOfPerson,String date) throws InterruptedException
    {

    driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Username);
    driver.findElement(By.xpath("//input[@name='person']")).clear();
    driver.findElement(By.xpath("//input[@name='person']")).sendKeys(noOfPerson);
    driver.findElement(By.xpath("//input[@name = 'date']")).sendKeys(date);
    driver.findElement(By.xpath("//button[text()='Reserve']")).click();

    Thread.sleep(2000);

    }
}