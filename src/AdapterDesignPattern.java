public class AdapterDesignPattern {
    public static void main(String args[]) {
        testAdapter();
    }

    private static void testAdapter() {
        Amplifier speaker = new Speaker();
        System.out.println(getDesible(speaker, 3).getDesible());

    }

    private static Desible getDesible(Amplifier speaker, int i) {
        switch (i) {
            case 2:
                return speaker.getVolume2();
            case 3:
                return speaker.getVolume3();
        }
        return new Desible(0);
    }
}

//To measure sound
class Desible {

    public Desible(int desible) {
        this.desible = desible;
    }

    public int getDesible() {
        return desible;
    }

    public void setDesible(int desible) {
        this.desible = desible;
    }

    int desible;
}


class Mike {
    public Desible getDesible() {
        return new Desible(1000);
    }
}

//Adapter class
interface Amplifier {
    Desible getVolume1();

    Desible getVolume2();

    Desible getVolume3();

}


class Speaker extends Mike implements Amplifier {


    @Override
    public Desible getVolume1() {
        return getDesible();
    }

    @Override
    public Desible getVolume2() {
        return convertTODesible(getDesible(), 2);
    }

    @Override
    public Desible getVolume3() {
        return convertTODesible(getDesible(), 3);
    }

    private Desible convertTODesible(Desible d, int i) {
        return new Desible(d.getDesible() * i);
    }
}


