
class Profile{

}

interface ProfilesBuilder {
    void setName();

    void addMaterial();

    void addVersion();

    void addSettings();

    void reSet();
}

class Builder implements ProfilesBuilder{
    Profile profile;
    Builder(){
        reSet();
    }
    @Override
    public void setName() {

    }

    @Override
    public void addMaterial() {

    }

    @Override
    public void addVersion() {

    }

    @Override
    public void addSettings() {

    }

    @Override
    public void reSet() {
       this.profile = new Profile();
    }

    public Profile getProfile(){
        profile = this.profile;
        this.reSet();
        return profile;
    }
}

class Director {
    private ProfilesBuilder builder;

    void setBuilder(ProfilesBuilder builder){
        this.builder = builder;
    }

    void makeSurgeonProfile(ProfilesBuilder surgeonProfile){
        surgeonProfile.addMaterial();
        surgeonProfile.addSettings();
        surgeonProfile.addVersion();
    }
    void makeAnestheticProfile(ProfilesBuilder surgeonProfile){
        surgeonProfile.addMaterial();
        surgeonProfile.addSettings();
        surgeonProfile.addVersion();
    }
    void makeSurgicleProfile(ProfilesBuilder surgeonProfile){
        surgeonProfile.addMaterial();
        surgeonProfile.addSettings();
        surgeonProfile.addVersion();
    }
}

public class BuilderDesignPattern {
    public static void main(String args[]){
        Director director = new Director();

        Builder builder = new Builder();
        director.makeSurgeonProfile(builder);
        Profile surgeonProfile = builder.getProfile();
    }
}
