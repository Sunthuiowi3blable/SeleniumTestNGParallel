package BT10.testcases;

import BT10.pages.*;
import common.BaseTest;
import constants.ConfigData;
import dataproviders.DataProviderFactory;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class BrandTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    InHouseProductsPage inHouseProductsPage;
    AllProductsPage allProductsPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    BrandPage brandPage;
    private ExcelHelper excelHelper;

    @Test (dataProvider = "data_provider_brand_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testAddNewBrandSuccess(Hashtable<String, String> data){

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel Login
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang brandPage
        brandPage = dashboardPage.clickMenuBrandPageWithMenuProducts();

        brandPage.enterDataBrand(data);
        brandPage.verifySearchBrand(data);
    }
}
