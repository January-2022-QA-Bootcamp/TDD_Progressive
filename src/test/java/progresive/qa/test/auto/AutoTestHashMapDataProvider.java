package progresive.qa.test.auto;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import utils.ExcelUtils;
import utils.ReadConfigFile;

public class AutoTestHashMapDataProvider extends BaseClass{

	@DataProvider(name = "mapData")
	public Object[][] mapData(){
		String filePath = ReadConfigFile.getInstance().getExcelPath();
		String sheetName = ReadConfigFile.getInstance().getSheetName();
		ExcelUtils excelUtils = new ExcelUtils(filePath, sheetName);
		int rows = excelUtils.mapData().size();
		Object[][] dataObjects = new Object[rows][1];
		for(int i = 0; i < rows; i++) {
			Map<String, String> map = excelUtils.mapData().get(i);
			dataObjects[i][0] = map;
		}
		return dataObjects;
	}
	
	@Test(dataProvider = "mapData", groups = {"excel"})
	public void autoTest(Map<String, String> map) {
		landingPage.landingPageSteps(commonActions);
		zipCodePage.zipCodePageSteps(commonActions, map);
		startPersonalDetailsPage.startPersonalDetailsPageSteps(commonActions, map);
		vehicleDetailsPage.vehicleDetailsPageSteps(commonActions, map);
	}
	
	//@Test(groups = "retry",retryAnalyzer = Retry.class)
	@Test(groups = "retry")
	public void retryTest() {
		System.out.println("Retry Test");
		Assert.fail();
	}
	
	@Test(groups = "retry")
	public void retryTest2() {
		System.out.println("Retry Test2");
		Assert.fail();
	}
}
