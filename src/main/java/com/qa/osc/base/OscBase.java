package com.qa.osc.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;

public class OscBase {

	public static WindowsDriver<WebElement> applicaitonSession, driver = null;
	public static WindowsDriver<RemoteWebElement> desktopSession = null;
	public static DesiredCapabilities capabilities, cap1, cap2;
	public static ProcessBuilder pBuilder;
	public static Process p;
	public static Properties prop;

	public OscBase() throws IOException {

		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				path + "\\src\\main\\java\\com\\qa\\osc\\properties\\data.properties");
		prop = new Properties();
		prop.load(fis);

	}

	public void startDriver() {
		try {

			pBuilder = new ProcessBuilder("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
			pBuilder.inheritIO();
			p = pBuilder.start();

		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stopDriver() {

		p.destroy();
	}

	public void createDesktopSession() throws MalformedURLException {

		cap1 = new DesiredCapabilities();
		cap1.setCapability("app", "Root");
		desktopSession = new WindowsDriver<RemoteWebElement>(new URL("http://localhost:4723"), cap1);
	}

	public void openApplication() throws InterruptedException, MalformedURLException {

		if (driver == null) {

			try {

				capabilities = new DesiredCapabilities();
				capabilities.setCapability("app",
						"C:\\Users\\kbas663\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\RightNow\\RightNow (uoa__tst2).appref-ms");
				applicaitonSession = new WindowsDriver<WebElement>(new URL("http://localhost:4723"), capabilities);

			} catch (Exception e) {

				System.out.println("Application opened!!!");

			} finally {

				createDesktopSession();
			}

			Thread.sleep(4000L);

			String handle = desktopSession.findElementByAccessibilityId("InstallerView5")
					.getAttribute("NativeWindowHandle");
			System.out.println(handle);
			int inthandle = Integer.parseInt(handle);
			String hexHandle = Integer.toHexString(inthandle);

			cap2 = new DesiredCapabilities();
			cap2.setCapability("appTopLevelWindow", hexHandle);
			driver = new WindowsDriver<WebElement>(new URL("http://localhost:4723"), cap2);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

	}

}
