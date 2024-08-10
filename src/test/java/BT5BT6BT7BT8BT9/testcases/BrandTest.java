package BT5BT6BT7BT8BT9.testcases;

import BT5BT6BT7BT8BT9.pages.*;
import common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    InHouseProductsPage inHouseProductsPage;
    AllProductsPage allProductsPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    BrandPage brandPage;

    @Test
    public void testAddNewBrandSuccess(){
        String BRAND_NAME = "Brand TN Final 08-2024";

        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang brandPage
        brandPage = dashboardPage.clickMenuBrandPageWithMenuProducts();
        brandPage.enterDataBrand(BRAND_NAME);
        brandPage.verifySearchBrand(BRAND_NAME);
    }
}
