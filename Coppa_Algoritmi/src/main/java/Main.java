import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Parse file
        Parser parser = new Parser("rat783.tsp");

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

        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        double error = Double.MAX_VALUE;

        while(true) {

            double temperature = Math.abs(random.nextInt(20)) + 100;
            double alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;

            // Optime with Simulated Annealing (2-OPT is used into SA)
            Tour tourAfterSimulatedAnnealing = SimulatedAnnealing.searchSimulatedAnnealing(tour, random, temperature, alpha);
            double current = tourAfterSimulatedAnnealing.calculateError(bestKnown);
            int sizeTour = tourAfterSimulatedAnnealing.tourSize();

            if (current < error) {
                error = current;
                try {
                    Files.write(Paths.get("output.txt"), ("File: rat783 Size:" + sizeTour + " Seed: " + seed + " Alpha: " + alpha + " Temperature: " + temperature + " Error: " + error + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Calculate error
            System.out.println("Errore Tour " + tourAfterSimulatedAnnealing.calculateError(bestKnown) + "%");
        }
    }

}