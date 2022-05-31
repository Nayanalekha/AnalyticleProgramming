class operationItems {
    OpProfile profile = new OpProfile();
    OpSurgoen surgoen = new OpSurgoen();

    void makeOpProfileCombination() {
        profile.addProfile();
        surgoen.addSurgeon();
    }
}

class OpProfile {
    public void addProfile() {

    }
}

class OpSurgoen {
    public void addSurgeon() {

    }
}
// Here operationItems class is directly depend on low level modules(OpSurgoen,OpProfile) which violates DIP
//By using interface OpItems we can follow with the DIP principle

interface OpItemes {
    void add();
}

class operationProfile1 {
    void makeOpProfileCombination(OpItemes itemes) {
        itemes.add();
    }
}

class OpProfile1 implements OpItemes {
    public void addProfile() {
        //todo method
    }

    @Override
    public void add() {
        this.addProfile();
    }
}

class OpSurgoen1 implements OpItemes {
    public void addSurgeon() {
        //todo method
    }

    @Override
    public void add() {
        this.addSurgeon();
    }
}

public class DipendencyInversionPrinciple {

    public static void main(String[] args) {
        OpItemes profile = new OpProfile1();
        OpItemes surgoen = new OpSurgoen1();
        operationProfile1 operationProfile1 = new operationProfile1();

        operationProfile1.makeOpProfileCombination(profile);
        operationProfile1.makeOpProfileCombination(surgoen);

    }
}