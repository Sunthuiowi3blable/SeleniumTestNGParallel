package BT5BT6BT7BT8BT9.testcases;

import BT5BT6BT7BT8BT9.pages.AddNewProductPage;
import BT5BT6BT7BT8BT9.pages.AllProductsPage;
import BT5BT6BT7BT8BT9.pages.DashboardPage;
import BT5BT6BT7BT8BT9.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class AddNewProductTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    AllProductsPage allProductsPage;

    @Test
    public void testAddNewProductSuccess(){

        String NAME_PRODUCT = "GIOQUAMH";
        String CATEGORY_NAME = "sunthuiowi11";

        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang addNewProductPage
        addNewProductPage = dashboardPage.clickMenuAddNewProductWithMenuProducts();
        addNewProductPage.enterDataAddNewProduct(NAME_PRODUCT, CATEGORY_NAME);

        //LIÊN KẾT TRANG: từ trang addNewProductPage sang trang allProductsPage
        allProductsPage = addNewProductPage.clickButtonSavePublish();
        allProductsPage.verifySearchProduct(NAME_PRODUCT);
    }
}
