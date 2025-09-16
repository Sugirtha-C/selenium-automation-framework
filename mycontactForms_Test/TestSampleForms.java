package natwest.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestSampleForms {

	
	@BeforeClass
	public static void browserTest() {
		
		ConfigBrowser.getBrowser();
		ConfigBrowser.redirectUrl("https://www.mycontactform.com/");
		
	}
	
	@Test
	public void sampleFormsTest01() {
		boolean b=ConfigBrowser.clickSampleForms().isDisplayed();
		assertTrue(b);
		ConfigBrowser.clickSampleForms().click();
	}
	
	@Test
	public void sampleFormsTest02() {
		boolean b=ConfigBrowser.clickFirstCheckBox().isDisplayed();
		assertTrue(b);
		ConfigBrowser.clickFirstCheckBox().click();
	}
	
	@Test
	public void sampleFormsTest03() {
		boolean b=ConfigBrowser.clickSecondCheckBox().isDisplayed();
		assertTrue(b);
		ConfigBrowser.clickSecondCheckBox().click();
	}
	
	@Test
	public void sampleFormsTest04() {
		boolean b=ConfigBrowser.clickThirdCheckBox().isDisplayed();
		assertTrue(b);
		ConfigBrowser.clickThirdCheckBox().click();
	}
	
	@Test
	public void sampleFormsTest05() {
		
		WebElement firstCheckBox=ConfigBrowser.clickFirstCheckBox();
		assertTrue(firstCheckBox.isDisplayed());
		
		if(firstCheckBox.isSelected()) {
			firstCheckBox.click();
			assertTrue(!firstCheckBox.isSelected());
		}
		
	}

	@Test
	public void sampleFormsTest06() {
		WebElement secondCheckBox=ConfigBrowser.clickSecondCheckBox();
		assertTrue(secondCheckBox.isDisplayed());
		
		if(secondCheckBox.isSelected()) {
			secondCheckBox.click();
			assertTrue(!secondCheckBox.isSelected());
		}
	}
	
	@Test
	public void sampleFormsTest07() {
		WebElement thirdCheckBox=ConfigBrowser.clickThirdCheckBox();
		assertTrue(thirdCheckBox.isDisplayed());
		
		if(thirdCheckBox.isSelected()) {
			thirdCheckBox.click();
			assertTrue(!thirdCheckBox.isSelected());
		}
	}
	
	@Test
	public void sampleFormsTest08() {
		boolean b=ConfigBrowser.checkSubjectText().isDisplayed();
		assertTrue(b);
	}
	
	@Test
	public void sampleFormsTest09() {
		boolean b=ConfigBrowser.inputSubjectText().isDisplayed();
		assertTrue(b);
		ConfigBrowser.inputSubjectText().sendKeys("Sample text for testing");
	}
	
	@Test
	public void sampleFormsTest10() {
		boolean b=ConfigBrowser.checkEmailText().isDisplayed();
		assertTrue(b);
	}
	
	@Test
	public void sampleFormsTest11() {
		boolean b=ConfigBrowser.inputEmailText().isDisplayed();
		assertTrue(b);
		ConfigBrowser.inputEmailText().sendKeys("Test@hotmail.com");
	}
	
	@Test
	public void sampleFormsTest12() {
		boolean b=ConfigBrowser.checkTextField().isDisplayed();
		assertTrue(b);
	}
	
	@Test
	public void sampleFormsTest13() {
		boolean b=ConfigBrowser.inputTextField().isDisplayed();
		assertTrue(b);
		ConfigBrowser.inputTextField().sendKeys("Test input for check box");
	}
	
	@Test
	public void sampleFormsTest14() {
		boolean b=ConfigBrowser.checkMultiLineField().isDisplayed();
		assertTrue(b);
	}
	
	@Test
	public void sampleFormsTest15() {
		boolean b=ConfigBrowser.inputMultiLineField().isDisplayed();
		assertTrue(b);
		ConfigBrowser.inputMultiLineField().sendKeys("Test input for check box to verify a multi line input.This textbox should hold multiple lines as per the expected outcome.");
	}
	
	@Test
	public void sampleFormsTest16() {
		
		Select select=new Select(ConfigBrowser.selectDropDown());
		select.selectByVisibleText("Third Option");
			
		assert(select.getFirstSelectedOption().getText().equals("Third Option"));
	}
	
	@Test
	public void sampleFormsTest17() {
		
		boolean b=ConfigBrowser.selectRadioButton().isEnabled();
		assert(b);
		ConfigBrowser.selectRadioButton().click();
		
		}
	
	@Test
	public void sampleFormsTest18() {
		
		boolean b=ConfigBrowser.selectMultiAnswerCheckBox_1().isDisplayed();
		assert(b);
		ConfigBrowser.selectMultiAnswerCheckBox_1().click();
		
		}
	
	@Test
	public void sampleFormsTest19() {
		
		boolean b=ConfigBrowser.selectMultiAnswerCheckBox_2().isDisplayed();
		assert(b);
		ConfigBrowser.selectMultiAnswerCheckBox_2().click();
		
		}
	
	@Test
	public void sampleFormsTest20() {
		
		boolean b=ConfigBrowser.dateSelector().isDisplayed();
		assert(b);
		
		ConfigBrowser.dateSelector().sendKeys("07-02-2024");
		
		}
	
	@Test
	public void sampleFormsTest21() {
		
		boolean b=ConfigBrowser.selectStateDropDown().isDisplayed();
		assert(b);
		
		Select select=new Select(ConfigBrowser.selectStateDropDown());
		select.selectByVisibleText("ME");
				
		}
	
	@Test
	public void sampleFormsTest22() {
		
		boolean b=ConfigBrowser.selectCountryDropDown().isDisplayed();
		assert(b);
		
		Select select=new Select(ConfigBrowser.selectCountryDropDown());
		select.selectByVisibleText("Australia");
				
		}
	
	@Test
	public void sampleFormsTest23() {
		
		boolean b=ConfigBrowser.selectProvinceDropDown().isDisplayed();
		assert(b);
		
		Select select=new Select(ConfigBrowser.selectProvinceDropDown());
		select.selectByVisibleText("Ontario");
				
		}
	
	@Test
	public  void sampleFormsTest24() {
		
		boolean b=ConfigBrowser.fieldNames_1().isDisplayed();
		assert(b);
		
		Select select=new Select(ConfigBrowser.fieldNames_1());
		select.selectByVisibleText("Mrs.");
		
		}
	
	@Test
	public  void sampleFormsTest25() {
		
		boolean b=ConfigBrowser.fieldNames_2().isDisplayed();
		assert(b);
		ConfigBrowser.fieldNames_2().sendKeys("Tyrion");
		
		}
	
	@Test
	public  void sampleFormsTest26() {
		
		boolean b=ConfigBrowser.fieldNames_3().isDisplayed();
		assert(b);
		ConfigBrowser.fieldNames_2().sendKeys("Lannister");
		
		}
	
	@Test
	public  void sampleFormsTest27() {
		
		boolean b=ConfigBrowser.dateOfBirth_Month().isDisplayed();
		assert(b);
		Select select=new Select(ConfigBrowser.dateOfBirth_Month());
		select.selectByVisibleText("8");
		
		}
	
	@Test
	public  void sampleFormsTest28() {
		
		boolean b=ConfigBrowser.dateOfBirth_Day().isDisplayed();
		assert(b);
		Select select=new Select(ConfigBrowser.dateOfBirth_Day());
		select.selectByVisibleText("30");
		
		}
	
	@Test
	public  void sampleFormsTest29() {
		
		boolean b=ConfigBrowser.dateOfBirth_Year().isDisplayed();
		assert(b);
		Select select=new Select(ConfigBrowser.dateOfBirth_Year());
		select.selectByVisibleText("1992");
		
		}
	
	@Test
	public  void sampleFormsTest30() {
		
		boolean b=ConfigBrowser.attachFiles().isDisplayed();
		assert(b);
		ConfigBrowser.attachFiles().sendKeys("/home/zadmin/JavaAssignments/vms");		
		
		}
	
	
	@Test
	public void sampleFormsTest31() {
		
			
		WebElement element=ConfigBrowser.resetButton();
		assertTrue(element.isDisplayed());
		ConfigBrowser.resetButton().click();
		
		
		WebElement subjectField = ConfigBrowser.inputSubjectText();
		WebElement emailField = ConfigBrowser.inputEmailText();
		WebElement textBoxField = ConfigBrowser.inputTextField();
	    WebElement multiLineField = ConfigBrowser.inputMultiLineField();
	    WebElement firstCheckBox = ConfigBrowser.clickFirstCheckBox();
	    WebElement secondCheckBox = ConfigBrowser.clickSecondCheckBox();
	    WebElement thirdCheckBox = ConfigBrowser.clickThirdCheckBox();
	    WebElement subjectText=ConfigBrowser.inputSubjectText();
	    WebElement emailText=ConfigBrowser.inputEmailText();
	    WebElement multiLine=ConfigBrowser.inputMultiLineField();
	    WebElement dropDown_1=ConfigBrowser.selectDropDown();
	    
	    assertEquals("", subjectField.getAttribute("value"));
	    assertEquals("", emailField.getAttribute("value"));
	    assertEquals("", textBoxField.getAttribute("value"));
	    assertEquals("", multiLineField.getAttribute("value"));
	    assertTrue(!firstCheckBox.isSelected());
	    assertTrue(!secondCheckBox.isSelected());
	    assertTrue(!thirdCheckBox.isSelected());
	    assertEquals("",subjectText.getAttribute("value"));
	    assertEquals("",emailText.getAttribute("value"));
	    assertEquals("",multiLine.getAttribute("value"));
	    assertEquals("First Option",dropDown_1.getAttribute("value"));
	    
	}
}
