package Tranggle_Method_p;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Tranggle_Method {

	// Xpath 변수 성언
	private static String front_Popup_CheckBox_Txt_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox";
	private static String front_Popup_Close_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView";
	private static String front_Popup_CheckBox_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CheckBox";

	// 트랭글 홈 화면
	private static String home_Profil_Nickname_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
	private static String home_Profil_Guest_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
	private static String home_Pedometer_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.TextView";
	private static String home_Header_Settings_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[2]";

	// 트랭글 홈 화면 > 하단 > 내비게이션
	private static String home_Bottom_Nav_Home_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]";
	private static String home_Bottom_Nav_Exercise_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]";
	private static String home_Bottom_Nav_Community_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]";
	private static String home_Bottom_Nav_Mission_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]";
	
	// 트랭글 홈 > 절전기능 중지 요청 팝업
	private static String req_to_Stop_Power_Saving_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView";
	private static String req_to_Stop_Power_Saving_Popup_Confirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";

	// 트랭글 홈 > 배터리 사용량 최적화 중지
	private static String stop_Optimizing_Battery_Usage_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	private static String stop_Optimizing_Battery_Usage_Popup_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]";
	private static String stop_Optimizing_Battery_Usage_Popup_Deny_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]";

	// 트랭글 환경설정 화면 (홈 > 환결설정)
	private static String settings_Title_Xpath = "//android.widget.LinearLayout[@content-desc=\"환경설정, 상위 메뉴로 이동\"]/android.widget.LinearLayout/android.widget.TextView";
	private static String settings_Account_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	private static String settings_Account_Detail_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.ImageView";

	// 트랭글 계정 화면 (홈 > 환경설정 > 계정)
	private static String account_Title_Xpath = "//android.widget.LinearLayout[@content-desc=\"계정, 상위 메뉴로 이동\"]/android.widget.LinearLayout/android.widget.TextView";
	private static String account_Logout_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[2]";
	private static String account_Logout_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView";
	private static String account_Logout_Popup_Cancel_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]";
	private static String account_Logout_Popup_Confirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]";

	// 트랭글 > 운동하기 화면 
	private static String exercise_Traning_Start_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
	
	// 트랭글 로그인 화면
	private static String loginpage_ID_Input_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[1]";
	private static String loginpage_PW_Input_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[2]";
	private static String loginpage_Login_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]";
	private static String loginpage_Login_Status_Checkbox_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.CheckBox";
	private static String loginpage_Login_Status_Check_Txt_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView";
	private static String loginpage_Signup_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";
	private static String loginpage_Naver_Icon_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageButton[1]";
	private static String loginpage_Kakao_Icon_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageButton[2]";
	private static String loginpage_Facebook_Icon_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageButton[3]";

	private static String loginpage_Guest_In_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]";
	private static String guest_In_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView";
	private static String guest_In_Popup_Continue_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]";
	private static String guest_In_Popup_Login_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]";
	private static String guest_In_Popup_Create_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[3]";

	// 트랭글 > 로그인 > 네이버 로그인 화면
	private static String nloginpage_Title_Xpath = "//android.view.View[@content-desc=\"네이버\"]/android.widget.TextView";
	private static String nloginpage_ID_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText";
	private static String nloginpage_PW_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";
	private static String nloginpage_Login_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.Button";
	private static String nloginpage_Status_Checkbox_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View";

	// 트랭글 > 로그인 > 카카오 로그인 화면
	private static String kloginpage_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView";
	private static String kloginpage_ID_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.EditText";
	private static String kloginpage_PW_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.EditText";
	private static String kloginpage_Login_Btn_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button";
	private static String kloginpage_Status_Checkbox_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View";

	// 트랭글 앱 접근 권한 안내 화면
	private static String app_Access_Rights_Guide_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]";
	private static String app_Access_Rights_Guide_Confirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView";

	// 트랭글 백그라운드 위치정보 사용
	private static String using_BG_Loc_Inf_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
	private static String using_BG_Loc_Inf_Popup_Confirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";

	// 트랭글 내 기기 위치에 액세스하도록 허용하시겠습니까? 시스템 팝업
	private static String my_Device_Loc_Access_Check_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	private static String my_Device_Loc_Access_Check_Popup_App_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]";
	private static String my_Device_Loc_Access_Check_Popup_One_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[2]";
	private static String my_Device_Loc_Access_Check_Popup_Do_Not_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[3]";

	// 디바이스 > 설정 > 트랭글 > 위치 액세스 권한 화면
	private static String device_Settings_Loc_Access_Rights_Back_Xpath = "//android.widget.ImageButton[@content-desc=\"뒤로\"]";
	private static String device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RadioGroup/android.widget.RadioButton[1]";
	private static String device_Settings_Loc_Access_Rights_Using_App_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RadioGroup/android.widget.RadioButton[2]";
	private static String device_Settings_Loc_Access_Rights_Allthetime_Comfirm_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RadioGroup/android.widget.RadioButton[3]";
	private static String device_Settings_Loc_Access_Rights_Do_Not_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RadioGroup/android.widget.RadioButton[4]";

	// 트랭글 > 사진, 동영상, 음악, 오디오 액세스 허용 팝업
	private static String media_Access_Allow_Popup_Allow_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	private static String media_Access_Allow_Popup_Allow_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]";
	private static String media_Access_Allow_Popup_Allow_Do_Not_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]";

	// 트랭글 > 전화 걸고, 관리 허용 팝업
	private static String phone_Call_And_Manage_Allow_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	private static String phone_Call_And_Manage_Allow_Popup_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]";
	private static String phone_Call_And_Manage_Allow_Popup_Do_Not_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]";

	// 트랭글 > 사진을 촬영하고 동영상 녹화 허용 팝업
	private static String picture_And_Video_Record_Allow_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	private static String picture_And_Video_Record_Allow_Popup_Using_App_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]";
	private static String picture_And_Video_Record_Allow_Popup_One_App_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]";
	private static String picture_And_Video_Record_Allow_Popup_Do_Not_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[3]";

	// 트랭글 > 근처에 있는 기기를 찾아 연결 및 기기간 상대적 위치를 파악하도록 허용 팝업
	private static String device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	private static String device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]";
	private static String device_Connect_Or_Device_Location_Check_Allow_Popup_Do_Not_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]";

	// 트랭글 > 내 신체 활동 정보에 액세스 허용 팝업
	private static String health_Inf_Access_Allow_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	private static String health_Inf_Access_Allow_Popup_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]";
	private static String health_Inf_Access_Allow_Popup_Do_Not_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]";

	// 트랭글 > 알림 허용 팝업
	private static String alert_Allow_Popup_Title_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	private static String alert_Allow_Popup_Allowed_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]";
	private static String alert_Allow_Popup_Do_Not_Allow_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]";

	// 트랭글 > 트랭글 가이드 화면
	private static String trg_Guide_Skip_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";
	private static String trg_Guide_Start_Xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView";

	// 트랭글 테스트 시 로그인 계정 정보 변수
	private static String normal_Login_ID = "koreatest67";
	private static String normal_Login_PW = "test1234@";

	// 트랭글 테스트 시 네이버 로그인 계정 정보 변수
	private static String naver_Login_ID = "starbictoli1";
	private static String naver_Login_PW = "1@qordlf";

	// 트랭글 테스트 시 카카오 로그인 계정 정보 변수
	private static String kakao_Login_ID = "starbictoli4";
	private static String kakao_Login_PW = "1@qordlf";

	// 타임 대기 시간 변수 선언
	public static int short_Sleep_Seconds_1 = 1;
	public static int normal_Sleep_Seconds_2 = 2;
	public static int normal_Sleep_Seconds_3 = 3;
	public static int long_Sleep_Seconds_5 = 5;
	public static int long_Sleep_Seconds_7 = 7;
	public static int long_Sleep_Seconds_10 = 10;
	public static int long_Sleep_Seconds_30 = 30;

	public static int short_Sleep_Times_500 = 500;
	public static int short_Sleep_Times_1000 = 1000;
	public static int normal_Sleep_Times_2000 = 2000;
	public static int normal_Sleep_Times_3000 = 3000;
	public static int long_Sleep_Times_5000 = 5000;
	public static int long_Sleep_Times_7000 = 7000;
	public static int long_Sleep_Times_10000 = 10000;

	// Applium Driver Settings 변수 선언
	public static String app_Package = "appPackage";
	public static String app_Activity = "appActivity";

	// mobileCapabilityType Value 명 변수 선언
	public static String platform_Android = "Android";
	public static String devicename = "emulator-5554";
	public static String app_Package_Name = "com.beaglemap.tranggle";
	public static String app_Activity_Name = "com.beaglemap.tranggle.ui.base.UITranggleMainShell";

	public static void App_Access_Right_Guide_Confirm_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > App_Access_Right_Guide_Confirm_Click() - Start");

		MobileElement app_Access_Right_Guide_Confirm = driver.findElementByXPath(app_Access_Rights_Guide_Confirm_Xpath);
		app_Access_Right_Guide_Confirm.click();

		driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);

		MobileElement using_BG_Loc_Inf_Popup_Title = driver.findElementByXPath(using_BG_Loc_Inf_Popup_Title_Xpath);
		String using_BG_Loc_Inf_Popup_Title_Text = using_BG_Loc_Inf_Popup_Title.getText();

		if (using_BG_Loc_Inf_Popup_Title_Text.equals("백그라운드 위치정보 사용")) {
			System.out.println(
					"App_Access_Right_Guide_Confirm_Click() > App_Access_Right_Guide_Confirm_Click Success > using_BG_Loc_Inf_Popup_Title_Text : "
							+ using_BG_Loc_Inf_Popup_Title_Text);
		} else {
			System.out.println(
					"App_Access_Right_Guide_Confirm_Click() > App_Access_Right_Guide_Confirm_Click Failure > using_BG_Loc_Inf_Popup_Title_Text : "
							+ using_BG_Loc_Inf_Popup_Title_Text);

			throw new Exception("앱 접근 권한 안내 화면 > [확인] 버튼 클릭 실패 or 백그라운드 위치정보 사용 화면 이동 실패했습니다.");
		}
	}

	public static void Using_BG_Loc_Inf_Popup_Confirm_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Using_BG_Loc_Inf_Popup_Confirm() - Start");

		MobileElement using_BG_Loc_Inf_Popup_Confirm = driver.findElementByXPath(using_BG_Loc_Inf_Popup_Confirm_Xpath);
		using_BG_Loc_Inf_Popup_Confirm.click();

		System.out.println("Using_BG_Loc_Inf_Popup_Confirm() - Using_BG_Loc_Int_Popup Confirm Click Success");

		driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
		Thread.sleep(normal_Sleep_Times_2000);

		MobileElement my_Device_Loc_Access_Check_Popup_Title = driver
				.findElementByXPath(my_Device_Loc_Access_Check_Popup_Title_Xpath);
		String my_Device_Loc_Access_Check_Popup_Title_Text = my_Device_Loc_Access_Check_Popup_Title.getText();

		if (my_Device_Loc_Access_Check_Popup_Title_Text.equals("트랭글에서 내 기기의 위치 정보에 액세스하도록 허용하시겠습니까?")) {
			System.out.println(
					"Using_BG_Loc_Inf_Popup_Confirm_Click() - my_Device_Loc_Access_Check_Popup Print Success > my_Device_Loc_Access_Check_Popup_Title_Text : "
							+ my_Device_Loc_Access_Check_Popup_Title_Text);
		} else {
			System.out.println(
					"Using_BG_Loc_Inf_Popup_Confirm_Click() - my_Device_Loc_Access_Check_Popup Print Failure > my_Device_Loc_Access_Check_Popup_Title_Text : "
							+ my_Device_Loc_Access_Check_Popup_Title_Text);

			throw new Exception("트랭글 앱 > 백그라운드 위치정보 사용 팝업 > 확인 버튼 클릭 실패 및 내 기기 위치에 액세스 허용 팝업 출력에 실패했습니다.");
		}
	}

	public static void My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click() - Start");

		MobileElement my_Device_Loc_Access_Check_Popup_App_Allowed = driver
				.findElementByXPath(my_Device_Loc_Access_Check_Popup_App_Allowed_Xpath);
		String my_Device_Loc_Access_Check_Popup_App_Allowed_Text = my_Device_Loc_Access_Check_Popup_App_Allowed
				.getText();

		if (my_Device_Loc_Access_Check_Popup_App_Allowed_Text.equals("앱 사용 중에만 허용")) {
			System.out.println(
					"My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click() - my_Device_Loc_Access_Check_Popup_App_Allowed Btn Check Success > my_Device_Loc_Access_Check_Popup_App_Allowed_Text : "
							+ my_Device_Loc_Access_Check_Popup_App_Allowed_Text);

			my_Device_Loc_Access_Check_Popup_App_Allowed.click();

			Thread.sleep(normal_Sleep_Times_3000);
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
		} else {
			System.out.println(
					"My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click() - my_Device_Loc_Access_Check_Popup_App_Allowed Btn Check Success > my_Device_Loc_Access_Check_Popup_App_Allowed_Text : "
							+ my_Device_Loc_Access_Check_Popup_App_Allowed_Text);

			throw new Exception("나의 기기 위치 액세스 허용 팝업 출력 실패 or [앱 사용 중에만 허용] 버튼 앨리먼트 찾기 실패했습니다.");
		}

		MobileElement device_Settings_Loc_Access_Rights_Using_App_Allow = driver
				.findElementByXPath(device_Settings_Loc_Access_Rights_Using_App_Allow_Xpath);
		String device_Settings_Loc_Access_Rights_Using_App_Allow_Text = device_Settings_Loc_Access_Rights_Using_App_Allow
				.getText();

		if (device_Settings_Loc_Access_Rights_Using_App_Allow_Text.equals("앱 사용 중에만 허용")) {
			System.out.println(
					"My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click() - Using_App_allowed Btn Click Success > device_Settings_Loc_Access_rights_Using_App_Allow_Text : "
							+ device_Settings_Loc_Access_Rights_Using_App_Allow_Text);
		} else {
			System.out.println(
					"My_Dev_Loc_Allowed_Popup_Using_App_Allow_Click() - Using_App_allowed Btn Click Failure > device_Settings_Loc_Access_rights_Using_App_Allow_Text : "
							+ device_Settings_Loc_Access_Rights_Using_App_Allow_Text);

			throw new Exception(
					"나의 기기 위치 액세스 허용 팝업 > [앱 사용 중에만 허용] 버튼 클릭 실패 or 위치 액세스 권한 화면 > [앱 사용 중에만 허용] 앨리먼트 찾기 실패했습니다.");
		}
	}

	public static void My_Dev_Loc_Allowed_Popup_One_Allow_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > My_Dev_Loc_Allowed_Popup_One_Allow_Click() - Start");

	}

	public static void My_Dev_Loc_Allowed_Popup_Do_Not_Allow_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > My_Dev_Loc_Allowed_Popup_Do_Not_Allow_Click() - Start");
	}

	public static void Device_Settings_Loc_Access_Rights_Back_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Device_Settings_Loc_Access_Rights_Back_Click() - Start");

		MobileElement Device_Settings_Loc_Access_Rights_Back = driver
				.findElementByXPath(device_Settings_Loc_Access_Rights_Back_Xpath);

		Device_Settings_Loc_Access_Rights_Back.click();

		Thread.sleep(long_Sleep_Times_5000);
	}

	public static void Device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println(
				"Tranggle_Method Class > Device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Click() - Start");

		MobileElement device_Settings_Loc_Access_Rights_Allthetime_App_Allow = driver
				.findElementByXPath(device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Xpath);
		String device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Text = device_Settings_Loc_Access_Rights_Allthetime_App_Allow
				.getText();

		if (device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Text.equals("항상 허용")) {
			System.out.println(
					"Device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Click() - Loc_Access_Rights_Allthetime_App_Allow Find Success > device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Text : "
							+ device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Text);

			device_Settings_Loc_Access_Rights_Allthetime_App_Allow.click();
			Thread.sleep(normal_Sleep_Times_3000);
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);

		} else {
			System.out.println(
					"Device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Click() - Loc_Access_Rights_Allthetime_App_Allow Find Failure > device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Text : "
							+ device_Settings_Loc_Access_Rights_Allthetime_App_Allow_Text);

			throw new Exception("위치 액세스 권한 화면 출력 실패 or 위치 액세스 권한 화면 > 항상 허용 앨리먼트 찾기 실패했습니다.");
		}

	}

	public static void Media_Access_Allow_Popup_Allow_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Media_Access_Allow_Popup_Allow_Click() - Start");

		MobileElement media_Access_Allow_Popup_Allow_Allowed = driver
				.findElementByXPath(media_Access_Allow_Popup_Allow_Allowed_Xpath);
		String media_Access_Allow_Popup_Allow_Allowed_Text = media_Access_Allow_Popup_Allow_Allowed.getText();

		if (media_Access_Allow_Popup_Allow_Allowed_Text.equals("허용")) {
			System.out.println(
					"Media_Access_Allow_Popup_Allow_Click() > media_Access_Allow_Popup_Allow Check Success - media_Access_Allow_Popup_Allow_Allowed_Text : "
							+ media_Access_Allow_Popup_Allow_Allowed_Text);

			media_Access_Allow_Popup_Allow_Allowed.click();

			Thread.sleep(normal_Sleep_Times_3000);
		} else {
			System.out.println(
					"Media_Access_Allow_Popup_Allow_Click() > media_Access_Allow_Popup_Allow Check Failure - media_Access_Allow_Popup_Allow_Allowed_Text : "
							+ media_Access_Allow_Popup_Allow_Allowed_Text);

			throw new Exception("트랭글 > 사진, 동영상, 음악, 오디오에 액세스 허용 팝업 출력 실패 or 팝업 > [허용] 앨리먼트 찾기 실패했습니다.");
		}

		MobileElement phone_Call_And_Manage_Allow_Popup_Title = driver
				.findElementByXPath(phone_Call_And_Manage_Allow_Popup_Title_Xpath);
		String phone_Call_And_Manage_Allow_Popup_Title_Text = phone_Call_And_Manage_Allow_Popup_Title.getText();

		if (phone_Call_And_Manage_Allow_Popup_Title_Text.equals("트랭글에서 전화를 걸고 관리하도록 허용하시겠습니까?")) {
			System.out.println(
					"Media_Access_Allow_Popup_Allow_Click() > media_Access_Allow_Popup_Allow_Click Success - phone_Call_And_Manage_Allow_Popup_Title_Text : "
							+ phone_Call_And_Manage_Allow_Popup_Title_Text);
		} else {
			System.out.println(
					"Media_Access_Allow_Popup_Allow_Click() > media_Access_Allow_Popup_Allow_Click Failure - phone_Call_And_Manage_Allow_Popup_Title_Text : "
							+ phone_Call_And_Manage_Allow_Popup_Title_Text);

			throw new Exception("트랭글 > 사진 등 미디어 권한 허용 > 허용 실패 or 트랭글에서 전화를 걸고 관리하도록 허용 팝업 출력 실패했습니다.");
		}
	}

	public static void Phone_Call_And_Manage_Allow_Popup_Allowed_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Phone_Call_And_Manage_Allow_Popup_Allowed_Click() - Start");

		MobileElement phone_Call_And_Manage_Allow_Popup_Allowed = driver
				.findElementByXPath(phone_Call_And_Manage_Allow_Popup_Allowed_Xpath);
		String phone_Call_And_Manage_Allow_Popup_Allowed_Text = phone_Call_And_Manage_Allow_Popup_Allowed.getText();

		if (phone_Call_And_Manage_Allow_Popup_Allowed_Text.equals("허용")) {
			System.out.println(
					"Phone_Call_And_Manage_Allow_Popup_Allowed_Click() - phone_Call_And_Manage_Allow_Popup_Allowed Check Success > phone_Call_And_Manage_Allow_Popup_Allowed_Text : "
							+ phone_Call_And_Manage_Allow_Popup_Allowed_Text);

			phone_Call_And_Manage_Allow_Popup_Allowed.click();

			Thread.sleep(normal_Sleep_Times_2000);
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);

		} else {
			System.out.println(
					"Phone_Call_And_Manage_Allow_Popup_Allowed_Click() - phone_Call_And_Manage_Allow_Popup_Allowed Check Failure > phone_Call_And_Manage_Allow_Popup_Allowed_Text : "
							+ phone_Call_And_Manage_Allow_Popup_Allowed_Text);

			throw new Exception("전화 걸기 및 관리 허용 팝업 출력 실패 or 허용 팝업 > [허용] 버튼 앨러민트 찾기 실패했습니다.");
		}

		MobileElement picture_And_Video_Record_Allow_Popup_Title = driver
				.findElementByXPath(picture_And_Video_Record_Allow_Popup_Title_Xpath);
		String picture_And_Video_Record_Allow_Popup_Title_Text = picture_And_Video_Record_Allow_Popup_Title.getText();

		if (picture_And_Video_Record_Allow_Popup_Title_Text.equals("트랭글에서 사진을 촬영하고 동영상을 녹화하도록 허용하시겠습니까?")) {
			System.out.println(
					"Phone_Call_And_Manage_Allow_Popup_Allowed_Click() - phone_Call_And_Manage_Allow_Popup_Allowed Click Success > picture_And_Video_Record_Allow_Popup_Title_Text : "
							+ picture_And_Video_Record_Allow_Popup_Title_Text);
		} else {
			System.out.println(
					"Phone_Call_And_Manage_Allow_Popup_Allowed_Click() - phone_Call_And_Manage_Allow_Popup_Allowed Click Failure > picture_And_Video_Record_Allow_Popup_Title_Text : "
							+ picture_And_Video_Record_Allow_Popup_Title_Text);

			throw new Exception("전화 걸기 및 관리 허용 팝업 > [허용] 클릭 실패 or 사진을 촬영 및 동영상 녹화 허용 팝업 출력 실패했습니다.");
		}

	}

	public static void Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println(
				"Tranggle_Method Class > Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click() - Start");

		MobileElement picture_And_Video_Record_Allow_Popup_Using_App_Allow = driver
				.findElementByXPath(picture_And_Video_Record_Allow_Popup_Using_App_Allow_Xpath);
		String picture_And_Video_Record_Allow_Popup_Using_App_Allow_Text = picture_And_Video_Record_Allow_Popup_Using_App_Allow
				.getText();

		if (picture_And_Video_Record_Allow_Popup_Using_App_Allow_Text.equals("앱 사용 중에만 허용")) {
			System.out.println(
					"Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click() - Using_App_Allow find Success > picture_And_Video_Record_Allow_Popup_Using_App_Allow_Text : "
							+ picture_And_Video_Record_Allow_Popup_Using_App_Allow_Text);

			picture_And_Video_Record_Allow_Popup_Using_App_Allow.click();

			Thread.sleep(normal_Sleep_Times_3000);
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);

		} else {
			System.out.println(
					"Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click() - Using_App_Allow find Failure > picture_And_Video_Record_Allow_Popup_Using_App_Allow_Text : "
							+ picture_And_Video_Record_Allow_Popup_Using_App_Allow_Text);

			throw new Exception("트랭글에서 사진을 촬영하고 동영상을 녹화하도록 허용하시겠습니까? 팝업 미출력 또는 앱 사용 중에만 허용 앨리먼트 찾기 실패했습니다.");
		}

		MobileElement Device_Connect_Or_Device_Location_Check_Allow_Popup_Title = driver
				.findElementByXPath(device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Xpath);
		String Device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Text = Device_Connect_Or_Device_Location_Check_Allow_Popup_Title
				.getText();

		if (Device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Text
				.equals("트랭글에서 근처에 있는 기기를 찾아 연결하고 기기 간 상대적 위치를 파악하도록 허용하시겠습니까?")) {
			System.out.println(
					"Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click() - Popup_Using_App_Allow_Click Success > Device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Text : "
							+ Device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Text);
		} else {
			System.out.println(
					"Picture_And_Video_Record_Allow_Popup_Using_App_Allow_Click() - Popup_Using_App_Allow_Click Failure > Device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Text : "
							+ Device_Connect_Or_Device_Location_Check_Allow_Popup_Title_Text);

			throw new Exception("트랭글에서 사진 / 비디오 녹화 허용 팝업 > 앱 사용 중에만 허용 클릭 실패 or 위치 허용 팝업 출력 실패했습니다.");
		}

	}

	public static void Picture_And_Video_Record_Allow_Popup_One_Allow_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Picture_And_Video_Record_Allow_Popup_One_Allow_Click() - Start");

	}

	public static void Picture_And_Video_Record_Allow_Popup_Do_Not_Allow_Click(AppiumDriver<MobileElement> drvier)
			throws Exception {
		System.out.println("Tranggle_Method Class > Picture_And_Video_Record_Allow_Popup_Do_Not_Allow_Click() - Start");

	}

	public static void Device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click(
			AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println(
				"Tranggle_Method Class > Device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click() - Start");

		MobileElement device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed = driver
				.findElementByXPath(device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Xpath);
		String device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Text = device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed
				.getText();

		if (device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Text.equals("허용")) {
			System.out.println(
					"device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click - Popup_Allowed Find Success > device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Text : "
							+ device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Text);

			device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed.click();

			Thread.sleep(normal_Sleep_Times_3000);
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
		} else {
			System.out.println(
					"device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click - Popup_Allowed Find Failure > device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Text : "
							+ device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Text);

			throw new Exception("트랭글 > 근처에 있는 기기 연결 및 다른 기기 위치 파악 허용 팝업 찾기 실패 or 허용 버튼 앨리먼트 찾기 실패했습니다.");
		}

		MobileElement health_Inf_Access_Allow_Popup_Title = driver
				.findElementByXPath(health_Inf_Access_Allow_Popup_Title_Xpath);
		String health_Inf_Access_Allow_Popup_Title_Text = health_Inf_Access_Allow_Popup_Title.getText();

		if (health_Inf_Access_Allow_Popup_Title_Text.equals("트랭글에서 내 신체 활동 정보에 액세스하도록 허용하시겠습니까?")) {
			System.out.println(
					"Device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click() - Popup_Allowed_Click Success > health_Inf_Access_Allow_Popup_Title_Text : "
							+ health_Inf_Access_Allow_Popup_Title_Text);
		} else {
			System.out.println(
					"Device_Connect_Or_Device_Location_Check_Allow_Popup_Allowed_Click() - Popup_Allowed_Click Failure > health_Inf_Access_Allow_Popup_Title_Text : "
							+ health_Inf_Access_Allow_Popup_Title_Text);

			throw new Exception("트랭글 > 근처에 있는 기기 연결 및 위치 허용 팝업 > 허용 클릭 실패 or 신체 활동 정보 액세스 팝업 출력 실패했습니다.");
		}
	}

	public static void Device_Connect_Or_Device_Location_Check_Allow_Popup_Do_Not_Allow_Click(
			AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println(
				"Tranggle_Method Class > Device_Connect_Or_Device_Location_Check_Allow_Popup_Do_Not_Allow_Click() - Start");
	}

	public static void Health_Inf_Access_Allow_Popup_Allowed_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Health_Inf_Access_Allow_Popup_Allowed_Click() - Start");

		MobileElement health_Inf_Access_Allow_Popup_Allowed = driver
				.findElementByXPath(health_Inf_Access_Allow_Popup_Allowed_Xpath);
		String health_Inf_Access_Allow_Popup_Allowed_Text = health_Inf_Access_Allow_Popup_Allowed.getText();

		if (health_Inf_Access_Allow_Popup_Allowed_Text.equals("허용")) {
			System.out.println(
					"Health_Inf_Access_Allow_Popup_Allowed_Click() - Popup_Allowed Find Success > health_Inf_Access_Allow_Popup_Allowed_Text : "
							+ health_Inf_Access_Allow_Popup_Allowed_Text);

			health_Inf_Access_Allow_Popup_Allowed.click();
			Thread.sleep(normal_Sleep_Times_3000);
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);

		} else {
			System.out.println(
					"Health_Inf_Access_Allow_Popup_Allowed_Click() - Popup_Allowed Find Failure > health_Inf_Access_Allow_Popup_Allowed_Text : "
							+ health_Inf_Access_Allow_Popup_Allowed_Text);

			throw new Exception("트랭글 > 내 신체 활동 정보 액세스 허용 팝업 출력 실패 or 허용 버튼 앨리먼튼 찾기 실패했습니다.");
		}

	}

	public static void Health_Inf_Access_Allow_Popup_Do_Not_Allow_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Health_Inf_Access_Allow_Popup_Do_Not_Allow_Click() - Start");

	}

	public static void Alert_Allow_Popup_Allowed_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Alert_Allow_Popup_Allowed_Click() - Start");

		MobileElement Alert_Allow_Popup_Allowed = driver.findElementByXPath(alert_Allow_Popup_Allowed_Xpath);
		String Alert_Allow_Popup_Allowed_Text = Alert_Allow_Popup_Allowed.getText();

		if (Alert_Allow_Popup_Allowed_Text.equals("허용")) {
			System.out.println(
					"Alert_Allow_Popup_Allowed_Click() - Popup_Allowed Find Success > Alert_Allow_Popup_Allowed_Text : "
							+ Alert_Allow_Popup_Allowed_Text);

			Alert_Allow_Popup_Allowed.click();
			Thread.sleep(normal_Sleep_Times_3000);
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);

		} else {
			System.out.println(
					"Alert_Allow_Popup_Allowed_Click() - Popup_Allowed Find Failure > Alert_Allow_Popup_Allowed_Text : "
							+ Alert_Allow_Popup_Allowed_Text);

			throw new Exception("트랭글 > 알림 허용 팝업 미출력 or 허용 버튼 앨리먼트 찾기 실패했습니다.");
		}

	}

	public static void Alert_Allow_Popup_Do_Not_Allow_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Alert_Allow_Popup_Do_Not_Allow_Click() - Start");

	}

	public static void Trg_Guide_Skip_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Trg_Guide_Skip_Click() - Start");

		MobileElement trg_Guide_Skip = driver.findElementByXPath(trg_Guide_Skip_Xpath);
		String trg_Guide_Skip_Text = trg_Guide_Skip.getText();

		if (trg_Guide_Skip_Text.equals("건너뛰기")) {
			System.out.println("Trg_Guide_Skip_Click() - Trg_Guide_Skip Find Success > trg_Guide_Skip_Text : "
					+ trg_Guide_Skip_Text);

			trg_Guide_Skip.click();
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);

		} else {
			System.out.println("Trg_Guide_Skip_Click() - Trg_Guide_Skip Find Failure > trg_Guide_Skip_Text : "
					+ trg_Guide_Skip_Text);

			throw new Exception("트랭글 가이드 화면 출력 실패 or 건너뛰기 버튼 앨리먼트 찾기 실패했습니다.");
		}

	}

	public static void Trg_Guide_Start_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Trg_Guide_Start_Click() - Start");

		MobileElement trg_Guide_Start_Btn = driver.findElementByXPath(trg_Guide_Start_Xpath);
		String trg_Guide_Start_Btn_Text = trg_Guide_Start_Btn.getText();

		if (trg_Guide_Start_Btn_Text.equals("시작하기")) {
			System.out.println("Trg_Guide_Start_Click() - Trg_Guide_Start Find Succcess > trg_Guide_Start_Btn_Text : "
					+ trg_Guide_Start_Btn_Text);

			trg_Guide_Start_Btn.click();
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
		} else {
			System.out.println("Trg_Guide_Start_Click() - Trg_Guide_Start Find Failure > trg_Guide_Start_Btn_Text : "
					+ trg_Guide_Start_Btn_Text);

			throw new Exception("트랭글 > 가이드 화면 5페이지 출력 실패 및 [시작하기] 버튼 앨리먼트 찾기 실패했습니다.");
		}
	}

	public static boolean LoginPage_Login_Status_isChecked(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > LoginPage_Login_Status_isChecked() - Start");

		// 앨리먼트 선택
		MobileElement loginpage_Login_Status_CheckBox = driver
				.findElementByXPath(loginpage_Login_Status_Checkbox_Xpath);

		// 앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = loginpage_Login_Status_CheckBox.getLocation();
		Dimension elementSize = loginpage_Login_Status_CheckBox.getSize();

		// 스크린 샷 전체 화면 이미지 가져오기
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);

		// 앨리먼트의 부분 이미지 추출
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(),
				elementSize.getWidth(), elementSize.getHeight());

		// 기존 이미지 로드
		BufferedImage referenceImage = ImageIO.read(new File(
				"E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\loginpage_login_status_Checkbox_Unchecked.png"));

		// 이미지 비교
		double similarity = compareImage(referenceImage, elementImage);

		if (similarity >= 0.9) {
			System.out.println("LoginPage_Login_Status_isChecked() - Image Compare Unchecked Success - similarity : "
					+ similarity);
			return false;
		} else {
			System.out.println(
					"LoginPage_Login_Status_isChecked() - Image Compage Checked Fail - similarity : " + similarity);
			return true;
		}
	}

	public static void LoginPage_Login_Status_Check_Unchecked(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > LoginPage_Login_Status_Check_Unchecked() - Start");

		// 앨리먼트 선택
		MobileElement loginpage_Login_Status_CheckBox = driver
				.findElementByXPath(loginpage_Login_Status_Checkbox_Xpath);

		// 앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = loginpage_Login_Status_CheckBox.getLocation();
		Dimension elementSize = loginpage_Login_Status_CheckBox.getSize();

		// 스크린 샷 전체 화면 이미지 가져오기
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);

		// 앨리먼트의 부분 이미지 추출
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(),
				elementSize.getWidth(), elementSize.getHeight());

		// 기존 이미지 로드
		BufferedImage referenceImage = ImageIO.read(new File(
				"E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\loginpage_login_status_Checkbox_Checked.png"));

		// 이미지 비교
		double similarity = compareImage(referenceImage, elementImage);

		if (similarity >= 0.9) {
			System.out.println(
					"LoginPage_Login_Status_Check_Unchecked() - Image Compare Success - similarity : " + similarity);

			loginpage_Login_Status_CheckBox.click();
			Thread.sleep(short_Sleep_Times_1000);

			System.out.println(
					"LoginPage_Login_Status_Check_Unchecked() - loginpage_Login_Statuc_Checkbox Unchecked Success");
		} else {
			System.out.println(
					"LoginPage_Login_Status_Check_Unchecked() - Image Compage Fail - similarity : " + similarity);

			throw new Exception("로그인페이지 진입 실패 or 로그인 페이지 > 로그인 상태 유지 앨리먼트 찾기 실패했습니다.");
		}
	}

	public static void LoginPage_Login_Status_Check_Checked(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > LoginPage_Login_Status_Check_Checked() - Start");

		// 앨리먼트 선택
		MobileElement loginpage_Login_Status_CheckBox = driver
				.findElementByXPath(loginpage_Login_Status_Checkbox_Xpath);

		// 앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = loginpage_Login_Status_CheckBox.getLocation();
		Dimension elementSize = loginpage_Login_Status_CheckBox.getSize();

		// 스크린 샷 전체 화면 이미지 가져오기
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);

		// 앨리먼트의 부분 이미지 추출
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(),
				elementSize.getWidth(), elementSize.getHeight());

		// 기존 이미지 로드
		BufferedImage referenceImage = ImageIO.read(new File(
				"E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\loginpage_login_status_Checkbox_Unchecked.png"));

		// 이미지 비교
		double similarity = compareImage(referenceImage, elementImage);

		if (similarity >= 0.9) {
			System.out.println(
					"LoginPage_Login_Status_Check_Checked() - Image Compare Success - similarity : " + similarity);

			loginpage_Login_Status_CheckBox.click();
			Thread.sleep(short_Sleep_Times_1000);

			System.out.println(
					"LoginPage_Login_Status_Check_Checked() - loginpage_Login_Statuc_Checkbox Checked Success");
		} else {
			System.out.println(
					"LoginPage_Login_Status_Check_Checked() - Image Compage Fail - similarity : " + similarity);

			throw new Exception("로그인페이지 진입 실패 or 로그인 페이지 > 로그인 상태 유지 앨리먼트 찾기 실패했습니다.");
		}
	}

	public static void Req_To_Stop_Power_Saving_Popop_Confirm_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Req_To_Stop_Power_Saving_Popop_Confirm_Click() - Start");

		MobileElement req_To_Stop_Power_Saving_Popop_Title = driver
				.findElementByXPath(req_to_Stop_Power_Saving_Popup_Title_Xpath);
		String req_To_Stop_Power_Saving_Popop_Title_Text = req_To_Stop_Power_Saving_Popop_Title.getText();

		if (req_To_Stop_Power_Saving_Popop_Title_Text.equals("절전기능 중지 요청")) {
			System.out.println(
					"Req_To_Stop_Power_Saving_Popop_Confirm_Click() - Popup Print Success > req_To_Stop_Power_Saving_Popop_Title_Text : "
							+ req_To_Stop_Power_Saving_Popop_Title_Text);

			MobileElement req_To_Stop_Power_Saving_Popop_Confirm = driver
					.findElementByXPath(req_to_Stop_Power_Saving_Popup_Confirm_Xpath);
			req_To_Stop_Power_Saving_Popop_Confirm.click();

			System.out.println(
					"Req_To_Stop_Power_Saving_Popop_Confirm_Click() - req_To_Stop_Power_Saving_Popop_Confirm Click Success");

			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_7, TimeUnit.SECONDS);
			Thread.sleep(normal_Sleep_Times_2000);
		} else {
			System.out.println(
					"Req_To_Stop_Power_Saving_Popop_Confirm_Click() - Popup Print Failure > req_To_Stop_Power_Saving_Popop_Title_Text : "
							+ req_To_Stop_Power_Saving_Popop_Title_Text);

			throw new Exception("절전기능 중지 요청 팝업 출력에 실패했습니다.");
		}
	}

	public static void Stop_Optimizing_Battery_Usage_Popup_Allowed_Click(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Stop_Optimizing_Battery_Usage_Popup_Allowed_Click() - Start");

		MobileElement stop_Optimizing_Battery_Usage_Popup_Title = driver
				.findElementByXPath(stop_Optimizing_Battery_Usage_Popup_Title_Xpath);
		String stop_Optimizing_Battery_Usage_Popup_Title_Text = stop_Optimizing_Battery_Usage_Popup_Title.getText();

		if (stop_Optimizing_Battery_Usage_Popup_Title_Text.equals("배터리 사용량 최적화 중지")) {
			System.out.println(
					"Stop_Optimizing_Battery_Usage_Popup_Allowed_Click() - Popup Print Success > stop_Optimizing_Battery_Usage_Popup_Title_Text : "
							+ stop_Optimizing_Battery_Usage_Popup_Title_Text);

			MobileElement stop_Optimizing_Battery_Usage_Popup_Allowed = driver
					.findElementByXPath(stop_Optimizing_Battery_Usage_Popup_Allowed_Xpath);
			stop_Optimizing_Battery_Usage_Popup_Allowed.click();

			System.out.println(
					"Stop_Optimizing_Battery_Usage_Popup_Allowed_Click() - Stop_Optimizing_Battery_Usage_Popup_Allowed_Click Success");

			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_7, TimeUnit.SECONDS);
			Thread.sleep(normal_Sleep_Times_2000);
		} else {
			System.out.println(
					"Stop_Optimizing_Battery_Usage_Popup_Allowed_Click() - Popup Print Failure > stop_Optimizing_Battery_Usage_Popup_Title_Text : "
							+ stop_Optimizing_Battery_Usage_Popup_Title_Text);

			throw new Exception("배터리 사용량 최적화 중지 팝업 출력에 실패했습니다.");
		}

	}

	// 트랭글 일반 계정 로그인
	public static void Login(AppiumDriver<MobileElement> driver) throws Exception {

		System.out.println("Tranggle_Method Class > Login() - Start");

		MobileElement loginpage_ID_Input = driver.findElementByXPath(loginpage_ID_Input_Xpath);
		loginpage_ID_Input.sendKeys(normal_Login_ID);

		MobileElement loginpage_PW_Input = driver.findElementByXPath(loginpage_PW_Input_Xpath);
		loginpage_PW_Input.sendKeys(normal_Login_PW);

		Thread.sleep(normal_Sleep_Times_3000);

		MobileElement loginpage_Login_Btn = driver.findElementByXPath(loginpage_Login_Btn_Xpath);
		String loginpage_Login_Btn_Text = loginpage_Login_Btn.getText();

		if (loginpage_Login_Btn_Text.equals("로그인")) {
			System.out.println("Login() - loginpage > Login Button Click Before > Login Button Text : "
					+ loginpage_Login_Btn_Text);

			loginpage_Login_Btn.click();

			System.out.println("Login() - loginpage > Login Button Click Success - few 10 Second wait.....");

			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_7, TimeUnit.SECONDS);
		} else {
			System.out.println("Loing() - loginpage > Login Button Click Failure > Login Button Text : "
					+ loginpage_Login_Btn_Text);

			throw new InterruptedException("로그인 버튼 클릭 및 로그인 실패하였습니다.");
		}

		driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);

	}

	// 트랭글 로그인 페이지 > 간편로그인 > 네이버 아이콘 클릭
	public static void Loginpage_Naver_Icon_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Loginpage_Naver_Icon_Click() - Start");

		// 로그인 페이지 > 네이버 아이콘 앨리먼트 가져옮
		MobileElement loginpage_Login_Naver_Icon = driver.findElementByXPath(loginpage_Naver_Icon_Xpath);

		// 네이버 아이콘 > 앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = loginpage_Login_Naver_Icon.getLocation();
		Dimension elementSize = loginpage_Login_Naver_Icon.getSize();

		// 가져온 앨리먼트를 스크린 샷 전체 화면 이미지 가져온 파일 읽음
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);

		// 가져온 앨리먼트의 부분 이미지 추출 (함주 파라미터 값으로 앨리먼트 x, y 좌표와 가로 / 세로 크키값을 넘겨줆
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(),
				elementSize.getWidth(), elementSize.getHeight());

		// 로컬에 저장되어 있는 비교하기 위한 기존 이미지 로드
		// 이떄 파일의 경로 값을 절대 경로 지정함.
		BufferedImage referenceImage = ImageIO
				.read(new File("E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\loginpage_naver_icon.png"));

		// compageImage 함수에서 이미지 비교한 유사도 값을 리턴값으로 받아온다.
		double similarity = compareImage(referenceImage, elementImage);

		if (similarity >= 0.9) {
			System.out.println("Loginpage_Naver_Icon_Click() - Image Compare Success - similarity : " + similarity);

			loginpage_Login_Naver_Icon.click();
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);

			System.out.println("Loginpage_Naver_Icon_Click() - loginpage_Naver_Login_Icon Click Success");
		} else {
			System.out.println("Naver_Login() - Image Compage Fail - similarity : " + similarity);

			throw new Exception("로그인페이지 > 네이버 아이콘을 찾기 못하거나 로그인 페이지 > 네이버 아이콘 클릭에 실패했습니다.");
		}
	}

	// 네이비 로그인 기능
	public static void Naver_Login_Check(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Naver_Login_Check() - Start");

		MobileElement nloginpage_Title = driver.findElementByXPath(nloginpage_Title_Xpath);
		String nloginpage_Title_Text = nloginpage_Title.getText();

		if (nloginpage_Title_Text.equals("네이버")) {
			System.out.println(
					"Naver_Login_Check() - nloginpage Move Success > nloginpage_Title_Text : " + nloginpage_Title_Text);

			MobileElement nloginpage_ID = driver.findElementByXPath(nloginpage_ID_Xpath);
			nloginpage_ID.sendKeys(naver_Login_ID);

			MobileElement nloginpage_PW = driver.findElementByXPath(nloginpage_PW_Xpath);
			nloginpage_PW.sendKeys(naver_Login_PW);

			Thread.sleep(short_Sleep_Times_1000);

			MobileElement nloginpage_Login_Btn = driver.findElementByXPath(nloginpage_Login_Btn_Xpath);
			nloginpage_Login_Btn.click();

			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);
		} else {
			System.out.println(
					"Naver_Login_Check() - nloginpage Move Failure > nloginpage_Title_Text : " + nloginpage_Title_Text);

			throw new Exception("네이버 로그인 화면 이동 및 네이버 로그인 화면 > 타이틀 앨리먼트 찾기 실패했습니다.");
		}
	}

	// 네이버 로그인 페이지 > 로그인 상태 유지 체크박스 해제
	public static void Naver_Loginpage_Login_Status_Check_Unchecked(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Naver_Loginpage_Login_Status_Check_Unchecked() - Start");

		// 네이버 로그인 페이지 > 로그인 상태 유지 앨리먼트 가져옮
		MobileElement nloginpage_Status_Checkbox = driver.findElementByXPath(nloginpage_Status_Checkbox_Xpath);

		// 로그인 상태 유지 앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = nloginpage_Status_Checkbox.getLocation();
		Dimension elementSize = nloginpage_Status_Checkbox.getSize();

		// 가져온 앨리먼트를 스크린 샷 전체 화면 이미지 가져온 파일 읽음
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);

		// 가져온 앨리먼트의 부분 이미지 추출 (함주 파라미터 값으로 앨리먼트 x, y 좌표와 가로 / 세로 크키값을 넘겨줆
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(),
				elementSize.getWidth(), elementSize.getHeight());

		// 로컬에 저장되어 있는 비교하기 위한 기존 이미지 로드
		// 이떄 파일의 경로 값을 절대 경로 지정함.
		BufferedImage referenceImage = ImageIO.read(new File(
				"E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\naver_loginpage_login_status_Checkbox_Checked.png"));

		// compageImage 함수에서 이미지 비교한 유사도 값을 리턴값으로 받아온다.
		double similarity = compareImage(referenceImage, elementImage);

		if (similarity >= 0.9) {
			System.out.println("Naver_Loginpage_Login_Status_Check_Unchecked() - Image Compare Success - similarity : "
					+ similarity);

			nloginpage_Status_Checkbox.click();
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);

			System.out.println(
					"Naver_Loginpage_Login_Status_Check_Unchecked() - naver_Loginpage_Login_Status_Check Click(Checked -> Unchecked) Success");
		} else {
			System.out.println(
					"Naver_Loginpage_Login_Status_Check_Unchecked() - Image Compage Fail - similarity : " + similarity);

			throw new Exception("네이버 로그인 페이지 > 로그인 상태 유지 선택상태가 아니거나 체크 해제에 실패했습니다.");
		}

	}

	// 트랭글 > 로그인 페이지 > 카카오 아이콘 클릭
	public static void Loginpage_Kakao_Icon_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Loginpage_Kakao_Icon_Click() - Start");

		MobileElement loginpage_Kakao_Icon = driver.findElementByXPath(loginpage_Kakao_Icon_Xpath);

		// 카카오 아이콘 > 앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = loginpage_Kakao_Icon.getLocation();
		Dimension elementSize = loginpage_Kakao_Icon.getSize();

		// 가져온 앨리먼트를 스크린 샷 전체 화면 이미지 가져온 파일 읽음
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);

		// 가져온 앨리먼트의 부분 이미지 추출 (함주 파라미터 값으로 앨리먼트 x, y 좌표와 가로 / 세로 크키값을 넘겨줆
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(),
				elementSize.getWidth(), elementSize.getHeight());

		// 로컬에 저장되어 있는 비교하기 위한 기존 이미지 로드
		// 이떄 파일의 경로 값을 절대 경로 지정함.
		BufferedImage referenceImage = ImageIO
				.read(new File("E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\loginpage_kakao_icon.png"));

		// compageImage 함수에서 이미지 비교한 유사도 값을 리턴값으로 받아온다.
		double similarity = compareImage(referenceImage, elementImage);

		if (similarity >= 0.9) {
			System.out.println("Loginpage_Kakao_Icon_Click() - Image Compare Success - similarity : " + similarity);

			loginpage_Kakao_Icon.click();
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);

			System.out.println("Loginpage_Kakao_Icon_Click() - loginpage_Kakao_Icon Click Success");
		} else {
			System.out.println("Loginpage_Kakao_Icon_Click() - Image Compage Fail - similarity : " + similarity);

			throw new Exception("로그인페이지 > 카카오 아이콘 이미지 아니거나 로그인 페이지 > 카카오 아이콘 클릭에 실패했습니다.");
		}

	}

	// 카카오 로그인 기능
	public static void Kakao_Login_Check(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Kakao_Login_Check() - Start");

		MobileElement kloginpage_Title = driver.findElementByXPath(kloginpage_Title_Xpath);
		String kloginpage_Title_Text = kloginpage_Title.getText();

		if (kloginpage_Title_Text.equals("Kakao")) {
			System.out.println(
					"Kakao_Login_Check() - kloginpage Move Success > nloginpage_Title_Text : " + kloginpage_Title_Text);

			MobileElement kloginpage_ID = driver.findElementByXPath(kloginpage_ID_Xpath);
			kloginpage_ID.sendKeys(kakao_Login_ID);

			MobileElement kloginpage_PW = driver.findElementByXPath(kloginpage_PW_Xpath);
			kloginpage_PW.sendKeys(kakao_Login_PW);

			Thread.sleep(short_Sleep_Times_1000);

			MobileElement kloginpage_Login_Btn = driver.findElementByXPath(kloginpage_Login_Btn_Xpath);
			kloginpage_Login_Btn.click();

			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);
		} else {
			System.out.println("Kakao_Login_Check() - kloginpage Move Failure > nkloginpage_Title_Text : "
					+ kloginpage_Title_Text);

			throw new Exception("카카오 로그인 화면 이동 및 카카오 로그인 화면 > 타이틀 앨리먼트 찾기 실패했습니다.");
		}
	}

	// 카카오 로그인 페이지 > 로그인 상태 유지 체크박스 해제
	public static void Kakao_Loginpage_Login_Status_Check_Unchecked(AppiumDriver<MobileElement> driver)
			throws Exception {
		System.out.println("Tranggle_Method Class > Kakao_Loginpage_Login_Status_Check_Unchecked() - Start");

		// 네이버 로그인 페이지 > 로그인 상태 유지 앨리먼트 가져옮
		MobileElement kloginpage_Status_Checkbox = driver.findElementByXPath(kloginpage_Status_Checkbox_Xpath);

		// 로그인 상태 유지 앨리먼트의 위치와 크기 가져오기
		org.openqa.selenium.Point elementLocation = kloginpage_Status_Checkbox.getLocation();
		Dimension elementSize = kloginpage_Status_Checkbox.getSize();

		// 가져온 앨리먼트를 스크린 샷 전체 화면 이미지 가져온 파일 읽음
		File screenshotFile = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		BufferedImage screenshotImage = ImageIO.read(screenshotFile);

		// 가져온 앨리먼트의 부분 이미지 추출 (함주 파라미터 값으로 앨리먼트 x, y 좌표와 가로 / 세로 크키값을 넘겨줆
		BufferedImage elementImage = screenshotImage.getSubimage(elementLocation.getX(), elementLocation.getY(),
				elementSize.getWidth(), elementSize.getHeight());

		// 로컬에 저장되어 있는 비교하기 위한 기존 이미지 로드
		// 이떄 파일의 경로 값을 절대 경로 지정함.
		BufferedImage referenceImage = ImageIO.read(new File(
				"E:\\eclipse_workspace\\Tranggle_App\\src\\main\\resources\\kakao_loginpage_login_status_Checkbox_Checked.png"));

		// compageImage 함수에서 이미지 비교한 유사도 값을 리턴값으로 받아온다.
		double similarity = compareImage(referenceImage, elementImage);

		if (similarity >= 0.9) {
			System.out.println("Kakao_Loginpage_Login_Status_Check_Unchecked() - Image Compare Success - similarity : "
					+ similarity);

			kloginpage_Status_Checkbox.click();
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_30, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);

			System.out.println(
					"Kakao_Loginpage_Login_Status_Check_Unchecked() - kakao_Loginpage_Login_Status_Check Click(Checked -> Unchecked) Success");
		} else {
			System.out.println(
					"Kakao_Loginpage_Login_Status_Check_Unchecked() - Image Compage Fail - similarity : " + similarity);

			throw new Exception("카카오 로그인 페이지 > 로그인 상태 유지 선택상태가 아니거나 체크 해제에 실패했습니다.");
		}

	}

	// 트랭글 로그아웃
	public static void Logout(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Logout() - Start");

		Home_Header_Setting_Click(driver);
		Settings_Account_Detail_Btn_Click(driver);

		System.out.println("Logout() - account_Logout Button 앨리먼트 가져오기 전");

		MobileElement account_Logout_Btn = driver.findElementByXPath(account_Logout_Btn_Xpath);
		String account_Logout_Btn_Text = account_Logout_Btn.getText();

		if (account_Logout_Btn_Text.equals("로그아웃")) {
			System.out.println("Logout() - account_Logout Button Find Success -> 앨리먼트 확인 후 클릭 전");
			account_Logout_Btn.click();

			System.out.println("Logout() - account_Logout Button 클릭 후 5초 대기");
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_5, TimeUnit.SECONDS);
		} else {
			System.out.println("Logout() - account_Logout Button Find Failure");

			throw new Exception("계정 화면 > [로그아웃] 버튼을 찾기 못했습니다.");
		}

		MobileElement account_Logout_Popup_Title = driver.findElementByXPath(account_Logout_Popup_Title_Xpath);
		String account_Logout_Popup_Title_Text = account_Logout_Popup_Title.getText();

		if (account_Logout_Popup_Title_Text.equals("로그아웃")) {
			System.out.println("Logout() - Logout Popup Print Success -> account_Logout_Popup_Title_Text : "
					+ account_Logout_Popup_Title_Text);

			MobileElement account_Logout_Popup_Confirm = driver.findElementByXPath(account_Logout_Popup_Confirm_Xpath);
			account_Logout_Popup_Confirm.click();

			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);

			System.out.println("Logout() - Logout Popup > [Confirm] Button 클릭 후 약 10초 대기");
		} else {
			System.out.println("Logout() - Logout Popup Print Failure -> account_Logout_Popup_Title_Text : "
					+ account_Logout_Popup_Title_Text);

			throw new Exception("계정 화면 > [로그아웃] > 로그아웃 팝업 출력에 실패했습니다.");
		}

		System.out.println("Logout() - Loinpage > [로그인] 버튼 앨리먼트 가져오기 전");

		MobileElement loginpage_Login_Btn = driver.findElementByXPath(loginpage_Login_Btn_Xpath);
		String loginpage_Login_Btn_Text = loginpage_Login_Btn.getText();

		if (loginpage_Login_Btn_Text.equals("로그인")) {
			System.out.println("Logout() - Logout & Loginpage Move Success > loginpage_Login_Btn_Text : "
					+ loginpage_Login_Btn_Text);
		} else {
			System.out.println("Logout() - Logout & Loginpage Move Failure > loginpage_Login_Btn_Text : "
					+ loginpage_Login_Btn_Text);

			throw new Exception("로그아웃 실패 or 로그아웃 후 로그인 페이지 이동 실패했습니다.");
		}

	}

	// 트랭글 홈 화면 > 상단 > 설정 버튼 클릭
	public static void Home_Header_Setting_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Home_Header_Setting_Click() - Start");
		System.out.println("Home_Header_Setting_Click() - home_Header_Settings Button 앨리먼트 가져오기");

		MobileElement home_Header_Settings = driver.findElementByXPath(home_Header_Settings_Xpath);
		home_Header_Settings.click();

		System.out.println("Home_Header_Setting_Click() - home_Header_Settings Button 클릭 후 약 5초 대기");

		driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_5, TimeUnit.SECONDS);

		MobileElement settings_Account_Title = driver.findElementByXPath(settings_Account_Title_Xpath);
		String settings_Account_Title_Text = settings_Account_Title.getText();

		if (settings_Account_Title_Text.equals("계정")) {
			System.out.println("Home_Header_Setting_Click() - Settings Move Success -> settings_Account_Title_Text : "
					+ settings_Account_Title_Text);
		} else {
			System.out.println("Home_Header_Setting_Click() - Settings Move Failure -> settings_Account_Title_Text : "
					+ settings_Account_Title_Text);

			throw new Exception("트랭글 앱 > 설정 화면 이동으로 실패했습니다.");
		}
	}

	public static void Settings_Account_Detail_Btn_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Settings_Account_Detail_Btn_Click() - Start");
		System.out.println("Settings_Account_Detail_Btn_Click() - Settings_Account_Detail_Btn 앨리먼트 가져오기");

		MobileElement settings_Account_Detail_Btn = driver.findElementByXPath(settings_Account_Detail_Btn_Xpath);
		settings_Account_Detail_Btn.click();

		System.out.println("Settings_Account_Detail_Btn_Click() - Settings > [>] 버튼 클릭 후 약 5초 대기");

		driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_5, TimeUnit.SECONDS);

		MobileElement Account_Title = driver.findElementByXPath(account_Title_Xpath);
		String Account_Title_Text = Account_Title.getText();

		if (Account_Title_Text.equals("계정")) {
			System.out.println("Settings_Account_Detail_Btn_Click() - Account Move Success -> Account_Title_Text : "
					+ Account_Title_Text);
		} else {
			System.out.println("Settings_Account_Detail_Btn_Click() - Account Move Failure -> Account_Title_Text : "
					+ Account_Title_Text);

			throw new Exception("트랭글 앱 > 설정 > 계정 화면 이동으로 실패하였습니다.");
		}
	}

	public static void Front_PopUp_Close(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Front_PopUp_Close() - Start");

		try {
			MobileElement front_Popup_Close_Btn = driver.findElementByXPath(front_Popup_Close_Btn_Xpath);

			front_Popup_Close_Btn.click();
			Thread.sleep(short_Sleep_Times_1000);

			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_7, TimeUnit.SECONDS);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Front_PopUp_Close() - Front_Popup_Close Failure > e : " + e);
			e.printStackTrace();

		}
	}

	public static void Front_Popup_CheckBox_Check(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Front_Popup_CheckBox_Check() - Start");

		MobileElement front_Popup_CheckBox = driver.findElementByXPath(front_Popup_CheckBox_Xpath);
		String front_Popup_CheckBox_Text = front_Popup_CheckBox.getText();

		if (front_Popup_CheckBox_Text.equals("오늘 하루 보지 않기")) {
			front_Popup_CheckBox.click();

			Thread.sleep(normal_Sleep_Times_2000);
		} else {
			throw new Exception("Login() - 이벤트 전면 팝업 출력 되지 않음");
		}
	}

	public static void Loginpage_Guest_In(AppiumDriver<MobileElement> driver) {
		System.out.println("Tranggle_Method Class > Loginpage_Guest_In() - Start");

		try {
			MobileElement loginpage_Guest_In_Btn = driver.findElementByXPath(loginpage_Guest_In_Btn_Xpath);
			String loginpage_Guest_In_Btn_Text = loginpage_Guest_In_Btn.getText();

			if (loginpage_Guest_In_Btn_Text.equals("손님으로 입장")) {
				loginpage_Guest_In_Btn.click();

				Thread.sleep(long_Sleep_Times_5000);
			} else {
				throw new Exception("로그인페이지 화면에 이동에 실패하였습니다.");
			}

			MobileElement guest_In_Popup_Continue_Btn = driver.findElementByXPath(guest_In_Popup_Continue_Btn_Xpath);
			String guest_In_Popup_Continue_Btn_Text = guest_In_Popup_Continue_Btn.getText();

			if (guest_In_Popup_Continue_Btn_Text.equals("계속 진행")) {
				guest_In_Popup_Continue_Btn.click();

				driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
			} else {
				throw new Exception("손님으로 입장 팝업 출력 or 계속 진행 버튼 클릭에 실패했습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void Home_Bottom_Nav_Exercise_Click(AppiumDriver<MobileElement> driver) throws Exception {
		System.out.println("Tranggle_Method Class > Home_Bottom_Nav_Exercise_Click - Start");
		
		try {
			MobileElement home_Bottom_Nav_Exercise = driver.findElementByXPath(home_Bottom_Nav_Exercise_Xpath);
			
			System.out.println("Home_Bottom_Nav_Exercise_Click() - Nav_Exercise Click Success");
			home_Bottom_Nav_Exercise.click();
			driver.manage().timeouts().implicitlyWait(long_Sleep_Seconds_10, TimeUnit.SECONDS);
			Thread.sleep(short_Sleep_Times_1000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Home_Bottom_Nav_Exercise_Click() - Nav_Exercise Click Failure");
			e.printStackTrace();
			
			throw new Exception("홈 > 하단 > 내비게이션 > 운동하기 앨리먼트를 찾기 못했거나 클릭에 실패했습니다.");
		}
	}
	

	// 스크롤 다운 / 업 / LEFT / RIGHT 이동 함수 정의
	// 스크롤 다운 이동 함수
	public static void scrollDown(AppiumDriver<MobileElement> driver) {
		System.out.println("Tranggle_Method Class > scrollDown - Start");

		// 모바일 화면의 현재 사이즈를 가져옮
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.2);

		System.out.println("scrollDown() - Start ExecuteScript");

		// 스크롤 액션 수행 -> 화면의 20~80% 영역만큼 스크롤 이동
		driver.executeScript("mobile:shell", ImmutableMap.of("command", "input swipe", "args",
				ImmutableList.of("0", String.valueOf(startY), "0", String.valueOf(endY))));

		System.out.println("scrollDown() - End() ExecuteScript");

	}

	// 스크롤 왼쪽 이동 함수
	public static void scrollLeft(AppiumDriver<MobileElement> driver) {
		System.out.println("Tranggle_Method Class > scrollLeft - Start");

		// 모바일 화면의 현재 사이즈를 가져옮
		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width * 0.8);
		int endX = (int) (size.width * 0.2);
		int startY = size.height / 2;
		int endY = startY;

		System.out.println("scrollLeft() - Start ExecuteScript");

		// 스크롤 액션 수행 -> 화면의 20~80% 영역만큼 스크롤 이동
		driver.executeScript("mobile:shell", ImmutableMap.of("command", "input swipe", "args",
				ImmutableList.of(String.valueOf(startX), startY, String.valueOf(endX), endY)));

		System.out.println("scrollLeft() - End() ExecuteScript");
	}

	public static void scrollRight(AppiumDriver<MobileElement> driver) {
		System.out.println("Tranggle_Method Class > scrollRight - Start");

		// 모바일 화면의 현재 사이즈를 가져옮
		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width * 0.2);
		int endX = (int) (size.width * 0.8);
		int startY = size.height / 2;
		int endY = startY;

		System.out.println("scrollLeft() - Start ExecuteScript");

		// 스크롤 액션 수행 -> 화면의 20~80% 영역만큼 스크롤 이동
		driver.executeScript("mobile:shell", ImmutableMap.of("command", "input swipe", "args",
				ImmutableList.of(String.valueOf(startX), startY, String.valueOf(endX), endY)));

		System.out.println("scrollLeft() - End() ExecuteScript");
	}

	// 이미지 유사도 비교 함수
	public static double compareImage(BufferedImage image1, BufferedImage image2) {
		// 로컬의 저장된 이미지와 앨리먼트로 갭쳐한 이미지를 각 픽셀의 RGB 값으로 한 픽셀씩 비교한다.
		int width = image1.getWidth();
		int height = image1.getHeight();
		int equalPixels = 0;

		// 한 픽셀 시 비교 하는 함수 > 값이 동일할 경우, pixel 변수값을 증가 시킴
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (image1.getRGB(x, y) == image2.getRGB(x, y)) {
					equalPixels++;
				}
			}
		}
		// 이미지 가로 x 세로 곲한 영역 만큼 비교한 변수 값으로 나누어 얼마나
		// 이미지가 유사 했는지 값을 리턴한다.
		return (double) equalPixels / (width * height);
	}

}
