package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage {

    RemoteWebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/";

    public HomePage(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToHomePage()
    {
        if(!this.driver.getCurrentUrl().equals(this.url))
        {
            this.driver.get(this.url);
        }
    }

    public void PerformSearch(String city) throws InterruptedException
    {

        try{

        driver.findElement(By.xpath("//input[@placeholder = 'Search a City ']")).clear();
        driver.findElement(By.xpath("//input[@placeholder = 'Search a City ']")).sendKeys(city);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id ='results']//li")).click();

        Thread.sleep(1000);

        // driver.navigate().refresh();
        
        }
        catch (Exception e)
        {
            driver.findElement(By.xpath("//input[@placeholder = 'Search a City ']")).clear();
            driver.findElement(By.xpath("//input[@placeholder = 'Search a City ']")).sendKeys(city);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//ul[@id ='results']//li")).click();

            Thread.sleep(1000);
        }
      
    }

    public boolean HomefilterSearch(String Duration,String Category) throws InterruptedException
    {
        driver.findElement(By.xpath("//select[@name = 'duration']")).click();
        driver.findElement(By.xpath("//select[@name = 'duration']//option[text()='"+Duration+"']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//select[@id = 'category-select']")).click();
        driver.findElement(By.xpath("//select[@id = 'category-select']//option[text()='"+Category+"']")).click();

        Thread.sleep(1000);

        List<WebElement> FilteredResults = driver.findElements(By.xpath("//div[@class = 'col-6 col-lg-3 mb-4']"));
        int FSize = FilteredResults.size();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@name='duration']/following-sibling::div[contains(text(),'Clear')]")).click();
        driver.findElement(By.xpath("//select[@id = 'category-select']/following-sibling::div[contains(text(),'Clear')]")).click();
        
        List<WebElement> results = driver.findElements(By.xpath("//div[@class = 'col-6 col-lg-3 mb-4']"));
        
        Thread.sleep(2000);

        if(FSize != results.size())
        return true;
        

        return false;
    }
}
