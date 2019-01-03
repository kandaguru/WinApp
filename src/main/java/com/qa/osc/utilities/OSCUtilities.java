package com.qa.osc.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.qa.osc.base.OscBase;

public class OSCUtilities extends OscBase {
	
	

	public OSCUtilities() throws IOException {
		super();
	}

	public static void maximize() throws InterruptedException {
		Thread.sleep(1500L);
		Actions action = new Actions(driver);
		action.keyDown(Keys.COMMAND).sendKeys(Keys.UP).keyUp(Keys.COMMAND).build().perform();

	}

	public static void minimizeAll() throws InterruptedException {
		Thread.sleep(1500L);
		Actions action = new Actions(driver);
		action.keyDown(Keys.COMMAND).sendKeys(Keys.HOME).keyUp(Keys.COMMAND).build().perform();

	}

	public static void switch_To_Window() {

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		driver.switchTo().window(it.next());

	}
	
	
	public static String getCurrentDate() {
		
		String timeStamp = new SimpleDateFormat("ddMMyyyy_hhmmss").format(Calendar.getInstance().getTime());
		return timeStamp;
		
	}

	
	public static void click_enter()  {
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).build().perform();

	}
	
	
}
