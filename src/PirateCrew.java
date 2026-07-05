//Module 2: Affiliation
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PirateCrew {

    private Long ID;
    private String CrewName;
    private String ShipsName;
    private Pirate Captain;
    private List<Pirate> CrewMembers = new ArrayList<>();
    private int TotalCrewBounty;


    PirateCrew(String CrewName, String ShipsName, Pirate Captain, int TotalCrewBounty)
    {
        this.GenerateID();

        this.CrewName = CrewName;
        this.ShipsName = ShipsName;
        this.Captain = Captain;
        this.TotalCrewBounty = TotalCrewBounty;
    }
    
    PirateCrew(String CrewName, String ShipsName, Pirate Captain, List<Pirate> CrewMembers, int TotalCrewBounty)
    {
        this.GenerateID();

        this.CrewName = CrewName;
        this.ShipsName = ShipsName;
        this.Captain = Captain;
        this.CrewMembers = CrewMembers;
        this.TotalCrewBounty = TotalCrewBounty;
    }

    public Long GetCrewID()
    {
        return this.ID;
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
        this.Captain.SetIsCaptain(false);
        Captain.SetIsCaptain(true);

        this.Captain = Captain;
    }

    public void CalculateTotalCrewBounty()
    {
        int TotalCrewBounty = 0;

        for (Pirate p : CrewMembers) {
            if (p.GetStatus().equalsIgnoreCase("alive"))
            {
                TotalCrewBounty += p.GetBounty();
            }
        }

        this.TotalCrewBounty = TotalCrewBounty;
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

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yMdHms"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }
}