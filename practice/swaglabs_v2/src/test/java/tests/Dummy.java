package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy {
	
	@Test(dataProvider="testdata")
	
	public void dummy(String name) {
		
		System.out.println(name);
	}
	@DataProvider(name="testdata")
	public String [] getData() {
		return new String[] {"hello","data","test"};
	}
	
	@Test(dataProvider="testdata_2")
	public void dummy(String name, int age) {
		System.out.println("Name: " + name + ", Age: " + age);
	}

	@DataProvider(name="testdata_2")
	public Object[][] getData1() {
		return new Object[][] {
			{"Alice", 30},
			{"Bob", 25},
			{"Charlie", 35}
		};
}
	
	

	@DataProvider(name="loginChecks")
			public Object[][] getLoginData(){
			return new Object[][] {
				{"locked_out_user","secret_sauce"},
				{"standard_user","secret_sauce"},
				{"problem_user","secret_sauce"}
			};
	}

}
