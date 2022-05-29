public class DecoratorPattern {
    public static void main(String args[]) {
        Cake birthDayCake = new BirthDayCake();
        System.out.println(birthDayCake.addDeco());
        Cake icingBirthdayCake = new IcingDecorator(new BirthDayCake());
        System.out.println(icingBirthdayCake.addDeco());
        Cake anniversaryCakeWithStand = new CakeStandDecorator(new AnniversaryCake());
        System.out.println(anniversaryCakeWithStand.addDeco());
    }
}


interface Cake {
    void makeMixture();

    void bake();

    String addDeco();
}

class BirthDayCake implements Cake {

    @Override
    public void makeMixture() {

    }

    @Override
    public void bake() {

    }

    @Override
    public String addDeco() {
        return " Happy Birthday";
    }
}

class AnniversaryCake implements Cake {

    @Override
    public void makeMixture() {

    }

    @Override
    public void bake() {

    }


    @Override
    public String addDeco() {
        return " HAppy Anniversary";
    }
}

abstract class CakeDecorator implements Cake {
    protected Cake cakeDecorator;

    public CakeDecorator(Cake decoratorCake) {
        this.cakeDecorator = decoratorCake;
    }

    public String addDeco() {
        return cakeDecorator.addDeco();
    }
}

class IcingDecorator extends CakeDecorator {

    public IcingDecorator(Cake decoratorCake) {
        super(decoratorCake);
    }

    @Override
    public void makeMixture() {

    }

    @Override
    public void bake() {

    }

    @Override
    public String addDeco() {
        return super.addDeco() + " with icing Roses";
    }
}

class CakeStandDecorator extends CakeDecorator {

    public CakeStandDecorator(Cake decoratorCake) {
        super(decoratorCake);
    }

    @Override
    public void makeMixture() {

    }

    @Override
    public void bake() {

    }

    @Override
    public String addDeco() {
        return super.addDeco() + " with wooden stand ";
    }
}