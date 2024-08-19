package BT12BT13.testcases;

import BT12BT13.pages.*;
import common.BaseTest;
import dataproviders.DataProviderFactory;
import helpers.CaptureHelper;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class InHouseProductsTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    InHouseProductsPage inHouseProductsPage;
    AllProductsPage allProductsPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    ExcelHelper excelHelper;

    //Test edit product vừa thêm
    @Test (dataProvider = "data_provider_addnewproduct_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testEditNewProduct(Hashtable<String, String> data){

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: Từ trang dashboardPage chuyển sang trang addNewProductPage
        addNewProductPage = dashboardPage.clickMenuAddNewProductWithMenuProducts();
        addNewProductPage.enterDataAddNewProduct(data);

        //LIÊN KẾT TRANG: Từ trang addNewProductPage chuyển sang trang allProductsPage
        allProductsPage = addNewProductPage.clickButtonSavePublish();
        allProductsPage.verifySearchProduct(data);

        //LIÊN KẾT TRANG: Từ trang allProductsPage chuyển sang trang inHouseProductsPage
        inHouseProductsPage = allProductsPage.clickButtonEdit();
        inHouseProductsPage.editProductName();
    }

    //Test edit product tùy ý
    @Test(dataProvider = "data_provider_addnewproduct_excel_hashtable", dataProviderClass = DataProviderFactory .class)
    public void testEditProduct(Hashtable<String, String> data){

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: Từ trang dashboardPage chuyển sang trang allProductsPage
        allProductsPage = dashboardPage.clickMenuAllProductsWithMenuProducts();
        allProductsPage.searchProduct(data);

        //LIÊN KẾT TRANG: Từ trang allProductsPage chuyển sang trang inHouseProductsPage
        inHouseProductsPage = allProductsPage.clickButtonEdit();
        inHouseProductsPage.editProductName();
    }
}
