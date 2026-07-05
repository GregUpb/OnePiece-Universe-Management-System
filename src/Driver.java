import java.util.List;
import java.util.Locale.Category;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    
    private static List<Character> CharacterList = new ArrayList<>();
    private static List<DevilFruit> DevilFruitList = new ArrayList<>();
    private static List<PirateCrew> PirateCrewList = new ArrayList<>();
    private static List<MarineCorp> MarineCorpList = new ArrayList<>(); 

    private static List<String> Roles = new ArrayList<>(List.of(
        "None",
        "Captain", 
        "First Mate", 
        "Second Mate", 
        "Boatswain", 
        "Cook", 
        "Doctor", 
        "Navigator", 
        "Shipwright", 
        "Sniper", 
        "Archaeologist", 
        "Assassin", 
        "Barber", 
        "Beast Tamer", 
        "Blacksmith", 
        "Cabin Mate", 
        "Chronicler", 
        "Commando", 
        "Devil Fruit Specialist", 
        "Helmsman", 
        "Infantry", 
        "Instructor", 
        "Janitor", 
        "Lookout", 
        "Quartermaster", 
        "Martial Artist", 
        "Merchant", 
        "Musician", 
        "Pet", 
        "Rigger", 
        "Scholar", 
        "Staff", 
        "Swashbuckler", 
        "Swordsman", 
        "Tailor"
    ));

    private static List<String> Ranks = new ArrayList<>(List.of(
        "None",
        "World Government Commander-In-Chief", 
        "Fleet Admiral", 
        "Admiral", 
        "Vice Admiral", 
        "Rear Admiral", 
        "Commodore", 
        "Captain", 
        "Commander", 
        "Lieutenant Commander", 
        "Lieutenant", 
        "Lieutenant Junior Grade", 
        "Ensign", 
        "Warrant Officer", 
        "Master Chief Petty Officer", 
        "Chief Petty Officer", 
        "Petty Officer", 
        "Seaman First Class", 
        "Seaman Apprentice", 
        "Seaman Recruit", 
        "Chore Boy"
    ));

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int choice = 0;

        /* NOT FINAL */

        do {
            System.out.println("=====[ One Piece Universe Management System ]=====");
            System.out.println("[1] - Characters");
            System.out.println("[2] - Devil Fruits");
            System.out.println("[3] - Pirate Crew");
            System.out.println("[4] - Marine Corp");
            System.out.println("[5] - Quit");

            System.out.print("> ");
            
            choice = getChoice();

            switch (choice) {
                case 1:
                    Characters();
                    break;
                case 2:

                    CharacterList.get(0).displayProfile();

                    DevilFruits();
                    break;
                case 3:
                    PirateCrews();
                    break;
                case 4:
                    MarineCorps();
                    break;
                case 5:
                    break;
            
                default:
                    System.out.println("Invalid Input");
                    break;
            }

        } while (choice != 5);

    }

    public static void Characters()
    {
        // int input;

        System.out.println("[1] - Pirate");
        System.out.println("[2] - Marine");
        System.out.println("[3] - Pirate Hunter");
        System.out.println("[4] - Civilian");
        System.out.print("> ");

        switch (getChoice()) {
            case 1: // Pirate
                CreateCharacter("Pirate");
                break;
            case 2: // Marine
                CreateCharacter("Marine");
                break;
            case 3: // Pirate Hunter
                CreateCharacter("PirateHunter");
                break;
            case 4: // Civilian
                CreateCharacter("Civilian");
                break;
        
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public static void DevilFruits()
    {

    }

    public static void PirateCrews()
    {

    }
    
    public static void MarineCorps()
    {

    }

    
    public static void CreateCharacter(String type)
    {
        // 
        String name, alias, origin, status;
        int dfIndex, wallet;

        name = getInput("Name");
        alias = getInput("Alias (leave blank if none)");
        origin = getInput("Origin");

        // Status Verification
        do {
            status = getInput("Status");

            if (!(status.equalsIgnoreCase("alive") || status.equalsIgnoreCase("captured") || status.equalsIgnoreCase("dead")))
            {
                System.out.println("Status can only be \"Alive\", \"Captured\" or \"Dead\".");
            }
        } while (!(status.equalsIgnoreCase("alive") || status.equalsIgnoreCase("captured") || status.equalsIgnoreCase("dead")));
        
        // Devil Fruit Selection
        do {
            displayDF();
            dfIndex = getChoice();

            if (dfIndex < 0 || dfIndex > DevilFruitList.size())
            {
                System.out.println("Invalid Index");
            }
        } while (dfIndex < 0 || dfIndex > DevilFruitList.size());

        // Wallet Verification
        do {
            System.out.print("Enter Wallet:");
            wallet = getChoice();

            if (wallet < 0)
            {
                System.out.println("Wallet cannot be negative");
            }
        } while (wallet < 0);

        // Type specific
        switch (type) {
            case "Pirate":

                int Bounty, RoleIndex, CrewIndex;
                Boolean IsCaptain = true;
                String buffer;

                // Bounty Verification
                do {
                    System.out.print("Enter Bounty:");
                    Bounty = getChoice();

                    if (Bounty < 0)
                    {
                        System.out.println("Bounty cannot be negative");
                    }
                } while (Bounty < 0);


                // Role Verification
                do {
                    displayRole();
                    RoleIndex = getChoice();

                    if (RoleIndex < 0 || RoleIndex > Roles.size())
                    {
                        System.out.println("Invalid Index");
                    }
                } while (RoleIndex < 0 || RoleIndex > Roles.size());

                // Captain
                do {
                    System.out.print("Captain (Y/N): ");
                    
                    buffer = scanner.nextLine();
                    if (buffer.equalsIgnoreCase("Y"))
                    {
                        IsCaptain = true;
                    } else if (buffer.equalsIgnoreCase("N"))
                    {
                        IsCaptain = false;
                    } else
                    {
                        System.out.println("Answer with Y or N");
                    }
                } while (!(buffer.equalsIgnoreCase("Y") || buffer.equalsIgnoreCase("N")));

                // Crew Verification
                do {
                    displayCrew();
                    CrewIndex = getChoice();

                    if (CrewIndex < 0 || CrewIndex > PirateCrewList.size())
                    {
                        System.out.println("Invalid Index");
                    }
                } while (CrewIndex < 0 || CrewIndex > PirateCrewList.size());

                Pirate temp;
                // Selection of modified creation
                if (dfIndex == 0 && CrewIndex == 0)
                {
                    temp = new Pirate(name, alias, origin, status, wallet, Bounty, Roles.get(RoleIndex), IsCaptain);
                } else if (dfIndex > 0 && CrewIndex == 0)
                {
                    temp = new Pirate(name, alias, origin, status, DevilFruitList.get(dfIndex-1), wallet, Bounty, Roles.get(RoleIndex), IsCaptain);
                } else if (dfIndex == 0 && CrewIndex > 0)
                {
                    temp = new Pirate(name, alias, origin, status, wallet, Bounty, Roles.get(RoleIndex), IsCaptain, PirateCrewList.get(CrewIndex));
                } else
                {
                    temp = new Pirate(name, alias, origin, status, DevilFruitList.get(dfIndex-1), wallet, Bounty, Roles.get(RoleIndex), IsCaptain, PirateCrewList.get(CrewIndex));
                }

                CharacterList.add(temp);

                break;
            case "Marine":
                
                break;
            case "PirateHunter":
                
                break;
            case "Civilian":
                
                break;
        
            default:
                break;
        }
    }

    public static void displayDF()
    {
        System.out.println("[ Devil Fruit ]");

        System.out.println("[0] - None");        
        for (DevilFruit df : DevilFruitList)
        {
            System.out.println("[" + (DevilFruitList.indexOf(df) + 1) + "] - " + df.GetFruitName());
        }
    }

    public static void displayRole()
    {
        System.out.println("[ Role ]");
  
        for (String s : Roles)
        {
            System.out.println("[" + Roles.indexOf(s) + "] - " + s);
        }
    }

    public static void displayRank()
    {
        System.out.println("[ Rank ]");
     
        for (String s : Ranks)
        {
            System.out.println("[" + Ranks.indexOf(s) + "] - " + s);
        }
    }

    public static void displayCrew()
    {
        System.out.println("[ Pirate Crew ]");

        System.out.println("[0] - None");        
        for (PirateCrew p : PirateCrewList)
        {
            System.out.println("[" + (PirateCrewList.indexOf(p) + 1) + "] - " + p.GetCrewName());
        }
    }

    public static void displayCorp()
    {
        System.out.println("[ Marine Corp ]");

        System.out.println("[0] - None");        
        for (MarineCorp p : MarineCorpList)
        {
            System.out.println("[" + (MarineCorpList.indexOf(p) + 1) + "] - " + p.GetBaseLocation());
        }
    }
    
    /* HELPER */
    public static int getChoice()
    {
        int choice;

        if (scanner.hasNextInt())
        {
            choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } else
        {
            scanner.nextLine();
            return -1;
        }
    }

    public static String getInput(String text)
    {
        System.out.print("Enter " + text + ": ");
        return scanner.nextLine();
    }
}
