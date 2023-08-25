package Tranggle_App;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.functors.NullIsExceptionPredicate;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Tranggle_Method_p.Tranggle_Method;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class App_Run {

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
			System.out.println("SetDriver() - Driver Created Failure - driver : " + driver);
			e.printStackTrace();
		}
	}

	@Test
	public void App_Run_Test() throws Exception {
		String loginpage_Age_14_Limit_Guide_Txt_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]";
		String front_Popup_Check_Text_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox";
		String trg_Guide_Skip_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
		
		//int case_Check = 0;
		
		System.out.println("App_Run_Test() - Start > 7 Second Wait...");
		
		driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
		
		System.out.println("App_Run_Test() - 앱 실행 체크 - 앨리먼트 가져오기 시작");
		
		try {
			System.out.println("App_Run_Test() - 실행 후 로그인 페이지 일 경우, 로그인 페이지 > 상단 만 14세이상 가입 가능 안내 텍스트 엘리먼트 가져오기 전");
			
			MobileElement loginpage_Age_14_Limit_Guide_Txt = driver.findElementByXPath(loginpage_Age_14_Limit_Guide_Txt_Xpath);
			String loginpage_Age_14_Limit_Guide_Txt_Text = loginpage_Age_14_Limit_Guide_Txt.getText();
			
			if (loginpage_Age_14_Limit_Guide_Txt_Text.equals("* 만 14세 이상 가입 가능합니다.")) {
				System.out.println("App_Run_Test() - Loginpage Print & App_Run Success > loginpage_Age_14_Limit_Guide_Txt_Text : " + loginpage_Age_14_Limit_Guide_Txt_Text);
			} else {
				System.out.println("App_Run_Test() - Loginpage Print & App_Run Failure > loginpage_Age_14_Limit_Guide_Txt_Text : " + loginpage_Age_14_Limit_Guide_Txt_Text);
				
				throw new Exception("로그인 페이지 출력 or 앱 실행에 실패했습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("App_Run_Test() - 실행 후 트랭글 가이드 화면이 출력되었을 경우");
			
			MobileElement trg_Guide_Skip_Btn = driver.findElementByXPath(trg_Guide_Skip_Xpath);
			String trg_Guide_Skip_Btn_Text = trg_Guide_Skip_Btn.getText();
					
			if (trg_Guide_Skip_Btn_Text.equals("건너뛰기")) {
				System.out.println("App_Run_Test() -Tranggle Guide Print & App Run Success > trg_Guide_Skip_Btn_Text : " + trg_Guide_Skip_Btn_Text);
				
				Tranggle_Method.Trg_Guide_Skip_Click(driver);
			} else {
				System.out.println("App_Run_Test() -Tranggle Guide Print & App Run Failure > trg_Guide_Skip_Btn_Text : " + trg_Guide_Skip_Btn_Text);
				
				throw new Exception("트랭글 가이드 화면 출력 실패 or 앱 실행에 실패했습니다.");
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
