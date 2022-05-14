package practice;

import utils.ReadConfigFile;

public class TestReadConfig {

	public static void main(String[] args) {
		System.out.println(ReadConfigFile.getInstance().getUrl());
	}
}
