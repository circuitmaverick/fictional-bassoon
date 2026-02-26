import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileCopier {
    private String fSource, fDest;

    public FileCopier(String fSource, String fDest) {
        this.fSource = fSource;
        this.fDest = fDest;
    }

    private void store(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(this.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            if(!new File(filename).exists()) { System.out.println("FILE DOESN'T EXIST"); return ""; }
            String res = reader.readAllAsString();
            reader.close();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void copyUsingCharStream() {
        
    }
}

public class Driver {
    
}
