package BT12BT13.testcases;

import BT12BT13.pages.AddNewProductPage;
import BT12BT13.pages.AllProductsPage;
import BT12BT13.pages.DashboardPage;
import BT12BT13.pages.LoginPage;
import common.BaseTest;
import dataproviders.DataProviderFactory;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AllProductsTest extends BaseTest {

    LoginPage loginPage;
    AllProductsPage allProductsPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    ExcelHelper excelHelper;

    //Test search Product vừa add có tồn tại không
    @Test(dataProvider = "data_provider_addnewproduct_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testSearchNewProduct(Hashtable<String, String> data){

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang addNewProductPage
        addNewProductPage = dashboardPage.clickMenuAddNewProductWithMenuProducts();
        addNewProductPage.enterDataAddNewProduct(data);

        //LIÊN KẾT TRANG: từ trang addNewProductPage sang trang allProductsPage
        allProductsPage = addNewProductPage.clickButtonSavePublish();
        allProductsPage.verifySearchProduct(data);
    }

    //Test search Product tùy ý
    @Test(dataProvider = "data_provider_addnewproduct_excel_hashtable", dataProviderClass = DataProviderFactory .class)
    public void testSearchProduct(Hashtable<String, String> data){

        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang allProductsPage
        allProductsPage = dashboardPage.clickMenuAllProductsWithMenuProducts();
        allProductsPage.verifySearchProduct(data);
    }
}
