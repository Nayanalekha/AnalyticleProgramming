import java.util.ArrayList;
import java.util.List;

class OperationCenter {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

 abstract class Observer {
    protected OperationCenter observerble;
    public abstract void update();
}

class operationOverview extends Observer{

    public operationOverview(OperationCenter subject){
        this.observerble = subject;
        this.observerble.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Update operation overview screen " );
    }
}

class operationMonitoring extends Observer{

    public operationMonitoring(OperationCenter opCenter){
        this.observerble = opCenter;
        this.observerble.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Update operation monitoring screen " );
    }
}

public class EventSource {

    public static void main(String args[]){
        OperationCenter OperationCenter = new OperationCenter();

        new operationOverview(OperationCenter);
        new operationMonitoring(OperationCenter);
        OperationCenter.setState(15);
        OperationCenter.setState(7);
    }
}// End of the Eventsource class.