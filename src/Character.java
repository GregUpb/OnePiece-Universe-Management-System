//Module 1: Characters
abstract class Character{
    private int CharID; //
    private String Name;
    private String Alias;
    private String Origin;
    private String Status;
    private DevilFruit DFPower;
    private int Wallet;

    abstract void displayProfile();
    abstract void performDuty();

    public Character(String Name, String Alias, String Origin, String Status, int Wallet)
    {
        this.Name = Name;
        this.Alias = Alias;
        this.Origin = Origin;
        this.Status = Status;
        this.Wallet = Wallet;
    }

    public Character(String Name, String Alias, String Origin, String Status, DevilFruit DFPower, int Wallet)
    {
        this.Name = Name;
        this.Alias = Alias;
        this.Origin = Origin;
        this.Status = Status;
        this.DFPower = DFPower;
        this.Wallet = Wallet;
    }

    public int GetCharID()
    {
        return this.CharID;
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
    }

    public void SetDFPower(DevilFruit DFPower)
    {
        this.DFPower = DFPower;
    }

    public void SetWallet(int Wallet)
    {
        this.Wallet = Wallet;
    }

    

}