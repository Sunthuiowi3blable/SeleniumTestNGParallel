package BT12BT13.testcases;

import BT12BT13.pages.LoginPage;
import common.BaseTest;
import dataproviders.DataProviderFactory;
import helpers.CaptureHelper;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends BaseTest {

    //Khởi tạo đối tượng trang
    private LoginPage loginPage;
    private ExcelHelper excelHelper;

    //Testcase đăng nhập thành công lấy data trực tiếp bằng file excel
    @Test
    public void testLoginSuccess(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //Gọi hàm đăng nhập
        loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //Gọi hàm xử lý đăng nhập thành công
        loginPage.verifyLoginSuccess();
    }

//    //Testcase đăng nhập thành công với data provider
//    @Test (dataProvider = "data_provider_login", dataProviderClass = DataProviderFactory.class)
//    public void testLoginSuccessDataProvider(String email, String password){
//        //Khởi tạo đối tượng
//        loginPage = new LoginPage();
//
//        //Gọi hàm đăng nhập
//        loginPage.loginCMS(email, password);
//
//        //Gọi hàm xử lý đăng nhập thành công
//        loginPage.verifyLoginSuccess();
//    }
//
//    //Testcase đăng nhập thành công với data đọc từ file excel với dataprovider
//    @Test (dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
//    public void testLoginSuccessDataProviderFromExcel(String email, String password){
//        //Khởi tạo đối tượng
//        loginPage = new LoginPage();
//
//        //Gọi hàm đăng nhập
//        loginPage.loginCMS(email, password);
//
//        //Gọi hàm xử lý đăng nhập thành công
//        loginPage.verifyLoginSuccess();
//    }
//
//    //Testcase đăng nhập thành công với data đọc từ file excel với dataprovider
//    @Test (dataProvider = "data_provider_login_excel_hashtable", dataProviderClass = DataProviderFactory.class)
//    public void testLoginSuccessDataProviderFromExcel_Hashtable(Hashtable<String, String> data){
//        //Khởi tạo đối tượng
//        loginPage = new LoginPage();
//
//        //Gọi hàm đăng nhập
//        loginPage.loginCMS(data.get("EMAIL"), data.get("PASSWORD"));
//
//        //Gọi hàm xử lý đăng nhập thành công
//        loginPage.verifyLoginSuccess();
//    }
//
    //Testcase đăng nhập không thành công với email trống (null)
    @Test (dataProvider = "data_provider_login_fail_with_email_null_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginFailWithEmailNull(Hashtable<String, String> data){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //Gọi hàm đăng nhập
        loginPage.loginCMS(data.get("EMAIL"), data.get("PASSWORD"));

        //Chụp màn hình
        CaptureHelper.screenshot("LoginFailWithEmailNull");

        //Gọi hàm xử lý đăng nhập không thành công với email trống (null)
        loginPage.verifyLoginFailWithEmail(excelHelper.getCellData("ALERT", 2));
    }

    //Testcase đăng nhập không thành công với password trống (null)
    @Test
    public void testLoginFailWithPasswordNull(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //Gọi hàm đăng nhập
        loginPage.loginCMS(excelHelper.getCellData("EMAIL", 3), "" );

        //Gọi hàm xử lý đăng nhập không thành công với password trống (null)
        loginPage.verifyLoginFailWithPassword(excelHelper.getCellData("ALERT", 3));
    }

    //Testcase đăng nhập không thành công với cả password và email trống (null)
    @Test
    public void testLoginBothEmpty(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //Gọi hàm đăng nhập
        loginPage.loginCMS("1", "");

        //Gọi hàm xử lý
        loginPage.verifyLoginFailWithEmail(excelHelper.getCellData("ALERT", 4));
    }

    //Testcase đăng nhập không thành công với Email nhập không hợp lệ (invalid)
    @Test
    public void testLoginFailWithEmailInvalid(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //Gọi hàm đăng nhập
        loginPage.loginCMS(excelHelper.getCellData("EMAIL", 5), excelHelper.getCellData("PASSWORD", 5));

        //Gọi hàm xử lý
        loginPage.verifyLoginFailWithEmail(excelHelper.getCellData("ALERT", 5));
    }

    //Testcase đăng nhập không thành công với Password nhập không hợp lệ (invalid)
    @Test
    public void testLoginFailWithPasswordInvalid(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //Gọi hàm đăng nhập
        loginPage.loginCMS(excelHelper.getCellData("EMAIL", 6), excelHelper.getCellData("PASSWORD", 6));

        //Gọi hàm xử lý
        loginPage.verifyLoginFailWithEmail(excelHelper.getCellData("ALERT", 6));
    }
}
