public class NearestNeighbor {

    public NearestNeighbor() { }

    public static Tour searchNearestNeighborTour(Place[] places, int matrixDistances[][]) {

        Tour tour = new Tour(places.length);
        boolean[] visited = new boolean[matrixDistances[1].length+1];

        for (int i=0; i<visited.length; i++){
            visited[i] = false;
        }

        // Aggiungo la prima citta nel tour e la setto visitata
        tour.addPlace(places[0]);
        visited[0] = true;

        // Aggiungo le altre città vicine
        int index = 0, min;
        int current = 0;
        for (int i=0; i < matrixDistances.length-1; i++){
            min = Integer.MAX_VALUE;
            for (int j=0; j < matrixDistances.length; j++){
                if(current != j && matrixDistances[current][j] > 0 && matrixDistances[current][j] < min && !visited[j]){
                    min = matrixDistances[current][j];
                    index = j;
                }
            }
            // Aggiungo la città piu vicina alla città corrente
            tour.addPlace(places[index]);
            visited[index] = true;

            // Setto la città corrente come l'ultima città visitata
            current = index;
        }
        return tour;
    }
}
