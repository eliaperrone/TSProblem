import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Parse file
        Parser eil76 = new Parser("eil76.tsp");
        Parser kroA100 = new Parser("kroA100.tsp");
        Parser ch130 = new Parser("ch130.tsp");
        Parser d198 = new Parser("d198.tsp");
        Parser lin318 = new Parser("lin318.tsp");
        Parser pr439 = new Parser("pr439.tsp");
        Parser pcb442 = new Parser("pcb442.tsp");
        Parser rat783 = new Parser("rat783.tsp");
        Parser u1060 = new Parser("u1060.tsp");
        Parser fl1577 = new Parser("fl1577.tsp");

        // Get lists of places
        Place[] placeseil76 = new Place[0];
        Place[] placeskroA100 = new Place[0];
        Place[] placesch130 = new Place[0];
        Place[] placesd198 = new Place[0];
        Place[] placeslin318 = new Place[0];
        Place[] placespr439 = new Place[0];
        Place[] placespcb442 = new Place[0];
        Place[] placesrat783 = new Place[0];
        Place[] placesu1060 = new Place[0];
        Place[] placesfl1577 = new Place[0];

        // Get size places
        int sizeeil76 = 0;
        int sizekroA100 = 0;
        int sizech130 = 0;
        int sized198 = 0;
        int sizelin318 = 0;
        int sizepr439 = 0;
        int sizepcb442 = 0;
        int sizerat783 = 0;
        int sizeu1060 = 0;
        int sizefl1577 = 0;

        // Get best known
        int bestKnowneil76 = 0;
        int bestKnownkroA100 = 0;
        int bestKnownch130 = 0;
        int bestKnownd198 = 0;
        int bestKnownlin318 = 0;
        int bestKnownpr439 = 0;
        int bestKnownpcb442 = 0;
        int bestKnownrat783 = 0;
        int bestKnownu1060 = 0;
        int bestKnownfl1577 = 0;

        try{
            // eil76
            sizeeil76 = eil76.getSizePlaces();
            bestKnowneil76 = eil76.getBestKnown();
            placeseil76 = new Place[sizeeil76];
            placeseil76 = eil76.getPlaces(sizeeil76);

            // kroA100
            sizekroA100 = kroA100.getSizePlaces();
            bestKnownkroA100 = kroA100.getBestKnown();
            placeskroA100 = new Place[sizekroA100];
            placeskroA100 = kroA100.getPlaces(sizekroA100);

            // ch130
            sizech130 = ch130.getSizePlaces();
            bestKnownch130 = ch130.getBestKnown();
            placesch130 = new Place[sizech130];
            placesch130 = ch130.getPlaces(sizech130);

            // d198
            sized198 = d198.getSizePlaces();
            bestKnownd198 = d198.getBestKnown();
            placesd198 = new Place[sized198];
            placesd198 = d198.getPlaces(sized198);

            // lin318
            sizelin318 = lin318.getSizePlaces();
            bestKnownlin318 = lin318.getBestKnown();
            placeslin318 = new Place[sizelin318];
            placeslin318 = lin318.getPlaces(sizelin318);

            // pr439
            sizepr439 = pr439.getSizePlaces();
            bestKnownpr439 = pr439.getBestKnown();
            placespr439 = new Place[sizepr439];
            placespr439 = pr439.getPlaces(sizepr439);

            // pcb442
            sizepcb442 = pcb442.getSizePlaces();
            bestKnownpcb442 = pcb442.getBestKnown();
            placespcb442 = new Place[sizepcb442];
            placespcb442 = pcb442.getPlaces(sizepcb442);

            // rat783
            sizerat783 = rat783.getSizePlaces();
            bestKnownrat783 = rat783.getBestKnown();
            placesrat783 = new Place[sizerat783];
            placesrat783 = rat783.getPlaces(sizerat783);

            // u1060
            sizeu1060 = u1060.getSizePlaces();
            bestKnownu1060 = u1060.getBestKnown();
            placesu1060 = new Place[sizeu1060];
            placesu1060 = u1060.getPlaces(sizeu1060);

            // fl1577
            sizefl1577 = fl1577.getSizePlaces();
            bestKnownfl1577 = fl1577.getBestKnown();
            placesfl1577 = new Place[sizefl1577];
            placesfl1577 = fl1577.getPlaces(sizefl1577);
        }catch (IOException e){
            e.printStackTrace();
        }

        // Get distances of cities
        int[][] matrixDistanceseil76 = Place.getMatrixDistances(placeseil76);
        int[][] matrixDistanceskroA100 = Place.getMatrixDistances(placeskroA100);
        int[][] matrixDistancesch130 = Place.getMatrixDistances(placesch130);
        int[][] matrixDistancesd198 = Place.getMatrixDistances(placesd198);
        int[][] matrixDistanceslin318 = Place.getMatrixDistances(placeslin318);
        int[][] matrixDistancespr439 = Place.getMatrixDistances(placespr439);
        int[][] matrixDistancespcb442 = Place.getMatrixDistances(placespcb442);
        int[][] matrixDistancesrat783 = Place.getMatrixDistances(placesrat783);
        int[][] matrixDistancesu1060 = Place.getMatrixDistances(placesu1060);
        int[][] matrixDistancesfl1577 = Place.getMatrixDistances(placesfl1577);


        /********************************************* NEAREST NEIGHBOR ***********************************************/
