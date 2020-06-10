package Model;

public class Model {
    private String findString;
    private String replaceString;
    private String countString;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCountString() {
        return countString;
    }

    public void setCountString(String countString) {
        this.countString = countString;
    }

    public String getFindString() {
        return findString;
    }

    public void setFindString(String findString) {
        this.findString = findString;
    }

    public String getReplaceString() {
        return replaceString;
    }

    public void setReplaceString(String replaceString) {
        this.replaceString = replaceString;
    }
}
