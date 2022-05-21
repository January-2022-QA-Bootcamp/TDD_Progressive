package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import reporting.JavaLog;

public class ReadConfigFile {

	private static ReadConfigFile readConfigFile;
	private static String location = "./configuration/configure.properties";

	private static String url;
	private static int pageLoadTime;
	private static int implicitlyWaitTime;
	private static String excelPath;
	private static String sheetName;
	private static String titleFilePath;

	private ReadConfigFile() {

	}

	public static ReadConfigFile getInstance() {
		if (readConfigFile == null) {
			readConfigFile = new ReadConfigFile();
			readProperties();
		}
		return readConfigFile;
	}

	private static void readProperties() {
		try {
			FileReader reader = new FileReader(location);
			Properties properties = new Properties();
			properties.load(reader);
			//Top 3 lines are reading the configure.properties file
			url = properties.getProperty("url");
			pageLoadTime = Integer.parseInt(properties.getProperty("pageLoadTime"));
			implicitlyWaitTime = Integer.parseInt(properties.getProperty("implicitlyWaitTime"));
			excelPath = properties.getProperty("excelPath");
			sheetName = properties.getProperty("sheetName");
			titleFilePath = properties.getProperty("titleFilePath");
		} catch (IOException e) {
			JavaLog.log("File Not Found \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		} catch(NumberFormatException e) {
			JavaLog.log("Number format in properties not correct \n"+e.getMessage() + "<br>");
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return url;
	}

	public int getPageLoadTime() {
		return pageLoadTime;
	}

	public int getImplicitlyWaitTime() {
		return implicitlyWaitTime;
	}
	
	public String getExcelPath() {
		return excelPath;
	}
	
	public String getSheetName() {
		return sheetName;
	}
	
	public String getTitleFilePath() {
		return titleFilePath;
	}
}
