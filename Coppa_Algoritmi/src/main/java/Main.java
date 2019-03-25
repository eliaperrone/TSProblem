import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Parse file input
        Parser parser = new Parser("ch130.tsp");
        List<Place> places = new ArrayList<>();
        int bestKnown = 0;

        try {
            // Get list of places
            places = parser.getPlaces();
            // Get best known
            bestKnown = parser.getBestKnown();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] matrixDistances = Place.getMatrixDistances(places);

        /********************************************* NEAREST NEIGHBOR ***********************************************/
        System.out.println("Nearest Neighbor");

        // Search Nearest Neighbor Tour
        Tour tour = NearestNeighbor.searchNearestNeighborTour(places, matrixDistances);

        // Print best tour with Nearest Neighbor
        tour.printTour();
        System.out.println();

        // Calculate distance Tour
        System.out.println("Lunghezza Tour " + tour.calculateDistanceTour());
        // Calculate error (rendere dinamico il bestKnow)
        System.out.println("Errore Tour " + tour.calculateError(bestKnown) + "%");

        /************************************************** 2-OPT *****************************************************/
        System.out.println("2-OPT");

        // Optimize with 2-OPT
        Tour tourAfterTwoOpt = TwoOpt.searchTwoOpt(tour);

        // Print best tour after 2-OPT
        tourAfterTwoOpt.printTour();
        System.out.println();

        // Calculate distance Tour
        System.out.println("Lunghezza Tour " + tourAfterTwoOpt.calculateDistanceTour());
        // Calculate error (rendere dinamico il bestKnow)
        System.out.println("Errore Tour " + tourAfterTwoOpt.calculateError(bestKnown) + "%");

        /***************************************** SIMULATED ANNEALING ************************************************/
        System.out.println("Simulated Annealing");

        // Optime with Simulated Annealing


    }

}