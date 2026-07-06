//Module 1: Characters
import java.util.ArrayList;
import java.util.List;

public class Marine extends Character{

    private String Rank;
    private MarineCorp MCorps = null;

    final List<String[]> Ranks = new ArrayList<>(List.of(
        new String[] {"World Government Commander-In-Chief", "KING KINGINA MO"},
        new String[] {"Fleet Admiral", "KING KINGINA MO"},
        new String[] {"Admiral", "KING KINGINA MO"},
        new String[] {"Vice Admiral", "KING KINGINA MO"},
        new String[] {"Rear Admiral", "KING KINGINA MO"},
        new String[] {"Commodore", "KING KINGINA MO"},
        new String[] {"Captain", "KING KINGINA MO"},
        new String[] {"Commander", "KING KINGINA MO"},
        new String[] {"Lieutenant Commander", "KING KINGINA MO"},
        new String[] {"Lieutenant", "KING KINGINA MO"},
        new String[] {"Lieutenant Junior Grade", "KING KINGINA MO"},
        new String[] {"Ensign", "KING KINGINA MO"},
        new String[] {"Warrant Officer", "KING KINGINA MO"},
        new String[] {"Master Chief Petty Officer", "KING KINGINA MO"},
        new String[] {"Chief Petty Officer", "KING KINGINA MO"},
        new String[] {"Petty Officer", "KING KINGINA MO"},
        new String[] {"Seaman First Class", "KING KINGINA MO"},
        new String[] {"Seaman Apprentice", "KING KINGINA MO"},
        new String[] {"Seaman Recruit", "KING KINGINA MO"},
        new String[] {"Chore Boy", "KING KINGINA MO"}
    ));

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

    public List<String[]> GetRanks()
    {
        return this.Ranks;
    }

    public void SetRank(String Rank)
    {
        for (String[] s : Ranks)
        {
            if (Rank.equalsIgnoreCase(s[0]))
            {
                this.Rank = s[0];  // Set to the requested rank but with a format
            }
        }
    }

    public void SetMCorps(MarineCorp MCorps)
    {
        this.MCorps = MCorps;
    }

    @Override
    public void displayProfile()
    {
        super.displayProfile();

        System.out.println(""); // Buffer

        System.out.println("Rank: " + this.Rank);
        if (this.MCorps != null)
        {
            System.out.println("Corp Designated: " + this.MCorps.GetBaseLocation());
        } else
        {
            System.out.println("Corp Designated: None");
        }
    }

    public void performDuty()
    {
        for (String[] s : Ranks)
        {
            if (this.Rank.equalsIgnoreCase(s[0]))
            {
                System.out.println(s[1]);
            }
        }
    }

}