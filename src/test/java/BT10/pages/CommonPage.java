package BT10.pages;

import keywords.WebUI;
import org.openqa.selenium.By;

//CommonPage là để lưu những Element không thuộc về bất kỳ trang nào cả
public class CommonPage {

    //Khởi tạo đối tượng trang
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AllProductsPage allProductsPage;
    private AddNewProductPage addNewProductPage;
    private CategoryPage categoryPage;
    private InHouseProductsPage inHouseProductsPage;

    //Khai báo hàm xây dựng
    public CommonPage() {
    }

    //Khai báo các element trên trang dạng đối tượng By (đối tượng By là đối tượng mới chỉ thiết lập cấu trúc chứ chưa tìm kiếm)
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuAllProducts = By.xpath("//span[normalize-space()='All products']");
    private By menuInHouseProducts = By.xpath("//span[normalize-space()='In House Products']");
    private By menuBrand = By.xpath("//span[normalize-space()='Brand']");

    //**Các hàm xử lý**
    //LIÊN KẾT TRANG: sau khi hàm clickMenuDashboard xử lý xong nó sẽ chuyển đến trang DashboardPage
    public DashboardPage clickMenuDashboard(){
        WebUI.clickElement(menuDashboard);

        //Khởi tạo mới cho trang DashboardPage
        return new DashboardPage();
    }

    public void clickMenuProducts(){
        WebUI.clickElement(menuProducts);
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuAllProducts xử lý xong nó sẽ chuyển đến trang AllProductsPage
    public AllProductsPage clickMenuAllProducts(){
        WebUI.clickElement(menuAllProducts);

        //Khởi tạo mới cho trang AllProductsPage
        return new AllProductsPage();
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuBrand xử lý xong nó sẽ chuyển đến trang BrandPage
    public BrandPage clickMenuBrand(){
        WebUI.clickElement(menuBrand);

        //Khởi tạo mới cho trang AllProductsPage
        return new BrandPage();
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuAllProductsWithMenuProducts xử lý xong nó sẽ chuyển đến trang AllProductsPage
    public AllProductsPage clickMenuAllProductsWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuAllProducts);
        WebUI.clickElement(menuAllProducts);

        //Khởi tạo mới cho trang AllProductsPage
        return new AllProductsPage();
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuCategoryWithMenuProducts xử lý xong nó sẽ chuyển đến trang CategoryPage
    public CategoryPage clickMenuCategoryWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuCategory);
        WebUI.clickElement(menuCategory);

        //Khởi tạo mới cho trang CategoryPage
        return new CategoryPage();
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuAddNewProductWithMenuProducts xử lý xong nó sẽ chuyển đến trang AddNewProductPage
    public AddNewProductPage clickMenuAddNewProductWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuAddNewProduct);
        WebUI.clickElement(menuAddNewProduct);

        //Khởi tạo mới cho trang AddNewProductPage
        return new AddNewProductPage();
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuInHouseProductsWithMenuProducts xử lý xong nó sẽ chuyển đến trang InHouseProductsPage
    public InHouseProductsPage clickMenuInHouseProductsWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuInHouseProducts);
        WebUI.clickElement(menuInHouseProducts);

        //Khởi tạo mới cho trang InHouseProductsPage
        return new InHouseProductsPage();
    }

    //LIÊN KẾT TRANG: sau khi hàm clickMenuBrandPageWithMenuProducts xử lý xong nó sẽ chuyển đến trang BrandPage
    public BrandPage clickMenuBrandPageWithMenuProducts(){
        clickMenuProducts();
        WebUI.waitForElementVisible(menuBrand);
        WebUI.clickElement(menuBrand);

        //Khởi tạo mới cho trang BrandPage
        return new BrandPage();
    }

}
