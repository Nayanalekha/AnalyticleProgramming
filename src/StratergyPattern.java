public class StratergyPattern {
    public static void main(String args[]) {

     context context = new context(new OptimalPlanningOperation());
     context context1 = new context(new NormalPlanningOperation());
     context.doPlanOperation();
     context1.doPlanOperation();
    }
}

class context{
    private Stratergy stratergy;
    public context(Stratergy stratergy){
        this.stratergy = stratergy;
    }
    public boolean doPlanOperation(){
        return stratergy.doPlanOperation();
    }
}

interface Stratergy {
    boolean doPlanOperation();
}

class OptimalPlanningOperation implements Stratergy {

    @Override
    public boolean doPlanOperation() {
        System.out.println(" Do Optimal plan Logic...");
        return true;
    }
}

class NormalPlanningOperation implements Stratergy {

    @Override
    public boolean doPlanOperation() {
        System.out.println(" Do Normal plan Logic...");
        return true;
    }
}
