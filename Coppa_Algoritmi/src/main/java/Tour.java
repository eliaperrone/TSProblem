
public class Tour {

    private Place[] tour;
    private int currentIndex = 0;

    public Tour(int size){
        tour = new Place[size];
    }

    public void addPlace(Place place){
        tour[currentIndex] = place;
        currentIndex++;
    }

    public double calculateDistanceTour(int[][] matrixDistances){
        double distance = 0;
        int i=0;
        while(i < tour.length-1){
            distance += tour[i].getDistanceByMatrix(tour[i+1], matrixDistances);
            i++;
        }
        distance += tour[tour.length-1].getDistanceByMatrix(tour[0], matrixDistances);
        return distance;
    }

    public int tourSize(){
        return tour.length;
    }

//    public void addPlaceByIndex(int index, Place place){
//        tour[index] = place;
//    }

    public Place getPlace(int index){
        return tour[index];
    }

    public double calculateError(int bestKnow, int[][] matrixDistances){
        double currentDistance = calculateDistanceTour(matrixDistances);
        return (((currentDistance-bestKnow)/bestKnow)*100);
    }

    public void printTour(){
        for (Place place : tour){
            System.out.print(place.getId() + " -> ");
        }
    }
}