//        System.out.println("Nearest Neighbor");

        //Search Nearest Neighbor Tour

        //eil76
        Tour toureil76 = NearestNeighbor.searchNearestNeighborTour(placeseil76, matrixDistanceseil76);
//        System.out.println("Errore Tour " + toureil76.calculateError(bestKnowneil76) + "%");

        // kroA100
        Tour tourkroA100 = NearestNeighbor.searchNearestNeighborTour(placeskroA100, matrixDistanceskroA100);
//        System.out.println("Errore Tour " + tourkroA100.calculateError(bestKnownkroA100) + "%");

        // ch130
        Tour tourch130 = NearestNeighbor.searchNearestNeighborTour(placesch130, matrixDistancesch130);
//        System.out.println("Errore Tour " + tourch130.calculateError(bestKnownch130) + "%");

        // d198
        Tour tourd198 = NearestNeighbor.searchNearestNeighborTour(placesd198, matrixDistancesd198);
//        System.out.println("Errore Tour " + tourd198.calculateError(bestKnownd198) + "%");

        // lin318
        Tour tourlin318 = NearestNeighbor.searchNearestNeighborTour(placeslin318, matrixDistanceslin318);
//        System.out.println("Errore Tour " + tourlin318.calculateError(bestKnownlin318) + "%");

        // pr439
        Tour tourpr439 = NearestNeighbor.searchNearestNeighborTour(placespr439, matrixDistancespr439);
//        System.out.println("Errore Tour " + tourpr439.calculateError(bestKnownpr439) + "%");

        // pcb442
        Tour tourpcb442 = NearestNeighbor.searchNearestNeighborTour(placespcb442, matrixDistancespcb442);
//        System.out.println("Errore Tour " + tourpcb442.calculateError(bestKnownpcb442) + "%");

        // rat783
        Tour tourrat783 = NearestNeighbor.searchNearestNeighborTour(placesrat783, matrixDistancesrat783);
//        System.out.println("Errore Tour " + tourrat783.calculateError(bestKnownrat783) + "%");

        // u1060
        Tour touru1060 = NearestNeighbor.searchNearestNeighborTour(placesu1060, matrixDistancesu1060);
//        System.out.println("Errore Tour " + touru1060.calculateError(bestKnownu1060) + "%");

        // fl1577
        Tour tourfl1577 = NearestNeighbor.searchNearestNeighborTour(placesfl1577, matrixDistancesfl1577);
//        System.out.println("Errore Tour " + tourfl1577.calculateError(bestKnownfl1577) + "%");

