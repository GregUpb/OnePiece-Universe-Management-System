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
        for (String[] s : this.GetRoles())
        {
            if (Profession.equalsIgnoreCase(s[0]))
            {
                this.Profession = s[0];  // Set to the requested rank but with a format
            }
        }
    }

    public void SetResidence(String Residence)
    {
        this.Residence = Residence;
    }

    @Override
    public void displayProfile()
    {
        super.displayProfile();

        System.out.println(""); // Buffer

        System.out.println("Profession: " + this.Profession);
        System.out.println("Residence: " + this.Residence);
    }

    public void performDuty()
    {
        for (String[] s : this.GetRoles())
        {
            if (this.Profession.equalsIgnoreCase(s[0]))
            {
                System.out.println(s[1]);
            }
        }
    }


}