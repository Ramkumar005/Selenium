package leaftap;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws IOException {

		 WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

		driver.get("http://leaftaps.com/opentaps/");

		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/img.jpg");
		FileUtils.copyFile(src, dest);
		
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("RamKumar");
		driver.findElementById("createLeadForm_lastName").sendKeys("Ramiah");
		driver.findElementByName("primaryPhoneNumber").sendKeys("9750249477");
		driver.findElementByName("submitButton").click();
		driver.close();

	}
}