//        System.out.println();

        /************************************************** 2-OPT *****************************************************/
//        System.out.println("2-OPT");
//
//        // Optimize with 2-OPT
//
//        // eil76
//        Tour tourAfterTwoOpteil76 = TwoOpt.searchTwoOpt(toureil76);
////        System.out.println("Errore Tour " + tourAfterTwoOpteil76.calculateError(bestKnowneil76) + "%");
//
//        // kroA100
//        Tour tourAfterTwoOptkroA100 = TwoOpt.searchTwoOpt(tourkroA100);
////        System.out.println("Errore Tour " + tourAfterTwoOptkroA100.calculateError(bestKnownkroA100) + "%");
//
//        // ch130
//        Tour tourAfterTwoOptch130 = TwoOpt.searchTwoOpt(tourch130);
////        System.out.println("Errore Tour " + tourAfterTwoOptch130.calculateError(bestKnownch130) + "%");
//
//        // d198
//        Tour tourAfterTwoOptd198 = TwoOpt.searchTwoOpt(tourd198);
////        System.out.println("Errore Tour " + tourAfterTwoOptd198.calculateError(bestKnownd198) + "%");
//
//        // lin318
//        Tour tourAfterTwoOptlin318 = TwoOpt.searchTwoOpt(tourlin318);
////        System.out.println("Errore Tour " + tourAfterTwoOptlin318.calculateError(bestKnownlin318) + "%");
//
//        // pr439
//        Tour tourAfterTwoOptpr439 = TwoOpt.searchTwoOpt(tourpr439);
////        System.out.println("Errore Tour " + tourAfterTwoOptpr439.calculateError(bestKnownpr439) + "%");
//
//        // pcb442
//        Tour tourAfterTwoOptpcb442 = TwoOpt.searchTwoOpt(tourpcb442);
////        System.out.println("Errore Tour " + tourAfterTwoOptpcb442.calculateError(bestKnownpcb442) + "%");
//
//        // rat783
//        Tour tourAfterTwoOptrat783 = TwoOpt.searchTwoOpt(tourrat783);
////        System.out.println("Errore Tour " + tourAfterTwoOptrat783.calculateError(bestKnownrat783) + "%");
//
//        // u1060
//        Tour tourAfterTwoOptu1060 = TwoOpt.searchTwoOpt(touru1060);
////        System.out.println("Errore Tour " + tourAfterTwoOptu1060.calculateError(bestKnownu1060) + "%");
//
//        // fl1577
//        Tour tourAfterTwoOptfl1577 = TwoOpt.searchTwoOpt(tourfl1577);
////        System.out.println("Errore Tour " + tourAfterTwoOptfl1577.calculateError(bestKnownfl1577) + "%");
//
////        System.out.println();

        /***************************************** SIMULATED ANNEALING ************************************************/
