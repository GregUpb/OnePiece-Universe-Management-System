//Module 1: Characters
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

abstract class Character{
    private long ID;
    private String Name;
    private String Alias;
    private String Origin;
    private String Status;
    private DevilFruit DFPower;
    private int Wallet;

    private List<String[]> Roles = new ArrayList<>(List.of(
        new String[] {"Captain", "I AM THE CAPTAIN NIGGERSSSSSSSSSS"}, 
        new String[] {"First Mate", "COPY PASTE"},
        new String[] {"Second Mate", "COPY PASTE"},
        new String[] {"Boatswain", "COPY PASTE"},
        new String[] {"Cook", "COPY PASTE"},
        new String[] {"Doctor", "COPY PASTE"},
        new String[] {"Navigator", "COPY PASTE"},
        new String[] {"Shipwright", "COPY PASTE"},
        new String[] {"Sniper", "COPY PASTE"},
        new String[] {"Archaeologist", "COPY PASTE"},
        new String[] {"Assassin", "COPY PASTE"},
        new String[] {"Barber", "COPY PASTE"},
        new String[] {"Beast Tamer", "COPY PASTE"},
        new String[] {"Blacksmith", "COPY PASTE"},
        new String[] {"Cabin Mate", "COPY PASTE"},
        new String[] {"Chronicler", "COPY PASTE"},
        new String[] {"Commando", "COPY PASTE"},
        new String[] {"Devil Fruit Specialist", "COPY PASTE"},
        new String[] {"Helmsman", "COPY PASTE"},
        new String[] {"Infantry", "COPY PASTE"},
        new String[] {"Instructor", "COPY PASTE"},
        new String[] {"Janitor", "COPY PASTE"},
        new String[] {"Lookout", "COPY PASTE"},
        new String[] {"Quartermaster", "COPY PASTE"},
        new String[] {"Martial Artist", "COPY PASTE"},
        new String[] {"Merchant", "COPY PASTE"},
        new String[] {"Musician", "COPY PASTE"},
        new String[] {"Pet", "COPY PASTE"},
        new String[] {"Rigger", "COPY PASTE"},
        new String[] {"Scholar", "COPY PASTE"},
        new String[] {"Staff", "COPY PASTE"},
        new String[] {"Swashbuckler", "COPY PASTE"},
        new String[] {"Swordsman", "COPY PASTE"},
        new String[] {"Tailor", "COPY PASTE"}
    ));

    abstract void displayProfile();
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

    public List<String[]> GetRoles()
    {
        return this.Roles;
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
        this.DFPower = DFPower;
    }

    public void SetWallet(int Wallet)
    {
        this.Wallet = Wallet;
    }

    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yMdHms"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }
    

}