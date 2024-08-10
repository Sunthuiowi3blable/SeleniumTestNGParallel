package BT5BT6BT7BT8BT9.testcases;

import BT5BT6BT7BT8BT9.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khởi tạo đối tượng trang
    private LoginPage loginPage;

    //Testcase đăng nhập thành công
    @Test
    public void testLoginSuccess(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Gọi hàm đăng nhập
        loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //Gọi hàm xử lý đăng nhập thành công
        loginPage.verifyLoginSuccess();
    }

    //Testcase đăng nhập không thành công với email trống (null)
    @Test
    public void testLoginFailWithEmailNull(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Gọi hàm đăng nhập
        loginPage.loginCMS("", ConfigData.PASSWORD);

        //Gọi hàm xử lý đăng nhập không thành công với email trống (null)
        loginPage.verifyLoginFailWithEmail("Please fill out this field.");
    }

    //Testcase đăng nhập không thành công với password trống (null)
    @Test
    public void testLoginFailWithPasswordNull(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Gọi hàm đăng nhập
        loginPage.loginCMS(ConfigData.EMAIL, "" );

        //Gọi hàm xử lý đăng nhập không thành công vơ password trống (null)
        loginPage.verifyLoginFailWithPassword("Please fill out this field.");
    }

    //Testcase đăng nhập không thành công với cả password và email trống (null)
    @Test
    public void testLoginBothEmpty(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Gọi hàm đăng nhập
        loginPage.loginCMS("", "");

        //Gọi hàm xử lý
        loginPage.verifyLoginFailWithEmail("Please fill out this field.");
    }

    //Testcase đăng nhập không thành công với Email nhập không hợp lệ (invalid)
    @Test
    public void testLoginFailWithEmailInvalid(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Gọi hàm đăng nhập
        loginPage.loginCMS("admin123@example.com", ConfigData.PASSWORD);

        //Gọi hàm xử lý
        loginPage.verifyLoginFailWithEmail("Please fill out this field.");
    }

    //Testcase đăng nhập không thành công với Password nhập không hợp lệ (invalid)
    @Test
    public void testLoginFailWithPasswordInvalid(){
        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Gọi hàm đăng nhập
        loginPage.loginCMS(ConfigData.EMAIL, "123");

        //Gọi hàm xử lý
        loginPage.verifyLoginFailWithEmail("Please fill out this field.");
    }
}
