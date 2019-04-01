public class TwoOpt {

    public TwoOpt(){ }

    public static Tour searchTwoOpt(Tour tour){

        int improve = -1;

        while(improve < 0){
            int gain, indexI = 0, indexJ = 0,a, b;
            improve = 0;
            for (int i=0; i<tour.tourSize(); i++){
                for (int j=i+1; j<tour.tourSize()-1; j++){
                    if(i == 0){
                        a = tour.tourSize()-1;
                    } else {
                        a = i-1;
                    }
                    if(j == tour.tourSize()){
                        b = 0;
                    } else {
                        b = j+1;
                    }
                    int straightDistance = tour.getPlace(i).getDistance(tour.getPlace(b)) + tour.getPlace(a).getDistance(tour.getPlace(j));
                    int diagDistance = tour.getPlace(a).getDistance(tour.getPlace(i)) + tour.getPlace(j).getDistance(tour.getPlace(b));
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

    public static Tour swap(int i, int j, Tour tour){

        Tour swappedTour = new Tour();

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
