public class TwoOpt {

    public TwoOpt(){ }

    public static Tour searchTwoOpt(Tour tour, int[][] matrixDistances){

        int tourSize = tour.tourSize();
        int improve = -1;

        while(improve < 0){
            int gain, indexI = 0, indexJ = 0,a, b;
            improve = 0;
            for (int i=0; i<tourSize; i++){
                for (int j=i+1; j<tourSize-1; j++){
                    if(i == 0){
                        a = tourSize-1;
                    } else {
                        a = i-1;
                    }
                    if(j == tourSize){
                        b = 0;
                    } else {
                        b = j+1;
                    }
                    int straightDistance = tour.getPlace(i).getDistanceByMatrix(tour.getPlace(b), matrixDistances) + tour.getPlace(a).getDistanceByMatrix(tour.getPlace(j), matrixDistances);
                    int diagDistance = tour.getPlace(a).getDistanceByMatrix(tour.getPlace(i), matrixDistances) + tour.getPlace(j).getDistanceByMatrix(tour.getPlace(b), matrixDistances);
                    gain = straightDistance - diagDistance;
                    if(gain < improve){
                        improve = gain;
                        indexI = i;
                        indexJ = j;
                    }
                }
            }
            if(improve < 0){
                tour = swap(indexI,indexJ,tour);
            }
        }
        return  tour;
    }

    private static Tour swap(int i, int j, Tour tour){

        Tour swappedTour = new Tour(tour.tourSize());

        for(int k=0; k<=i-1; k++){
            swappedTour.addPlace(tour.getPlace(k));
        }

        swappedTour.addPlace(tour.getPlace(j));

        for(int k=j-1; k>i; k--){
            swappedTour.addPlace(tour.getPlace(k));
        }

        swappedTour.addPlace(tour.getPlace(i));

        for (int k=j+1; k<tour.tourSize(); k++){
            swappedTour.addPlace(tour.getPlace(k));
        }

        return swappedTour;
    }
}
