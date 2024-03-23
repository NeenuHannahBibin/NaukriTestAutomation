package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Naukribase {
	public WebDriver driver;

	@BeforeTest
		public void url()
	{
		 String link="https://www.naukri.com/";

		driver=new ChromeDriver();
		driver.get(link);
		driver.manage().window().maximize();
	}

}
