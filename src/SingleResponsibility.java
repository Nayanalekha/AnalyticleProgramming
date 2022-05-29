import java.util.Date;

public class SingleResponsibility {
}

class Profile{

}

interface ProfilesBuilder {
    void setName();

    void addMaterial();

    void addVersion();

    void addSettings();

    void reSet();
}

class ProfileBuilder implements ProfilesBuilder{
    Profile profile;
    ProfileBuilder(){
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

class Builder{
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

class ProfileCreator{
    public static void main(String args[]){
        Builder builder = new Builder();

        ProfileBuilder profileBuilder = new ProfileBuilder();
        builder.makeSurgeonProfile(profileBuilder);
        Profile surgeonProfile = profileBuilder.getProfile();
    }
}
