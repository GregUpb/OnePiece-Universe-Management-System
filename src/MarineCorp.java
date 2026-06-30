//Module 2: Affiliation
import java.util.List;
import java.util.ArrayList;

public class MarineCorp{

    private int CorpID;
    private String BaseLocation;
    private Character CorpsCommander;
    private int OperationalFunds;
    private List<Character> CorpMembers = new ArrayList<>();

    MarineCorp(String BaseLocation, Character CorpsCommander, int OperationalFunds)
    {
        this.BaseLocation = BaseLocation;
        this.CorpsCommander = CorpsCommander;
        this.OperationalFunds = OperationalFunds;
    }

    MarineCorp(String BaseLocation, Character CorpsCommander, int OperationalFunds, List<Character> CorpMembers)
    {
        this.BaseLocation = BaseLocation;
        this.CorpsCommander = CorpsCommander;
        this.OperationalFunds = OperationalFunds;
        this.CorpMembers = CorpMembers;
    }

    public int GetCorpID()
    {
        return this.CorpID;
    }

    public String GetBaseLocation()
    {
        return this.BaseLocation;
    }

    public Character GetCorpsCommander()
    {
        return this.CorpsCommander;
    }

    public int GetOperationalFunds()
    {
        return this.OperationalFunds;
    }

    public List<Character> GetCorpMembers()
    {
        return this.CorpMembers;
    }

    public void SetBaseLocation(String BaseLocation)
    {
        this.BaseLocation = BaseLocation;
    }

    public void SetCorpsCommander(Character CorpsCommander)
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

    public void AddCorpMember(Character CorpMember)
    {
        if (!(CorpMembers.contains(CorpMember)))
        {
            CorpMembers.add(CorpMember);
        }
    }

    public void RemoveCorpMember(Character CorpMember)
    {
        if (CorpMembers.contains(CorpMember))
        {
            CorpMembers.remove(CorpMember);
        }
    }

}