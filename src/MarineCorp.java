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
    }

    MarineCorp(String BaseLocation, Marine CorpsCommander, int OperationalFunds, List<Marine> CorpMembers)
    {
        this.GenerateID();
        
        this.BaseLocation = BaseLocation;
        this.CorpsCommander = CorpsCommander;
        this.OperationalFunds = OperationalFunds;
        this.CorpMembers = CorpMembers;
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

    public void SetCorpsCommander(Marine CorpsCommander)
    {
        if (CorpsCommander.GetMCorps() == this)
        {
            this.CorpsCommander = CorpsCommander;
        } else
        {
            System.out.println(CorpsCommander.GetName() + " is not part of the Marine Corp " + this.BaseLocation + " HQ");
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
            if (CorpMember.GetMCorps() != this)
            {
                CorpMember.GetMCorps().RemoveCorpMember(CorpMember);
            }

            CorpMember.SetMCorps(this);
            CorpMembers.add(CorpMember);
        }
    }

    public void RemoveCorpMember(Marine CorpMember)
    {
        if (CorpMembers.contains(CorpMember))
        {
            CorpMembers.remove(CorpMember);
            CorpMember.SetMCorps(null);
        }
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yMdHms"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }

}