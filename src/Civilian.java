//Module 1: Characters
import java.util.List;
import java.util.ArrayList;
public class Civilian extends Character{

    private String Profession;
    private String Residence;
    public static final List<String[]> CIVPROFESSIONS = new ArrayList<>(List.of(
            new String[] {"None", "Doing nothing..."},
            new String[] {"Boatswain", "Maintaning ships..."},
            new String[] {"Cook", "Cooking food..."},
            new String[] {"Cleric", "Praying.."},
            new String[] {"Clerk", "Working..."},
            new String[] {"Doctor", "Healing injuries..."},
            new String[] {"Navigator", "Checking the map..."},
            new String[] {"Shipwright", "Repairing the ship..."},
            new String[] {"Archaeologist", "Examining artifacts..."},
            new String[] {"Assassin", "Hiding..."},
            new String[] {"Barber", "Cutting hair..."},
            new String[] {"Beast Tamer", "Taming beast..."},
            new String[] {"Blacksmith", "Forging equipments..."},
            new String[] {"Instructor", "Teaching..."},
            new String[] {"Janitor", "Cleaning..."},
            new String[] {"Martial Artist", "Practicing martial arts..."},
            new String[] {"Mechanic", "Fixing machineries..."},
            new String[] {"Merchant", "Counting money..."},
            new String[] {"Musician", "Playing instrument..."},
            new String[] {"Scholar", "Conducting research..."},
            new String[] {"Scientist", "Conducting experiments..."},
            new String[] {"Tailor", "Sewing clothes..."}
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
        for (String[] s : CIVPROFESSIONS)
        {
            if (Profession.equalsIgnoreCase(s[0]))
            {
                this.Profession = s[0];  // Set to the requested rank but with a format
            }
        }
    }

    public void SetResidence(String Residence)
    {
        if (Residence.isBlank())
        {
            System.out.println("Residence cannot be blank");
        } else
        {
            this.Residence = Residence;
        }
    }

    @Override
    public void displayProfile()
    {
        super.displayProfile();

        System.out.println(); // Buffer

        System.out.println("Profession: " + this.Profession);
        System.out.println("Residence: " + this.Residence);
        
        System.out.println();
        System.out.print(this.GetName() + " is ");
        performDuty();
    }

    public void performDuty()
    {
        for (String[] s : CIVPROFESSIONS)
        {
            if (this.Profession.equalsIgnoreCase(s[0]))
            {
                System.out.println(s[1]);
            }
        }
    }


}