package com.qa.osc.test;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.osc.base.OscBase;
import com.qa.osc.page.OscLogin;
import com.qa.osc.page.OscMainPage;
import com.qa.osc.utilities.OSCUtilities;

public class OscTest extends OscBase {

	public OscTest() throws IOException {
		super();
	}

	OscLogin oscLogin;
	OscMainPage oscMainPage;

	@BeforeMethod
	public void setup_And_Login() throws InterruptedException, IOException {

		startDriver();
		openApplication();

		oscLogin = new OscLogin(); // create instance of the OSC login page
		oscMainPage = new OscMainPage(); // create instance of OSC Main Page

		OSCUtilities.minimizeAll();

		oscLogin.login(); // Login into OSC

	}

	@Test
	public void osc_Get_Data() throws InterruptedException, IOException {

		Thread.sleep(20000);

		/*
		 * Check the visibility of Safe Login Dialog Box and Click on No if displayed
		 */

		try {
			Boolean value = oscLogin.isDisplayed_SafeLoginNoBtn();

			if (value) {

				oscLogin.click_safeLogin();
			}
		} catch (Exception e) {

			System.out.println("Safe Login!!!!");
		}

		Thread.sleep(5000L);

		/*
		 * maximize the application window
		 */
		OSCUtilities.maximize();
		/*
		 * click on STC Queue on the navigation bar
		 */
		oscMainPage.click_Stc_Queue();
		/*
		 * click on Slice icon and sort by topic
		 */
		oscMainPage.click_Slice();
		/*
		 * click on PO Entire Receipting
		 */
		oscMainPage.click_PO_Receipting();
		/*
		 * click on export icon and export as excel file
		 */
		oscMainPage.export_Excel();
		/*
		 * handling the save as dialog
		 */
		oscMainPage.enter_Export_Option();
	}

	@AfterMethod
	public void tearDown() throws IOException {

		driver.close();
		stopDriver();

	}

}