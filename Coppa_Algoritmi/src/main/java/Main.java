import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int getBestTrip(int[][] matrix){
        int bestDistances = 0;

        //DO ALGORITHM
        for (int i=0; i<matrix.length-1; i++){
            System.out.println();
            for (int j=0; j<matrix.length-1; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }


        return bestDistances;
    }

    public static void main(String[] args) {

        List<String> fileParsed = null;
        List<Place> places = new ArrayList<>();

        Parser parser = new Parser("ch130.tsp");
        try {
            //parser.printHeader();
            //fileParsed = parser.getData();
            places = parser.getPlaces();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] matrixDistances = Place.getMatrixDistances(places);

        /*
        for (int i=0; i<places.size()-1; i++){
            System.out.println();
            for (int j=0; j<places.size()-1; j++){
                System.out.print(matrixDistances[i][j] + " ");
            }
        }
        */

        int bestDistance = Main.getBestTrip(matrixDistances);
        System.out.println();
        System.out.println("Distanza migliore: " + bestDistance);
    }

}