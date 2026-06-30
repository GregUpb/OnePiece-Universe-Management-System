//Module 3: Devil Fruit
import java.util.List;
import java.util.ArrayList;
public class DevilFruit{

    private int FruitID;
    private String FruitName;
    private String Category;
    private String PrimaryAbility;
    private Character CurrentOwner;
    private List<Character> HistoricalOwners = new ArrayList<>();

    DevilFruit(String FruitName, String Category, String PrimaryAbility)
    {
        this.FruitName = FruitName;
        this.Category = Category;
        this.PrimaryAbility = PrimaryAbility;
    }

    DevilFruit(String FruitName, String Category, String PrimaryAbility, Character CurrentOwner)
    {
        this.FruitName = FruitName;
        this.Category = Category;
        this.PrimaryAbility = PrimaryAbility;
        this.CurrentOwner = CurrentOwner;
    }

    DevilFruit(String FruitName, String Category, String PrimaryAbility, Character CurrentOwner, List<Character> HistoricalOwners)
    {
        this.FruitName = FruitName;
        this.Category = Category;
        this.PrimaryAbility = PrimaryAbility;
        this.CurrentOwner = CurrentOwner;
        this.HistoricalOwners = HistoricalOwners;
    }

    public int GetFruitID()
    {
        return this.FruitID;
    }

    public String GetFruitName()
    {
        return this.FruitName;
    }

    public String GetCategory()
    {
        return this.Category;
    }

    public String GetPrimaryAbility()
    {
        return this.PrimaryAbility;
    }

    public Character GetCurrentOwner()
    {
        return this.CurrentOwner;
    }

    public List<Character> GetHistoricalOwners()
    {
        return this.HistoricalOwners;
    }

    public void SetFruitName(String FruitName)
    {
        this.FruitName = FruitName;
    }

    public void SetCategory(String Category)
    {
        this.Category = Category;
    }

    public void SetPrimaryAbility(String PrimaryAbility)
    {
        this.PrimaryAbility = PrimaryAbility;
    }

    public void SetCurrentOwner(Character CurrentOwner)
    {
        this.CurrentOwner = CurrentOwner;
    }

    /* STUFF */

    public void AddHistoricalOwner(Character HistoricalOwner)
    {
        if (!(HistoricalOwners.contains(HistoricalOwner)))
        {
            HistoricalOwners.add(HistoricalOwner);
        }
    }

    public void RemoveHistoricalOwner(Character HistoricalOwner)
    {
        if (HistoricalOwners.contains(HistoricalOwner))
        {
            HistoricalOwners.remove(HistoricalOwner);
        }
    }


}