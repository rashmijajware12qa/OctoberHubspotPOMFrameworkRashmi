package POIAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeCrmLoginDataDriven {
	
	public static void main(String[] args) throws InterruptedException {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\vibhas\\eclipse-workspace\\kumarirashmi_pom\\src\\main\\java\\POIAPI\\FreeCrmTestData.xlsx");
		
//		String username = reader.getCellData("login", "username", 2);
//		System.out.println(username);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vibhas\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
		
		reader.addColumn("login", "status");
		
		System.out.println(reader.getColumnCount("login"));
		System.out.println(reader.getRowCount("login"));
		
		reader.addSheet("register");
		
		
		
		
		for(int rowNum=2; rowNum<=reader.getRowCount("login"); rowNum++) {
			
			String username=reader.getCellData("login", "username", rowNum);
			String password=reader.getCellData("login", "password", rowNum);
			System.out.println(username+" "+password);
			
			
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]")).clear();;
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[2]")).clear();
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[2]")).sendKeys(password);
			
			reader.setCellData("login", "status", rowNum, "Pass");
			
			
			
			
			
		}
		
		
	}

}
