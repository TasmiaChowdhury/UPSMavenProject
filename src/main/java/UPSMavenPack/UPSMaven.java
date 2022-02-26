package UPSMavenPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UPSMaven {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // this is parent-child upcasting 
		
		
		driver.get("https://www.ups.com/ship/guided/origin"); 
		driver.manage().window().maximize(); 
		
		//using relative xpath 
		driver.findElement(By.xpath("//select[@id='origin-cac_country']")).sendKeys("United State");
		driver.findElement(By.xpath(" //input[@id='origin-cac_companyOrName']")).sendKeys("CPHL Company");;
		
		//Xpath with or operator 
		driver.findElement(By.xpath("//input[@id='origin-cac_contactName' or @name='cac_contactName']")).sendKeys("Tasmia C");;
		
		//Xpath using And 
		driver.findElement(By.xpath("//input[@id='origin-cac_singleLineAddress' and @name='cac_singleLineAddress']")).sendKeys("219 crown ave.Floral prak.11001");;
		
		//xpath using Contains()
		//tagname[contains(@Attribute,'value')]
		driver.findElement(By.xpath("//input[contains (@id, 'origin-cac_email')]")).sendKeys("Tasmiarahi95@gmail.com");;
		
		//xpath using starts_with 
		//tagname[starts_with(@Attribute,'value')]
		driver.findElement(By.xpath("//input[starts-with(@name,'cac_phone')]")).sendKeys("123456789");
		
		
		driver.findElement(By.xpath("//input[@id='origin-cac_extension']")).sendKeys("897");;
		//Xpath using text()
		driver.findElement(By.xpath("//button[text()='Continue']")).click();;
		
		

		
		
		
		Thread.sleep(2000);// this is to give time how long you want it to take. 2 sec
		
		driver.close();

	}

}
