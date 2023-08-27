package Tranggle_App;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Tranggle_Method_p.Tranggle_Method;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Naver_Login {
	private AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void SetDriver() {
		String app_Package = "appPackage";
		String app_Activity = "appActivity";

		// mobileCapabilityType Value 명 변수 선언
		String platform_Android = "Android";
		String devicename = "emulator-5554";
		String app_Package_Name = "com.beaglemap.tranggle";
		String app_Activity_Name = "com.beaglemap.tranggle.ui.base.UITranggleMainShell";

		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_Android);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);

			capabilities.setCapability(app_Package, app_Package_Name);
			capabilities.setCapability(app_Activity, app_Activity_Name);

			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

			System.out.println("SetDriver() - Driver setCapability Success");

			// Appium 드라이버 초기화 및 드라이버 URL / 셋팅 값으로 드라이버 셋팅
			URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<>(appiumServerUrl, capabilities);

			System.out.println("SetDriver() - Driver Created Success - driver : " + driver);

		} catch (Exception e) {
			System.out.println("SetDriver() - Driver Created Failure - driver : " + driver);
			e.printStackTrace();
		}

	}

	@Test
	public void Naver_Login_Test() throws Exception {
		// 변수 선언
		String loginpage_Sns_Login_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView";
		String home_Profil_Nickname_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";

		System.out.println("Naver_Login_Test() - Start > 7 Second Wait...");

		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_10, TimeUnit.SECONDS);

		System.out.println("Naver_Login_Test() - 네이버로그인 > 로그인 페이지 진입");

		try {
			MobileElement loginpage_Sns_Login_Title = driver.findElementByXPath(loginpage_Sns_Login_Title_Xpath);
			String loginpage_Sns_Login_Title_Text = loginpage_Sns_Login_Title.getText();

			if (loginpage_Sns_Login_Title_Text.equals("간편로그인")) {
				System.out.println("Naver_Login_Test() - loginpage Print Success > loginpage_Sns_Login_Title_Text ; "
						+ loginpage_Sns_Login_Title_Text);
				Tranggle_Method.Loginpage_Naver_Icon_Click(driver);
				Tranggle_Method.Naver_Login_Check(driver);
				// Tranggle_Method.Front_Popup_CheckBox_Check(driver);
				// Tranggle_Method.Front_PopUp_Close(driver);
			} else {
				System.out.println("Naver_Login_Test() - loginpage Print Failure > loginpage_Sns_Login_Title_Text ; "
						+ loginpage_Sns_Login_Title_Text);

				throw new Exception("네이버 로그인 과정 중 실패 했습니다.");
			}

			MobileElement home_Profil_Nickname = driver.findElementByXPath(home_Profil_Nickname_Xpath);
			String home_Profil_Nickname_Text = home_Profil_Nickname.getText();

			if (home_Profil_Nickname_Text.equals("@N2005675387")) {
				System.out.println(
						"Naver_Login_Test() - Naver Login & home Nickname Check Success > home_Profil_Nickname_Text : "
								+ home_Profil_Nickname_Text);
			} else {
				System.out.println(
						"Naver_Login_Test() - Naver Login & home Nickname Check Failure > home_Profil_Nickname_Text : "
								+ home_Profil_Nickname_Text);

				throw new Exception("네이버 로그인에 실패 했습니다.");
			}
		} catch (Exception e) {
			System.out.println("Naver_Login_Test() - naver Login Failure > e : " + e);
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
