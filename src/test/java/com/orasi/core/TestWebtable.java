package com.orasi.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orasi.core.interfaces.Label;
import com.orasi.core.interfaces.Webtable;
import com.orasi.core.interfaces.impl.LabelImpl;
import com.orasi.core.interfaces.impl.WebtableImpl;
import com.orasi.utils.TestEnvironment;

public class TestWebtable extends TestEnvironment{
    
    @BeforeTest(groups ={"regression", "interfaces", "webtable", "dev"})
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion",
	    "operatingSystem", "environment" })
    public void setup(@Optional String runLocation, String browserUnderTest,
	    String browserVersion, String operatingSystem, String environment) {
	setApplicationUnderTest("Test Site");
	setBrowserUnderTest(browserUnderTest);
	setBrowserVersion(browserVersion);
	setOperatingSystem(operatingSystem);
	setRunLocation(runLocation);
	setTestEnvironment(environment);
	setPageURL("file:" +getClass().getClassLoader().getResource("sites/htmlTest/testApp.html").getPath());
	testStart("TestWebtable");
	getDriver().findElement(By.id("Load")).click();
    }
    
    @AfterTest(groups ={"regression", "interfaces", "webtable", "dev"})
    public void close(){
	endTest("TestWebtable");
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void clickCell(){
    	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
    	webtable.clickCell(this, 1, 1);
    	Assert.assertTrue(getDriver().findElement(By.id("LastName")).getAttribute("value").equals("clicked"));
      } 
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getCell(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getCell(this, 1, 2).getText().equals("First Name"));
	
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getCellData(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getCellData(this, 1, 2).equals("First Name"));
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getColumnCount(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getColumnCount(this, 1) == 5);
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getColumnWithCellText(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getColumnWithCellText(this, "Gender") == 4);
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getColumnWithCellTextUsingRow(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getColumnWithCellText(this, "Monroe", 7) == 3);
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getRowCount(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getRowCount(this) == 7);
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getRowWithCellText(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getRowWithCellText(this, "Elvis") == 3);
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getRowWithCellTextSpecifedColumn(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getRowWithCellText(this, "Curie",3) == 4);
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getRowWithCellTextSpecifedRowAndColumn(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getRowWithCellText(this, "Male", 4, 4) == 5);
    }
    
    @Test(groups ={"regression", "interfaces", "webtable"})
    public void getRowWithCellTextNotExact(){
	Webtable webtable= new WebtableImpl(getDriver().findElement(By.id("VIPs")));
	Assert.assertTrue(webtable.getRowWithCellText(this, "science", 5, 1, false) == 4);
    }
    

}