package BT10.testcases;

import BT10.pages.AddNewProductPage;
import BT10.pages.AllProductsPage;
import BT10.pages.DashboardPage;
import BT10.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

public class AddNewProductTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    AllProductsPage allProductsPage;
    private ExcelHelper excelHelper;

    @Test
    public void testAddNewProductSuccess(){

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang addNewProductPage
        addNewProductPage = dashboardPage.clickMenuAddNewProductWithMenuProducts();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "AddNewProduct");

        addNewProductPage.enterDataAddNewProduct(excelHelper.getCellData("PRODUCT NAME", 1), excelHelper.getCellData("CATEGORY", 1));

        //LIÊN KẾT TRANG: từ trang addNewProductPage sang trang allProductsPage
        allProductsPage = addNewProductPage.clickButtonSavePublish();
        allProductsPage.verifySearchProduct(excelHelper.getCellData("PRODUCT NAME", 1));
    }
}
