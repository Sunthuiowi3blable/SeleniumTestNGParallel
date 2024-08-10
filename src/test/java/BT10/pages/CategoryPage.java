package BT10.pages;

import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CategoryPage extends CommonPage {

    //Phải có hàm xây dựng cho từng class Page
    public CategoryPage(){
    }

    //Khởi tạo đối tượng ExcelHelper (file Excel)
    ExcelHelper excelHelper;

    //**Khai báo các element trên trang Category đó dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)**

        private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");

        //Name
        private By inputName = By.xpath("//input[@id='name']");

        //Parent Category
        private By selectParentCategory = By.xpath("//select[@name='parent_id']/following-sibling::button");
        private By inputParentCategory = By.xpath("//div[@id='bs-select-1']/preceding-sibling::div[1]/input[1]");

        //Ordering Number
        private By inputOrderingNumber = By.xpath("//input[@id='order_level']");

        //Type
        private By selectType = By.xpath("//div[@id='bs-select-2']/parent::div/preceding-sibling::button[1]");
        private By buttonType = By.xpath("//a[@id='bs-select-2-0']");

        //Banner (200x200)
        private By buttonBrowseBanner = By.xpath("(//div[normalize-space()='Browse'])[2]");
        private By inputSearchBanner = By.xpath("//input[@name='aiz-uploader-search']");
        private By fileBanner = By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]");
        private By buttonAddFilesBanner = By.xpath("//button[normalize-space()='Add Files']");

        //Icon (32x32)
        private By buttonBrowseIcon = By.xpath("(//div[normalize-space()='Browse'])[4]");
        private By inputSearchIcon = By.xpath("//input[@name='aiz-uploader-search']");
        private By fileIcon = By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]");
        private By buttonAddFilesIcon = By.xpath("//button[normalize-space()='Add Files']");

        //Meta Title
        private By inputMetaTitle = By.xpath("//input[@name='meta_title']");

        //Meta description
        private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");

        //Filtering Attributes
        private By selectFilteringAttributes = By.xpath("//select[@name='filtering_attributes[]']/following-sibling::button");
        private By inputFilteringAttributes = By.xpath("//div[@id='bs-select-3']/preceding-sibling::div/input");

        //Save
        private By buttonSave = By.xpath("//button[normalize-space()='Save']");

        //Search
        private By inputSearch = By.xpath("//input[@id='search']");

        //Giá trị vừa Add
        private By newCategory = By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[2]");

        //Nút xem chi tiết thông tin category
        private By buttonDetailCategory = By.xpath("//form[@id='sort_categories']/parent::div/following-sibling::div//tbody//td[10]/a[1]");

    //**Hàm xử lý cho trang Category**

    //Hàm click chọn nút Add New Category
    public void clickButtonAddNewCategory(){
        WebUI.waitForElementVisible(buttonAddNewCategory);
        WebUI.clickElement(buttonAddNewCategory);
    }

    //Hàm nhập thông tin trong trang sau khi ấn nút Add New Category
    public void enterDataAddNewCategory(String categoryName, String parentCategoryName){

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Category");

        WebUI.waitForPageLoaded();
        WebUI.setText(inputName, categoryName);

        WebUI.clickElement(selectParentCategory);
        WebUI.setText(inputParentCategory, parentCategoryName);
        WebUI.setKey(inputParentCategory, Keys.ENTER);

        WebUI.setText(inputOrderingNumber, excelHelper.getCellData("ORDERING NUMBER", 1));

        WebUI.clickElement(selectType);
        WebUI.clickElement(buttonType);

        WebUI.clickElement(buttonBrowseBanner);
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearchBanner, excelHelper.getCellData("BANNER", 1));
        WebUI.setKey(inputSearchBanner, Keys.ENTER);
        WebUI.sleep(2);
        WebUI.clickElement(fileBanner);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddFilesBanner);

        WebUI.sleep(2);

        WebUI.clickElement(buttonBrowseIcon);
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearchIcon, excelHelper.getCellData("ICON", 1));
        WebUI.setKey(inputSearchIcon, Keys.ENTER);
        WebUI.sleep(2);
        WebUI.clickElement(fileIcon);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddFilesIcon);
        WebUI.waitForPageLoaded();

        WebUI.sleep(1);

        WebUI.setText(inputMetaTitle, excelHelper.getCellData("META TITLE", 1));

        WebUI.setText(inputMetaDescription, excelHelper.getCellData("META DESCRIPTION", 1));

        WebUI.clickElement(selectFilteringAttributes);
        WebUI.setText(inputFilteringAttributes, excelHelper.getCellData("FILTERING ATTRIBUTES", 1));
        WebUI.setKey(inputFilteringAttributes, Keys.ENTER);
        WebUI.clickElement(selectFilteringAttributes);

        WebUI.clickElement(buttonSave);
    }

    //Hàm kiểm tra bằng việc tìm kiếm giá trị vừa Add và gettext giá trị vừa Add ra
    public void checkCategoryInTableList(String categoryName){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearch, categoryName);
        WebUI.setKey(inputSearch, Keys.ENTER);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);

        Assert.assertTrue(WebUI.checkElementExist(newCategory), "FAIL!! The category name not display in table.");
        WebUI.assertEquals(WebUI.getElementText(newCategory), categoryName, "FAIL!! The new category not match.");
        System.out.println("New Category: " + WebUI.getElementText(newCategory));
    }

    //Hàm kiểm tra lại các giá trị thông tin vừa được Add vào
    public void checkCategoryDetail(String categoryName, String parentCategoryName){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonDetailCategory);
        WebUI.waitForPageLoaded();
        WebUI.assertEquals(WebUI.getElementAttribute(inputName, "value"), categoryName, "FAIL!! The category name not match.");
        WebUI.assertEquals(WebUI.getElementAttribute(selectParentCategory, "title"), "-- " + parentCategoryName, "FAIL!! The parent category name not match.");
        WebUI.assertEquals(WebUI.getElementAttribute(inputOrderingNumber, "value"), excelHelper.getCellData("ORDERING NUMBER", 1), "FAIL!! The ordering number not match.");
        WebUI.assertEquals(WebUI.getElementAttribute(selectType, "title"), "Physical", "FAIL!! The type not match.");
        WebUI.assertEquals(WebUI.getElementAttribute(inputMetaTitle, "value"), excelHelper.getCellData("META TITLE", 1), "FAIL!! The meta title not match.");
        WebUI.assertEquals(WebUI.getElementText(inputMetaDescription), excelHelper.getCellData("META DESCRIPTION", 1), "FAIL!! The meta description not match.");
        WebUI.assertEquals(WebUI.getElementAttribute(selectFilteringAttributes, "title"), excelHelper.getCellData("FILTERING ATTRIBUTES", 1), "FAIL!! The filtering attributes not match.");
    }
}
