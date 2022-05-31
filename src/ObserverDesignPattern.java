import java.util.ArrayList;
import java.util.List;

class OperationCenter {

    private List<Observer> observers = new ArrayList<Observer>();
    private int roomID;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
        notifyAllObservers(roomID);
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(int roomID){
        for (Observer observer : observers) {
            observer.update(roomID);
        }
    }
}

 abstract class Observer {
    protected OperationCenter observerble;
    public abstract void update(int room);
}

class operationOverview extends Observer{

    public operationOverview(OperationCenter subject){
        this.observerble = subject;
        this.observerble.attach(this);
    }

    @Override
    public void update(int room) {
        System.out.println( "Update operation overview screen with new room ID " + room );
    }
}

class operationMonitoring extends Observer{

    public operationMonitoring(OperationCenter opCenter){
        this.observerble = opCenter;
        this.observerble.attach(this);
    }

    @Override
    public void update(int room) {
        System.out.println( "Update operation monitoring screen with room " + room);
    }
}

public class ObserverDesignPattern {

    public static void main(String args[]){
        OperationCenter OperationCenter = new OperationCenter();

        new operationOverview(OperationCenter);
        new operationMonitoring(OperationCenter);
        OperationCenter.setRoomID(15);
        OperationCenter.setRoomID(7);
    }
}