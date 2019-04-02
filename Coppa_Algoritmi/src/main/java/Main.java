import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Parse file
        Parser parser = new Parser("d198.tsp");

        // Get list of places
        Place[] places = new Place[0];

        // Get size places and best known of file
        int size=0, bestKnown = 0;

        try{
            size = parser.getSizePlaces();
            bestKnown = parser.getBestKnown();
            places = new Place[size];
            places = parser.getPlaces(size);
        }catch (IOException e){
            e.printStackTrace();
        }

        // Get distances of cities
        int[][] matrixDistances = Place.getMatrixDistances(places);

        /********************************************* NEAREST NEIGHBOR ***********************************************/
        System.out.println("Nearest Neighbor");

        //Search Nearest Neighbor Tour
        Tour tour = NearestNeighbor.searchNearestNeighborTour(places, matrixDistances);

        // Print best tour with Nearest Neighbor
        tour.printTour();
        System.out.println();

        // Calculate distance Tour
        System.out.println("Lunghezza Tour " + tour.calculateDistanceTour());
        // Calculate error
        System.out.println("Errore Tour " + tour.calculateError(bestKnown) + "%");

        System.out.println();

        /************************************************** 2-OPT *****************************************************/
        System.out.println("2-OPT");

        // Optimize with 2-OPT
        Tour tourAfterTwoOpt = TwoOpt.searchTwoOpt(tour);

        // Print best tour after 2-OPT
        tourAfterTwoOpt.printTour();
        System.out.println();

        // Calculate distance Tour
        System.out.println("Lunghezza Tour " + tourAfterTwoOpt.calculateDistanceTour());
        // Calculate error
        System.out.println("Errore Tour " + tourAfterTwoOpt.calculateError(bestKnown) + "%");

        System.out.println();

        /***************************************** SIMULATED ANNEALING ************************************************/
        System.out.println("Simulated Annealing");

        // Optime with Simulated Annealing (2-OPT is used into SA)
        Tour tourAfterSimulatedAnnealing = SimulatedAnnealing.searchSimulatedAnnealing(tour);

        // Print best tour after Simulated Annealing
        tourAfterSimulatedAnnealing.printTour();
        System.out.println();

        // Calculate distance Tour
        System.out.println("Lunghezza Tour " + tourAfterSimulatedAnnealing.calculateDistanceTour());
        // Calculate error
        System.out.println("Errore Tour " + tourAfterSimulatedAnnealing.calculateError(bestKnown) + "%");
    }

}