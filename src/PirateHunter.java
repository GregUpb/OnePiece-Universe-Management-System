//Module 1: Characters
public class PirateHunter extends Character{
    private String CombatStyle;
    private int Captures;

    PirateHunter(String Name, String Alias, String Origin, String Status, int Wallet, int Captures)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Captures = Captures;
    }

    PirateHunter(String Name, String Alias, String Origin, String Status, int Wallet, String CombatStyle, int Captures)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.CombatStyle = CombatStyle;
        this.Captures = Captures;
    }

    PirateHunter(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, int Captures)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Captures = Captures;
    }

    PirateHunter(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String CombatStyle, int Captures)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.CombatStyle = CombatStyle;
        this.Captures = Captures;
    }

    public String GetCombatStyle()
    {
        return this.CombatStyle;
    }

    public int GetCaptures()
    {
        return this.Captures;
    }

    public void SetCombatStyle(String CombatStyle)
    {
        this.CombatStyle = CombatStyle;
    }

    public void SetCaptures(int Captures)
    {
        this.Captures = Captures;
    }

    public void AddCaptures(int Amount)
    {
        this.Captures += Amount;
    }

    @Override
    public void displayProfile()
    {
        super.displayProfile();

        System.out.println(""); // Buffer

        System.out.println("Combat Style: " + this.CombatStyle);
        System.out.println("Captures: " + this.Captures);
    }

    public void performDuty()
    {
        System.out.println("HUNTING");
    }
}