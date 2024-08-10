package BT10.testcases;

import BT10.pages.DashboardPage;
import BT10.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    //Khởi tạo đối tượng class
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    //Testcase Total Customer
    @Test
    public void testTotalCustomer(){
        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage.checkTotalCustomer();
    }

    //Testcase Total Order
    @Test
    public void testTotalOrder(){
        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage.checkTotalOrder();
    }

    //Testcase Total Product Category
    @Test
    public void  testTotalProductCategory(){
        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage.checkTotalProducCategory();
    }

    //Testcase Total Product Brand
    @Test
    public void testTotalProductBrand(){
        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage.checkTotalProductBrand();
    }
}
