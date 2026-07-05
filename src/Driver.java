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
                int rankIndex, mCorpIndex;

                // Rank Verification
                do {
                    displayRank();
                    rankIndex = getChoice();

                    if (rankIndex < 0 || rankIndex >= Ranks.size()) {
                        System.out.println("Invalid Index");
                    }
                } while (rankIndex < 0 || rankIndex >= Ranks.size());

                // Marine Corp Verification
                do {
                    displayCorp();
                    mCorpIndex = getChoice();

                    if (mCorpIndex < 0 || mCorpIndex > MarineCorpList.size()) {
                        System.out.println("Invalid Index");
                    }
                } while (mCorpIndex < 0 || mCorpIndex > MarineCorpList.size());

                Marine tempMarine;
                String selectedRank = Ranks.get(rankIndex);

                // Selection of modified creation
                if (dfIndex == 0 && mCorpIndex == 0) {
                    tempMarine = new Marine(name, alias, origin, status, wallet, selectedRank);
                } else if (dfIndex > 0 && mCorpIndex == 0) {
                    tempMarine = new Marine(name, alias, origin, status, DevilFruitList.get(dfIndex - 1), wallet, selectedRank);
                } else if (dfIndex == 0 && mCorpIndex > 0) {
                    tempMarine = new Marine(name, alias, origin, status, wallet, selectedRank, MarineCorpList.get(mCorpIndex - 1));
                } else {
                    tempMarine = new Marine(name, alias, origin, status, DevilFruitList.get(dfIndex - 1), wallet, selectedRank, MarineCorpList.get(mCorpIndex - 1));
                }

                CharacterList.add(tempMarine);
                System.out.println();
                System.out.println("Marine successfully registered.");

                break;

            case "PirateHunter":
                String combatStyle;
                int captures;

                combatStyle = getInput("Combat Style");

                // Captures Verification
                do {
                    System.out.print("Enter Confirmed Captures: ");
                    captures = getChoice();

                    if (captures < 0) {
                        System.out.println("Captures cannot be negative.");
                    }
                } while (captures < 0);

                PirateHunter tempHunter;

                if (dfIndex == 0) {
                    tempHunter = new PirateHunter(name, alias, origin, status, wallet, combatStyle, captures);
                } else {
                    tempHunter = new PirateHunter(name, alias, origin, status, DevilFruitList.get(dfIndex - 1), wallet, combatStyle, captures);
                }

                CharacterList.add(tempHunter);
                System.out.println();
                System.out.println("Pirate Hunter successfully registered.");

                break;

            case "Civilian":
                String profession, residence;

                profession = getInput("Profession");
                residence = getInput("Residence");

                Civilian tempCiv;

                if (dfIndex == 0) {
                    tempCiv = new Civilian(name, alias, origin, status, wallet, profession, residence);
                } else {
                    tempCiv = new Civilian(name, alias, origin, status, DevilFruitList.get(dfIndex - 1), wallet, profession, residence);
                }

                CharacterList.add(tempCiv);
                System.out.println("\nCivilian successfully registered.");
                break;
        
            default:
                break;
        }
    }

    public static void ModifyCharacter() {
        if (CharacterList.isEmpty()) {
            System.out.println("No characters available to modify.");
            return;
        }

        // Select Character
        System.out.println("=====[ Modify Character ]=====");
        for (int i = 0; i < CharacterList.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + CharacterList.get(i).GetName() + " (" + CharacterList.get(i).getClass().getSimpleName() + ")");
        }
        int charIndex = getChoice();

        if (charIndex < 1 || charIndex > CharacterList.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Character selectedChar = CharacterList.get(charIndex - 1);

        //Display Options
        System.out.println();
        System.out.println("Modifying: " + selectedChar.GetName());
        System.out.println("[1] - Name");
        System.out.println("[2] - Alias");
        System.out.println("[3] - Origin");
        System.out.println("[4] - Status");
        System.out.println("[5] - Wallet");
        System.out.println("[6] - Devil Fruit");

        int maxOptions = 6;

        // Display Sub-class Options
        if (selectedChar instanceof Pirate) {
            System.out.println("[7] - Bounty");
            System.out.println("[8] - Role");
            System.out.println("[9] - Crew");
            maxOptions = 9;
        } else if (selectedChar instanceof Marine) {
            System.out.println("[7] - Rank");
            System.out.println("[8] - Marine Corp");
            maxOptions = 8;
        } else if (selectedChar instanceof PirateHunter) {
            System.out.println("[7] - Combat Style");
            System.out.println("[8] - Captures");
            maxOptions = 8;
        } else if (selectedChar instanceof Civilian) {
            System.out.println("[7] - Profession");
            System.out.println("[8] - Residence");
            maxOptions = 8;
        }

        int choice = getChoice();

        if (choice < 1 || choice > maxOptions) {
            System.out.println("Invalid option.");
            return;
        }

        // 4. Process Universal Edits
        switch (choice) {
            case 1:
                selectedChar.SetName(getInput("New Name"));
                break;
            case 2:
                selectedChar.SetAlias(getInput("New Alias"));
                break;
            case 3:
                selectedChar.SetOrigin(getInput("New Origin"));
                break;
            case 4:
                String newStatus;
                do {
                    newStatus = getInput("New Status (Alive/Captured/Dead)");
                    if (!(newStatus.equalsIgnoreCase("alive") || newStatus.equalsIgnoreCase("captured") || newStatus.equalsIgnoreCase("dead"))) {
                        System.out.println("Invalid status.");
                    }
                } while (!(newStatus.equalsIgnoreCase("alive") || newStatus.equalsIgnoreCase("captured") || newStatus.equalsIgnoreCase("dead")));
                selectedChar.SetStatus(newStatus);
                break;
            case 5:
                int newWallet;
                do {
                    System.out.print("Enter New Wallet: ");
                    newWallet = getChoice();
                    if (newWallet < 0) {
                        System.out.println("Wallet cannot be negative.");
                    }
                } while (newWallet < 0);
                selectedChar.SetWallet(newWallet);
                break;
            case 6:
                // "One Fruit, One Soul" Rule
                if (selectedChar.GetDFPower() != null) {
                    System.out.println("Cannot reassign. Character already has a Devil Fruit. They must be 'Dead' to relinquish it.");
                } else {
                    displayDF();
                    int dfIndex = getChoice();
                    if (dfIndex > 0 && dfIndex <= DevilFruitList.size()) {
                        DevilFruit selectedFruit = DevilFruitList.get(dfIndex - 1);
                        if (selectedFruit.HasCurrentOwner()) {
                            System.out.println("This Devil Fruit is already owned by another character.");
                        } else {
                            selectedFruit.SetCurrentOwner(selectedChar);
                            System.out.println("Devil Fruit successfully assigned.");
                        }
                    }
                }
                break;
        }

        // Sub-class Specific Modifications
        if (choice > 6) {
            if (selectedChar instanceof Pirate) {
                Pirate p = (Pirate) selectedChar; //Downcasting, ChildClass <var_name> = (ChildClass) ParenClass **DELETE BEFORE SUBMISSION
                if (choice == 7) {
                    int newBounty;
                    do {
                        System.out.print("Enter New Bounty: ");
                        newBounty = getChoice();
                    } while (newBounty < 0);
                    p.SetBounty(newBounty);
                } else if (choice == 8) {
                    displayRole();
                    int roleIndex = getChoice();
                    if (roleIndex > 0 && roleIndex < Roles.size()) {
                        p.SetPirateRole(Roles.get(roleIndex));
                    }
                } else if (choice == 9) {
                    displayCrew();
                    int crewIndex = getChoice();
                    if (crewIndex == 0) {
                        p.setPirateCrew(null);
                    } else if (crewIndex > 0 && crewIndex <= PirateCrewList.size()) {
                        p.setPirateCrew(PirateCrewList.get(crewIndex - 1));
                    }
                }
            } else if (selectedChar instanceof Marine) {
                Marine m = (Marine) selectedChar; //Downcasting, ChildClass <var_name> = (ChildClass) ParenClass **DELETE BEFORE SUBMISSION
                if (choice == 7) {
                    displayRank();
                    int rankIndex = getChoice();
                    if (rankIndex > 0 && rankIndex < Ranks.size()) m.SetRank(Ranks.get(rankIndex));
                } else if (choice == 8) {
                    displayCorp();
                    int corpIndex = getChoice();
                    if (corpIndex == 0) {
                        m.SetMCorps(null);
                    } else if (corpIndex > 0 && corpIndex <= MarineCorpList.size()) {
                        m.SetMCorps(MarineCorpList.get(corpIndex - 1));
                    }
                }
            } else if (selectedChar instanceof PirateHunter) {
                PirateHunter ph = (PirateHunter) selectedChar; //Downcasting, ChildClass <var_name> = (ChildClass) ParenClass **DELETE BEFORE SUBMISSION
                if (choice == 7) {
                    ph.SetCombatStyle(getInput("New Combat Style"));
                } else if (choice == 8) {
                    int caps;
                    do {
                        System.out.print("Enter New Captures: ");
                        caps = getChoice();
                    } while (caps < 0);
                    ph.SetCaptures(caps);
                }
            } else if (selectedChar instanceof Civilian) {
                Civilian c = (Civilian) selectedChar;//Downcasting, ChildClass <var_name> = (ChildClass) ParenClass **DELETE BEFORE SUBMISSION
                if (choice == 7) {
                    c.SetProfession(getInput("New Profession"));
                } else if (choice == 8) {
                    c.SetResidence(getInput("New Residence"));
                }
            }
        }

        System.out.println("Modification complete!");
    }

    public static void DeleteCharacter() {
        if (CharacterList.isEmpty()) {
            System.out.println("No characters available to delete.");
            return;
        }
        System.out.println("=====[ Delete Character ]=====");
        for (int i = 0; i < CharacterList.size(); i++) {
            System.out.println("[" + (i + 1) + "] - " + CharacterList.get(i).GetName() + " (" + CharacterList.get(i).getClass().getSimpleName() + ")");
        }
        int charIndex = getChoice();

        if (charIndex < 1 || charIndex > CharacterList.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Character selectedChar = CharacterList.get(charIndex - 1);

        // Trigger reincarnation to remove fruit
        if (selectedChar.GetDFPower() != null) {
            selectedChar.GetDFPower().TriggerReinc();
        }

        // Delete affiliation connections
        if (selectedChar instanceof Pirate) {
            Pirate p = (Pirate) selectedChar;
            if (p.GetPirateCrew() != null) {
                p.GetPirateCrew().RemoveCrewMember(p);
            }
        } else if (selectedChar instanceof Marine) {
            Marine m = (Marine) selectedChar;
            if (m.GetMCorps() != null) {
                m.GetMCorps().RemoveCorpMember(m);
            }
        }

        // Remove from Global list
        CharacterList.remove(selectedChar);
        System.out.println("Character successfully deleted and unlinked from all systems.");
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
