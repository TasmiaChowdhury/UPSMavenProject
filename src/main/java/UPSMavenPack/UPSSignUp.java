package UPSMavenPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ErrorCodes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UPSSignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // this is parent-child upcasting 
		
		
		driver.get("https://www.ups.com/us/en/Home.page"); 
		driver.manage().window().maximize(); 
		
		driver.findElement(By.xpath("//*[@id=\"ups-navContainer\"]/header/div/div[3]/a")).click();
		
		driver.findElement(By.linkText("Sign up")).click();
		
		// using relative Xpath
		driver.findElement(By.xpath("//input[@id='ups-full_name_input']")).sendKeys("Tasmia Chowdhury");
		
		//using or operator Xpath 
		driver.findElement(By.xpath("//input[@id='ups-email_input' and @name='email_input']")).sendKeys("Tasmiarahi95@gmail.com");;
		
		//using and opator Xpath
		driver.findElement(By.xpath("//input[@id='ups-user_id_input' and @name='user_id_input']")).sendKeys("Tas123");
		
		//using contains Xpath
		driver.findElement(By.xpath("//input[contains (@id, 'ups-user_passwor')]")).sendKeys("Password123");
		
		//using tagname customized Xpath 
		driver.findElement(By.xpath("//select[@name='phoneCountryCode']")).sendKeys("");
		
		//using starts-with Xpath 
		driver.findElement(By.xpath("//input[starts-with (@name, 'phoneInput')]")).sendKeys("917123456");
		driver.findElement(By.xpath("//input[@id='ups-terms_checkbox']")).click();
		
		//using text() Xpath
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		
		WebElement errorMessages=driver.findElement(By.xpath("//span[@id='ErrorHeader']"));
		
		String error =errorMessages.getText();// fetching the output error 
		
	
		if (error.contains("Please correct the following errors")){
			System.out.println("PASSED!!");
		}else{
			System.out.println("FAILED!!");
		}

	}

}