//        System.out.println("Simulated Annealing");

        Random random = new Random();

        // Optime with Simulated Annealing (2-OPT is used into SA)

        double error = Double.MAX_VALUE;
        double besteil76 = Double.MAX_VALUE;
        double bestkroA100 = Double.MAX_VALUE;
        double bestch130 = Double.MAX_VALUE;
        double bestd198 = Double.MAX_VALUE;
        double bestlin318 = Double.MAX_VALUE;
        double bestpr439 = Double.MAX_VALUE;
        double bestpcb442 = Double.MAX_VALUE;
        double bestrat783 = Double.MAX_VALUE;
        double bestu1060 = Double.MAX_VALUE;
        double bestfl1577 = Double.MAX_VALUE;

        try {
            Files.delete(Paths.get("/home/eliaperrone/Dropbox/output.txt"));
            Files.createFile(Paths.get("/home/eliaperrone/Dropbox/output.txt"));
        }catch(IOException e){
            e.printStackTrace();
        }


        while(true){

            System.out.println("RUNNING...");

            // eil76
            SimulatedAnnealing.seed = System.currentTimeMillis();
            double temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingeil75 = SimulatedAnnealing.searchSimulatedAnnealing(toureil76);
            error = tourAfterSimulatedAnnealingeil75.calculateError(bestKnowneil76);
            if(error < besteil76){
                besteil76 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: eil76 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + besteil76 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("eil76 - iterazione: " + iteration);

            // kroA100
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingkroA100 = SimulatedAnnealing.searchSimulatedAnnealing(tourkroA100);
            error = tourAfterSimulatedAnnealingkroA100.calculateError(bestKnownkroA100);
            if(error < bestkroA100){
                bestkroA100 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: kroA100 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestkroA100 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("kroA100 - iterazione: " + iteration);

            // ch130
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingch130 = SimulatedAnnealing.searchSimulatedAnnealing(tourch130);
            error = tourAfterSimulatedAnnealingch130.calculateError(bestKnownch130);
            if(error < bestch130){
                bestch130 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: ch130 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestch130 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("ch130 - iterazione: " + iteration);

            // d198
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingd198 = SimulatedAnnealing.searchSimulatedAnnealing(tourd198);
            error = tourAfterSimulatedAnnealingd198.calculateError(bestKnownd198);
            if(error < bestd198){
                bestd198 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: d198 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestd198 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("d198 - iterazione: " + iteration);

            // lin318
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealinglin318 = SimulatedAnnealing.searchSimulatedAnnealing(tourlin318);
            error = tourAfterSimulatedAnnealinglin318.calculateError(bestKnownlin318);
            if(error < bestlin318){
                bestlin318 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: lin318 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestlin318 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("lin318 - iterazione: " + iteration);

            // pr439
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingpr439 = SimulatedAnnealing.searchSimulatedAnnealing(tourpr439);
            error = tourAfterSimulatedAnnealingpr439.calculateError(bestKnownpr439);
            if(error < bestpr439){
                bestpr439 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: pr439 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestpr439 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("pr439 - iterazione: " + iteration);

            // pcb442
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp =  Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingpcb442 = SimulatedAnnealing.searchSimulatedAnnealing(tourpcb442);
            error = tourAfterSimulatedAnnealingpcb442.calculateError(bestKnownpcb442);
            if(error < bestpcb442){
                bestpcb442 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: pcb442 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestpcb442 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("pcb442 - iterazione: " + iteration);

            // rat783
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingrat783 = SimulatedAnnealing.searchSimulatedAnnealing(tourrat783);
            error = tourAfterSimulatedAnnealingrat783.calculateError(bestKnownrat783);
            if(error < bestrat783){
                bestrat783 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: rat783 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestrat783 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("rat783 - iterazione: " + iteration);

            // u1060
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingu1060 = SimulatedAnnealing.searchSimulatedAnnealing(touru1060);
            error = tourAfterSimulatedAnnealingu1060.calculateError(bestKnownu1060);
            if(error < bestu1060){
                bestu1060 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: u1060 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestu1060 + "\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("u1060 - iterazione: " + iteration);

            // fl1577
            SimulatedAnnealing.seed = System.currentTimeMillis();
            temp = Math.abs(random.nextInt(100)) + 80;
            SimulatedAnnealing.temperature = temp;
            SimulatedAnnealing.alpha = Math.abs(random.nextDouble() * 0.1) + 0.9;
            Tour tourAfterSimulatedAnnealingfl1577 = SimulatedAnnealing.searchSimulatedAnnealing(tourfl1577);
            error = tourAfterSimulatedAnnealingfl1577.calculateError(bestKnownfl1577);
            if(error < bestfl1577){
                bestfl1577 = error;
                try {
                    Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("FILE: fl1577 SEED: " + SimulatedAnnealing.seed + " TEMPERATURE: " + temp
                            + " ALPHA:" + SimulatedAnnealing.alpha + " ERROR: " + bestfl1577 + "\n\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                Files.write(Paths.get("/home/eliaperrone/Dropbox/output.txt"), ("\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }

//            System.out.println("fl1577 - iterazione: " + iteration);

        }

    }

}