import java.util.ArrayList;
import java.util.List;

public class Tour {

    private List<Place> tour = new ArrayList<>();

    public Tour(){ }

    public Tour(Tour tour){
        for (int i=0; i< tour.tourSize(); i++){
            tour.addPlace(tour.getPlace(i));
        }
    }

    public void addPlace(Place place){
        tour.add(place);
    }

    public double calculateDistanceTour(){
        double distance = 0;
        int i=0;
        while(i < tour.size()-1){
            distance += tour.get(i).getDistance(tour.get(i+1));
            i++;
        }
        distance += tour.get(tour.size()-1).getDistance(tour.get(0));
        return distance;
    }

    public int tourSize(){
        return tour.size();
    }

    public void addPlaceByIndex(int index, Place place){
        tour.add(index, place);
    }

    public Place getPlace(int index){
        return tour.get(index);
    }

    public double calculateError(int bestKnow){
        double currentDistance = calculateDistanceTour();
        return (((currentDistance-bestKnow)/bestKnow)*100);
    }

    public void printTour(){
        for (Place place : tour){
            System.out.print(place.getId() + " -> ");
        }
    }
}
