import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTourGenerator {

    public FileTourGenerator(Tour tour,String fileName, int[][] matrixDistances) {

        try {

            File file = new File("src/main/output/"+fileName+".opt.tour");
            BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter(file));

            StringBuilder textToWrite =new StringBuilder(
                    "NAME : "+fileName+".opt.tour\n" +
                    "COMMENT : Optimum tour for "+fileName+".tsp " + "(" + tour.calculateDistanceTour(matrixDistances) + ")\n" +
                    "TYPE : TOUR\n" +
                    "DIMENSION : " + tour.tourSize() + "\n" +
                    "TOUR_SECTION\n");

            for(int i=0;i<tour.tourSize();i++){
                textToWrite.append(tour.getPlace(i).getId()+"\n");
            }

            textToWrite.append("-1"+"\n");
            textToWrite.append("EOF");
            bufferedWriter.write(textToWrite.toString());
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}