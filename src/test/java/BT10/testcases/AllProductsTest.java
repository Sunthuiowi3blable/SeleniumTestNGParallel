package BT10.testcases;

import BT10.pages.AddNewProductPage;
import BT10.pages.AllProductsPage;
import BT10.pages.DashboardPage;
import BT10.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import org.testng.annotations.Test;

public class AllProductsTest extends BaseTest {

    LoginPage loginPage;
    AllProductsPage allProductsPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;

    //Test search Product vừa add có tồn tại không
    @Test
    public void testSearchNewProduct(){

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

    //Test search Product tùy ý
    @Test
    public void testSearchProduct(){

        String NAME_PRODUCT = "GIOQUAMH";
        String CATEGORY_NAME = "sunthuiowi11";

        loginPage = new LoginPage();

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang allProductsPage
        allProductsPage = dashboardPage.clickMenuAllProductsWithMenuProducts();
        allProductsPage.verifySearchProduct(NAME_PRODUCT);
    }
}
