package practice;

import utils.ReadTxtFile;

public class TestReadTxtFile {

	public static void main(String[] args) {
		ReadTxtFile txtFile = new ReadTxtFile("./src/test/resources/SpringTitle.txt");
		for(String s: txtFile.getListData()) {
			System.out.println(s);
		}
		System.out.println(System.getProperty("user.name"));
	}
}
