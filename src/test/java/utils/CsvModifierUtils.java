package utils;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvModifierUtils {

    /**
     * Updates the 'Nickname' and 'Usage' fields in a tab-separated CSV file using today's date.
     *
     * @param inputFilePath  The path to the original CSV file
     * @throws IOException If there's an error reading or writing the file
     */
    public static void updateNicknameAndUsage(String inputFilePath) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(inputFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> updatedLines = new ArrayList<>();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Preserve header
        if (!lines.isEmpty()) {
            updatedLines.add(lines.get(0));
        }

        for (int i = 1; i < lines.size(); i++) {
            String[] columns = lines.get(i).split(",", -1); // split using tab, keep empty fields

            if (columns.length >= 13) {
                columns[2] = today + "_" + i;               // Nickname (column index 2)
                columns[9] = today + i;        // Usage (column index 9)
            }

            updatedLines.add(String.join(",", columns));
        }

        try {
            Files.write(Paths.get(inputFilePath), updatedLines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
