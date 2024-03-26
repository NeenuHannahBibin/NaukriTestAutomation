package page;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

//import sun.net.www.protocol.http.HttpURLConnection;

public class Naukripages 
{
	
	WebDriver driver;
	By nkhmlogin=By.id("login_Layer");
	By nkemail=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input");
	By nkpwd=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input");
	By nklogin=By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button");
	By nkhmreg=By.id("register_Layer");
	By nkflname=By.id("name");
	By nkregemail=By.id("email");
	By nkregpwd=By.id("password");
	By nkregmobile=By.id("mobile");
	By nkimg=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[4]/div[2]/div[2]");
	By nkckbox=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[6]");
	By Nkreg=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[7]/button");
	By currentcity=By.id("currentCity");
	By currentst=By.id("currentState");
	By press1=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[1]/form/div[2]/div[5]/div");
	By press2=By.xpath("//*[@id=\"sa-dd-scrollcurrentState\"]");
	
	public  Naukripages(WebDriver driver)
	{
		this.driver=driver;
	}
	//home login
	public void homelogin() throws Exception
	{
		
		driver.findElement(nkhmlogin).click();	
		Thread.sleep(3000);
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
	public void setvalues(String user,String password) throws InterruptedException
	
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
		} catch (Exception e)
		{
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
	//vreifying text of button 
	public void buttonverify()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		WebElement button =driver.findElement(nklogin);
		String buttontext=button.getAttribute("value");
		System.out.println("no value in the button"+buttontext);

		if(buttontext.equalsIgnoreCase("Login"))
		{
			System.out.println("text matched");
		}
		else
		{
			System.out.println("text not matched");
		}
	}
	// whole page screenshot
	
	public void scrennshots() throws IOException
	{
	File  screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(screenshot, new File("D://naukriscreenshot.png"));
	}
	
	// single element screenshot
	public void elementscreenshot() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		WebElement pic=driver.findElement(By.id("register_Layer"));
		File ScreenShotpic=pic.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ScreenShotpic, new File("./naukripic//naukri.png"));
	}
	//scroll down to the bottom of page 
	public void scrolldown() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)", " ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		
	}
	// link validations
	public void linkvalidation() throws IOException, Exception
	{
    Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		String link="https://www.naukri.com/";
		URL con=new URL(link);
		HttpURLConnection connection =(HttpURLConnection)con.openConnection();
		connection.connect();
		if(connection.getResponseCode()==200)
		{
			System.out.println("valid link------"+link);
			
		}
		else
		{
			System.out.println("invalid link----"+link);
		}
	}
	//logo verify
	public void logoverify()
	{
		WebElement logo=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/a/img"));
		boolean display=logo.isDisplayed();
		if(display)
		{
			System.out.println("logo is displayed");
		}
		else
		{
			System.out.println("logo is not displayed");
		}
		
	}
	public void setregvalues(String fullname, String emailid,String password,String mobile,String city,String State) throws InterruptedException
	{
	
	driver.findElement(nkflname).sendKeys(fullname);
	driver.findElement(nkregemail).sendKeys(emailid);
	driver.findElement(nkregpwd).sendKeys(password);
	driver.findElement(nkregmobile).sendKeys(mobile);
	driver.findElement(nkimg).click();
	Thread.sleep(3000);
	driver.findElement(currentcity).sendKeys(city);
	Thread.sleep(1500);
	driver.findElement(press1).click();

	driver.findElement(currentst).sendKeys(State);
	Thread.sleep(3000);
	driver.findElement(press2).click();

	driver.findElement(nkckbox).click();
	
	}
	public void homeregister()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(nkhmreg).click();
	}
	public void register()
	{
		driver.findElement(Nkreg).click();
	}
	public void logout()
	{
		driver.findElement(By.xpath("//*[@id=\"ni-gnb-header-section\"]/div[3]/div[2]/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"ni-gnb-header-section\"]/div[3]/div[2]/div[3]/div[2]/div[2]/div/div[3]/div/div[1]/div[4]")).click();
		
	}
	
}	
	


