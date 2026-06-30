//Module 1: Characters
public class Civilian extends Character{

    private String Profession;
    private String Residence;

    Civilian(String Name, String Alias, String Origin, String Status, int Wallet, String Profession, String Residence)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Profession = Profession;
        this.Residence = Residence;
    }

    Civilian(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String Profession, String Residence)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Profession = Profession;
        this.Residence = Residence;
    }

    public String GetProfession()
    {
        return this.Profession;
    }

    public String GetResidence()
    {
        return this.Residence;
    }

    public void SetProfession(String Profession)
    {
        this.Profession = Profession;
    }

    public void SetResidence(String Residence)
    {
        this.Residence = Residence;
    }

    public void displayProfile()
    {

    }

    public void performDuty()
    {

    }


}