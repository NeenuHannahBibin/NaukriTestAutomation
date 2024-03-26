package test;

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
		//ob.homeregister();

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
			ob.logout();
	  }
		
		/*Sheet="Sheet2";
		rowCount=Naukriexcel.getRowCount(x1, Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			Thread.sleep(3000);
			String fullname=Naukriexcel.getCellValue(x1, Sheet, i, 0);
			System.out.println("fullname==="+fullname);
			String emailid=Naukriexcel.getCellValue(x1, Sheet, i, 1);
			System.out.println("emailid==="+emailid);
			String password=Naukriexcel.getCellValue(x1, Sheet, i, 2);
			System.out.println("password==="+password);
			String mobile=Naukriexcel.getCellValue(x1, Sheet, i, 3);
			System.out.println("mobile==="+mobile);
			String city=Naukriexcel.getCellValue(x1, Sheet, i, 4);
			System.out.println("city==="+city);
			String state=Naukriexcel.getCellValue(x1, Sheet, i, 5);
			System.out.println("state==="+state);
			ob.setregvalues(fullname, emailid,password,mobile,city,state);
			//ob.setregvalues(fullname, emailid, password, mobile, city);
			ob.register();
			

			
			
	  }*/
		

		

	}
}
