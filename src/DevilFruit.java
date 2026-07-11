//Module 3: Devil Fruit
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DevilFruit{

    private Long ID;
    private String FruitName;
    private String Category;
    private String PrimaryAbility;
    private Character CurrentOwner = null;
    private List<Character> HistoricalOwners = new ArrayList<>();

    DevilFruit(String FruitName, String Category, String PrimaryAbility)
    {
        this.GenerateID();

        this.FruitName = FruitName;
        this.Category = Category;
        this.PrimaryAbility = PrimaryAbility;
    }

    DevilFruit(String FruitName, String Category, String PrimaryAbility, Character CurrentOwner)
    {
        this.GenerateID();

        this.FruitName = FruitName;
        this.Category = Category;
        this.PrimaryAbility = PrimaryAbility;
        this.CurrentOwner = CurrentOwner;
    }

    DevilFruit(String FruitName, String Category, String PrimaryAbility, List<Character> HistoricalOwners)
    {
        this.GenerateID();

        this.FruitName = FruitName;
        this.Category = Category;
        this.PrimaryAbility = PrimaryAbility;
        this.HistoricalOwners = HistoricalOwners;
    }

    DevilFruit(String FruitName, String Category, String PrimaryAbility, Character CurrentOwner, List<Character> HistoricalOwners)
    {
        this.GenerateID();

        this.FruitName = FruitName;
        this.Category = Category;
        this.PrimaryAbility = PrimaryAbility;
        this.CurrentOwner = CurrentOwner;
        this.HistoricalOwners = HistoricalOwners;
    }

    public Long GetFruitID()
    {
        return this.ID;
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
        if (FruitName.isBlank())
        {
            System.out.println("Devil Fruit Name cannot be empty");
        } else
        {
            this.FruitName = FruitName;
        }
    }

    public void SetCategory(String Category)
    {
        if (Category.equalsIgnoreCase("paramecia") || Category.equalsIgnoreCase("zoan") || Category.equalsIgnoreCase("logia"))
        {
            this.Category = Category;
        } else
        {
            System.out.println("Invalid Devil Fruit Category");
        }
    }

    public void SetPrimaryAbility(String PrimaryAbility)
    {
        this.PrimaryAbility = PrimaryAbility;
    }

    public void SetCurrentOwner(Character CurrentOwner)
    {
        if (!(this.HistoricalOwners.contains(CurrentOwner)))
        {
            if (this.CurrentOwner == null && CurrentOwner.GetDFPower() == null)
            {
                this.CurrentOwner = CurrentOwner;
                CurrentOwner.SetDFPower(this);
            } else if (this.CurrentOwner == null && CurrentOwner.GetDFPower() == this)
            {
                this.CurrentOwner = CurrentOwner;
            }
        } else
        {
            System.out.println(CurrentOwner.GetName() + " is already a former " + this.FruitName + " user");
        }
    }

    public boolean HasCurrentOwner(){ // Validation checks for Character Constructor
        return this.CurrentOwner != null;
    }

    /* STUFF */

    public void AddHistoricalOwner(Character HistoricalOwner)
    {
        if (!(HistoricalOwners.contains(HistoricalOwner)))
        {
            HistoricalOwners.add(HistoricalOwner);
        } else if (CurrentOwner == HistoricalOwner && CurrentOwner.GetStatus().equalsIgnoreCase("dead"))
        {
            this.TriggerReinc();
        } else
        {
            System.out.println(HistoricalOwner.GetName() + " is already a former " + this.FruitName + " user");
        }
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }

    public void TriggerReinc()
    {
        if (this.CurrentOwner != null){
            this.AddHistoricalOwner(this.CurrentOwner);
            this.CurrentOwner.SetDFPower(null);
            this.CurrentOwner = null;
        }
    }
}