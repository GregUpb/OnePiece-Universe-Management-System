//Module 1: Characters
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Character{
    private long ID;
    private String Name;
    private String Alias;
    private String Origin;
    private String Status;
    private DevilFruit DFPower = null;
    private int Wallet;

    abstract void performDuty();

    public Character(String Name, String Alias, String Origin, String Status, int Wallet)
    {
        this.GenerateID();

        this.Name = Name;
        this.Alias = Alias;
        this.Origin = Origin;
        this.Status = Status;
        this.Wallet = Wallet;
    }

    public Character(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet)
    {
        this.GenerateID();

        this.Name = Name;
        this.Alias = Alias;
        this.Origin = Origin;
        this.Status = Status;
        this.DFPower = DFPower;
        this.Wallet = Wallet;
    }

    public long GetID()
    {
        return this.ID;
    }

    public String GetName()
    {
        return this.Name;
    }

    public String GetAlias()
    {
        return this.Alias;
    }

    public String GetOrigin()
    {
        return this.Origin;
    }

    public String GetStatus()
    {
        return this.Status;
    }

    public DevilFruit GetDFPower()
    {
        return this.DFPower;
    }

    public int GetWallet()
    {
        return this.Wallet;
    }


    public void SetName(String Name)
    {
        if (Name.isBlank())
        {
            System.out.println("Name cannot be blank");
        } else
        {
            this.Name = Name;
        }
    }

    public void SetAlias(String Alias)
    {
        this.Alias = Alias;
    }

    public void SetOrigin(String Origin)
    {
        if (Origin.isBlank())
        {
            System.out.println("Origin cannot be blank");
        } else
        {
            this.Origin = Origin;
        }
    }

    public void SetStatus(String Status)
    {
        if (this instanceof Pirate)
        {
            if (Status.equalsIgnoreCase("alive") || Status.equalsIgnoreCase("captured") || Status.equalsIgnoreCase("dead"))
            {
                this.Status = Status;
            }
        } else
        {
            if (Status.equalsIgnoreCase("alive") || Status.equalsIgnoreCase("dead"))
            {
                this.Status = Status;
            }
        }

        //Reincarnation Trigger
        if (this.Status.equalsIgnoreCase("dead") && this.DFPower != null) {
            this.DFPower.TriggerReinc();
        }

    }

    public void SetDFPower(DevilFruit DFPower)
    {
        if (DFPower == null)
        {
            this.DFPower = null;
            return; // Exit the method early so it doesn't run the rest of the code
        }

        if (!(DFPower.GetHistoricalOwners().contains(this)))
        {
            if (this.DFPower == null)
            {
                // Check if the Devil Fruit has a current owner
                if (!(DFPower.HasCurrentOwner()))
                {
                    // set this character as the new current owner
                    this.DFPower = DFPower;
                    DFPower.SetCurrentOwner(this);
                }
            }else if (this.DFPower != DFPower)
            {
                System.out.println("Already have a devil fruit");
            }
        } else
        {
            System.out.println(this.Name + " is already a former " + DFPower.GetFruitName() + " user");
        }

    }

    public void SetWallet(int Wallet)
    {
        if (Wallet >= 0)
        {
            this.Wallet = Wallet;
        } else
        {
            System.out.println("Wallet cannot be negative");
        }
    }

    public void displayProfile()
    {
        System.out.println("=[ Profile ]=");
        System.out.println("ID: " + this.GetID());
        System.out.println("Name: " + this.GetName());
        System.out.println("Alias: " + this.GetAlias());
        System.out.println("Origin: " + this.GetOrigin());
        if (this.GetDFPower() != null)
        {
            System.out.println("Devil Fruit: " + this.GetDFPower().GetFruitName());
        } else
        {
            System.out.println("Devil Fruit: None");
        }
        System.out.println("Wallet: " + this.GetWallet());
        System.out.println("Status: " + this.GetStatus());
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }
    

}