package BT10.testcases;

import BT10.pages.*;
import common.BaseTest;
import constants.ConfigData;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    InHouseProductsPage inHouseProductsPage;
    AllProductsPage allProductsPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    BrandPage brandPage;
    private ExcelHelper excelHelper;

    @Test
    public void testAddNewBrandSuccess(){
        String BRAND_NAME = "Brand TN Final 08-2024";

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang brandPage
        brandPage = dashboardPage.clickMenuBrandPageWithMenuProducts();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Brand");

        brandPage.enterDataBrand(excelHelper.getCellData("NAME", 1));
        brandPage.verifySearchBrand(excelHelper.getCellData("NAME", 1));
    }
}
