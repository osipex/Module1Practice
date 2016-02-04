import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by pooh on 03.02.2016.
 *
 */
public class FileEventLogger implements EventLogger {

    public String filename;
    public File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public FileEventLogger() {
    }


    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file,event.toString(),true);
        } catch (IOException e) {
            System.out.println("Some problem with file");
        }
    }

    public void init() throws IOException{
        this.file = new File(filename);
        if(!file.canWrite()) throw new IOException(String.format("File '%s' is not avaialbe", filename));
    }
}
