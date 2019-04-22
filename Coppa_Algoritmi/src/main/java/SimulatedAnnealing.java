import java.util.Random;

public class SimulatedAnnealing {

    public static Tour doubleBridge(Tour tour, Random random) {

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

    public static Tour searchSimulatedAnnealing(Tour tour, long seed, int[][] matrixDistances){

        Random random = new Random(seed);

        double temperature = Math.abs(random.nextInt(20)) + 100;
        double alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;

        long initTime = System.currentTimeMillis();
        long currentTime = 0;

        Tour current = tour;
        Tour best = current;

        while((currentTime-initTime) < 172000){

            for (int i=0; i<100; i++){

                Tour next = doubleBridge(current, random);
                Tour candidate = TwoOpt.searchTwoOpt(next, matrixDistances);

                if(candidate.calculateDistanceTour(matrixDistances) < current.calculateDistanceTour(matrixDistances)){
                    current = candidate;

                    if(current.calculateDistanceTour(matrixDistances) < best.calculateDistanceTour(matrixDistances)){
                        best = current;
                    }

                }else if(random.nextDouble() < Math.pow(Math.E,(-(candidate.calculateDistanceTour(matrixDistances) - current.calculateDistanceTour(matrixDistances)))/(180000-(currentTime-initTime)))){
                    current = candidate;
                }
            }
            temperature = temperature*alpha;
            currentTime = System.currentTimeMillis();
        }

        return best;
    }
}
