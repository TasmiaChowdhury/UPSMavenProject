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
		
		
		driver.get("https://www.ups.com"); // this will open the browser 
		driver.manage().window().maximize(); // this is to maximize the webpage
		
		WebElement signInIcon=driver.findElement(By.xpath("//*[@id=\"ups-navContainer\"]/header/div/div/a/span"));
		signInIcon.click();
		
		WebElement userID= driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement password= driver.findElement(By.xpath("//*[@id=\"pwd\"]"));
		WebElement submitButton= driver.findElement(By.xpath("//*[@id=\"submitBtn\"]"));
		
		userID.sendKeys(new String[] {"Tasmiarahi95@gmail.com"});
		password.sendKeys(new String[] {"password"});
		submitButton.click();
		
WebElement errorMessages=driver.findElement(By.id("errorMessages"));
		
		String error =errorMessages.getText();// fetching the output error 
		
	
		if (error.contains("Something seems to have gone wrong.")){
			System.out.println("PASSED!!");
		}else{
			System.out.println("FAILED!!");
		}
		
		
		Thread.sleep(2000);// this is to give time how long you want it to take. 2 sec
		
		driver.close();

	}

}
