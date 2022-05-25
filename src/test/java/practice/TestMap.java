package practice;

import java.util.Map;

import utils.ExcelUtils;

public class TestMap {

	public static void main(String[] args) {
		ExcelUtils objExcelUtils = new ExcelUtils("./src/test/resources/UserData.xlsx", "Sheet1");
		Map<Integer, Map<String, String>> mapOfMaps = objExcelUtils.mapData();
		for (Integer index : mapOfMaps.keySet()) {
			Map<String, String> map = mapOfMaps.get(index);
			System.out.println(map.get("Address"));
		}
	}
}
