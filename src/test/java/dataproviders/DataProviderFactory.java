package dataproviders;

import helpers.ExcelHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "data_provider_login", parallel = true)
    public Object[][] dataProviderLogin(){
        return new Object[][]{
                {"admin@example.com", "123456"},
                {"admin@example.com", "123456"}
        };
    }

    @DataProvider(name = "data_provider_login_excel", parallel = true)
    public Object[][] dataProviderLoginFromExcel(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra toàn bộ dữ liệu trong file Excel chỉ định
        Object[][] data = excelHelper.getExcelData(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx","LoginDataProvider");
        System.out.println("Login Data from Excel: " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_hashtable", parallel = true)
    public Object[][] dataProviderLoginFromExcelWithHashtable(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra dữ liệu chỉ định trong file Excel chỉ định
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx", "LoginDataProvider", 1, 3);
        System.out.println("Login Data from Excel (Hashtable): " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }

    @DataProvider(name = "data_provider_login_fail_with_email_null_excel_hashtable", parallel = true)
    public Object[][] dataProviderLoginFailWithEmailNullFromExcelWithHashtable(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra dữ liệu chỉ định trong file Excel chỉ định
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx", "LoginDataProvider", 4, 6);
        System.out.println("Login Data from Excel (Hashtable): " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }

    @DataProvider(name = "data_provider_addnewproduct_excel_hashtable", parallel = true)
    public Object[][] dataProviderAddNewProductFromExcelWithHashtable(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra dữ liệu chỉ định trong file Excel chỉ đinh
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx", "AddNewProduct", 1, 3);
        System.out.println("Add New Product from Excel (Hashtable): " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }

    @DataProvider(name = "data_provider_brand_excel_hashtable", parallel = true)
    public Object[][] dataProviderBrandFromExcelWithHashtable(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra dữ liệu chỉ định trong file Excel chỉ đinh
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx", "Brand", 1, 3);
        System.out.println("Add New Product from Excel (Hashtable): " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }

    @DataProvider(name = "data_provider_category_excel_hashtable", parallel = true)
    public Object[][] dataProviderCategoryFromExcelWithHashtable(){
        //Khởi tạo đối tượng
        ExcelHelper excelHelper = new ExcelHelper();

        //Lấy ra dữ liệu chỉ định trong file Excel chỉ đinh
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataTest.xlsx", "Category", 1, 3);
        System.out.println("Add New Product from Excel (Hashtable): " + data);

        //Trả về data Object[][] (object 2 chiều)
        return data;
    }

}
