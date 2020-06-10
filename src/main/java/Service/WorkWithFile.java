package Service;

import Model.Model;
import Validator.Validator;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithFile {

    File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void replaceString(Storage storage, Model model) {
        for (int i = 0; i < storage.lines.size(); i++) {
            String s = storage.getLines().get(i).replaceAll(model.getFindString(), model.getReplaceString());
            storage.getLines().remove(storage.getLines().get(i));
            storage.getLines().add(i,s);
        }
    }

    public int countAmountOfStrings(Storage storage, Model model) {
        Pattern p = Pattern.compile(model.getCountString());
        int count = 0;
        for (int i = 0; i < storage.getLines().size(); i++) {
            Matcher matcher = p.matcher(storage.getLines().get(i));
            while (matcher.find()) {
                count++;
            }
        }
        return count;
    }
}

