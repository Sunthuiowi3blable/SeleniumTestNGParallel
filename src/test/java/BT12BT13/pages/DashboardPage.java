package BT12BT13.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage extends CommonPage {

    //Khai báo hàm xây dựng
    public DashboardPage(){
    }

    //Khai báo các Element trên trang Dashboard đó
    private By totalCustomer = By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/div/div[2]");
    private By totalOrder = By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div/div[2]");
    private By totalProductCategory = By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[3]/div/div/div[2]");
    private By totalProductBrand = By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[4]/div/div/div[2]");

    //**Khai báo các hàm xử lý**

    //Hàm kiểm tra Total Customer
    public void checkTotalCustomer(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(totalCustomer), "FAIL!! The section Total Customer not display!");
        Assert.assertEquals(WebUI.getElementText(totalCustomer), "188", "FAIL!! Cutomer total not match!");
    }

    //Hàm kiểm tra Total Order
    public void checkTotalOrder(){
        Assert.assertTrue(WebUI.checkElementExist(totalOrder), "FAIL!! The section Total Order not display!");
        Assert.assertEquals(WebUI.getWebElement(totalOrder), "740", "FAIL!! Order total not match!");
    }

    //Hàm kiểm tra Total Product Category
    public void checkTotalProducCategory(){
        Assert.assertTrue(WebUI.checkElementExist(totalProductCategory), "FAIL!! The section Total Product Category not display!");
        Assert.assertEquals(WebUI.getElementText(totalProductCategory), "657", "FAIL!! Product Category total not match!");
    }

    //Hàm kiểm tra Total Product Brand
    public void checkTotalProductBrand(){
        Assert.assertTrue(WebUI.checkElementExist(totalProductBrand), "FAIL!! The section Total Product Brand not display!");
        Assert.assertEquals(WebUI.getElementText(totalProductBrand), "84", "FAIL!! Product Brand total not match!");
    }

}
