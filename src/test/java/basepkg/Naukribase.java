package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Naukribase {
	public WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void url()
	{
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
	}

}
