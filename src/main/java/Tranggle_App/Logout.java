package Tranggle_App;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Tranggle_Method_p.Tranggle_Method;
import bsh.Console;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Logout {

	private AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void SetDriver() throws MalformedURLException {
		try {
			System.out.println("SetDriver() - Driver Creating Start");

			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Tranggle_Method.platform_Android);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Tranggle_Method.devicename);

			capabilities.setCapability(Tranggle_Method.app_Package, Tranggle_Method.app_Package_Name);
			capabilities.setCapability(Tranggle_Method.app_Activity, Tranggle_Method.app_Activity_Name);

			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

			System.out.println("SetDriver() - Driver setCapability Success");

			// Appium 드라이버 초기화 및 드라이버 URL / 셋팅 값으로 드라이버 셋팅
			URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<>(appiumServerUrl, capabilities);

			System.out.println("SetDriver() - Driver Created Success - driver : " + driver);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SetDriver() - Driver Created Failure - driver : " + driver);
			e.printStackTrace();
		}

	}

	@Test
	public void Logout_Test() throws InterruptedException {
		System.out.println("Logout_Test() - Start");
		System.out.println("Logout_Test() - App Run > 7 Second Wait...");
		
		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_10, TimeUnit.SECONDS);
		
		try {
			System.out.println("Logout_Test() - Logout Start");
			Tranggle_Method.Front_PopUp_Close(driver);
			Tranggle_Method.Logout(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Logout_Test() - Logout Failure -> e : " + e);
			e.printStackTrace();
			
			throw new InterruptedException("로그아웃 처리에 실패했습니다.");
		}
	}

	@AfterClass
	public void EndDriver() {
		if (driver != null) {
			System.out.println("EndDriver() - Driver quit");
			driver.quit();
		}
	}

}
