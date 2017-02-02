/**
 * Created by smrut on 2/2/2017.
 */
public class ParkingSpot {
    private static final String OCCUPIED_STR="Occupied";
    private int spot;
    private Permit.Type type;
    private Vehicle vehicle;

    public ParkingSpot(int spot,Permit.Type type){
        this.spot=spot;
        this.type=type;
    }

    public int getSpot(){
        return spot;
    }
    public Permit.Type getType(){
        return type;
    }
    public Vehicle getVehicle(){
        return vehicle;

    }
    public void occupySpot(Vehicle vehicle){
        if (this.vehicle!=null) {
            this.vehicle=vehicle;
            this.vehicle.setParked(true);
        }


    }
    public void vacateSpot(){
        if (this.vehicle!=null) {
            this.vehicle.setParked(false);
            this.vehicle = null;
        }

    }
    public String toString(){
        return "";
    }
    public static void verifySpot(String spotVar,ParkingSpot s,int spot,Permit.Type type,Vehicle vehicle){
        System.out.println( spotVar+ "is correct spot?" + (spot == s.getSpot() ? "OK" : ("Fail! Got:" + s.getSpot() + ", Expected" + type)));

        System.out.println(spotVar+" is correct type? " + (s.getType() == type ? "OK" : "FAIL! Got: " + s.getType() + ",  Expected: " + type));
        System.out.println(" is the vehicle null?");
        if(vehicle==null && s.getVehicle()==null) {
            System.out.println("FAIL! Got: "+s.getVehicle()+",Expected: " + vehicle);

        }
        else{
            System.out.println("OK");
        }
        System.out.println(" is the vehicle correct?");
        if (s.getVehicle()!=null && vehicle!=null){
          if(vehicle.equals(s.getVehicle())){
              System.out.println("OK");
          }
          else{
              System.out.println("No! Got: "+s.getVehicle()+",Expected: " + vehicle);
          }
          System.out.println("is Vehicle parked? " + (vehicle.isParked() ? "Parked" : "FAIL! Got: Not Parked,  Expected: " + "Parked"));
          System.out.println("Verify if the vehicle is correct "+ vehicle.toString());
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




}
}
