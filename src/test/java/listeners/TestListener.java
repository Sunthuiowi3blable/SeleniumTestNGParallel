package listeners;

import helpers.CaptureHelper;
import helpers.PropertiesHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LogUtils;

public class TestListener implements ITestListener {

    //Chạy trước nhất khi quá trình chạy một LỚP (CLASS) kiểm thử bắt đầu
    @Override //Ghi đè phương thức onStart của giao diện ITestListener (lớp cha). Việc ghi đè này cho phép lớp con có thể thay đổi hoặc mở rộng hành vi của phương thức đó.
    public void onStart(ITestContext iTestContext) {
        LogUtils.info("⭐ ********* START TESTING " + iTestContext.getName() + " *********");
        PropertiesHelper.loadAllFiles();
    }

    //Chạy sau khi tất cả các phương thức kiểm thử trong một LỚP (CLASS) kiểm thử đã chạy xong.
    @Override //Ghi đè phương thức onFinish của giao diện ITestListener (lớp cha). Việc ghi đè này cho phép lớp con có thể thay đổi hoặc mở rộng hành vi của phương thức đó.
    public void onFinish(ITestContext iTestContext) {
        LogUtils.info("⭐ ********* END TESTING " + iTestContext.getName() + " *********");
    }

    //Chạy mỗi khi 1 @Test chạy (chạy // với mỗi testcase) (trong quá trình chạy). Việc ghi đè này cho phép lớp con có thể thay đổi hoặc mở rộng hành vi của phương thức đó.
    @Override //Ghi đè phương thức onTestStart của giao diện ITestListener (lớp cha)
    public void onTestStart(ITestResult iTestResult) {
        LogUtils.info("⭐ Starting test case " + iTestResult.getName());

        //Nếu giá trị "RECORD_VIDEO" = true thì nó sẽ record video, bằng false thì không record video
        if (PropertiesHelper.getValue("RECORD_VIDEO").equals("true")){
            CaptureHelper.startRecord(iTestResult.getName());
        }
    }

    //Chạy mỗi khi 1 ca kiểm thử vượt qua thành công (sau quá trình chạy). Việc ghi đè này cho phép lớp con có thể thay đổi hoặc mở rộng hành vi của phương thức đó.
    @Override //Ghi đè phương thức onTestSuccess của giao diện ITestListener (lớp cha)
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info("✅ Test case " + iTestResult.getName() + " passedd.");

        //Nếu giá trị "SCREENSHOT_STEP_PASS" = true thì nó sẽ screenshot, bằng false thì không screenshot
        if (PropertiesHelper.getValue("SCREENSHOT_STEP_PASS").equals("true")){
            CaptureHelper.screenshotSuccess(iTestResult.getName());
        }

        //Nếu giá trị "RECORD_VIDEO" = true thì nó sẽ record video, bằng false thì không record video
        if (PropertiesHelper.getValue("RECORD_VIDEO").equals("true")) {
            CaptureHelper.stopRecord();
        }
    }

    //Chạy mỗi khi 1 ca kiểm thử không thành công (sau quá trình chạy). Việc ghi đè này cho phép lớp con có thể thay đổi hoặc mở rộng hành vi của phương thức đó.
    @Override //Ghi đè phương thức onTestFailure của giao diện ITestListener (lớp cha)
    public void onTestFailure(ITestResult iTestResult) {
        LogUtils.error("❌ Test case " + iTestResult.getName() + " failed.");

        //Lấy ra lý do lỗi
        LogUtils.error(iTestResult.getThrowable());

        //Nếu giá trị "SCREENSHOT_STEP_FAIL" = true thì nó sẽ screenshot, bằng false thì không screenshot
        if (PropertiesHelper.getValue("SCREENSHOT_STEP_FAIL").equals("true")){
            CaptureHelper.screenshotFail(iTestResult.getName());
        }

        //Nếu giá trị "RECORD_VIDEO" = true thì nó sẽ record video, bằng false thì không record video
        if (PropertiesHelper.getValue("RECORD_VIDEO").equals("true")) {
            CaptureHelper.stopRecord();
        }
    }

    //Chạy mỗi khi 1 ca kiểm thử bị bỏ qua (sau quá trình chạy). Việc ghi đè này cho phép lớp con có thể thay đổi hoặc mở rộng hành vi của phương thức đó.
    @Override //Ghi đè phương thức onTestSkipped của giao diện ITestListener (lớp cha)
    public void onTestSkipped(ITestResult iTestResult) {
        LogUtils.warn("\uD83D\uDD1C Test case " + iTestResult.getName() + " skipped.");

        //Nếu giá trị "RECORD_VIDEO" = true thì nó sẽ record video, bằng false thì không record video
        if (PropertiesHelper.getValue("RECORD_VIDEO").equals("true")) {
            CaptureHelper.stopRecord();
        }
    }
}
