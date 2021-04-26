package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport() {
		
		String extentReportPath= System.getProperty("user.dir")+"\\reports\\extentreport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		
		reporter.config().setReportName("Tutorials Ninja Test Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("OperatingSystem", "Windows 10");
		extentReport.setSystemInfo("Tested By", "Surendra Reddy");
		
		return extentReport;
		
		
	}

}
