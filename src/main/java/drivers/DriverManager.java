package drivers;

import org.openqa.selenium.WebDriver;

//Class toàn cục hỗ trợ hàm toàn cục là getDriver
public class DriverManager {

    //ThreadLocal là thuộc cua Java hỗ trợ chạy code đa luồng
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    //Gọi hàm này lấy giá trị driver từ trong ThreadLocal mang ra sử dụng
    public static WebDriver getDriver() {
        return driver.get(); //get này thuộc của ThreadLocal chứ không phải của Selenium
    }

    //Gọi hàm này set giá trị driver vào trong ThreadLocal
    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver); //set này thuộc của ThreadLocal chứ không phải của Selenium
    }

    //Hàm quit dùng để xóa đi các section (phần) mà đã chạy xong
    public static void quit() {
        DriverManager.driver.get().quit(); //Hàm driver.get().quit() là lấy ra giá trị hiện tại ở trong driver trong ThreadLocal và đóng nó lại. Hàm get() là của ThreadLocal. Hàm quit() là của selenium.
        driver.remove(); //Xóa vùng nhớ dữ liệu trong ThreadLocal (giải phóng bộ nhớ của ThreadLocal đó). Hàm remove này là của ThreadLocal
    }
}
