package BT10.pages;

import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Hashtable;

public class AllProductsPage extends CommonPage {

    //Khai báo hàm xây dựng
    public AllProductsPage(){
    }

    //Khởi tạo đối tượng ExcelHelper (file Excel)
    ExcelHelper excelHelper;

    //**Khai báo các element trên trang All Products đó dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)**
    private By inputSearch = By.xpath("//input[@id='search']");
    private By itemNewProduct = By.xpath("(//td[normalize-space()='GIOQUAMH'])[1]");
    private By buttonEdit = By.xpath("(//tbody//a[@title='Edit'])[1]");

    // **Hàm xử lý cho trang All Products**
    //Hàm thay đổi Xpath itemNewProduct theo PRODUCT NAME
    public String changeItemNewProductXpath(String productName){
        return WebUI.getElementText(By.xpath("(//td[normalize-space()='"+ productName +"'])[1]"));
    }

    public void verifySearchProduct(Hashtable<String, String> data){

        //Khởi tạo đối tượng ExcelHelper (file Excel)
        excelHelper = new ExcelHelper();

        //Đọc Data từ file Excel
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "AddNewProduct");

        WebUI.setText(inputSearch, data.get("PRODUCT NAME"));
        WebUI.setKey(inputSearch, Keys.ENTER);

        WebUI.assertEquals(changeItemNewProductXpath(data.get("PRODUCT NAME")), data.get("PRODUCT NAME"), "FAIL!! The new product not match.");
        System.out.println("Text Product: " + changeItemNewProductXpath(data.get("PRODUCT NAME")));
    }

    public void searchProduct(Hashtable <String, String> data){
        WebUI.setText(inputSearch, data.get("PRODUCT NAME"));
        WebUI.setKey(inputSearch, Keys.ENTER);
    }

    public InHouseProductsPage clickButtonEdit(){
        WebUI.clickElement(buttonEdit);

        //Khởi tạo mới cho trang InHouseProductsPage
        return new InHouseProductsPage();
    }

}
