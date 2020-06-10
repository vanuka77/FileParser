package Service;

import Model.Model;
import Service.Storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public void writeToFile(Storage storage, File file) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < storage.getLines().size(); i++) {
            bufferedWriter.write(storage.getLines().get(i));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
