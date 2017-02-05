import java.util.ArrayList;

/**
 * Created by smrut on 2/3/2017.
 */
public class ParkingOfficer {
    private ParkingLot lot;
    private static final int PAUSE_TIME=1000;
    private ArrayList<Ticket> tickets;

    public ParkingOfficer(){
        lot=null;
        tickets=new ArrayList<Ticket>();
    }

    public static Fine getFineVehicleSpot(Vehicle vehicle,ParkingSpot spot){
        if(!vehicle.hasPermit() || (vehicle.getPermit().getType()!=spot.getType())){
            switch (spot.getType()){
                case GENERAL:if(!vehicle.hasPermit()){
//                    System.out.println("has permit?"+vehicle.hasPermit());
                    return Fine.NO_PERMIT;
                }
                return Fine.NO_FINE;
                case HANDICAPPED:if(!vehicle.hasPermit() || vehicle.getPermit().getType()!=Permit.Type.HANDICAPPED){
                    return Fine.PARKING_HANDICAPPED;
                }
                case RESERVED:if(!vehicle.hasPermit() || vehicle.getPermit().getType()!=Permit.Type.RESERVED
                        || vehicle.getPermit().getType()!=Permit.Type.HANDICAPPED) {
                    return Fine.PARKING_RESERVED;
                }
                default:return Fine.NO_FINE;
            }


        }
        return Fine.NO_FINE;
    }

    public ArrayList<Ticket> getTickets(){
        return tickets;
    }

    private void issueTicket(Vehicle vehicle,int spot,Fine fine){
        if(vehicle!=null && fine!=Fine.NO_FINE) {
            Ticket t = new Ticket(vehicle.getPlate(), fine);
            tickets.add(t);
            vehicle.giveTicket(t);
            System.out.println("Issuing ticket to: " + vehicle.toString() + " in spot " + spot + " for " + fine);

        }

    }

    public void patrolLot(){
        for (int i = 0; i <lot.getCapacity() ; i++) {
            ParkingSpot sp=lot.getSpot(i);
            Vehicle v1=sp.getVehicle();
            if(v1!=null) {
                Fine f1 = getFineVehicleSpot(v1, sp);

                if (f1 != Fine.NO_FINE) {
                    issueTicket(v1, sp.getSpot(), f1);
                    RITParking.pause(PAUSE_TIME);
                }
            }
        }



    }

    public void setParkingLot(ParkingLot lot){
        if (lot!=null){
            this.lot=lot;
        }

    }

    public static void main(String[] args){
        ParkingOfficer pO=new ParkingOfficer();
        ParkingLot pL=new ParkingLot(4,5,20);
        Vehicle v1=new Vehicle(01);

        ParkingSpot pS1=new ParkingSpot(2, Permit.Type.HANDICAPPED);
        pS1.occupySpot(v1);
//        System.out.println(pS1.getVehicle());
        pL.parkVehicle(v1,pS1.getSpot());
        pO.setParkingLot(pL);
        pO.patrolLot();
        System.out.println(pO.getTickets());
        System.out.println(pL.toString());

        //Creating Parkingoffice2, type-General
        ParkingOfficer pO2=new ParkingOfficer();
        ParkingLot pL2=new ParkingLot(10,0,20);
        Vehicle v2=new Vehicle(2);
        Permit p2=new Permit(1, Permit.Type.GENERAL);
        v2.setPermit(p2);

        ParkingSpot pS2=pL2.getSpot(20);//new ParkingSpot(20, Permit.Type.GENERAL);
        pS2.occupySpot(v2);
//        System.out.println(pS1.getVehicle());
        pL2.parkVehicle(v2,pS2.getSpot());
        pO2.setParkingLot(pL2);
        pO2.patrolLot();
        System.out.println(pO2.getTickets());
        System.out.println(pL2.toString());

        //Creating Parkingoffice2, type-Reserved
        ParkingOfficer pO3=new ParkingOfficer();
        ParkingLot pL3=new ParkingLot(10,10,20);
        Vehicle v3=new Vehicle(3);
        Permit p3=new Permit(2, Permit.Type.GENERAL);
        v3.setPermit(p3);

        ParkingSpot pS3=pL3.getSpot(3);//new ParkingSpot(3, Permit.Type.RESERVED);
        pS3.occupySpot(v2);
//        System.out.println(pS1.getVehicle());
        pL3.parkVehicle(v3,pS3.getSpot());
        pO3.setParkingLot(pL3);
        pO.patrolLot();
        System.out.println(pO3.getTickets());
        System.out.println(pL3.toString());

        //Creating Parkingoffice2, type-null
        ParkingOfficer pO4=new ParkingOfficer();
        ParkingLot pL4=new ParkingLot(10,10,20);
        Vehicle v4=new Vehicle(4);
        Permit p4 = new Permit(3, null);
        v4.setPermit(p4);

//        ParkingSpot pS4=new ParkingSpot(22, Permit.Type.HANDICAPPED);
       ParkingSpot pS4=pL4.getSpot(10);
        pL4.getSpot(24).occupySpot(v4);
//        System.out.println(pS1.getVehicle());
        pL4.parkVehicle(v4,pS4.getSpot());
        pO4.setParkingLot(pL4);
        pO4.patrolLot();
        System.out.println(pO4.getTickets());
        System.out.println(pL4.toString());

    }
}
