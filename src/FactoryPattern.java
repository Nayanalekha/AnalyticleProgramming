import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryPattern {
    public static void main(String args[]) throws IOException {
        GetRoomFactory roomFactory = new GetRoomFactory();

        System.out.print("Enter the name of room for which the bill will be generated: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String roomName = br.readLine();
        System.out.print("Enter the number of people for bill will be calculated: ");
        int opeople = Integer.parseInt(br.readLine());

        Room p = roomFactory.getRoom(roomName);

        System.out.print("Bill amount for " + roomName + " of  " + opeople + " people is: ");
        p.getRate();
        p.calculateBill(opeople);
    }
}

abstract class Room {

    protected double rate;

    abstract void getRate();

    public void calculateBill(int people) {
        System.out.println(people * rate);
    }
}

class Luxury extends Room {
    //@override
    public void getRate() {
        rate = 13.50;
    }
}

class Normal extends Room {
    //@override
    public void getRate() {
        rate = 7.50;
    }
}

class GetRoomFactory {

    //use getPlan method to get object of type Plan
    public Room getRoom(String planType) {
        if (planType == null) {
            return null;
        }
        if (planType.equalsIgnoreCase("Luxury")) {
            return new Luxury();
        } else if (planType.equalsIgnoreCase("Normal")) {
            return new Normal();
        }

        return null;
    }
}
