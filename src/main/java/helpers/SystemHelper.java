package helpers;

import java.io.File;

public class SystemHelper {

    //getCurrentDir: get thư mục soure hiện tại
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
