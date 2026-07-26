package model;

//Module 1: Characters
public class PirateHunter extends Character{
    private String CombatStyle = "None";
    private int Captures;

    public PirateHunter(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String CombatStyle, int Captures)
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
        if (CombatStyle.isBlank())
        {
            this.CombatStyle = "None";
        } else
        {
            this.CombatStyle = CombatStyle;
        }
    }

    public void SetCaptures(int Captures)
    {
        if (Captures >= 0)
        {
            this.Captures = Captures;
        } else
        {
            System.out.println("Captures cannot be negative");
        }
    }

    public void AddCaptures(int Amount)
    {
        this.Captures += Amount;
    }

    @Override
    public void displayProfile()
    {
        super.displayProfile();

        System.out.println(); // Buffer

        System.out.println("Combat Style: " + this.CombatStyle);
        System.out.println("Captures: " + this.Captures);

        System.out.println();
        System.out.print(this.GetName() + " is ");
        performDuty();
    }

    public void performDuty()
    {
        System.out.println("Bounty Hunting...");
    }
}