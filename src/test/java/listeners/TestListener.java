package listeners;

import helpers.CaptureHelper;
import helpers.PropertiesHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    //Chạy trước nhất khi quá trình chạy một LỚP (CLASS) kiểm thử bắt đầu
    @Override //Ghi đè phương thức onStart của giao diện ITestListener (lớp cha)
    public void onStart(ITestContext arg0) {
        System.out.println("⭐ onStart");
        PropertiesHelper.loadAllFiles();
    }

    //Chạy sau khi tất cả các phương thức kiểm thử trong một LỚP (CLASS) kiểm thử đã chạy xong.
    @Override //Ghi đè phương thức onFinish của giao diện ITestListener (lớp cha)
    public void onFinish(ITestContext arg0) {
        System.out.println("⭐ onFinish");
    }

    //Chạy mỗi khi 1 @Test chạy (chạy // với mỗi testcase) (trong quá trình chạy)
    @Override //Ghi đè phương thức onTestStart của giao diện ITestListener (lớp cha)
    public void onTestStart(ITestResult arg0) {
        System.out.println("⭐ onTestStart");
        CaptureHelper.startRecord(arg0.getName());
    }

    //Chạy mỗi khi 1 ca kiểm thử vượt qua thành công (sau quá trình chạy)
    @Override //Ghi đè phương thức onTestSuccess của giao diện ITestListener (lớp cha)
    public void onTestSuccess(ITestResult arg0) {
        System.out.println("✅ onTestSuccess");
        CaptureHelper.screenshotSuccess(arg0.getName());
        CaptureHelper.stopRecord();
    }

    //Chạy mỗi khi 1 ca kiểm thử không thành công (sau quá trình chạy)
    @Override //Ghi đè phương thức onTestFailure của giao diện ITestListener (lớp cha)
    public void onTestFailure(ITestResult arg0) {
        System.out.println("❌ onTestFailure");
        CaptureHelper.screenshotFail(arg0.getName());
        CaptureHelper.stopRecord();
    }

    //Chạy mỗi khi 1 ca kiểm thử bị bỏ qua (sau quá trình chạy)
    @Override //Ghi đè phương thức onTestSkipped của giao diện ITestListener (lớp cha)
    public void onTestSkipped(ITestResult arg0) {
        System.out.println("\uD83D\uDD1C onTestSkipped");
        CaptureHelper.stopRecord();
    }
}
