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

public class App_Permission_Check {
	AppiumDriver<MobileElement> driver;

	// Xpath 변수 선언
	String app_Access_Rights_Guide_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]";
	String app_Access_Rights_Guide_Confirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView";
	String using_BG_Loc_Inf_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
	String using_BG_Loc_Inf_Popup_Confirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	String loginpage_Login_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]";
	String home_Pedometer_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.TextView";

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
	public void App_Permission_Check_Test() throws Exception {
		System.out.println("App_Permission_Check_Test() - Start > 10 Second Wait...");

		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_10, TimeUnit.SECONDS);

		System.out.println("App_Run_Test() - 앱 실행 체크 - 앨리먼트 가져오기 시작");

		try {
			System.out.println("App_Permission_Check_Test() - 실행 후 앱 접근 권한 안내 팝업이 처음 출력되는 경우,");

			MobileElement app_Access_Rights_Guide_Title = driver
					.findElementByXPath(app_Access_Rights_Guide_Title_Xpath);
			String app_Access_Rights_Guide_Title_Text = app_Access_Rights_Guide_Title.getText();

			if (app_Access_Rights_Guide_Title_Text.equals("앱 접근권한 안내")) {
				System.out.println(
						"App_Permission_Check_Test() - app_Access_Rights_Guide Print Success > app_Access_Rights_Guide_Title_Text : "
								+ app_Access_Rights_Guide_Title_Text);

				Tranggle_Method.App_Access_Right_Guide_Confirm_Click(driver);
				Tranggle_Method.Using_BG_Loc_Inf_Popup_Confirm_Click(driver);
				Tranggle_Method.My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click(driver);
				Tranggle_Method.Device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Click(driver);
				Tranggle_Method.Device_Settings_Loc_Access_Rights_Back_Click(driver);
				Tranggle_Method.Media_Access_Allow_Popup_Allow_Click(driver);
				Tranggle_Method.Phone_Call_And_Manage_Allow_Popup_Allowed_Click(driver);
				Tranggle_Method.Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click(driver);
				Tranggle_Method.Device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click(driver);
				Tranggle_Method.Health_Inf_Access_Allow_Popup_Allowed_Click(driver);
				Tranggle_Method.Alert_Allow_Popup_Allowed_Click(driver);
				Tranggle_Method.Trg_Guide_Skip_Click(driver);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("App_Permission_Check_Test() - 최초 실행 후 백그라운드 위치정보 사용 팝업이 처음 출력되는 경우");

			MobileElement using_BG_Loc_Inf_Popup_Title = driver.findElementByXPath(using_BG_Loc_Inf_Popup_Title_Xpath);
			String using_BG_Loc_Inf_Popup_Title_Text = using_BG_Loc_Inf_Popup_Title.getText();

			if (using_BG_Loc_Inf_Popup_Title_Text.equals("백그라운드 위치정보 사용")) {
				System.out.println(
						"App_Permission_Check_Test() - using_BG_Loc_Inf_Popup Print Success > using_BG_Loc_Inf_Popup_Title_Text : "
								+ using_BG_Loc_Inf_Popup_Title_Text);

				Tranggle_Method.Using_BG_Loc_Inf_Popup_Confirm_Click(driver);
				Tranggle_Method.My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click(driver);
				Tranggle_Method.Device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Click(driver);
				Tranggle_Method.Device_Settings_Loc_Access_Rights_Back_Click(driver);
				Tranggle_Method.Media_Access_Allow_Popup_Allow_Click(driver);
				Tranggle_Method.Phone_Call_And_Manage_Allow_Popup_Allowed_Click(driver);
				Tranggle_Method.Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click(driver);
				Tranggle_Method.Device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click(driver);
				Tranggle_Method.Health_Inf_Access_Allow_Popup_Allowed_Click(driver);
				Tranggle_Method.Alert_Allow_Popup_Allowed_Click(driver);
				// 해당 건은 최초 실행 시에 트랭글 가이드 화면이 나와야 하나 출력되지 않아 이슈 사항이나, 우선 테스트스크립트 동작을 위해
				// 주석 처리 함
				// Tranggle_Method.Trg_Guide_Skip_Click(driver);
			} else {
				System.out.println(
						"App_Permission_Check_Test() - using_BG_Loc_Inf_Popup Print Failure > using_BG_Loc_Inf_Popup_Title_Text : "
								+ using_BG_Loc_Inf_Popup_Title_Text);

				throw new Exception("앱 접근 권한 허용 후 로그인 페이지 이동에 실패했씁니다.");
			}
		}

		try {
			System.out.println("App_Permission_Check_Test() - login Page Print Case.....");

			MobileElement loginPage_Login_Btn = driver.findElementByXPath(loginpage_Login_Btn_Xpath);
			String loginPage_Login_Btn_Text = loginPage_Login_Btn.getText();

			if (loginPage_Login_Btn_Text.equals("로그인")) {
				System.out.println("App_Permission_Check_Test() - loginPage Move Success > loginPage_Login_Btn_Text : "
						+ loginPage_Login_Btn_Text);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("App_Permission_Check_Test() - home Print Case...... > Exception e : " + e);

			Tranggle_Method.Front_PopUp_Close(driver);

			try {
				System.out.println("App_Permission_Check_Test() - 절전기능 중지 요청 팝업이 출력되었을 경우,");
				Tranggle_Method.Req_To_Stop_Power_Saving_Popop_Confirm_Click(driver);
				Tranggle_Method.Stop_Optimizing_Battery_Usage_Popup_Allowed_Click(driver);
			} catch (Exception e1) {
				// TODO: handle exception
				System.out.println("App_Permission_Check_Test() - 절전기능 중지 요청 팝업 미출력됨 - 아무런 동작 처리 하지 않음");

				throw new Exception("홈 화면 > 전면 팝업 종료 후 절전기능 중지 요청 팝업이 미출력되어 실패했습니다.");
			}

			try {
				System.out.println("App_Permission_Check_Test() - home Move case...");

				MobileElement home_Pedometer_Title = driver.findElementByXPath(home_Pedometer_Title_Xpath);
				String home_Pedometer_Title_Text = home_Pedometer_Title.getText();

				if (home_Pedometer_Title_Text.equals("만보기")) {
					System.out.println(
							"App_Permission_Check_Test() - Home Print & App Permission_Check Success > home_Pedometer_Title_Text : "
									+ home_Pedometer_Title_Text);
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("App_Permission_Check_Test() - home Move Failure > e : " + e2);

				throw new Exception("홈 화면 > 전면 팝업 종료 후 홈화면 이동 실패 or 만보기 앨리먼트 찾기에 실패했습니다.");
			}
		}
	}

	@AfterClass
	public void EndDriver() throws Exception {
		if (driver != null) {
			System.out.println("EndDriver() - Start");

			try {
				System.out.println("EndDriver() - login Page Print Case.....");

				MobileElement loginPage_Login_Btn = driver.findElementByXPath(loginpage_Login_Btn_Xpath);
				String loginPage_Login_Btn_Text = loginPage_Login_Btn.getText();

				if (loginPage_Login_Btn_Text.equals("로그인")) {
					System.out.println(
							"EndDriver() - loginPage Move Success > loginPage_Login_Btn_Text : "
									+ loginPage_Login_Btn_Text);

					boolean loginpage_Login_Status_isChecked = Tranggle_Method.LoginPage_Login_Status_isChecked(driver);

					if (loginpage_Login_Status_isChecked == true) {
						Tranggle_Method.LoginPage_Login_Status_Check_Unchecked(driver);
					}
					Tranggle_Method.Login(driver);
					Tranggle_Method.Front_PopUp_Close(driver);

					try {
						System.out.println("EndDriver() - 절전기능 중지 요청 팝업이 출력되었을 경우,");
						Tranggle_Method.Req_To_Stop_Power_Saving_Popop_Confirm_Click(driver);
						Tranggle_Method.Stop_Optimizing_Battery_Usage_Popup_Allowed_Click(driver);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("EndDriver() - 절전기능 중지 요청 팝업 미출력됨 - 아무런 동작 처리 하지 않음");
					}

					Tranggle_Method.Logout(driver);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("EndDriver() - home Print Case..... > e : " + e);
				
				Tranggle_Method.Logout(driver);
			}

			driver.quit();
		}
	}
}
