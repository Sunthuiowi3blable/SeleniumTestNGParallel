package constants;

import helpers.PropertiesHelper;

public class ConfigData {

//Khai báo biến toàn cục để có thể dùng ở nhiều nơi
    public static String URL = PropertiesHelper.getValue("URL");
    public static String EMAIL = PropertiesHelper.getValue("EMAIL");
    public static String PASSWORD = PropertiesHelper.getValue("PASSWORD");
    public static int EXPLICIT_WAIT_TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("EXPLICIT_WAIT_TIMEOUT"));
    public static double STEP_TIME = Double.parseDouble(PropertiesHelper.getValue("STEP_TIME"));
    public static int PAGE_LOAD_TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));
    public static String SCREENSHOT_PATH = PropertiesHelper.getValue("SCREENSHOT_PATH");
    public static String SUCCESS_SCREENSHOT_PATH = PropertiesHelper.getValue("SUCCESS_SCREENSHOT_PATH");
    public static String FAIL_SCREENSHOT_PATH = PropertiesHelper.getValue("FAIL_SCREENSHOT_PATH");
    public static String RECORD_VIDEO_PATH = PropertiesHelper.getValue("RECORD_VIDEO_PATH");
}
