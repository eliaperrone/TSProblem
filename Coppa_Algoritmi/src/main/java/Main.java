import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Parse file input
        Parser parser = new Parser("ch130.tsp");
        List<Place> places = new ArrayList<>();

        try {
            // Get list of places
            places = parser.getPlaces();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Search Nearest Neighbor Tour
        Tour tour = NearestNeighbor.searchNearestNeighborTour(places);

        // Print best tour with Nearest Neighbor
        tour.printTour();
        System.out.println();

        // Calculate distance Tour
        System.out.println("Lunghezza Tour " + tour.calculateDistanceTour());

        // Calculate error (rendere dinamico il bestKnow)
        System.out.println("Errore Tour " + tour.calculateError(6110) + "%");

        // Optimize with 2-OPT
        // ...

    }

}