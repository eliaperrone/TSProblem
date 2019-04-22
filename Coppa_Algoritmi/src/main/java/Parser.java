import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String resourcesPath = "src/main/resources/";
    private static File file = null;
    private String fileName;

    public Parser(String fileName){
        this.fileName = fileName;
        file = new File(resourcesPath + fileName + ".tsp");
    }

    public String getFileName() {
        return fileName;
    }

    public int getSizePlaces() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        int numOfPlaces = 0;
        for(int i=0; i<7; i++) {
            line = in.readLine();
        }
        while(!(line = in.readLine()).equals("EOF")){
            numOfPlaces++;
        }
        return numOfPlaces;
    }

    public int getBestKnown() throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = null;
        int bestKnown = 0;
        for(int i=0; i<6; i++){
            line = in.readLine();
        }
        List<String> tmp = Arrays.asList(line.split(" "));
        bestKnown = Integer.parseInt(tmp.get(2));
        return bestKnown;
    }

    public Place[] getPlaces(int size) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        Place[] output = new Place[size];
        for(int i=0; i<7; i++) {
            line = in.readLine();
        }
        int k=0;
        while(!(line = in.readLine().trim()).equals("EOF")){
            List<String> tmp = Arrays.asList(line.split(" "));
            double x = Double.parseDouble(tmp.get(1));
            double y = Double.parseDouble(tmp.get(2));
            output[k] = new Place(x,y);
            k++;
        }
        return output;
    }

}
