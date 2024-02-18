package seleniumPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenFirefox {
	
	public static WebDriver driver = null;

	@BeforeTest
	public void setUp() {
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\VIHANGA\\Downloads\\New folder (2)\\geckodriver.exe");
	    driver = new FirefoxDriver();
	}
    
    @Test
    public void testInitiateMeeting() {
        try {
            // Step 1: Login to the application
            driver.get("http://localhost:4200/login");
            WebElement userName = driver.findElement(By.id("userName"));
            userName.sendKeys("EMP002");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("EMP002");
            WebElement loginBtn = driver.findElement(By.id("loginBtn"));
            loginBtn.click();
            
            Thread.sleep(2000);

            // Step 2: Click on Timeline button
            WebElement timelineBtn = driver.findElement(By.xpath("/html/body/app-root/app-nav-bar-component/mat-sidenav-container/mat-sidenav/div/button[2]"));
            timelineBtn.click();
            
            Thread.sleep(2000);

            // Step 3: Fill the timeline form and submit
            WebElement meetingId = driver.findElement(By.id("meetingId"));
            meetingId.sendKeys("MET005");
            WebElement bankerId = driver.findElement(By.id("bankerId"));
            bankerId.sendKeys("EMP002");
            WebElement customerId = driver.findElement(By.id("customerId"));
            customerId.sendKeys("CUS007");
            WebElement bankerFirstName = driver.findElement(By.id("bankerFirstName"));
            bankerFirstName.sendKeys("Naradha");
            WebElement bankerLastName = driver.findElement(By.id("bankerLastName"));
            bankerLastName.sendKeys("Silva");
            WebElement customerFirstName = driver.findElement(By.id("customerFirstName"));
            customerFirstName.sendKeys("Sahan");
            WebElement customerLastName = driver.findElement(By.id("customerLastName"));
            customerLastName.sendKeys("Ranasinghe");
            WebElement hostType = driver.findElement(By.id("hostType"));
            hostType.sendKeys("FA");
            WebElement meetingDate = driver.findElement(By.id("meetingDate"));
            meetingDate.sendKeys("2023-10-02");
            WebElement startTime = driver.findElement(By.id("startTime"));
            startTime.sendKeys("11:00");
            WebElement endTime = driver.findElement(By.id("endTime"));
            endTime.sendKeys("13:00");
            WebElement timelineSubmitBtn = driver.findElement(By.id("timelineSubmitBtn"));
            timelineSubmitBtn.click();
            
            Thread.sleep(2000);

            // Step 4: Go to the calendar section
            WebElement calendarBtn = driver.findElement(By.xpath("/html/body/app-root/app-nav-bar-component/mat-sidenav-container/mat-sidenav/div/button[3]"));
            calendarBtn.click();
            
            Thread.sleep(2000);

            // Step 5: Click on the calendar cell to see the meeting details
            WebElement calendarCell = driver.findElement(By.xpath("/html/body/app-root/app-nav-bar-component/mat-sidenav-container/mat-sidenav-content/div/app-calander-component/div/mwl-calendar-month-view/div/div/div[1]/div/mwl-calendar-month-cell[2]"));
            calendarCell.click();
            
            Thread.sleep(2000);

            // Step 6: Read the div and print it
            WebElement meetingDetails = driver.findElement(By.xpath("/html/body/app-root/app-nav-bar-component/mat-sidenav-container/mat-sidenav-content/div/app-calander-component/div/mwl-calendar-month-view/div/div/div[1]/mwl-calendar-open-day-events/div/div/mwl-calendar-event-title/span"));
            System.out.println(meetingDetails.getText());
            
            Thread.sleep(2000);

            // Assert that the meeting details are correct
            Assert.assertEquals(meetingDetails.getText(), "Naradha Meeting with Sahan - (MET005)");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed");
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        System.out.println("The driver has been closed.");
    }

	
	

}
