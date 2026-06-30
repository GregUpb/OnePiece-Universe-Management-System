//Module 2: Affiliation
import java.util.List;
import java.util.ArrayList;

public class PirateCrew {

    private int CrewID;
    private String CrewName;
    private String ShipsName;
    private String Captain;
    private List<Character> CrewMembers = new ArrayList<>();
    private int TotalCrewBounty;

    /* Can A Pirate Hunter be the Captain of a Pirate Crew??? */

    PirateCrew(String CrewName, String ShipsName, String Captain, int TotalCrewBounty)
    {
        this.CrewName = CrewName;
        this.ShipsName = ShipsName;
        this.Captain = Captain;
        this.TotalCrewBounty = TotalCrewBounty;
    }
    
    PirateCrew(String CrewName, String ShipsName, String Captain, List<Character> CrewMembers, int TotalCrewBounty)
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

    public String GetCaptain()
    {
        return this.Captain;
    }

    public List<Character> GetCrewMembers()
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

    public void SetCaptain(String Captain)
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

    public void AddCrewMember(Character CrewMember)
    {
        if (!(CrewMembers.contains(CrewMember)))
        {
            CrewMembers.add(CrewMember);
        }
    }

    public void RemoveCrewMember(Character CrewMember)
    {
        if (CrewMembers.contains(CrewMember))
        {
            CrewMembers.remove(CrewMember);
        }
    }
}