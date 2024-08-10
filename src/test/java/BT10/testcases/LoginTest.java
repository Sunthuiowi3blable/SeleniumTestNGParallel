package BT10.testcases;

import BT10.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khởi tạo đối tượng trang
    private LoginPage loginPage;
    private ExcelHelper excelHelper;

    //Testcase đăng nhập thành công
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

    //Testcase đăng nhập không thành công với email trống (null)
    @Test
    public void testLoginFailWithEmailNull(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //Gọi hàm đăng nhập
        loginPage.loginCMS("", excelHelper.getCellData("PASSWORD", 2));

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
        loginPage.loginCMS("", "");

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
