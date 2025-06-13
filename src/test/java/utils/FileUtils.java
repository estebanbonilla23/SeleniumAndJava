package utils;

import java.io.File;

public class FileUtils {
    public static void deleteFileIfExists(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("File does not exist: " + filePath);
        }
    }
}
