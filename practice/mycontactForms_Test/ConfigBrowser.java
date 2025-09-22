package natwest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigBrowser {

	static WebDriver driver;
	
	public static WebDriver getBrowser() {
		
		if(driver==null) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();				
		}
		return driver;
	}
	
	public static void redirectUrl(String url) {
		
		driver.get(url);
	}
	
	public static WebElement clickSampleForms() {
		WebElement element=driver.findElement(By.linkText("Sample Forms"));
		//element.click();
		return element;
	
	}
	
	public static WebElement clickFirstCheckBox() {
		WebElement element=driver.findElement(By.xpath("//input[@value='0']"));
		return element;
	}
	
	public static WebElement clickSecondCheckBox() {
		WebElement element=driver.findElement(By.xpath("//input[@value='1']"));
		return element;
	}
	
	public static WebElement clickThirdCheckBox() {
		WebElement element=driver.findElement(By.xpath("//input[@value='2']"));
		return element;
	}
		
	public static WebElement checkSubjectText() {
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'Subject')]"));
		return element;
	}
	
	public static WebElement inputSubjectText() {
		WebElement element=driver.findElement(By.id("subject"));
		return element;
	}
	
	public static WebElement checkEmailText() {
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'E-mail Address:')]"));
		return element;
	}
	
	public static WebElement inputEmailText() {
		WebElement element=driver.findElement(By.id("email"));
		return element;
	
}
	
	public static WebElement checkTextField() {
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'Text Box Field:')]"));
		return element;
	}
	
	public static WebElement inputTextField() {
		WebElement element=driver.findElement(By.id("q1"));
		return element;
	}
	
	public static WebElement checkMultiLineField() {
		WebElement element=driver.findElement(By.xpath("//label[contains(text(),'Text Box - Multi Line:')]"));
		return element;
	}
	
	public static WebElement inputMultiLineField() {
		WebElement element=driver.findElement(By.id("q2"));
		return element;
	}
	
		public static WebElement selectDropDown() {
			WebElement element=driver.findElement(By.id("q3"))	;
			return element;
			
		}
		
		public static WebElement selectRadioButton() {
			WebElement element=driver.findElement(By.xpath("//input[@id='q4'][@value='Second Option']"));
			return element;
		}
	
			
		public static WebElement selectSingleCheckBox() {
			WebElement element=driver.findElement(By.xpath("//input[@id='q5']"));
			return element;
			}
		
		public static WebElement selectMultiAnswerCheckBox_1() {
			WebElement element=driver.findElement(By.xpath("//input[@value='Fifth Check Box']"));
			return element;
			}
		

		public static WebElement selectMultiAnswerCheckBox_2() {
			WebElement element=driver.findElement(By.xpath("//input[@value='Second Check Box']"));
			return element;
			
		}
		
		public static WebElement dateSelector() {
			WebElement element=driver.findElement(By.xpath("//input[@id='q7']"));
			return element;
		}
		
		public static WebElement selectStateDropDown() {
			
			WebElement element=driver.findElement(By.id("q8"))	;
			return element;
			
		}
		
		public static WebElement selectCountryDropDown() {
			
			WebElement element=driver.findElement(By.id("q9"))	;
			return element;
			
		}
		
		public static WebElement selectProvinceDropDown() {
			
			WebElement element=driver.findElement(By.id("q10"))	;
			return element;
			
		}
		
		public static WebElement fieldNames_1() {
			
			WebElement element=driver.findElement(By.name("q11_title"));
			return element;
		}
			
		public static WebElement fieldNames_2() {
			
			WebElement element=driver.findElement(By.name("q11_first"));
			return element;
		}
		
		
		public static WebElement fieldNames_3() {
			
			WebElement element=driver.findElement(By.name("q11_last"));
			return element;
		}
			
		public static WebElement dateOfBirth_Month() {
			
			WebElement element=driver.findElement(By.name("q12_month"));
			return element;
		}
		
		public static WebElement dateOfBirth_Day() {
			
			WebElement element=driver.findElement(By.name("q12_day"));
			return element;
		}
		
		public static WebElement dateOfBirth_Year() {
			
			WebElement element=driver.findElement(By.name("q12_year"));
			return element;
		}
		
		public static WebElement attachFiles() {
			WebElement element=driver.findElement(By.name("attach4589"));
			return element;
		}
		public static WebElement resetButton() {
		WebElement element=driver.findElement(By.name("reset"));
		return element;
	}
}







