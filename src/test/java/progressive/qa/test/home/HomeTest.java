package progressive.qa.test.home;

import org.testng.annotations.Test;

import base.BaseClass;

public class HomeTest extends BaseClass{

	@Test(groups = {"home"})
	public void homeTest1() {
		System.out.println("Hometest1");
	}
	
	@Test(groups = {"home"})
	public void homeTest2() {
		System.out.println("Hometest2");
	}
}
