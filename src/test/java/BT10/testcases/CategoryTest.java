package BT10.testcases;

import BT10.pages.CategoryPage;
import BT10.pages.DashboardPage;
import BT10.pages.LoginPage;
import common.BaseTest;
import constants.ConfigData;
import dataproviders.DataProviderFactory;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CategoryTest extends BaseTest {

    //Khởi tạo đối tượng trang
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CategoryPage categoryPage;
    private ExcelHelper excelHelper;

    @Test (dataProvider = "data_provider_category_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testAddNewCategory (Hashtable<String, String> data){

        //Khởi tạo đối tượng
        loginPage = new LoginPage();

        //Khởi tạo đối tượng ExcelHelper để sử dụng file Excel
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Login");

        //LIÊN KẾT TRANG: Khi loginCMS đăng nhập xong thì nó sẽ chuyển đến dashboardPage
        dashboardPage = loginPage.loginCMS(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));

        //LIÊN KẾT TRANG: từ trang dashboardPage sang trang categoryPage
        categoryPage = dashboardPage.clickMenuCategoryWithMenuProducts();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Category");

        categoryPage.clickButtonAddNewCategory();
        categoryPage.enterDataAddNewCategory(data);
        categoryPage.checkCategoryInTableList(data);
        categoryPage.checkCategoryDetail(data);
    }
}
