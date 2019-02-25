import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String resourcesPath = "src/main/resources/";
    private static File file = null;

    public Parser(String fileName){
        file = new File(resourcesPath + fileName);
    }

    public List<String> getData() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        List<String> output = new ArrayList<String>();

        while((line = in.readLine()) != null){
            output.add(line);
        }

        return output;
    }

    public int getNumOfLines() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        int numOfLines = 0;
        while((line = in.readLine()) != null){
            numOfLines++;
        }

        return numOfLines;
    }

    public List<String> getHeader() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        List<String> output = new ArrayList<String>();

        for(int i=0; i<6; i++){
            line = in.readLine();
            output.add(line);
        }

        return output;

    }

    public List<Place> getPlaces() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        List<Place> output = new ArrayList<Place>();

        for(int i=0; i<7; i++) {
            line = in.readLine();
        }
        for(int i=7; i<this.getNumOfLines()-1; i++){
            line = in.readLine();
            List<String> tmp = Arrays.asList(line.split(" "));
            double x = Double.parseDouble(tmp.get(1));
            double y = Double.parseDouble(tmp.get(2));
            output.add(new Place(x,y));
        }
        return output;
    }

    public void printHeader() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        for(int i=0; i<7; i++){
            line = in.readLine();
            System.out.println(line);

        }
    }

}
