package com.qa.osc.page;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.osc.base.OscBase;
import com.qa.osc.utilities.OSCUtilities;

public class OscMainPage extends OscBase {

	WebDriverWait wait;
	Actions action;

	public OscMainPage() throws IOException {
		super();
	}

	// Loactors values in the Applicaiton Landing Page

	String stcQueueBtnLocator = "STC-General Inbox (1.1c) 106610";
	String sliceBtnLocator = "Slice";
	String sliceItemByLocator = "//*[@Name='Slice items by']/Pane[@AutomationId='_tableLayoutPanel']/ComboBox[@AutomationId='_reportColumnComboBox']";
	String topicOptionLocator = "Topic";

	String entirePOReceiptingLocator = "//TreeItem[contains(@Name,'Entire PO Receipting')]";
	String exportBtnLocator = "Export";
	String excelOptionLocator = "Excel";
	String FilePickerLocator = "_filePickerButton";
	String fileNameEditBoxLocator = "File name:";
	String saveBtnLocator = "Save";
	String onBtnLocator="OK";
	
	/*
	 * Locator functions returning the locator of the elements on the OSC main page
	 */

	public WebElement stcQueueBtn() {

		return driver.findElementByName(stcQueueBtnLocator);
	}

	public WebElement sliceBtn() {

		return driver.findElementByName(sliceBtnLocator);

	}

	public WebElement sliceItemByDrpDwn() {

		return driver.findElementByXPath(sliceItemByLocator);

	}

	public WebElement topicOption() {

		return driver.findElementByName(topicOptionLocator);
	}

	public WebElement entirePORecepting() {

		return driver.findElementByXPath(entirePOReceiptingLocator);
	}

	public WebElement exportDrpDwnBtn() {

		return driver.findElementByName(exportBtnLocator);

	}

	public WebElement excelOption() {

		return driver.findElementByName(excelOptionLocator);

	}

	public WebElement filePicker() {

		return driver.findElementByAccessibilityId(FilePickerLocator);
	}

	public WebElement fileNameEditBox() {

		return driver.findElementByName(fileNameEditBoxLocator);
	}

	public WebElement saveBtn() {

		return driver.findElementByName(saveBtnLocator);
	}

	public WebElement okBtn() {

		return driver.findElementByName(onBtnLocator);
	}

	/*
	 * functions implementing mouse movements and keyboard actions
	 */

	
	public void click_Stc_Queue() {

		OSCUtilities.switch_To_Window();
		action = new Actions(driver);
		action.moveToElement(stcQueueBtn()).doubleClick().build().perform();
	}

	public void click_Slice() throws InterruptedException {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(sliceBtn())).click();
		sliceItemByDrpDwn().click();
		action = new Actions(driver);
		action.moveToElement(topicOption()).click().sendKeys(Keys.ENTER).build().perform();

	}

	public void click_PO_Receipting() {

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(entirePORecepting())).click();

	}

	public void export_Excel() {

		action = new Actions(driver);
		exportDrpDwnBtn().click();
		action.moveToElement(excelOption()).click().build().perform();

	}

	public void enter_Export_Option() {

		String fileLoc = "C:\\Users\\kbas663\\Desktop\\desktop\\testloc\\sample-" + OSCUtilities.getCurrentDate()
				+ ".xlsx";

		action = new Actions(driver);
		filePicker().click();
		action.moveToElement(fileNameEditBox()).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).sendKeys(fileLoc).build().perform();
		saveBtn().click();
		okBtn().click();

	}

}
