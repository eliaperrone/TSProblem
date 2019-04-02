import java.util.Random;

public class SimulatedAnnealing {

    private static Random random = new Random(13452644);

    public static Tour doubleBridge(Tour tour) {

        Tour outputTour = new Tour(tour.tourSize());

        int split = (tour.tourSize()/4);

        int index_a = random.nextInt(split);
        int index_b = random.nextInt(split) + split;
        int index_c = random.nextInt(split) + (split*2);
        int index_d = random.nextInt(split) + (split*3);

        // 0 - A
        for (int k=0; k<=index_a; k++){
            outputTour.addPlace(tour.getPlace(k));
        }

        // A - C+1 - D
        for (int k=index_c+1; k<=index_d ;k++){
            outputTour.addPlace(tour.getPlace(k));
        }

        // D - B+1 - C
        for (int k=index_b+1; k<=index_c; k++){
            outputTour.addPlace(tour.getPlace(k));
        }

        // C - A+1 - B
        for (int k=index_a+1; k<=index_b; k++){
            outputTour.addPlace(tour.getPlace(k));
        }

        // D+1 - END
        for (int k=index_d+1; k<=tour.tourSize()-1; k++){
            outputTour.addPlace(tour.getPlace(k));
        }

        return outputTour;
    }

    public static Tour searchSimulatedAnnealing(Tour tour){

        long initTime = System.currentTimeMillis();
        long currentTime = 0;

        double temperature = 100;
        double cooling = 0.95;

        Tour current = tour;
        Tour best = current;

        while((currentTime-initTime) < 180000){

            for (int i=0; i<100; i++){

                Tour next = doubleBridge(current);
                Tour candidate = TwoOpt.searchTwoOpt(next);

                if(candidate.calculateDistanceTour() < current.calculateDistanceTour()){
                    current = candidate;

                    if(current.calculateDistanceTour() < best.calculateDistanceTour()){
                        best = current;
                    }

                }else if(random.nextDouble() < Math.pow(Math.E,(-(candidate.calculateDistanceTour() - current.calculateDistanceTour()))/(180000-(currentTime-initTime)))){
                    current = candidate;
                }
            }
            temperature = temperature*cooling;
            currentTime = System.currentTimeMillis();
        }
        return best;
    }
}
