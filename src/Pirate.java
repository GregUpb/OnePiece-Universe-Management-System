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
        this.PirateRole = PirateRole;
    }

    public void SetIsCaptain(Boolean IsCaptain)
    {
        this.IsCaptain = IsCaptain;
    }

    public void setPirateCrew(PirateCrew Crew)
    {
        this.Crew = Crew;
    }

    /* STUFF */
    public void AddBounty(int Bounty)
    {
        this.Bounty += Bounty;
    }

    public void displayProfile()
    {
        
    }

    public void performDuty()
    {

    }

}