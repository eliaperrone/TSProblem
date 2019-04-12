
public class Place {

    private static int idGenerator = 1;

    private int id;
    private double positionX;
    private double positionY;

    public Place(double positionX, double positionY) {
        this.id = idGenerator;
        idGenerator++;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getId() {
        return id;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public int getDistance(Place b){
        return ((int) (Math.sqrt(Math.pow(this.getPositionX()-b.getPositionX(),2) + Math.pow(this.getPositionY()-b.getPositionY(),2)) + 0.5));
    }

    // piu veloce
    public int getDistanceByMatrix(Place b, int[][] matrixDistances){
        return matrixDistances[this.id-1][b.id-1];
    }

    public static int[][] getMatrixDistances(Place[] places){
        int[][] output = new int[places.length][places.length];
        for (int i=0; i<places.length; i++){
            for (int j=0; j<places.length; j++){
                output[i][j] = places[i].getDistance(places[j]);
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

}
