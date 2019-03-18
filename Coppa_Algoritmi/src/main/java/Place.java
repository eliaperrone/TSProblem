import java.util.List;

public class Place {

    private static int idGenerator = 0;

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

    public static int[][] getMatrixDistances(List<Place> places){
        int[][] output = new int[places.size()][places.size()];
        for (int i=0; i<places.size(); i++){
            for (int j=0; j<places.size(); j++){
                output[i][j] = places.get(i).getDistance(places.get(j));
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
