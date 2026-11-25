package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadParametersinRunTime {
	WebDriver driver=null;

	@Test
	public void m1() throws Throwable {
		String browser = System.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        else {
            driver = new ChromeDriver();
        }
		driver.get(System.getProperty("url"));
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
