package myPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Deepti {
@Test
public static void verifyLogin()
{
	WebDriver d = new ChromeDriver();
	d.get("http://apps.qaplanet.in/qahrm/login.php");
	d.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	d.findElement(By.name("txtPassword")).sendKeys("lab1");
	d.findElement(By.name("Submit")).click();
	
	if(d.getTitle().equals("OrangeHRM"))
	{
		System.out.println("Tc passed");
	}
	else 
	{
		System.out.println("Tc failed");
	}
	d.findElement(By.linkText("Logout")).click();
	d.close();
}
@Test
public static void addEmployee() throws InterruptedException
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://apps.qaplanet.in/qahrm");
	
	
	driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	driver.findElement(By.name("txtPassword")).sendKeys("lab1");
	driver.findElement(By.name("Submit")).click();
	
	driver.switchTo().frame("rightMenu");
	driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[1]")).click(); // for add button

	Thread.sleep(5000);
	driver.findElement(By.name("txtEmpLastName")).sendKeys("Mandava");
	driver.findElement(By.name("txtEmpFirstName")).sendKeys("Deepthi");
	driver.findElement(By.xpath("//*[@id='btnEdit']")).click();   // to save 
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id='btnEditPers']")).click(); //clicking edit
	String fN=driver.findElement(By.xpath("//*[@id='txtEmpFirstName']")).getAttribute("value");
	String lN=driver.findElement(By.xpath("//*[@id='txtEmpLastName']")).getAttribute("value");
	System.out.println("firstName :"+ fN);
	System.out.println("lastName : "+ lN);
	
	if(fN.equals("Deepthi")&&(lN.equals("Mandava"))){
		System.out.println("Employee successfully added : TestCase Passed");
	}
	else
	{
		System.out.println("Add Employee failed : testcase failed");
	}
	//driver.switchTo().defaultContent(); //use this if gone inside too many frames
			driver.switchTo().parentFrame(); // back to one frame
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[3]/ul/li[3]/a")).click();
			
			Thread.sleep(2000);
			driver.close();	

}
}
