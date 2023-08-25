package Tranggle_App;

import java.net.MalformedURLException;
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

public class Normal_Login {
	private AppiumDriver<MobileElement> driver;

	// sleep 타임 대기 변수 -> 앱 이동 및 동작 간에 대기하는 시간이 발샏하여, 전역변수 선언을 통해 공유하여 사용
	int short_Sleep_Time = 500;
	int short_Sleep_Time_1000 = 1000;
	int normal_Sleep_Time_1500 = 1500;
	int normal_Sleep_Time_2000 = 2000;
	int long_Sleep_Time = 3000;
	int long_Sleep_Time_5000 = 5000;

	// 타임 대기 시간 변수 선언
	int short_Sleep_Seconds_1 = 1;
	int short_Sleep_Seconds_2 = 2;
	int normal_Sleep_Seconds_3 = 3;
	int long_Sleep_Seconds_5 = 5;
	int long_Sleep_Seconds_7 = 7;
	int long_Sleep_Seconds_10 = 10;

	@BeforeClass
	public void SetDriver() throws MalformedURLException {
		// mobileCapabilityType 명 변수 선언
		String app_Package = "appPackage";
		String app_Activity = "appActivity";

		// mobileCapabilityType Value 명 변수 선언
		String platform_Android = "Android";
		String devicename = "emulator-5554";
		String app_Package_Name = "com.beaglemap.tranggle";
		String app_Activity_Name = "com.beaglemap.tranggle.ui.base.UITranggleMainShell";

		try {
			System.out.println("SetDriver() - Driver Creating Start");

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
			// TODO: handle exception
			System.out.println("SetDriver() - Driver Created Failure - driver : " + driver);
			e.printStackTrace();
		}

	}

	@Test
	public void Normal_Login_Test() throws Exception {
		String loginpage_Go_Join_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";
		String front_Popup_Check_Text_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox";
		String home_Profil_Nickname_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";

		System.out.println("Normal_Login_Test() - Start > 10 Second Wait...");

		driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);

		System.out.println("Normal_Login_Test() - loginpage_Go_Join_Btn_Text > Go_Join(회원가입) 버튼 - 앨리먼트 가져오기 시작");

		try {
			MobileElement loginpage_Go_Join_Btn = driver.findElementByXPath(loginpage_Go_Join_Xpath);
			String loginpage_Go_Join_Btn_Text = loginpage_Go_Join_Btn.getText();
			
			if (loginpage_Go_Join_Btn_Text.equals("회원가입")) {
				System.out.println("Normal_Login_Test() - loginpage_Go_Join_Btn Find Success > loginpage_Go_Join_Btn_Text : " + loginpage_Go_Join_Btn_Text);
				
				Tranggle_Method.Login(driver);
				Tranggle_Method.Front_PopUp_Close(driver);
			} else {
				System.out.println("Normal_Login_Test() - loginpage_Go_Join_Btn Find Failure > loginpage_Go_Join_Btn_Text : " + loginpage_Go_Join_Btn_Text);
				
				throw new Exception("로그인 페이지 진입 실패 or 로그인 페이지 > 회원가입 버튼 앨리먼트 찾기 실패했습니다.");
			}	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Normal_Login_Test() - loginpage Move Failure > e : " + e);
			e.printStackTrace();
		}
		
		try {
			MobileElement home_Profil_Nickname = driver.findElementByXPath(home_Profil_Nickname_Xpath);
			String home_Profil_Nickname_Text = home_Profil_Nickname.getText();
			
			if (home_Profil_Nickname_Text.equals("코리아테스트68")) {
				System.out.println("Normal_Login_Test() - Home Move & Normal Login Success > home_Profil_Nickname_Text : " + home_Profil_Nickname_Text);
			} else {
				System.out.println("Normal_Login_Test() - Home Move & Normal Login Failure > home_Profil_Nickname_Text : " + home_Profil_Nickname_Text);
				
				throw new Exception("홈 화면 이동 실패 or 로그인 실패(홈 > 닉네임 찾지 못함)했습니다.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Normal_Login_Test() - Home Move & Login Failure > e : " + e);
			e.printStackTrace();
		}
		
	}

	@AfterClass
	public void EndDriver() throws Exception {
		if (driver != null) {
			System.out.println("EndDriver() - Driver quit");
			driver.quit();
		}
	}

}
