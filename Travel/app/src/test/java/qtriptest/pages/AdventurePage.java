package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AdventurePage {

    RemoteWebDriver driver;

    public AdventurePage(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public boolean filterSearch(String Duration,String Category) throws InterruptedException
    {
        driver.findElement(By.xpath("//select[@name = 'duration']")).click();
        driver.findElement(By.xpath("//select[@name = 'duration']//option[text()='"+Duration+"']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id = 'category-select']")).click();
        driver.findElement(By.xpath("//select[@id = 'category-select']//option[text()='"+Category+"']")).click();

        Thread.sleep(2000);

        List<WebElement> results = driver.findElements(By.xpath("//div[@class = 'col-6 col-lg-3 mb-4']"));
        int size = results.size();

        driver.findElement(By.xpath("//select[@name='duration']/following-sibling::div[contains(text(),'Clear')]")).click();
        driver.findElement(By.xpath("//select[@id = 'category-select']/following-sibling::div[contains(text(),'Clear')]")).click();
        
        Thread.sleep(5000);
        results = driver.findElements(By.xpath("//div[@class = 'col-6 col-lg-3 mb-4']"));
        
        if(size==results.size())
        return true;

        return false;
        

    }

    public void selectAdvn(String advn) throws InterruptedException
    {
        List<WebElement> results = driver.findElements(By.xpath("//div[@class = 'col-6 col-lg-3 mb-4']"));

        for(WebElement ele:results)
        {
            if(ele.getText().contains(advn))
            {
                ele.click();
                Thread.sleep(3000);
                break;
            }
        }
        
    }

       
    }
