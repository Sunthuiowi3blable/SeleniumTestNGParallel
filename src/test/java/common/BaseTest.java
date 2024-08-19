package common;

import drivers.DriverManager;
import helpers.PropertiesHelper;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeSuite
    public void setupEnviroment(){
        PropertiesHelper.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"}) //Khai báo tham số cho phương thức test
    //@Optional chỉ chạy trong trường hợp không truyền tham số (tham số được tuyền trong file xml), còn nếu đã truyền sẽ không chạy optional mà chạy theo hàm setupDriver
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver;

        //Nếu như giá trị trong config.properties khác Null (có giá trị) và khác empty (có giá trị) thì sẽ lấy giá trị từ config.properties, ngược lại sẽ lấy giá trị từ tham số được truyền từ file xml hoặc @Optional
        if (PropertiesHelper.getValue("BROWSER") != null && !PropertiesHelper.getValue("BROWSER").isEmpty()){
            driver = setupDriver(PropertiesHelper.getValue("BROWSER"));
        }else {
            driver = setupDriver(browser);
        }
        DriverManager.setDriver(driver); //Gán giá trị driver vào trong ThreadLocal
    }

    //Khi đã truyền tham số (tham số được truyền trong file xml) vào sẽ chạy hàm này
    public WebDriver setupDriver(String browserName) {
        WebDriver driver; //driver là để mang giá trị tạm thời

        switch (browserName.trim().toLowerCase()) { //.trim là để xóa khoảng trắng 2 đầu, .toLowerCase là để chuyển tất cả tên truyền vào về dạng chữ thường
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default: //Khi mà dữ liệu truyền vào bị sai thì sẽ chạy default là Chrome
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closerDriver(){

        //Trước khi tắt driver trong trường hợp testcase bị fail thì sẽ chụp màn hình cái đoạn dừng bị fail đó rồi mới tắt
        DriverManager.quit();
    }
}
