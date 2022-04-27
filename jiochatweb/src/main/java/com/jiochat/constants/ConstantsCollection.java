package com.jiochat.constants;

public class ConstantsCollection {
	
	private ConstantsCollection() {
		
	}
	
	private static final String CONFIGFILEPATH = System.getProperty("user.dir")+"\\src\\test\\resources\\config\\FrameworkProperties.properties";
	private static final int EXPLICITWAIT = 10;
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigPath()
	{
		return CONFIGFILEPATH;
		
	}
}
