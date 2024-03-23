package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basepkg.Naukribase;
import page.Naukripages;
import utilitiespkg.Naukriexcel;



public class Naukritest extends Naukribase
{

	
	@Test
	public void verifylogintest() throws Exception
	{
		Naukripages ob=new Naukripages(driver);
		ob.linkvalidation();

		ob.logoverify();
		ob.elementscreenshot();
		ob.homelogin();
		ob.title();
		ob.buttonverify();

		String x1="D:\\naukriusername.xlsx";
		String Sheet="Sheet1";
		int rowCount=Naukriexcel.getRowCount(x1, Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			Thread.sleep(3000);
			String username=Naukriexcel.getCellValue(x1, Sheet, i, 0);
			System.out.println("username==="+username);
			String password=Naukriexcel.getCellValue(x1, Sheet, i, 1);
			System.out.println("password==="+password);
			ob.setvalues(username, password);
			ob.userlogin();
			ob.upload();
			ob.scrennshots();
			ob.scrolldown();

			
			
	  }

		

	}
}
