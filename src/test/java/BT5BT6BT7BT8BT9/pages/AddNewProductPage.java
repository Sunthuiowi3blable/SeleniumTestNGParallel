package BT5BT6BT7BT8BT9.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AddNewProductPage extends CommonPage{

    //Khai báo hàm xây dựng
    public AddNewProductPage(){
    }

    //**Khai báo các element trên trang Add New Product đó dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)**
    //Product Name
    private By inputProductName = By.xpath("//input[@placeholder='Product Name']");

    //Category*
    private By selectCategory = By.xpath("//button[@data-id='category_id']");
    private By inputCategory = By.xpath("//button[@data-id='category_id']/following-sibling::div//input");

    //Brand
    private By selectBrand = By.xpath("//button[@data-id='brand_id']");
    private By inputBrand = By.xpath("//button[@data-id='brand_id']/following-sibling::div//input");

    //Unit
    private By inputUnit = By.xpath("//input[@name='unit']");

    //Weight (In Kg)
    private By inputWeight = By.xpath("//input[@name='weight']");

    //Minimum Purchase Qty
    private By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");

    //Tags*
    private By inputTags = By.xpath("//input[@name='tags[]']/preceding-sibling::tags");

    //Gallery Images (600x600)
    private By buttonBrowseGalleryImages = By.xpath("(//div[normalize-space()='Browse'])[2]");
    private By inputSearchGalleryImages = By.xpath("//input[@name='aiz-uploader-search']");
    private By itemGalleryImages = By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]/div");
    private By buttonAddFilesGalleryImages = By.xpath("//button[normalize-space()='Add Files']");

    //Thumbnail Images (300x300)
    private By buttonBrowseThumbnailImages = By.xpath("(//div[normalize-space()='Browse'])[4]");
    private By inputSearchThumbnailImages = By.xpath("//input[@name='aiz-uploader-search']");
    private By itemThumbnailImages = By.xpath("//div[@id='aiz-select-file']/div[2]/div[1]/div");
    private By buttonAddFilesThumbnailImages = By.xpath("//button[normalize-space()='Add Files']");

    //Video Provider
    private By selectVideoProvider = By.xpath("//button[@data-id='video_provider']");
    private By itemVideoProvider = By.xpath("//div[@id='bs-select-3']/ul[1]/li[1]");

    //Video Link
    private By inputVideoLink = By.xpath("//input[@name='video_link']");

    //Colors
    private By buttonColors = By.xpath("//input[@name='colors_active']/following-sibling::span");

    private By selectColors = By.xpath("//button[@data-id='colors']");

    private By primaryItemColors = By.xpath("//div[@id='bs-select-4']/ul[1]/li[2]");
    private By secondaryItemColors = By.xpath("//div[@id='bs-select-4']/ul[1]/li[5]");
    private By tertiaryItemColors = By.xpath("//div[@id='bs-select-4']/ul[1]/li[6]");
    private By quaternaryItemColors = By.xpath("//div[@id='bs-select-4']/ul[1]/li[8]");
    private By quinaryItemColors = By.xpath("//div[@id='bs-select-4']/ul[1]/li[9]");

    //Attributes
    private By selectAttributes = By.xpath("//button[@data-id='choice_attributes']");
    private By itemAttributes = By.xpath("//a[@id='bs-select-5-0']");

    //Size
    private By selectSize = By.xpath("//select[@name='choice_options_1[]']/following-sibling::button");
    private By inputSize = By.xpath("//div[@id='bs-select-10']/preceding-sibling::div/input");
    private By primaryItemSize = By.xpath("//a[@id='bs-select-10-0']");
    private By secondaryItemSize = By.xpath("//a[@id='bs-select-10-1']");

    //Unit price*
    private By inputUnitPrice = By.xpath("//input[@name='unit_price']");

    //Discount Date Range
    private By selectDiscountDateRange = By.xpath("//input[@name='date_range']");

    //**1
    private By itemDepartureDay = By.xpath("(//td[@data-title='r2c3'])[1]");

    private By selectDepartureHour = By.xpath("(//select[@class='hourselect'])[1]");
    private By itemDepartureHour = By.xpath("(//option[@value='5'])[2]");

    private By selectDepartureMinute = By.xpath("(//select[@class='minuteselect'])[1]");
    private By itemDepartureMinute = By.xpath("(//option[@value='15'])[1]");

    private By selectDepartureTime = By.xpath("(//select[@class='ampmselect'])[1]");
    private By itemDepartureTime = By.xpath("(//option[@value='PM'])[1]");

    //**2
    private By itemReturnDay = By.xpath("(//td[@data-title='r3c4'])[2]");

    private By selectReturnHour = By.xpath("(//select[@class='hourselect'])[2]");
    private By itemReturnHour = By.xpath("(//option[@value='7'])[3]");

    private By selectReturnMinute = By.xpath("(//select[@class='minuteselect'])[2]");
    private By itemReturnMinute = By.xpath("(//option[@value='20'])[3]");

    private By selectReturnTime = By.xpath("(//select[@class='ampmselect'])[2]");
    private By itemReturnTime = By.xpath("(//option[@value='PM'])[2]");

    //**Select
    private By buttonSelect = By.xpath("(//button[normalize-space()='Select'])[3]");

    //Discount*
    private By inputDiscount = By.xpath("//input[@name='discount']");
    private By selectDiscount = By.xpath("(//button[@title='Flat'])[1]");
    private By itemDiscount = By.xpath("//a[@id='bs-select-6-1']");

    //External link
    private By inputExternalLink = By.xpath("//input[@name='external_link']");

    //External link button text
    private By inputExternalLinkButtonText = By.xpath("//input[@name='external_link_btn']");

    //Meta Title
    private By inputMetaTitle = By.xpath("//input[@name='meta_title']");

    //Description
    private By inputDescription = By.xpath("//textarea[@name='meta_description']");

    //Meta Image
    private By buttonBrowseMetaImage = By.xpath("//label[normalize-space()='Meta Image']/following-sibling::div/div[1]/div[1]");
    private By inputSearchMetaImage = By.xpath("//input[@name='aiz-uploader-search']");
    private By itemMetaImage = By.xpath("/html/body/div[3]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div");
    private By buttonAddFilesMetaImage = By.xpath("//button[normalize-space()='Add Files']");

    //Quantity
    private By inputQuantity = By.xpath("//input[@name='low_stock_quantity']");

    //Tax
    private By inputTax = By.xpath("//input[@name='tax[]']");
    private By selectTax = By.xpath("//select[@name='tax_type[]']/following-sibling::button");
    private By itemTax = By.xpath("//a[@id='bs-select-9-1']");

    //Save & Publish
    private By buttonSavePublish = By.xpath("//button[normalize-space()='Save & Publish']");

    // **Hàm xử lý cho trang Add New Product**
    //Hàm thay đổi xpath item Tax
    public void selecttax(String itemTax){
        WebUI.clickElement(selectTax);
        WebUI.clickElement(By.xpath("//a[@id='bs-select-9-"+ itemTax +"']"));
    }

    //Hàm nhập thông tin trong trang
    public void enterDataAddNewProduct(String productName, String categoryName){
        WebUI.waitForPageLoaded();

        WebUI.setText(inputProductName, productName);

        WebUI.clickElement(selectCategory);
        WebUI.setText(inputCategory, categoryName);
        WebUI.setKey(inputCategory, Keys.ENTER);

        WebUI.clickElement(selectBrand);
        WebUI.setText(inputBrand, "qc test");
        WebUI.setKey(inputBrand, Keys.ENTER);

        WebUI.setText(inputUnit, "3");

        WebUI.clearText(inputWeight);
        WebUI.setText(inputWeight, "21");

        WebUI.clearText(inputMinimumPurchaseQty);
        WebUI.setText(inputMinimumPurchaseQty, "8");

        WebUI.setText(inputTags, "sun");

        WebUI.clickElement(buttonBrowseGalleryImages);
        WebUI.setText(inputSearchGalleryImages, "Cosy");
        WebUI.sleep(2);
        WebUI.clickElement(itemGalleryImages);
        WebUI.clickElement(buttonAddFilesGalleryImages);

        WebUI.clickElement(buttonBrowseThumbnailImages, 30);
        WebUI.setText(inputSearchThumbnailImages, "gio-qua-2");
        WebUI.sleep(1);
        WebUI.clickElement(itemThumbnailImages);
        WebUI.clickElement(buttonAddFilesThumbnailImages);

        WebUI.sleep(2);

        WebUI.clickElement(selectVideoProvider);
        WebUI.clickElement(itemVideoProvider, 30);

        WebUI.setText(inputVideoLink, "sunthuiowi.com");

        WebUI.clickElement(buttonColors);
        WebUI.clickElement(selectColors);
        WebUI.clickElement(primaryItemColors);
        WebUI.clickElement(secondaryItemColors);
        WebUI.clickElement(tertiaryItemColors);
        WebUI.clickElement(quaternaryItemColors);
        WebUI.clickElement(quinaryItemColors);
        WebUI.clickElement(buttonColors);

        WebUI.clickElement(selectAttributes);
        WebUI.clickElement(itemAttributes);
        WebUI.clickElement(selectAttributes);

        WebUI.clickElement(selectSize);
        WebUI.setText(inputSize, "22");
        WebUI.setKey(inputSize, Keys.ENTER);
        WebUI.clearText(inputSize);
        WebUI.setText(inputSize, "23");
        WebUI.setKey(inputSize, Keys.ENTER);
        WebUI.clickElement(selectSize);

        WebUI.clearText(inputUnitPrice);
        WebUI.setText(inputUnitPrice, "3");

        WebUI.clickElement(selectDiscountDateRange);
        WebUI.clickElement(itemDepartureDay);
        WebUI.clickElement(itemDepartureHour);
        WebUI.clickElement(itemDepartureMinute);
        WebUI.clickElement(itemDepartureTime);

        WebUI.clickElement(itemReturnDay);
        WebUI.clickElement(itemReturnHour);
        WebUI.clickElement(itemReturnMinute);
        WebUI.clickElement(itemReturnTime);

        WebUI.clickElement(buttonSelect);

        WebUI.clearText(inputDiscount);
        WebUI.setText(inputDiscount, "1");
        WebUI.clickElement(selectDiscount);
        WebUI.clickElement(itemDiscount);

        WebUI.setText(inputExternalLink, "therkat.com");

        WebUI.setText(inputExternalLinkButtonText, "button");

        WebUI.setText(inputMetaTitle, "SẢN PHẨM TỐT");

        WebUI.setText(inputDescription, "Sản phẩm chất lượng hàng đầu");

        WebUI.clickElement(buttonBrowseMetaImage);
        WebUI.setText(inputSearchMetaImage, "gio-qua-2");
        WebUI.sleep(2);
        WebUI.clickElement(itemMetaImage);
        WebUI.clickElement(buttonAddFilesMetaImage);

        WebUI.sleep(2);

        WebUI.clearText(inputQuantity);
        WebUI.setText(inputQuantity, "19");

        WebUI.clearText(inputTax);
        WebUI.setText(inputTax, "15");
        selecttax("0");
    }

    public AllProductsPage clickButtonSavePublish(){
        WebUI.clickElement(buttonSavePublish);
        WebUI.sleep(5);

        //Khởi tạo mới cho trang AllProductsPage
        return new AllProductsPage();
    }
}
