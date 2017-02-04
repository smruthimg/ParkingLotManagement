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
        tickets=null;
    }

    public static Fine getFineVehicleSpot(Vehicle vehicle,ParkingSpot spot){
        if(!vehicle.hasPermit() || (vehicle.getPermit().getType()!=spot.getType())){
            switch (spot.getType()){
                case GENERAL:return Fine.NO_PERMIT;
                case HANDICAPPED:return Fine.PARKING_HANDICAPPED;
                case RESERVED:return Fine.PARKING_RESERVED;
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
            System.out.println("Issuing ticket to vehicle " + vehicle.getPlate() + " in spot " + spot + " for " + fine);
            tickets.add(t);
            vehicle.giveTicket(t);
        }

    }

    public void patrolLot(){
        for (int i = 0; i <lot.getCapacity() ; i++) {


        }


    }

    public void setParkingLot(ParkingLot lot){
        if (lot!=null){
            this.lot=lot;
        }

    }

    public static void main(String[] args){

    }
}
