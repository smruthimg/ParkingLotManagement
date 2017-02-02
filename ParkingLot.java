import java.util.ArrayList;

/**
 * Created by smrut on 2/2/2017.
 */
public class ParkingLot {
    private int capacity;
    private int generalSpots;
    private int handicappedSpots;
    static int ILLEGAL_SPOT;
    private ArrayList<ParkingSpot> lot;
    private int parkedVehicles;
    private int reservedSpots;
    private static int SPOTS_PER_LINE;


    public ParkingLot(int handicappedSpots,int reservedSpots,int generalSpots){
        this.handicappedSpots=handicappedSpots;
        this.reservedSpots=reservedSpots;
        this.generalSpots=generalSpots;

    }

    private void initializeSpots(){

    }

    public int getCapacity(){
        return 0;
    }

    public int getNumParkedVehicles(){
        return 0;
    }

    public boolean isSpotVacant(int spot){
        return false;
    }

    public boolean isSpotValid(int spot){
        return false;
    }

    public boolean parkVehicle(Vehicle vehicle,int spot){
        return false;
    }
    public int removeVehicle(Vehicle vehicle){
        return 0;
    }
    public String toString(){
        return "";
    }

    public static void main(String[] args) {

    }
}
