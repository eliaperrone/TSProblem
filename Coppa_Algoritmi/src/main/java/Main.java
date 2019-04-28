import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Parse file
        Parser parser = new Parser("rat783");

        //Get seed specific of file
        Utils utils = new Utils(parser.getFileName(), "seed");

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

        // Get matrix distances of places
        int[][] matrixDistances = Place.getMatrixDistances(places);

        //Search Tour with Nearest Neighbor Algorithm
        Tour tour = NearestNeighbor.searchNearestNeighborTour(places, matrixDistances);

        long seed = utils.getSeed();

        System.out.println("Running " + parser.getFileName() + "..");

        // Optime Tour with Simulated Annealing Algorithm
        Tour tourAfterSimulatedAnnealing = SimulatedAnnealing.searchSimulatedAnnealing(tour, seed, matrixDistances);
        double current = tourAfterSimulatedAnnealing.calculateError(bestKnown, matrixDistances);

        System.out.println(current + "%");

        // Write output file
        FileTourGenerator fileTourGenerator = new FileTourGenerator(tourAfterSimulatedAnnealing, parser.getFileName(), matrixDistances);
    }
}