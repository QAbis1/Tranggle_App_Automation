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

public class Kakao_Login {
	AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void SetDriver() {
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
	public void Kakao_Login_Test() throws Exception {
		// 변수 선언
		String loginpage_Sns_Login_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView";
		String home_Profil_Nickname_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";

		System.out.println("Kakao_Login_Test() - Start > 10 Second Wait...");

		driver.manage().timeouts().implicitlyWait(Tranggle_Method.long_Sleep_Seconds_10, TimeUnit.SECONDS);

		System.out.println("Kakao_Login_Test() - 카카오로그인 > 로그인 페이지 진입");
		
		try {
			MobileElement loginpage_Sns_Login_Title = driver.findElementByXPath(loginpage_Sns_Login_Title_Xpath);
			String loginpage_Sns_Login_Title_Text = loginpage_Sns_Login_Title.getText();
			
			if (loginpage_Sns_Login_Title_Text.equals("간편로그인")) {
				System.out.println("Kakao_Login_Test() - loginpage Move Success > loginpage_Sns_Login_Title_Text : " + loginpage_Sns_Login_Title_Text);
				
				Tranggle_Method.Loginpage_Kakao_Icon_Click(driver);
				Tranggle_Method.Kakao_Loginpage_Login_Status_Check_Unchecked(driver);
				Tranggle_Method.Kakao_Login_Check(driver);
			//	Tranggle_Method.Front_PopUp_Close(driver);
			} else {
				System.out.println("Kakao_Login_Test() - loginpage Print Failure > loginpage_Sns_Login_Title_Text ; "
						+ loginpage_Sns_Login_Title_Text);

				throw new Exception("카카오 로그인 과정 중 실패 했습니다.");
			}
			
			MobileElement home_Profil_Nickname = driver.findElementByXPath(home_Profil_Nickname_Xpath);
			String home_Profil_Nickname_Text = home_Profil_Nickname.getText();

			if (home_Profil_Nickname_Text.equals("@K2625070050")) {
				System.out.println(
						"Kakao_Login_Test() - Kakao Login & home Nickname Check Success > home_Profil_Nickname_Text : "
								+ home_Profil_Nickname_Text);
			} else {
				System.out.println(
						"Kakao_Login_Test() - Kakao Login & home Nickname Check Failure > home_Profil_Nickname_Text : "
								+ home_Profil_Nickname_Text);

				throw new Exception("카카오 로그인에 실패 했습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Kakao_Login_Test() - e : " + e);
			e.printStackTrace();
			
			throw new Exception("트랭글 로그인 페이지 이동 실패 or 카카오 로그인 페이지 이동에 실패했습니다.");
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
