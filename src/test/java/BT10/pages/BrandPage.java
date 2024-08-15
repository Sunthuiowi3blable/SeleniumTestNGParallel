package BT10.pages;

import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Hashtable;

public class BrandPage extends CommonPage {

    public BrandPage() {
    }

    //Khởi tạo đối tượng ExcelHelper (file Excel)
    ExcelHelper excelHelper;

    //**Khai báo các Element dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)**
    //Search
    private By inputSearchBrand = By.xpath("//input[@id='search']");

    //Name
    private By inputBrandName = By.xpath("//input[@name='name']");

    //Logo(120x80)
    private By buttonBrowseLogo = By.xpath("//input[@name='logo']/preceding-sibling::div[2]");
    private By inputSearchLogo = By.xpath("//input[@name='aiz-uploader-search']");
    private By itemLogo = By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]/div");
    private By buttonAddFilesLogo = By.xpath("//button[normalize-space()='Add Files']");

    //Meta Title
    private By inputMetaTitle = By.xpath("//input[@name='meta_title']");

    //Meta description
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");

    //Save
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");

    //Item New Brand
    private By itemBrand = By.xpath("(//td[normalize-space()='Brand MH Final 08-2024'])[1]");

    // **Hàm xử lý cho trang Brand**
    //Hàm thay đổi Xpath itemBrand theo Name Brand
    public String changeItemBrandXpath(Hashtable <String, String> data){
        return WebUI.getElementText(By.xpath("(//td[normalize-space()='"+ data.get("NAME") +"'])[1]"));
    }

    //Hàm nhập thông tin trong trang Brand
    public void enterDataBrand(Hashtable<String, String> data){

        WebUI.setText(inputBrandName, data.get("NAME"));
        WebUI.clickElement(buttonBrowseLogo);
        WebUI.sleep(2);
        WebUI.setText(inputSearchLogo, data.get("LOGO"));
        WebUI.setKey(inputSearchLogo, Keys.ENTER);
        //WebUI.waitForElementClickable(itemLogo);
        WebUI.sleep(1);
        WebUI.clickElement(itemLogo);
        WebUI.clickElement(buttonAddFilesLogo);
        WebUI.waitForElementClickable(inputMetaTitle);
        WebUI.setText(inputMetaTitle, data.get("META TITLE"));
        WebUI.setText(inputMetaDescription, data.get("META DESCRIPTION"));
        WebUI.clickElement(buttonSave);
    }

    //Hàm kiểm tra xem New Brand đã được add thành công chưa
    public void verifySearchBrand(Hashtable<String, String> data){
        WebUI.sleep(2);
        WebUI.setText(inputSearchBrand, data.get("NAME"));
        WebUI.setKey(inputSearchBrand, Keys.ENTER);
        WebUI.waitForPageLoaded();
        WebUI.assertEquals(changeItemBrandXpath(data), data.get("NAME"), "FAIL!! The item new brand not match.");
        System.out.println("New Brand: " + changeItemBrandXpath(data));
    }
}
