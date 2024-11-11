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

public class Do_not_Watch_Front_Popup_Check {
	AppiumDriver<MobileElement> driver;

	String loginpage_Signup_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";
	String home_Pedometer_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.TextView";
	String front_Popup_CheckBox_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox";

	@BeforeClass
	public void SetDriver() {
		try {
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
			System.out.println("SetDriver() - Driver Created Failure - driver : " + driver);
			e.printStackTrace();
		}

	}

	@Test
	public void Do_not_Watch_Front_Popup_Check_Test() throws Exception {

		System.out.println("Do_not_Watch_Front_Popup_Check_Test() - Start > 7 Second Wait...");

		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_10, TimeUnit.SECONDS);

		System.out.println("Do_not_Watch_Front_Popup_Check_Test() - 앱 실행 체크 - 앨리먼트 가져오기 시작");

		try {
			System.out.println("Do_not_Watch_Front_Popup_Check_Test() - 로그인 페이지 일 경우,");

			MobileElement loginpage_Signup_Btn = driver.findElementByXPath(loginpage_Signup_Xpath);
			String loginpage_Signup_Btn_Text = loginpage_Signup_Btn.getText();

			if (loginpage_Signup_Btn_Text.equals("회원가입")) {
				System.out.println(
						"Do_not_Watch_Front_Popup_Check_Test() - loginpage_Signup Find Success > loginpage_Signup_Btn_Text : "
								+ loginpage_Signup_Btn_Text);

				Tranggle_Method.Login(driver);
				Tranggle_Method.Front_Popup_CheckBox_Check(driver);
				Tranggle_Method.Front_PopUp_Close(driver);
				Tranggle_Method.Logout(driver);
				Tranggle_Method.Login(driver);
			} 
			
			MobileElement home_Pedometer_Title = driver.findElementByXPath(home_Pedometer_Title_Xpath);
			String home_Pedometer_Title_Txt = home_Pedometer_Title.getText();

			if (home_Pedometer_Title_Txt.equals("만보기")) {
				System.out.println(
						"Do_not_Watch_Front_Popup_Check_Test() - Do_not_Watch_Front_Popup_Check Success > home_Pedometer_Title_Txt : "
								+ home_Pedometer_Title_Txt);
			} else {
				System.out.println(
						"Do_not_Watch_Front_Popup_Check_Test() - Do_not_Watch_Front_Popup_Check Failure > home_Pedometer_Title_Txt : "
								+ home_Pedometer_Title_Txt);

				throw new Exception("로그인 페이지 이동에 실패했습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			MobileElement front_Popup_CheckBox = driver.findElementByXPath(front_Popup_CheckBox_Xpath);
			String front_Popup_CheckBox_Text = front_Popup_CheckBox.getText();

			if (front_Popup_CheckBox_Text.equals("오늘 하루 보지 않기")) {
				System.out.println(
						"Do_not_Watch_Front_Popup_Check_Test() - front_Popup Print Success > front_Popup_CheckBox_Text : "
								+ front_Popup_CheckBox_Text);

				Tranggle_Method.Front_Popup_CheckBox_Check(driver);
				Tranggle_Method.Front_PopUp_Close(driver);
				Tranggle_Method.Logout(driver);
				Tranggle_Method.Login(driver);
			} else {
				System.out.println(
						"Do_not_Watch_Front_Popup_Check_Test() - front_Popup Print Failure > front_Popup_CheckBox_Text : "
								+ front_Popup_CheckBox_Text);

				throw new Exception("홈 화면 이동 or 전면 팝업 출력 or 팝업 종료 or 로그인에 실패했습니다.");
			}

			MobileElement home_Pedometer_Title = driver.findElementByXPath(home_Pedometer_Title_Xpath);
			String home_Pedometer_Title_Txt = home_Pedometer_Title.getText();

			if (home_Pedometer_Title_Txt.equals("만보기")) {
				System.out.println(
						"Do_not_Watch_Front_Popup_Check_Test() - Do_not_Watch_Front_Popup_Check Success > home_Pedometer_Title_Txt : "
								+ home_Pedometer_Title_Txt);
			} else {
				System.out.println(
						"Do_not_Watch_Front_Popup_Check_Test() - Do_not_Watch_Front_Popup_Check Failure > home_Pedometer_Title_Txt : "
								+ home_Pedometer_Title_Txt);

				throw new Exception("홈 화면 이동 및 오늘 하루 보지 않기 체크에 실패했습니다. ");
			}
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
