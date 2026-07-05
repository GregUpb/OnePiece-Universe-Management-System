//Module 1: Characters
public class Pirate extends Character{

    private int Bounty;
    private String PirateRole;
    private Boolean IsCaptain;
    private PirateCrew Crew = null;

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

    public void setPirateCrew(PirateCrew Crew)
    {
        this.Crew = Crew;
    }

    @Override
    public void SetStatus(String Status)
    {
        if (Status.equalsIgnoreCase("alive") || Status.equalsIgnoreCase("captured") || Status.equalsIgnoreCase("dead"))
        {
            super.SetStatus(Status);
    
            if (this.GetStatus().equalsIgnoreCase("captured") && !(this.Crew.equals(null)))
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