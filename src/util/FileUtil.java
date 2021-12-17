package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readFileByLine(String filePath) {
        List<String> res = new ArrayList<>();
        File f = new File(filePath);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));

            String line;
            while((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return res;
    }
}
