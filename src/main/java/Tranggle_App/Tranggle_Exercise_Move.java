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

public class Tranggle_Exercise_Move {
	AppiumDriver<MobileElement> driver;

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
	public void Tranggle_Exercise_Move_Test() throws Exception {
		// Xpath 변수 선언
		String exercise_Traning_Start_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
		String exercise_Tutorial_Guide_Skip_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
		String current_Loc_Button_Mode_Change_Popup_Confirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
		
		System.out.println("Tranggle_Exercise_Move_Test() - Start > 10 Second Wait...");

		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_10, TimeUnit.SECONDS);

		try {
			System.out.println("Tranggle_Exercise_Move_Test() - 트랭글 로그인 페이지로 진입할 경우,");

			Tranggle_Method.Login(driver);
			Tranggle_Method.Home_Bottom_Nav_Exercise_Click(driver);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tranggle_Exercise_Move_Test() - 홈 화면으로 진입할 경우,");

			Tranggle_Method.Home_Bottom_Nav_Exercise_Click(driver);
		}

		try {
			System.out.println("Tranggle_Exercise_Move_Test() - Tranggle_Exercise_Tutorial_Guide Print Check....");
			
			MobileElement exercise_Tutorial_Guide_Skip = driver.findElementByXPath(exercise_Tutorial_Guide_Skip_Xpath);
			String exercise_Tutorial_Guide_Skip_Text = exercise_Tutorial_Guide_Skip.getText();
			
			if (exercise_Tutorial_Guide_Skip_Text.equals("건너뛰기")) {
				System.out.println("Tranggle_Exercise_Move_Test() - exercise_Tutorial_Guide Print & Skip Find Success > exercise_Tutorial_Guide_Skip_Text : " + exercise_Tutorial_Guide_Skip_Text);
				Tranggle_Method.Exercise_Tutorial_Guide_Skip_Click(driver);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tranggle_Exercise_Move_Test() - exercise_Tutorial_Guide Print X > e : " + e);
		}
		
		try {
			System.out.println("Tranggle_Exercise_Move_Test() - current_Loc_Button_Mode_Change_Popup Check....");
			
			MobileElement current_Loc_Button_Mode_Change_Popup_Confirm = driver.findElementByXPath(current_Loc_Button_Mode_Change_Popup_Confirm_Xpath);
			String current_Loc_Button_Mode_Change_Popup_Confirm_Text = current_Loc_Button_Mode_Change_Popup_Confirm.getText();
			
			if (current_Loc_Button_Mode_Change_Popup_Confirm_Text.equals("확인")) {
				System.out.println("Tranggle_Exercise_Move_Test() - current_Loc_Button_Mode_Change_Popup Print & Confirm Find Success > current_Loc_Button_Mode_Change_Popup_Confirm_Text : " + current_Loc_Button_Mode_Change_Popup_Confirm_Text);
				
				Tranggle_Method.Current_Loc_Button_Mode_Change_Popup_Confirm_Click(driver);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tranggle_Exercise_Move_Test() - current_Loc_Button_Mode_Change_Popup Print X > e : " + e);
		}
		
		try {
			System.out.println("Tranggle_Exercise_Move_Test() - 트랭글 > 운동하기 화면 이동 여부 체크");

			MobileElement exercise_Traning_Start_Btn = driver.findElementByXPath(exercise_Traning_Start_Btn_Xpath);
			String exercise_Traning_Start_Btn_Text = exercise_Traning_Start_Btn.getText();

			if (exercise_Traning_Start_Btn_Text.equals("운동시작")) {
				System.out.println(
						"Tranggle_Exercise_Move_Test() - Exercise Move Success > exercise_Traning_Start_Btn_Text : "
								+ exercise_Traning_Start_Btn_Text);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tranggle_Exercise_Move_Test() - Tranggle_Exercise Move Failure > e : " + e);
			e.printStackTrace();

			throw new Exception("운동하기 화면 이동에 실패했습니다.");
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
