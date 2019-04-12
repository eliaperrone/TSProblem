import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//TODO creare file output .tour uguale ai file .tsp con soluzione

public class Main {

    public static void main(String[] args) {

        // Parse file
        Parser parser = new Parser("u1060.tsp");

        // Get list of places
        Place[] places = new Place[0];

        // Get size places and best known of file
        int size = 0, bestKnown = 0;

        try {
            size = parser.getSizePlaces();
            bestKnown = parser.getBestKnown();
            places = new Place[size];
            places = parser.getPlaces(size);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get distances of cities
        int[][] matrixDistances = Place.getMatrixDistances(places);

        //Search Nearest Neighbor Tour
        Tour tour = NearestNeighbor.searchNearestNeighborTour(places, matrixDistances);

        System.out.println("Running..");

        double error = Double.MAX_VALUE;

        while(true) {

            long seed = System.currentTimeMillis();

            // Optime with Simulated Annealing (2-OPT is used into SA)
            Tour tourAfterSimulatedAnnealing = SimulatedAnnealing.searchSimulatedAnnealing(tour, seed, matrixDistances);
            double current = tourAfterSimulatedAnnealing.calculateError(bestKnown, matrixDistances);
            int sizeTour = tourAfterSimulatedAnnealing.tourSize();

            System.out.println(current + "%");

            if (current < error) {
                error = current;
                try {
                    Files.write(Paths.get("output.txt"), ("File: u1060 Size: " + sizeTour + " Tour Distance: " + tourAfterSimulatedAnnealing.calculateDistanceTour(matrixDistances) + " Seed: " + seed +  " Error: " + error + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}