package Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public void readFromFile(Storage storage, File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            storage.getLines().add(line);
        }
        reader.close();
    }
}
