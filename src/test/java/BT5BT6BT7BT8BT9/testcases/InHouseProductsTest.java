package BT5BT6BT7BT8BT9.testcases;

import BT5BT6BT7BT8BT9.pages.*;
import common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class InHouseProductsTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    InHouseProductsPage inHouseProductsPage;
    AllProductsPage allProductsPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;

    //Test edit product vừa thêm
    @Test
    public void testEditNewProduct(){

        String NAME_PRODUCT = "GIOQUAMH";
        String CATEGORY_NAME = "sunthuiowi11";

        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //LIÊN KẾT TRANG: Từ trang dashboardPage chuyển sang trang addNewProductPage
        addNewProductPage = dashboardPage.clickMenuAddNewProductWithMenuProducts();
        addNewProductPage.enterDataAddNewProduct(NAME_PRODUCT, CATEGORY_NAME);

        //LIÊN KẾT TRANG: Từ trang addNewProductPage chuyển sang trang allProductsPage
        allProductsPage = addNewProductPage.clickButtonSavePublish();
        allProductsPage.verifySearchProduct(NAME_PRODUCT);

        //LIÊN KẾT TRANG: Từ trang allProductsPage chuyển sang trang inHouseProductsPage
        inHouseProductsPage = allProductsPage.clickButtonEdit();
        inHouseProductsPage.editProductName();
    }

    //Test edit product tùy ý
    @Test
    public void testEditProduct(){

        String NAME_PRODUCT = "GIOQUAMH";
        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //LIÊN KẾT TRANG: Từ trang dashboardPage chuyển sang trang allProductsPage
        allProductsPage = dashboardPage.clickMenuAllProductsWithMenuProducts();
        allProductsPage.searchProduct(NAME_PRODUCT);

        //LIÊN KẾT TRANG: Từ trang allProductsPage chuyển sang trang inHouseProductsPage
        inHouseProductsPage = allProductsPage.clickButtonEdit();
        inHouseProductsPage.editProductName();
    }
}
