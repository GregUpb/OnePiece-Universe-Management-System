//Module 2: Affiliation
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MarineCorp{

    private Long ID;
    private String BaseLocation;
    private Marine CorpsCommander;
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
        this.BaseLocation = BaseLocation;
    }

    public void SetCorpsCommander(Marine CorpsCommander)
    {
        this.CorpsCommander = CorpsCommander;
    }

    public void SetOperationalFunds(int OperationalFunds)
    {
        this.OperationalFunds = OperationalFunds;
    }

    public void AddOperationalFunds(int Amount)
    {
        this.OperationalFunds += Amount;
    }

    public void AddCorpMember(Marine CorpMember)
    {
        if (!(CorpMembers.contains(CorpMember)))
        {
            CorpMembers.add(CorpMember);
        }
    }

    public void RemoveCorpMember(Marine CorpMember)
    {
        if (CorpMembers.contains(CorpMember))
        {
            CorpMembers.remove(CorpMember);
        }
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yMdHms"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }

}