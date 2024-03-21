package page;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Naukripages 
{
	
	WebDriver driver;
	By nkhmlogin=By.id("login_Layer");
	By nkemail=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input");
	By nkpwd=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input");
	By nklogin=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button");
	
	public  Naukripages(WebDriver driver)
	{
		this.driver=driver;
	}
	//home login
	public void homelogin()
	{
		driver.findElement(nkhmlogin).click();	
	}
	//title verification
	public void title()
	{
		String title=driver.getCurrentUrl();
		System.out.println("title is==="+title);
		if(title.equalsIgnoreCase("https://www.naukri.com/"))
		{
			System.out.println("title matched");
		}
		else
		{
			System.out.println("title is not displayed");
		}
	}
	//reading username and password
	public void setvalues(String user,String password)
	
	{
	//driver.findElement(nkemail).clear();
	driver.findElement(nkemail).sendKeys(user);
	//driver.findElement(nkpwd).clear();
	driver.findElement(nkpwd).sendKeys(password);;
	}
	//login userpage
	public void userlogin()
	{
		driver.findElement(nklogin).click();
		
	}
	// file upload
	public void upload() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/a")).click();
		
		try {
			fileUpload("D:\\Resume Neenu\\Neenu Avarachan_QA_Resume.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fileUpload(String b) throws Exception
	{
		StringSelection strselection=new StringSelection(b);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	//vreifying text of button is not working properly
	public void buttonverify()
	{
		WebElement button =driver.findElement(nklogin);
		String buttontext=button.getAttribute("value");
		System.out.println(buttontext);

		if(buttontext.equalsIgnoreCase("Login"))
		{
			System.out.println("text matched");
		}
		else
		{
			System.out.println("text not matched");
		}
	}
	
	
	
}	
	


