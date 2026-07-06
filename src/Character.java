//Module 1: Characters
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

abstract class Character{
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
        this.Name = Name;
    }

    public void SetAlias(String Alias)
    {
        this.Alias = Alias;
    }

    public void SetOrigin(String Origin)
    {
        this.Origin = Origin;
    }

    public void SetStatus(String Status)
    {
        this.Status = Status;

        //Reincarnation Trigger
        if (this.Status.equalsIgnoreCase("dead") && this.DFPower != null) {
            this.DFPower.TriggerReinc();
        }

    }

    public void SetDFPower(DevilFruit DFPower)
    {
        // Check if the Devil Fruit has a current owner
        if (DFPower.HasCurrentOwner())
        {
            // make the owner a former
            DFPower.AddHistoricalOwner(DFPower.GetCurrentOwner());
            DFPower.SetCurrentOwner(this);  // set this character as the new current owner
            this.DFPower = DFPower;
        } else
        {
            // set this character as the new current owner
            DFPower.SetCurrentOwner(this);
            this.DFPower = DFPower;
        }

    }

    public void SetWallet(int Wallet)
    {
        this.Wallet = Wallet;
    }

    public void displayProfile()
    {
        System.out.println("===[ Profile ]===");
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