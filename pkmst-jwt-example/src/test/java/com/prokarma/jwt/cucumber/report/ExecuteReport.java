package com.prokarma.jwt.cucumber.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import org.junit.Test;

public class ExecuteReport {
	public static void main(String[] args) {
		generateReport();
	}

	//@Test
	public void testGenerateReport() {
		generateReport();
	}

	private static void generateReport() {
		String jenkinsBasePath = "";
		String buildNumber = "1";
		String projectName = "Spring-micro-sample";
		boolean skippedFails = true;
		boolean pendingFails = false;
		boolean undefinedFails = true;
		boolean missingFails = true;
		boolean runWithJenkins = false;
		boolean parallelTesting = false;

		File reportOutputDirectory = new File("./report/product-report-html/");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add("./report/product-report-json/product.json");

		Configuration configuration = new Configuration(reportOutputDirectory,
				projectName);
		// optionally only if you need
		configuration.setStatusFlags(skippedFails, pendingFails,
				undefinedFails, missingFails);
		configuration.setParallelTesting(parallelTesting);
		configuration.setJenkinsBasePath(jenkinsBasePath);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,
				configuration);
		reportBuilder.generateReports();

		System.out.println("\nreport generated..\n");
	}
}
