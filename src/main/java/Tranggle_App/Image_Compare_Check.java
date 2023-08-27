package Tranggle_App;

import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Tranggle_Method_p.Tranggle_Method;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;




public class Image_Compare_Check {
	AppiumDriver<MobileElement> driver;

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
	public void Image_Compare_Check_Test() throws Exception {
		String loginpage_Login_Status_Checkbox_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.CheckBox";
		String Front_Popup_Close_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView";
		String loginpage_Naver_Icon_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageButton[1]";
		String loginpage_Kakao_Icon_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageButton[2]";
		String loginpage_Facebook_Icon_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageButton[3]";
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//testcode 
		//Tranggle_Method.Login(driver);
		
		//앨리먼트 선택
		MobileElement loginpage_Login_Status_CheckBox = driver
				.findElementByXPath(loginpage_Facebook_Icon_Xpath);

		//앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = loginpage_Login_Status_CheckBox.getLocation();
		Dimension elementSize = loginpage_Login_Status_CheckBox.getSize();
		
		//스크린 샷 전체 화면 이미지 가져오기
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);
		
		//앨리먼트의 부분 이미지 추출
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(), elementSize.getWidth(), elementSize.getHeight());

		//기존 이미지 로드 
		BufferedImage referenceImage = ImageIO.read(new File("E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\loginpage_login_status_Checkbox_Unchecked.png"));
		
		/*
		Tranggle_Method.LoginPage_Login_Status_Check_Unchecked(driver);
		
		Thread.sleep(7000);
		*/
		
		//이미지 비교
		double similarity = compareImage(referenceImage, elementImage);
		
		//Unchecked - 유사도 40프로 정도 측정됨 - 0.45 / checked - 0.04
		//checked - 
		
		
		if (similarity >= 0.8) {
			System.out.println("Image Compare Success - similarity : " + similarity);
		} else {
			System.out.println("Image Compage Fail - similarity : " + similarity);
		}
		
		File screenshotFile1 = loginpage_Login_Status_CheckBox.getScreenshotAs(OutputType.FILE);

		
		String localImagePath = "E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\test3.png";
		
		
		try {
			File destinationFile = new File(localImagePath);
			screenshotFile1.renameTo(destinationFile);
			
			System.out.println("Element image saved at: " + localImagePath);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed to save element image : " + e.getMessage());
		}
		
		
	}

	public double compareImage(BufferedImage image1, BufferedImage image2) {
		int width = image1.getWidth();
		int height = image1.getHeight();
		int equalPixels = 0;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (image1.getRGB(x, y) == image2.getRGB(x, y)) {
					equalPixels++;
				}
			}
		}
		return (double) equalPixels / (width * height);
	}

	@AfterClass
	public void EndDriver() {
		if (driver != null) {
			System.out.println("EndDriver() - Driver quit");
			driver.quit();
		}
	}
}

class ImageSimilarityCalculator {
	public double calculateSimilarity(BufferedImage image1, BufferedImage image2) {
		return 0.0;
	}
}
