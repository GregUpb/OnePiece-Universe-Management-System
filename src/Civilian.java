//Module 1: Characters
public class Civilian extends Character{

    private String Profession;
    private String Residence;
    private List<String[]> CivProfessions = new ArrayList<>(List.of(
            new String[] {"Captain", "I AM THE CAPTAIN NIGGERSSSSSSSSSS"},
            new String[] {"First Mate", "COPY PASTE"},
            new String[] {"Second Mate", "COPY PASTE"},
            new String[] {"Boatswain", "COPY PASTE"},
            new String[] {"Cook", "COPY PASTE"},
            new String[] {"Cleric", "COPY PASTE"},
            new String[] {"Clerk", "COPY PASTE"},
            new String[] {"Doctor", "COPY PASTE"},
            new String[] {"Navigator", "COPY PASTE"},
            new String[] {"Shipwright", "COPY PASTE"},
            new String[] {"Archaeologist", "COPY PASTE"},
            new String[] {"Assassin", "COPY PASTE"},
            new String[] {"Barber", "COPY PASTE"},
            new String[] {"Beast Tamer", "COPY PASTE"},
            new String[] {"Blacksmith", "COPY PASTE"},
            new String[] {"Instructor", "COPY PASTE"},
            new String[] {"Janitor", "COPY PASTE"},
            new String[] {"Martial Artist", "COPY PASTE"},
            new String[] {"Mechanic", "COPY PASTE"},
            new String[] {"Merchant", "COPY PASTE"},
            new String[] {"Musician", "COPY PASTE"},
            new String[] {"Scholar", "COPY PASTE"},
            new String[] {"Scientist", "COPY PASTE"},
            new String[] {"Tailor", "COPY PASTE"}
    ));

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

    public List<String[]> GetCivProfessions()
    {
        return this.CivProfessions;
    }

    public String GetProfession() { return this.Profession; }

    public String GetResidence()
    {
        return this.Residence;
    }

    public void SetProfession(String Profession)
    {
        for (String[] s : this.GetCivProfessions())
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