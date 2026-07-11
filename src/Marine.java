//Module 1: Characters
import java.util.ArrayList;
import java.util.List;

public class Marine extends Character{

    private String Rank;
    private MarineCorp MCorps = null;
    private boolean isCorpCommander;

    public static final List<String[]> Ranks = new ArrayList<>(List.of(
        new String[] {"None", "Doing nothing..."},
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

    Marine(String Name, String Alias, String Origin, String Status, int Wallet, String Rank, boolean isCorpCommander)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Rank = Rank;
        this.isCorpCommander = isCorpCommander;
    }
    
    Marine(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String Rank, boolean isCorpCommander)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Rank = Rank;
        this.isCorpCommander = isCorpCommander;
    }

    Marine(String Name, String Alias, String Origin, String Status, int Wallet, String Rank, MarineCorp MCorps, boolean isCorpCommander)
    {
        super(Name, Alias, Origin, Status, Wallet);

        this.Rank = Rank;
        this.MCorps = MCorps;
        this.isCorpCommander = isCorpCommander;
    }
    
    Marine(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String Rank, MarineCorp MCorps, boolean isCorpCommander)
    {
        super(Name, Alias, Origin, Status, DFPower, Wallet);

        this.Rank = Rank;
        this.MCorps = MCorps;
        this.isCorpCommander = isCorpCommander;
    }

    public String GetRank()
    {
        return this.Rank;
    }

    public MarineCorp GetMCorps()
    {
        return this.MCorps;
    }

    public boolean GetIsCorpCommander()
    {
        return this.isCorpCommander;
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
        // If they are already in a crew, remove them from the old crew's list first
        if (this.MCorps != null) {
            this.MCorps.RemoveCorpMember(this);
        }

        this.MCorps = MCorps;

        // If they are not part of the crew then add
        if (MCorps != null)
        {
            if (!(MCorps.GetCorpMembers().contains(this)))
            {
                MCorps.AddCorpMember(this);
            }
        }
    }

    @Override
    public void displayProfile()
    {
        super.displayProfile();

        System.out.println(); // Buffer

        System.out.println("Rank: " + this.Rank);
        System.out.print("Corp Commander: ");
        if (isCorpCommander)
        {
            System.out.println("Yes");
        } else
        {
            System.out.println("No");
        }
        
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