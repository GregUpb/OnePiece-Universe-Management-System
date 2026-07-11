//Module 2: Affiliation
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MarineCorp{

    private Long ID;
    private String BaseLocation;
    private Marine CorpsCommander = null;
    private int OperationalFunds;
    private List<Marine> CorpMembers = new ArrayList<>();

    MarineCorp(String BaseLocation, Marine CorpsCommander, int OperationalFunds)
    {
        this.GenerateID();

        this.BaseLocation = BaseLocation;
        this.CorpsCommander = CorpsCommander;
        this.OperationalFunds = OperationalFunds;

        CorpMembers.add(CorpsCommander);
    }

    MarineCorp(String BaseLocation, Marine CorpsCommander, int OperationalFunds, List<Marine> CorpMembers)
    {
        this.GenerateID();
        
        this.BaseLocation = BaseLocation;
        this.CorpsCommander = CorpsCommander;
        this.OperationalFunds = OperationalFunds;
        this.CorpMembers = CorpMembers;

        CorpMembers.add(CorpsCommander);
    }

    public Long GetCorpID()
    {
        return this.ID;
    }

    public String GetBaseLocation()
    {
        return this.BaseLocation;
    }

    public Marine GetCorpsCommander()
    {
        return this.CorpsCommander;
    }

    public int GetOperationalFunds()
    {
        return this.OperationalFunds;
    }

    public List<Marine> GetCorpMembers()
    {
        return this.CorpMembers;
    }

    public void SetCorpCommander(Marine CorpCommander)
    {
        // Checks whether the supposed new captain is not in a crew or is already part of the crew
        if (CorpCommander.GetMCorps() == null || CorpCommander.GetMCorps() == this)
        {
            if (this.CorpsCommander != CorpCommander)
            {
                if (this.CorpsCommander != null) { //Checks if there is already an existing captain
                    this.CorpsCommander.SetIsCorpCommander(false);
        
                }
                this.CorpsCommander = CorpCommander;
                CorpCommander.SetIsCorpCommander(true);
                CorpCommander.SetMCorps(this);
            } else
            {
                System.out.println(this.CorpsCommander.GetName() + " is already the Corps Commander");
            }
        } else
        {
            System.out.println(CorpCommander.GetName() + " is not part of " + this.BaseLocation + " Marine Base");
        }

    }

    public void SetBaseLocation(String BaseLocation)
    {
        if (BaseLocation.isBlank())
        {
            System.out.println("Base Location cannot be empty");
        } else
        {
            this.BaseLocation = BaseLocation;
        }
    }

    public void SetOperationalFunds(int OperationalFunds)
    {
        if (OperationalFunds >= 0)
        {
            this.OperationalFunds = OperationalFunds;
        } else
        {
            System.out.println("Operational Funds cannot be negative");
        }
    }

    public void AddOperationalFunds(int Amount)
    {
        this.OperationalFunds += Amount;
    }

    public void AddCorpMember(Marine CorpMember)
    {
        if (!(CorpMembers.contains(CorpMember)))
        {
            if (CorpMember.GetMCorps() != null && CorpMember.GetMCorps() != this)
            {
                CorpMember.GetMCorps().RemoveCorpMember(CorpMember);
            }

            CorpMembers.add(CorpMember);

            if (CorpMember.GetMCorps() != this)
            {
                CorpMember.SetMCorps(this);
            }
        }
    }

    public void RemoveCorpMember(Marine CorpMember)
    {
        if (CorpMembers.contains(CorpMember))
        {
            if (CorpMember.GetIsCorpCommander())
            {
                CorpMember.SetIsCorpCommander(false);
                this.CorpsCommander = null;
            }

            CorpMembers.remove(CorpMember);
            CorpMember.SetMCorps(null);
        }
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }

}