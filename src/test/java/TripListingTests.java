import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TripListingTests extends BaseTest {

    @Test
    public void VerifyCountOfDay () {



        driver.get("https://deens.com/");

        driver.findElement(By.cssSelector("[title='Fun getaway with friends in London']")).click();

        List<WebElement> daysCount = driver.findElements(By.cssSelector("[class*='Itinerary__DayTitle']"));

//        List<WebElement> daysCount = [Webelement1, Webelement2, Webelement3]
//
//        for (int i = 0; i < daysCount.size(); i++) {
//
//            WebElement day = daysCount.get(i);
//
//            String dayText = day.getText();
//
//            System.out.println(dayText);
//        }

        Assert.assertEquals(daysCount.size(), 5);



    }

    @Test(enabled = false)
    public void PLPandPDPTitleTest () throws InterruptedException {


        driver.get("https://deens.com/");

        driver.findElement(By.cssSelector("[title='Fun getaway with friends in London']")).click();

        Thread.sleep(5000);

        List<WebElement> tripTitles = driver.findElements(By.cssSelector("[class*='Itinerary__ServiceTitle'] a"));

//        List<WebElement> tripTitles = driver.findElements(By.cssSelector("Itinerary__ServiceTitle"));

        Assert.assertTrue(tripTitles.size() > 0);



        String plpTitle =  tripTitles.get(0).getText();
        tripTitles.get(0).click();

        String pdpTitle = driver.findElement(By.cssSelector("[class*='Service__HeaderWrap'] h2")).getText();

        Assert.assertEquals(plpTitle, pdpTitle);



//        List<WebElement> daysCount = [Webelement1, Webelement2, Webelement3]
//
//        for (int i = 0; i < daysCount.size(); i++) {
//
//            WebElement day = daysCount.get(i);
//
//            String dayText = day.getText();
//
//            System.out.println(dayText);
//        }

//        Assert.assertEquals(daysCount.size(), 5);
        ;


    }
}
