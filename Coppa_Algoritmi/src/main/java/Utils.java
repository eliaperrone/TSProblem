import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final String resourcesPath = "src/main/resources/";
    private static File file = null;
    private String fileName;

    public Utils(String fileName, String seedFile){
        this.fileName = fileName;
        file = new File(resourcesPath + seedFile + ".txt");
    }

    public long getSeed(){
        long seed = 0;
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            while(!(line = in.readLine().trim()).equals("EOF")){
                List<String> tmp = Arrays.asList(line.split(" "));
                if(this.fileName.equals(tmp.get(0))){
                    seed = Long.parseLong(tmp.get(2));
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return seed;
    }
}
