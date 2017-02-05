import javax.sound.sampled.EnumControl;
import java.util.ArrayList;

/**
 * Created by smrut on 2/2/2017.
 */
public class ParkingLot {
    private int capacity;
    private int generalSpots;
    private int handicappedSpots;
    static int ILLEGAL_SPOT=-1;
    private ArrayList<ParkingSpot> lot=new ArrayList<ParkingSpot>();
    private int parkedVehicles;
    private int reservedSpots;
    private static int SPOTS_PER_LINE=10;


    public ParkingLot(int handicappedSpots,int reservedSpots,int generalSpots){
        this.handicappedSpots=handicappedSpots;
        this.reservedSpots=reservedSpots;
        this.generalSpots=generalSpots;
        initializeSpots();

    }

    private void initializeSpots(){
        for(int i=0;i<handicappedSpots;i++){
            ParkingSpot p=new ParkingSpot(i, Permit.Type.HANDICAPPED);
//            System.out.println(lot.size());
            lot.add(p);

        }
        for(int i=0;i<reservedSpots;i++){
            ParkingSpot p=new ParkingSpot(lot.size(), Permit.Type.RESERVED);
//            System.out.println(lot.size());
            lot.add(p);
        }
        for(int i=0;i<generalSpots;i++){
            ParkingSpot p=new ParkingSpot(lot.size(), Permit.Type.GENERAL);
//            System.out.println(lot.size());
            lot.add(p);
        }
        capacity=lot.size();
        parkedVehicles=0;

    }

    public int getCapacity(){
        return capacity;
    }

    public int getNumParkedVehicles(){
        return parkedVehicles;
    }

    public boolean isSpotVacant(int spot){
        if(spot>ILLEGAL_SPOT && spot<=capacity ){
            return(lot.get(spot).getVehicle()==null);
        }

        return false ;
    }

    public ParkingSpot getSpot(int spot){
        if(spot>ILLEGAL_SPOT && spot<=capacity ){
            return lot.get(spot);
        }
        return null;

    }

    public boolean isSpotValid(int spot){
        return(spot>ILLEGAL_SPOT && spot<=capacity );
    }

    public boolean parkVehicle(Vehicle vehicle,int spot){
        if(vehicle!=null && (spot>ILLEGAL_SPOT && spot<=capacity )){
            if (isSpotVacant(spot)){
                lot.get(spot).occupySpot(vehicle);
                parkedVehicles++;
                return true;
            }
        }
        return false;
    }
    public int removeVehicle(Vehicle vehicle){
        if(vehicle!=null){
            for(int i=0;i<getCapacity();i++){
                if (lot.get(i).getVehicle()==vehicle){
                    lot.get(i).vacateSpot();
                    parkedVehicles--;
                    return i;

                }
            }

        }

        return ILLEGAL_SPOT;
    }
    public String toString(){
        String str="";
//        System.out.println("capacity:" + capacity);
        int vacantSpots=0;
        for (int i =0; i <getCapacity() ; i++) {

            str+=lot.get(i).toString()+" ";
            if (lot.get(i).getVehicle()==null){
                vacantSpots++;
            }
            if(i%SPOTS_PER_LINE
                    ==9) {
                str += "\n";

            }

        }

        return str+" "+"\n"+"Vacant Spots: "+vacantSpots;
    }

    public static void main(String[] args) {
        ParkingLot P1=new ParkingLot(10,10,10);
        Vehicle v1=new Vehicle(001);
        P1.parkVehicle(v1,1);
        System.out.println(P1);
        Vehicle v2=new Vehicle(002);
        P1.parkVehicle(v2,1);
        System.out.println(P1);

    }
}
