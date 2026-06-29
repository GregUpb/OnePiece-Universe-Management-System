//Module 1: Characters
abstract class Character{
    private int CharID; //
    private String Name;
    private String Alias;
    private String Origin;
    private String Status;
    private String DFPower;
    private int Wallet;

    abstract void displayProfile();
    abstract void performDuty();
}