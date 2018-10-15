package com.jay.jenkinAutomation.testJenkins.Stepdef;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

public class Logclass {
	
	public static Logger logger;
	
	
	public void initializeLogger() throws IOException
	{
		logger=Logger.getLogger(AmazonDef.class.getName());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String currentDate=format.format(date);
		//System.out.println(currentDate);
		System.setProperty("currentdate", currentDate);
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	

}
