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

public class Front_Popup_Close {
	AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void SetDriver() {
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
	public void Front_Popup_Close_Test() throws Exception {
		String loginpage_Signup_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";
		String front_Popup_Check_Text_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox";
		String home_Profil_Guest_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
		String home_Pedometer_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.TextView"; 
		
		// int case_Check = 0;

		System.out.println("Front_Popup_Close_Test() - Start > 7 Second Wait...");

		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_30, TimeUnit.SECONDS);

		System.out.println("Front_Popup_Close_Test() - 앱 실행 체크 - 앨리먼트 가져오기 시작");

		try {
			System.out.println("Front_Popup_Close_Test() - 실행 후 로그인 페이지 일 경우, 로그인 페이지 > 회원가입 버튼 엘리먼트 가져오기 전");
			
			MobileElement loginpage_Signup_Btn = driver.findElementByXPath(loginpage_Signup_Xpath);
			String loginpage_Signup_Btn_Text = loginpage_Signup_Btn.getText();

			if (loginpage_Signup_Btn_Text.equals("회원가입")) {
				System.out.println("Front_Popup_Close_Test() - loginpage login processing.... -> loginpage_Signup_Btn_Text : "
						+ loginpage_Signup_Btn_Text);
				Tranggle_Method.Login(driver);
				Thread.sleep(Tranggle_Method.normal_Sleep_Times_2000);
				//2023.9.10 (일) 라이브 빌드 기준 > 전면 팝업 재출력되어 주석 해제
				Tranggle_Method.Front_PopUp_Close(driver);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Front_Popup_Close_Test() - 실행 후 홈 화면 일 경우, 전면팝업 출력된 상태로 앨리먼트 가져오기 전");
			Tranggle_Method.Front_PopUp_Close(driver);
			e.printStackTrace();
			
			throw new InterruptedException("실행 후 홈 화면이 아니거나 전면 팝업 > 닫기 버튼 클릭에 실패하였습니다.");
		}
		
		try {
			MobileElement home_Pedometer_Title = driver.findElementByXPath(home_Pedometer_Title_Xpath);
			String home_Pedometer_Title_Text = home_Pedometer_Title.getText();
			
			if (home_Pedometer_Title_Text.equals("만보기")) {
				System.out.println("Front_Popup_Close_Test() - Front_Popup_Close Success -> home_Pedometer_Title_Text : " + home_Pedometer_Title_Text);
			} else {
				System.out.println("Front_Popup_Close_Test() - Front_Popup_Close Failure -> home_Pedometer_Title_Text : " + home_Pedometer_Title_Text);
				
				throw new InterruptedException("실행 후 홈 화면 일 경우, 전면 팝업 종료 실패하였습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Front_Popup_Close_Test() - Front_Popup Close Failure > e : " + e);
			
			throw new InterruptedException("전면 팝업 종료 or 만보기 타이틀 문구 앨리먼트 찾기 실패했습니다.");
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
