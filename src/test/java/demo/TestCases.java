package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
//import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import io.opentelemetry.semconv.SemanticAttributes.SystemCpuStateValues;
import net.bytebuddy.asm.Advice.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in
     * instructions
     */

    /*
     * Do not change the provided methods unless necessary, they will help in
     * automation and assessment
     */
    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------    

    public void logStatus(String step, String message, String status){
           System.out.println(String.format("%s  | %s | %s",step,message,status)); 
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------    

    @Test(description = "Test Cases for Buildout")
    public void testCase01() throws InterruptedException {
        boolean status =false;

        // Navigate to this google form.       
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
        driver.get(url);
        if(driver.getCurrentUrl().equals(url)){
            status = true;
        }
        if(status){
            logStatus("Step 1 :", "Navigate to this google form : ", "PASS");
        }
        else{
            logStatus("Step 1 :", "Navigate to this google form : ", "FAIL");
        }

        System.out.println();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//-------------------------------------------------------------------------------------------------------------------------------------------------
        
        // Fill in Crio Learner in the 1st text box
        logStatus("Step 2 :", "Fill in Crio Learner in the 1st text box : ", "Done");
        WebElement textBox = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
        textBox.sendKeys("Crio Learner ");
        // if(enteredText.equals("Crio Learner ")){
        //     status=true;
        // }
        // if(status){
        //     logStatus("Step 2 :", "Fill in Crio Learner in the 1st text box", "PASS");
        // }
        // else{
        //     logStatus("Step 2 :", "Fill in Crio Learner in the 1st text box", "FAIL");
        // }
        System.out.println();
//------------------------------------------------------------------------------------------------------------------------------------------------------
        
        /* Write down "I want to be the best QA Engineer! 1710572021' where 1710572021 is variable - needs to be the current epoch time. */
        logStatus("Step 3 :", "Write text : " , "Done");
         WebElement textArea = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        textArea.sendKeys(
                "I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time.");
        System.out.println("Text has been enetered");
        System.out.println();
 
//------------------------------------------------------------------------------------------------------------------------------------------------------        

        // Enter your Automation Testing experience in the next radio button
        logStatus("Step 4 :", "Write Enter your Automation Testing experience in the next radio button  : ", "Done");
        WebElement radioButton = driver.findElement(By.xpath("//div[@id='i13']"));
        wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        System.out.println("Automation Testing experience has been clicked");
        radioButton.click();
        System.out.println();

//------------------------------------------------------------------------------------------------------------------------------------------------------        

        // Select Java, Selenium and TestNG from the next check-box
        logStatus("Step 5 :", "Select Java, Selenium and TestNG from the next check-box  : ", "Done");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='eBFwI']//span[@dir='auto']"));
        for (WebElement checkbox : checkboxes) {
            String checkBoxtext = checkbox.getText();
            if (checkBoxtext.equals("Java") || checkBoxtext.equals("Selenium") || checkBoxtext.equals("TestNG")) {
                wait.until(ExpectedConditions.elementToBeClickable(checkbox));
                System.out.println(checkBoxtext + " : checkbox has been clicked");
                checkbox.click();
            }
        }
        System.out.println();

//-------------------------------------------------------------------------------------------------------------------------------------------------        

        // Provide how you would like to be addressed in the next dropdown
        logStatus("Step 6 :", "Provide how you would like to be addressed in the next dropdown : ", "Done");
        WebElement dropdown = driver.findElement(By.xpath("//div[@role='listbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        System.out.println("dropdown has been clicked");
        dropdown.click();
        Thread.sleep(2000);

        List<WebElement> addresse = driver.findElements(By.xpath("//*[contains(@class,'vRMGwf')]"));  
        System.out.println("list size : "+addresse.size());   
       
        for(WebElement address : addresse){
            String addressText = address.getText(); 
            //System.out.println(addressText);   
            if(addressText.equals("Ms")){
                System.out.println("Address selected : "+addressText);   
                WebElement visibleEle = wait.until(ExpectedConditions.visibilityOf(address)); 
                visibleEle.click();                     
                System.out.println("address has been clicked");              
            }
        }
        System.out.println();

//-------------------------------------------------------------------------------------------------------------------------------------------------
       
        /* Provided the current date minus 7 days in the next date field, it should be dynamically 
        calculated and not hardcoded. */
        logStatus("Step 7 :", "Provided the current date minus 7 days in the next date field  : ", "Done");
        // current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("currentDate :" +currentDate);

        //subtract 7 days
        LocalDate pastDate = currentDate.minusDays(7);
        System.out.println("pastDate :"+pastDate);

        //format the date
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = pastDate.format(format);
        System.out.println("formattedDate :"+formattedDate);

        WebElement inputdate = driver.findElement(By.xpath("//input[@type='date']"));
        wait.until(ExpectedConditions.visibilityOf(inputdate));
        inputdate.clear();
        inputdate.sendKeys(formattedDate);
      
        System.out.println("date has been enetered");
        //Thread.sleep(3000);
        System.out.println();

    

//-------------------------------------------------------------------------------------------------------------------------------------------------
    
        //What is the time right now?
        logStatus("Step 8 :", "What is the time right now? :Provide 07:30 time ", "Done");

        //Current time Script
            // LocalTime currentTime = LocalTime.now();
            // System.out.println("Current time now is  : "+ currentTime);
    
            // int currentHour =  LocalTime.now().getHour();
            //     System.out.println("Current hour now is  : "+ currentHour); 
            // String hour = String.format("%02d",currentHour);
            //     System.out.println("Current hour now is  : "+ hour);

            // int currentMinute  =  LocalTime.now().getMinute();
            //     System.out.println("Current minute now is  : "+ currentMinute);
            // String minute = String.format("%02d",currentMinute);
            //     System.out.println("Current minute now is  : "+ minute);  
            
        //enter 07:30 or 19:30    

        WebElement hourElement =  driver.findElement(By.xpath("//div[@class='Xb9hP']//input[@aria-label='Hour']"));
        wait.until(ExpectedConditions.visibilityOf(hourElement));        
        hourElement.sendKeys("07");
        
        WebElement minuteElement = driver.findElement(By.xpath("//div[@class='Xb9hP']//input[@aria-label='Minute']"));
        wait.until(ExpectedConditions.visibilityOf(minuteElement));
        minuteElement.sendKeys("30");
        
        Thread.sleep(5000); 

        //submit the Form
        logStatus("Step 8 :", "Submit the Form : ", "Done");

        WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));        
        wait.until(ExpectedConditions.visibilityOf(submit));
        submit.click();


//-------------------------------------------------------------------------------------------------------------------------------------------------

        //You will see a success message on the website. Print the same message on the console upon successful completion
        logStatus("Step 9 :", "Print the same message on the console upon successful completion ", "Done");

        WebElement message = driver.findElement(By.xpath("//div[@class='idZHHb']/div[3]"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String text = message.getText();
        System.out.println(text);
        
        Thread.sleep(2000);
    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();

    }
}