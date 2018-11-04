package solution;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    private String path;
    private boolean fileAppend = false;

    public WriteFile(String filePath){
        path = filePath;
    }

    public WriteFile(String filePath, boolean appendValue){
        path = filePath;
        fileAppend = appendValue;
    }

    public void writetoFile(String textLine) throws IOException{
        FileWriter write = new FileWriter(path, fileAppend);
        PrintWriter printWriter = new PrintWriter(write);

        printWriter.printf("%s" + "%n", textLine);

        printWriter.close();
    }
}
