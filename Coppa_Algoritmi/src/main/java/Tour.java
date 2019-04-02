
public class Tour {

    private Place[] tour = new Place[0];
    private int currentIndex = 0;

    public Tour(int size){
        tour = new Place[size];
    }

    public void addPlace(Place place){
        tour[currentIndex] = place;
        currentIndex++;
    }

    public double calculateDistanceTour(){
        double distance = 0;
        int i=0;
        while(i < tour.length-1){
            distance += tour[i].getDistance(tour[i+1]);
            i++;
        }
        distance += tour[tour.length-1].getDistance(tour[0]);
        return distance;
    }

    public int tourSize(){
        return tour.length;
    }

    public void addPlaceByIndex(int index, Place place){
        tour[index] = place;
    }

    public Place getPlace(int index){
        return tour[index];
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
