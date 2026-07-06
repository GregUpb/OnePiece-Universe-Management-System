//Module 1: Characters
import java.util.List;
import java.util.ArrayList;
public class Pirate extends Character{

    private int Bounty;
    private String PirateRole;
    private Boolean IsCaptain;
    private PirateCrew Crew = null;
    final List<String[]> Roles = new ArrayList<>(List.of(
            new String[] {"Captain", "I AM THE CAPTAIN NIGGERSSSSSSSSSS"},
            new String[] {"First Mate", "COPY PASTE"},
            new String[] {"Second Mate", "COPY PASTE"},
            new String[] {"Boatswain", "COPY PASTE"},
            new String[] {"Cook", "COPY PASTE"},
            new String[] {"Doctor", "COPY PASTE"},
            new String[] {"Navigator", "COPY PASTE"},
            new String[] {"Shipwright", "COPY PASTE"},
            new String[] {"Sniper", "COPY PASTE"},
            new String[] {"Archaeologist", "COPY PASTE"},
            new String[] {"Assassin", "COPY PASTE"},
            new String[] {"Barber", "COPY PASTE"},
            new String[] {"Beast Tamer", "COPY PASTE"},
            new String[] {"Blacksmith", "COPY PASTE"},
            new String[] {"Cabin Mate", "COPY PASTE"},
            new String[] {"Chronicler", "COPY PASTE"},
            new String[] {"Commando", "COPY PASTE"},
            new String[] {"Devil Fruit Specialist", "COPY PASTE"},
            new String[] {"Helmsman", "COPY PASTE"},
            new String[] {"Infantry", "COPY PASTE"},
            new String[] {"Instructor", "COPY PASTE"},
            new String[] {"Janitor", "COPY PASTE"},
            new String[] {"Lookout", "COPY PASTE"},
            new String[] {"Quartermaster", "COPY PASTE"},
            new String[] {"Martial Artist", "COPY PASTE"},
            new String[] {"Merchant", "COPY PASTE"},
            new String[] {"Musician", "COPY PASTE"},
            new String[] {"Pet", "COPY PASTE"},
            new String[] {"Rigger", "COPY PASTE"},
            new String[] {"Scholar", "COPY PASTE"},
            new String[] {"Staff", "COPY PASTE"},
            new String[] {"Swashbuckler", "COPY PASTE"},
            new String[] {"Swordsman", "COPY PASTE"},
            new String[] {"Tailor", "COPY PASTE"}
    ));

    Pirate(String Name, String Alias, String Origin, String Status, int Wallet, int Bounty, String PirateRole, Boolean IsCaptain)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Bounty = Bounty;
        this.PirateRole = PirateRole;
        this.IsCaptain = IsCaptain;
    }

    Pirate(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, int Bounty, String PirateRole, Boolean IsCaptain)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Bounty = Bounty;
        this.PirateRole = PirateRole;
        this.IsCaptain = IsCaptain;
    }

    Pirate(String Name, String Alias, String Origin, String Status, int Wallet, int Bounty, String PirateRole, Boolean IsCaptain, PirateCrew Crew)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Bounty = Bounty;
        this.PirateRole = PirateRole;
        this.IsCaptain = IsCaptain;
        this.Crew = Crew;
    }

    Pirate(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, int Bounty, String PirateRole, Boolean IsCaptain, PirateCrew Crew)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Bounty = Bounty;
        this.PirateRole = PirateRole;
        this.IsCaptain = IsCaptain;
        this.Crew = Crew;
    }

    public int GetBounty()
    {
        return this.Bounty;
    }

    public String GetPirateRole()
    {
        return this.PirateRole;
    }

    public Boolean IsCaptain()
    {
        return this.IsCaptain;
    }

    public PirateCrew GetPirateCrew()
    {
        return this.Crew;
    }

    public List<String[]> GetRoles()
    {
        return this.Roles;
    }

    public void SetBounty(int Bounty)
    {
        if (Bounty >= 0){
            this.Bounty = Bounty;
        }
    }

    public void SetPirateRole(String PirateRole)
    {
        for (String[] s : this.GetRoles())
        {
            if (PirateRole.equalsIgnoreCase(s[0]))
            {
                this.PirateRole = s[0];  // Set to the requested rank but with a format
            }
        }
    }

    public void SetIsCaptain(Boolean IsCaptain)
    {
        this.IsCaptain = IsCaptain;
    }

    public void SetPirateCrew(PirateCrew Crew)
    {
        // If they are already in a crew, remove them from the old crew's list first
        if (this.Crew != null) {
            this.Crew.RemoveCrewMember(this);
        }

        this.Crew = Crew;

        // Check that the new crew has this pirate in their list
        if (this.Crew != null && !this.Crew.GetCrewMembers().contains(this)) {
            this.Crew.AddCrewMember(this);
        }
    }

    @Override
    public void SetStatus(String Status)
    {
        if (Status.equalsIgnoreCase("alive") || Status.equalsIgnoreCase("captured") || Status.equalsIgnoreCase("dead"))
        {
            super.SetStatus(Status);
    
            if (this.GetStatus().equalsIgnoreCase("captured") && this.Crew != null)
            {
                this.Crew.CalculateTotalCrewBounty();
            }
        } else
        {
            System.out.println("Invalid Status");
        }

    }

    /* STUFF */
    public void AddBounty(int Bounty)
    {
        this.Bounty += Bounty;
    }

    @Override
    public void displayProfile()
    {
        super.displayProfile();

        System.out.println(""); // Buffer

        System.out.println("Bounty: " + this.Bounty);
        System.out.println("Role: " + this.PirateRole);
        if (this.IsCaptain)
        {
            System.out.println("Captain: Yes");
        } else
        {
            System.out.println("Captain: No");
        }
        if (this.Crew != null)
        {
            System.out.println("Crew: " + this.Crew.GetCrewName());
        } else
        {
            System.out.println("Crew: None");
        }
    }

    public void performDuty()
    {
        for (String[] s : this.GetRoles())
        {
            if (this.PirateRole.equalsIgnoreCase(s[0]))
            {
                System.out.println(s[1]);
            }
        }
    }

}