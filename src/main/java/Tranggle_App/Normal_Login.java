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
	public void Normal_Login_Test() throws Exception {
		String loginpage_Go_Join_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";
		String front_Popup_Check_Text_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox";
		String home_Profil_Nickname_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";

		System.out.println("Normal_Login_Test() - Start > 10 Second Wait...");

		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_10, TimeUnit.SECONDS);

		System.out.println("Normal_Login_Test() - loginpage_Go_Join_Btn_Text > Go_Join(회원가입) 버튼 - 앨리먼트 가져오기 시작");

		try {
			MobileElement loginpage_Go_Join_Btn = driver.findElementByXPath(loginpage_Go_Join_Xpath);
			String loginpage_Go_Join_Btn_Text = loginpage_Go_Join_Btn.getText();
			
			if (loginpage_Go_Join_Btn_Text.equals("회원가입")) {
				System.out.println("Normal_Login_Test() - loginpage_Go_Join_Btn Find Success > loginpage_Go_Join_Btn_Text : " + loginpage_Go_Join_Btn_Text);
				
				Tranggle_Method.Login(driver);
				Tranggle_Method.Front_PopUp_Close(driver);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Normal_Login_Test() - loginpage Move Failure > e : " + e);
			e.printStackTrace();
			
			throw new Exception("로그인 페이지 진입 실패 or 로그인 페이지 > 회원가입 버튼 앨리먼트 찾기 실패했습니다.");
		}
		
		try {
			MobileElement home_Profil_Nickname = driver.findElementByXPath(home_Profil_Nickname_Xpath);
			String home_Profil_Nickname_Text = home_Profil_Nickname.getText();
			
			if (home_Profil_Nickname_Text.equals("코리아테스트68")) {
				System.out.println("Normal_Login_Test() - Home Move & Normal Login Success > home_Profil_Nickname_Text : " + home_Profil_Nickname_Text);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Normal_Login_Test() - Home Move & Login Failure > e : " + e);
			e.printStackTrace();
			
			throw new Exception("홈 화면 이동 실패 or 로그인 실패(홈 > 닉네임 찾지 못함)했습니다.");
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
