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
        if (CrewName.isBlank())
        {
            System.out.println("Crew Name cannot be empty");
        } else
        {
            this.CrewName = CrewName;
        }
    }

    public void SetShipsName(String ShipsName)
    {
        if (ShipsName.isBlank())
        {
            System.out.println("Ships Name cannot be empty");
        } else
        {
            this.ShipsName = ShipsName;
        }
    }

    public void SetCaptain(Pirate Captain)
    {
        if (this.Captain != null) { //Checks if there is already an existing captain
            this.Captain.SetIsCaptain(false);
            this.Captain.SetPirateRole("Crew Member");
        }
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
        //Check if pirate is already in the list
        if (!(CrewMembers.contains(CrewMember)))
        {
            CrewMembers.add(CrewMember);

            //Update the Pirate object's crew pointer only if it isn't already set to this crew.
            if (CrewMember.GetPirateCrew() != this)
            {
                CrewMember.SetPirateCrew(this);
            }
        }
    }

    public void RemoveCrewMember(Pirate CrewMember)
    {
        if (CrewMembers.contains(CrewMember))
        {
            CrewMembers.remove(CrewMember);
            // Clear Pirate object's crew pointer only if it's already pointing to this crew.
            if (CrewMember.GetPirateCrew() == this)
            {
                CrewMember.SetPirateCrew(null);
            }
        }
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yMdHms"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }
}