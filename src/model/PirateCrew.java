package model;

//Module 2: Affiliation
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PirateCrew {

    private Long ID;
    private String CrewName;
    private String ShipsName;
    private Pirate Captain = null;
    private List<Pirate> CrewMembers = new ArrayList<>();
    private int TotalCrewBounty;
    
    PirateCrew(String CrewName, String ShipsName, Pirate Captain, List<Pirate> CrewMembers)
    {
        this.GenerateID();

        this.CrewName = CrewName;
        this.ShipsName = ShipsName;
        this.Captain = Captain;
        this.CrewMembers = CrewMembers;

        if (Captain != null)
        {
            CrewMembers.add(Captain);
        }
        
        if (!(CrewMembers.isEmpty()))
        {
            this.CalculateTotalCrewBounty();
        }
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
        // Checks whether the supposed new captain is not in a crew or is already part of the crew
        if (Captain.GetPirateCrew() == null || Captain.GetPirateCrew() == this)
        {
            if (this.Captain != Captain)
            {
                if (this.Captain != null) { //Checks if there is already an existing captain
                    this.Captain.SetIsCaptain(false);
                    this.Captain.SetPirateRole("Crew Member");
                    
                }
                this.Captain = Captain;
                Captain.SetIsCaptain(true);
                Captain.SetPirateRole("Captain");
                Captain.SetPirateCrew(this);

                System.out.println(Captain.GetName() + " is now the captain of " + this.CrewName);
            } else
            {
                System.out.println(this.Captain.GetName() + " is already the Captain");
            }
        } else
        {
            System.out.println(Captain.GetName() + " is not part of " + this.CrewName);
        }

    }

    public void CalculateTotalCrewBounty()
    {
        int TotalCrewBounty = 0;

        // Add all the bounty of the crew members
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
        //Check if pirate is not in the list
        if (!(CrewMembers.contains(CrewMember)))
        {
            // Overwrite its crew with the new crew
            if (CrewMember.GetPirateCrew() != null && CrewMember.GetPirateCrew() != this)
            {
                CrewMember.GetPirateCrew().RemoveCrewMember(CrewMember);
            }
            
            CrewMembers.add(CrewMember);

            // Set the crew and role
            if (CrewMember.GetPirateCrew() != this)
            {
                CrewMember.SetPirateCrew(this);
            }
            CrewMember.SetPirateRole("Crew Member");

            CalculateTotalCrewBounty();

        } else
        {
            System.out.println(CrewMember.GetName() + " is already part of the " + this.CrewName);
        }
    }

    public void RemoveCrewMember(Pirate CrewMember)
    {
        if (CrewMembers.contains(CrewMember))
        {
            // Check if the member is a captain, remove it
            if (CrewMember.IsCaptain())
            {
                CrewMember.SetIsCaptain(false);
                this.Captain = null;
            }
            
            CrewMember.SetPirateRole("None");
            CrewMembers.remove(CrewMember);
            CrewMember.SetPirateCrew(null);

            CalculateTotalCrewBounty();
        } else
        {
            System.out.println(CrewMember.GetName() + " is not part of the " + this.CrewName);
        }
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }
}