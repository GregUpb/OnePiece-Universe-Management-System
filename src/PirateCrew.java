//Module 2: Affiliation
import java.util.List;
import java.util.ArrayList;

public class PirateCrew {

    private int CrewID;
    private String CrewName;
    private String ShipsName;
    private Pirate Captain;
    private List<Pirate> CrewMembers = new ArrayList<>();
    private int TotalCrewBounty;


    PirateCrew(String CrewName, String ShipsName, Pirate Captain, int TotalCrewBounty)
    {
        this.CrewName = CrewName;
        this.ShipsName = ShipsName;
        this.Captain = Captain;
        this.TotalCrewBounty = TotalCrewBounty;
    }
    
    PirateCrew(String CrewName, String ShipsName, Pirate Captain, List<Pirate> CrewMembers, int TotalCrewBounty)
    {
        this.CrewName = CrewName;
        this.ShipsName = ShipsName;
        this.Captain = Captain;
        this.CrewMembers = CrewMembers;
        this.TotalCrewBounty = TotalCrewBounty;
    }

    public int GetCrewID()
    {
        return this.CrewID;
    }

    public String GetCrewName()
    {
        return this.CrewName;
    }

    public String GetShipsName()
    {
        return this.ShipsName;
    }

    public Pirate GetCaptain()
    {
        return this.Captain;
    }

    public List<Pirate> GetCrewMembers()
    {
        return this.CrewMembers;
    }

    public int GetTotalCrewBounty()
    {
        return this.TotalCrewBounty;
    }

    public void SetCrewName(String CrewName)
    {
        this.CrewName = CrewName;
    }

    public void SetShipsName(String ShipsName)
    {
        this.ShipsName = ShipsName;
    }

    public void SetCaptain(Pirate Captain)
    {
        this.Captain = Captain;
    }

    public void SetTotalCrewBounty(int TotalCrewBounty)
    {
        this.TotalCrewBounty = TotalCrewBounty;
    }

    public void AddTotalCrewBounty(int Amount)
    {
        this.TotalCrewBounty += Amount;
    }

    public void AddCrewMember(Pirate CrewMember)
    {
        if (!(CrewMembers.contains(CrewMember)))
        {
            CrewMembers.add(CrewMember);
        }
    }

    public void RemoveCrewMember(Pirate CrewMember)
    {
        if (CrewMembers.contains(CrewMember))
        {
            CrewMembers.remove(CrewMember);
        }
    }
}