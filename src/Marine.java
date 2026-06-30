//Module 1: Characters
public class Marine extends Character{

    private String Rank;
    private MarineCorp MCorps = null;

    Marine(String Name, String Alias, String Origin, String Status, int Wallet, String Rank)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Rank = Rank;
    }
    
    Marine(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String Rank)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Rank = Rank;
    }

    Marine(String Name, String Alias, String Origin, String Status, int Wallet, String Rank, MarineCorp MCorps)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Rank = Rank;
        this.MCorps = MCorps;
    }
    
    Marine(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String Rank, MarineCorp MCorps)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Rank = Rank;
        this.MCorps = MCorps;
    }

    public String GetRank()
    {
        return this.Rank;
    }

    public MarineCorp GetMCorps()
    {
        return this.MCorps;
    }

    public void SetRank(String Rank)
    {
        this.Rank = Rank;
    }

    public void SetMCorps(MarineCorp MCorps)
    {
        this.MCorps = MCorps;
    }

    public void displayProfile()
    {

    }

    public void performDuty()
    {

    }

}