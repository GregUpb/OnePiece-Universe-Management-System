//Module 1: Characters
import java.util.ArrayList;
import java.util.List;
public class Pirate extends Character{

    private int Bounty;
    private String PirateRole;
    private Boolean IsCaptain;
    private PirateCrew Crew = null;
    public static final List<String[]> ROLES = new ArrayList<>(List.of(
            new String[] {"None", "Doing nothing..."},
            new String[] {"Captain", "Leading the crew..."},
            new String[] {"First Mate", "Assisting the captain..."},
            new String[] {"Second Mate", "Ordering commands..."},
            new String[] {"Crew Member", "Obeying captain's orders..."},
            new String[] {"Boatswain", "Maintaining ship..."},
            new String[] {"Cook", "Cooking food..."},
            new String[] {"Doctor", "Healing injuries..."},
            new String[] {"Navigator", "Checking the map..."},
            new String[] {"Shipwright", "Repairing the ship..."},
            new String[] {"Sniper", "Training marksmanship..."},
            new String[] {"Archaeologist", "Examining artifacts..."},
            new String[] {"Assassin", "Hiding..."},
            new String[] {"Barber", "Cutting hair..."},
            new String[] {"Beast Tamer", "Taming beast..."},
            new String[] {"Blacksmith", "Forging equipments..."},
            new String[] {"Cabin Mate", "Organizing cabins..."},
            new String[] {"Chronicler", "Recording events..."},
            new String[] {"Commando", "Training tactics..."},
            new String[] {"Devil Fruit Specialist", "Examining devil fruit..."},
            new String[] {"Helmsman", "Controlling the ship..."},
            new String[] {"Infantry", "Practicing drills..."},
            new String[] {"Instructor", "Teaching..."},
            new String[] {"Janitor", "Cleaning..."},
            new String[] {"Lookout", "Scanning surroundings.."},
            new String[] {"Quartermaster", "Organizing supplies..."},
            new String[] {"Martial Artist", "Practicing martial arts..."},
            new String[] {"Merchant", "Counting money..."},
            new String[] {"Musician", "Playing instrument..."},
            new String[] {"Pet", "Following commands..."},
            new String[] {"Rigger", "Adjusting sails..."},
            new String[] {"Scholar", "Conducting research..."},
            new String[] {"Staff", "Assisting..."},
            new String[] {"Swashbuckler", "Training combat..."},
            new String[] {"Swordsman", "Training swordmanship..."},
            new String[] {"Tailor", "Sewing clothes..."}
    ));

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

    public Boolean IsCaptain()
    {
        return this.IsCaptain;
    }

    public PirateCrew GetPirateCrew()
    {
        return this.Crew;
    }

    public List<String[]> GetROLES()
    {
        return ROLES;
    }

    public void SetBounty(int Bounty)
    {
        if (Bounty >= 0){
            this.Bounty = Bounty;
        } else
        {
            System.out.println("Bounty cannot be negative");
        }
    }

    public void SetPirateRole(String PirateRole)
    {
        for (String[] s : this.GetROLES())
        {
            if (PirateRole.equalsIgnoreCase(s[0]))
            {
                this.PirateRole = s[0];  // Set to the requested rank but with a format
            }
        }
    }

    public void SetIsCaptain(Boolean IsCaptain)
    {
        if (this.Crew != null)
        {
            this.IsCaptain = IsCaptain;
            // If IsCaptain is true
            if (IsCaptain)
            {
                if (this.GetPirateCrew().GetCaptain() != this)
                {
                    this.GetPirateCrew().SetCaptain(this);
                }
            }
        } else if (IsCaptain)
        {
            System.out.println(this.GetName() + " cannot be a captain without a crew");
        }
    }

    public void SetPirateCrew(PirateCrew Crew)
    {
        // If they are already in a crew, remove them from the old crew's list first
        if (this.Crew != null && this.Crew.GetCrewMembers().contains(this) && this.Crew != Crew) {
            this.Crew.RemoveCrewMember(this);
        }
        
        this.Crew = Crew;

        // If they are not part of the crew then add
        if (Crew != null)
        {
            if (!(Crew.GetCrewMembers().contains(this)))
            {
                Crew.AddCrewMember(this);
            }
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

        System.out.println(); // Buffer

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

        System.out.println();
        System.out.print(this.GetName() + " is ");
        performDuty();
    }

    public void performDuty()
    {
        for (String[] s : this.GetROLES())
        {
            if (this.PirateRole.equalsIgnoreCase(s[0]))
            {
                System.out.println(s[1]);
            }
        }
    }

}