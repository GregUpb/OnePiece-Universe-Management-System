package model;

//Module 1: Characters
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Marine extends Character implements Serializable{

    private String Rank;
    private MarineCorp MCorps = null;
    private boolean isCorpCommander = false;

    public static final List<String[]> RANKS = new ArrayList<>(List.of(
        new String[] {"None", "Doing nothing..."},
        new String[] {"Fleet Admiral", "Commanding the entire Marine organization while eating donuts..."},
        new String[] {"Admiral", "Leading major campaigns and calling Buster Calls..."},
        new String[] {"Vice Admiral", "Commanding Marine fleets..."},
        new String[] {"Rear Admiral", "Overseeing regional Marine forces..."},
        new String[] {"Commodore", "Managing major Marine bases and operations..."},
        new String[] {"Captain", "Commanding a Marine warship and base..."},
        new String[] {"Commander", "Assisting captains and leading specialized units..."},
        new String[] {"Lieutenant Commander", "Executing tactical missions and patrols..."},
        new String[] {"Lieutenant", "Leading squads and executing direct orders..."},
        new String[] {"Lieutenant Junior Grade", "Assisting senior officers in field ops..."},
        new String[] {"Ensign", "Commanding lowest-tier tactical units..."},
        new String[] {"Warrant Officer", "Supervising ship operations..."},
        new String[] {"Master Chief Petty Officer", "Managing enlisted personnel and ship logistics..."},
        new String[] {"Chief Petty Officer", "Overseeing daily crew tasks and discipline..."},
        new String[] {"Petty Officer", "Leading basic infantry squads..."},
        new String[] {"Seaman First Class", "Executing standard ship maintenance and combat duties..."},
        new String[] {"Seaman Apprentice", "Performing basic combat and operational tasks..."},
        new String[] {"Seaman Recruit", "Undergoing basic training and ship duties..."},
        new String[] {"Chore Boy", "Cleaning the deck and doing basic chores..."}
    ));

    public Marine(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet, String Rank, MarineCorp MCorps, boolean isCorpCommander)
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

    public void SetIsCorpCommander(Boolean IsCorpCommander)
    {
        if (this.MCorps != null)
        {
            this.isCorpCommander = IsCorpCommander;
            // If IsCaptain is true
            if (IsCorpCommander)
            {
                if (this.GetMCorps().GetCorpsCommander() != this)
                {
                    this.GetMCorps().SetCorpCommander(this);
                }
            }
        } else if (isCorpCommander)
        {
            System.out.println(this.GetName() + " cannot be a captain without a crew");
        }
    }

    public void SetRank(String Rank)
    {
        for (String[] s : RANKS)
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
        if (this.MCorps != null && this.MCorps.GetCorpMembers().contains(this) & this.MCorps != MCorps) {
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

        System.out.println();
        System.out.print(this.GetName() + " is ");
        performDuty();
    }

    public void performDuty()
    {
        for (String[] s : RANKS)
        {
            if (this.Rank.equalsIgnoreCase(s[0]))
            {
                System.out.println(s[1]);
            }
        }
    }

}
