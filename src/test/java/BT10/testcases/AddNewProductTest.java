package BT10.testcases;

import BT10.pages.AddNewProductPage;
import BT10.pages.AllProductsPage;
import BT10.pages.DashboardPage;
import BT10.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import dataproviders.DataProviderFactory;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddNewProductTest extends BaseTest {

    //Khởi tạo đối tượng trang
    LoginPage loginPage;
    AddNewProductPage addNewProductPage;
    DashboardPage dashboardPage;
    AllProductsPage allProductsPage;
    private ExcelHelper excelHelper;

    @Test(dataProvider = "data_provider_addnewproduct_excel_hashtable", dataProviderClass = DataProviderFactory .class)
    public void testAddNewProductSuccess(Hashtable<String, String> data){

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
}
