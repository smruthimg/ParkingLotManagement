//import com.sun.java.util.jar.pack.Instruction;

/**
 * Represents the Parkking spot in the paking simulator
 * Created by Smruthi Gadenkanahalli on 2/2/2017.
 */
public class ParkingSpot {
    private static final String OCCUPIED_STR="*";// type is * if the spot is occupied
    private int spot;
    private Permit.Type type;
    private Vehicle vehicle;

    /**
     * Parking spot constructor to assign values to member fields
     * @param spot integer to store the spot number
     * @param type Permit type field tostore the permit type
     */
    public ParkingSpot(int spot,Permit.Type type){
        this.spot=spot;
        this.type=type;
    }

    /**
     * method to fetch the spot number
     * @return integer value of the spot
     */
    public int getSpot(){
        return spot;
    }

    /**
     * method to get the permit type of the spot
     * @return permit type value
     */
    public Permit.Type getType(){

        return type;
    }

    /**
     *
     * @return
     */
    public Vehicle getVehicle(){
        return vehicle;

    }
    public void occupySpot(Vehicle vehicle){
        if (this.vehicle==null) {
            this.vehicle=vehicle;
            this.vehicle.setParked(true);
//            OCCUPIED_STR="*";
        }


    }
    public void vacateSpot(){
        if (this.vehicle!=null) {
            this.vehicle.setParked(false);
            this.vehicle = null;
        }

    }
    public String toString(){

        if (getVehicle()==null){

            if(getType()== Permit.Type.GENERAL){
                return String.format("%02d", getSpot())+":"+"G";
            }
            if(getType()== Permit.Type.HANDICAPPED){
                return String.format("%02d", getSpot())+":"+"H";
            }
            if(getType()== Permit.Type.RESERVED){
                return String.format("%02d", getSpot())+":"+"R";
            }
        }
        return String.format("%02d", getSpot())+":"+OCCUPIED_STR;
    }

    public static void verifySpot(String spotVar,ParkingSpot s,int spot,Permit.Type type,Vehicle vehicle){
        System.out.println( spotVar+ "is correct spot? " + (spot == s.getSpot() ? "OK" : ("Fail! Got:" + s.getSpot() + ", Expected" + spot)));

        System.out.println(spotVar+" is correct type? " + (s.getType() == type ? "OK" : "FAIL! Got: " + s.getType() + ",  Expected: " + type));

        System.out.println( "is the vehicle null?  ");
        if (s.getVehicle()!=null && vehicle!=null){
            System.out.println("Not Null");
            System.out.println( "is the vehicle correct?  ");
          if(vehicle.equals(s.getVehicle())){
              System.out.println("OK. Vehicle is correct");
          }
          else{
              System.out.println("FAIL! Got: "+s.getVehicle()+",Expected: " + vehicle);
          }

          System.out.println("is Vehicle parked? " + (vehicle.isParked() ? "OK":"Got: "+vehicle.isParked()+ "  Expected: " + s.vehicle.isParked()));
          System.out.println("Verify if the vehicle is correct: "+ vehicle.toString());
        }
        else{
            System.out.println("Yes ! Got: "+s.getVehicle()+",Expected: " + vehicle);
        }


    }

    public boolean equals(Object other){
        if (other instanceof ParkingSpot){
            ParkingSpot p1=(ParkingSpot)other;
        }
        return false;
    }

    public static void main(String [] args){
        ParkingSpot p1=new ParkingSpot(1, Permit.Type.HANDICAPPED);
        Vehicle v1=new Vehicle(10);
        p1.occupySpot(v1);
        verifySpot("p1",p1,1,Permit.Type.HANDICAPPED,v1);
       System.out.println( p1.toString());
        System.out.println();


        ParkingSpot p2= new ParkingSpot(2, Permit.Type.GENERAL);
        Vehicle v2 =new Vehicle(20);
        p2.occupySpot(v2);
        verifySpot("p2",p2,2,Permit.Type.GENERAL,v2);
        System.out.println( p2.toString());

        System.out.println();

        ParkingSpot p3=new ParkingSpot(3, Permit.Type.GENERAL);
        Vehicle v3=new Vehicle(30);
//        p3.occupySpot(v3);
        verifySpot("p3",p3,3, Permit.Type.GENERAL,v3);
        System.out.println( p3.toString());



}
}
