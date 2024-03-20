package page;

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
	//vreifying text of button
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
	


