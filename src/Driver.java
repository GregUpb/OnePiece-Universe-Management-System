import java.util.List;
import java.util.Locale.Category;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    
    private static List<Character> CharacterList = new ArrayList<>();
    private static List<DevilFruit> DevilFruitList = new ArrayList<>();
    private static List<PirateCrew> PirateCrewList = new ArrayList<>();
    private static List<MarineCorp> MarineCorpList = new ArrayList<>(); 

    final static List<String> Roles = new ArrayList<>(List.of(
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

    final static List<String> Ranks = new ArrayList<>(List.of(
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
        int input;

        do {

            System.out.println("==[ Characters ]==");
            System.out.println("[1] - Create a new Character");
            System.out.println("[2] - View Character");
            System.out.println("[3] - Modify Character");
            System.out.println("[4] - Delete Character");
            System.out.println("[5] - Return");

            System.out.print("> ");
            input = getChoice();

            switch (input) {
                case 1:
                    System.out.println("==[ Create Character ]==");
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

                    input = 0;  // Reset input
                    break;
                case 2:
                    ViewCharacter();
                    break;
                case 3:
                    ModifyCharacter();
                    break;
                case 4:
                    DeleteCharacter();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }

        } while (input < 1 || input > 4);


    }

    public static void DevilFruits()
    {
        int input;

        do {
            System.out.println("===[ Devil Fruit ]===");
            System.out.println("[1] - Create Devil Fruit");
            System.out.println("[2] - View Devil Fruit");
            System.out.println("[3] - Assign Devil Fruit");
            System.out.println("[4] - Return");

            input = getChoice();

            switch (input) {
                case 1:
                    CreateDF();
                    break;
                case 2:
                    ViewDF();
                    break;
                case 3:
                    AssignDF();
                    break;
                case 4:
                    break;
            
                default:
                    System.out.println("Invalid Input");
                    break;
            }


        } while (input < 1 || input > 4);

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

        // Name Verification
        do {
            name = getInput("Name");
            if (name.isBlank())
            {
                System.out.println("Name cannot be empty");
            }
        } while (name.isBlank());

        alias = getInput("Alias (leave blank if none)");
        
        // Origin Verification
        do {
            origin = getInput("Origin");
            if (origin.isBlank())
            {
                System.out.println("Origin cannot be empty");
            }
        } while (origin.isBlank());

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
                System.out.println();
                System.out.println("Pirate successfully registered.");

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

    public static void ViewCharacter()
    {
        int input;

        if (!(CharacterList.isEmpty()))
        {
            do {
                System.out.println("===[ View Character ]===");
    
                for (Character c : CharacterList)
                {
                    System.out.println("[" + (CharacterList.indexOf(c) + 1) + "] - " + c.GetName());
                }
    
                System.out.print("> ");
                input = getChoice();

                if (input < 1 || input > CharacterList.size())
                {
                    System.out.println("Invalid Index");
                }
                
            } while (input < 1 || input > CharacterList.size());

            CharacterList.get(input-1).displayProfile();

        } else
        {
            System.out.println("No Existing Character");
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
                        p.SetPirateCrew(null);
                    } else if (crewIndex > 0 && crewIndex <= PirateCrewList.size()) {
                        p.SetPirateCrew(PirateCrewList.get(crewIndex - 1));
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

    public static void CreateDF()
    {
        // Variables
        String name, primaryAbility;
        String category = "";
        int temp;
        int currOwnerIndex; // Index of the current owner in the CharacterList
        List<Character> historicalOwner = new ArrayList<>(); // A list of the former owner in the CharacterList

        System.out.println("=====[ Create Devil Fruit ]=====");

        // Name Verification
        do {
            name = getInput("Name of the Devil Fruit"); // Get the name of the devil fruit
            if (name.isBlank())
            {
                System.out.println("Name cannot be empty");
            }
        } while (name.isBlank());

        // Category Verification
        do {
            // Choices
            System.out.println("[ Category ]");
            System.out.println("[1] - Paramecia");
            System.out.println("[2] - Logia");
            System.out.println("[3] - Zoan");

            System.out.print("> ");
            temp = getChoice();
            
            // Check if the choice is within the boundary and sets the category
            switch (temp) {
                case 1:
                    category = "Paramecia";
                    break;

                case 2:
                    category = "Logia";
                    break;

                case 3:
                    category = "Zoan";
                    break;
            
                default:
                    System.out.println("Invalid Index");
                    break;
            }

        } while (temp < 1 || temp > 3);

        primaryAbility = getInput("Primary Ability of the Devil Fruit");    // Get the Primary Ability

        // Current Owner Verification
        do {

            System.out.println("[ Current Owner ]");
            System.out.println("[0] - None");

            for (Character c : CharacterList)
            {
                System.out.println("[" + (CharacterList.indexOf(c) + 1) + "] - " + c.GetName());
            }

            System.out.print("> ");
            currOwnerIndex = getChoice();

            if (currOwnerIndex < 0 || currOwnerIndex > CharacterList.size())
            {
                System.out.println("Invalid Index");
            }

        } while (currOwnerIndex < 0 || currOwnerIndex > CharacterList.size());

        // Historical Owner Verification
        do {
            System.out.println("[ Historical Owner ]");
            // Check if empty or not
            if (historicalOwner.isEmpty())
            {
                System.out.println("[0] - None");
            } else
            {
                System.out.println("[0] - Done");
            }

            // Loops through all characters in CharacterList
            for (Character c : CharacterList)
            {
                System.out.println("[" + (CharacterList.indexOf(c) + 1) + "] - " + c.GetName());
            }

            System.out.print("> ");
            temp = getChoice();

            // Check if the inputted is within the range
            if (temp >= 0 && temp <= CharacterList.size())
            {
                if (temp != 0)
                {
                    if (historicalOwner.contains(CharacterList.get(temp-1)))
                    {
                        System.out.println(CharacterList.get(temp-1).GetName() + " is already added");
                    } else
                    {
                        historicalOwner.add(CharacterList.get(temp-1));
                    }
                }
            } else
            {
                System.out.println("Invalid Index");
            }

        } while (temp != 0);

        DevilFruit dfTemp;

        // Creating the devil fruit based on the inputs
        if (currOwnerIndex == 0 && historicalOwner.isEmpty())
        {
            dfTemp = new DevilFruit(name, category, primaryAbility);
        } else if (currOwnerIndex > 0 && historicalOwner.isEmpty())
        {
            dfTemp = new DevilFruit(name, category, primaryAbility, CharacterList.get(currOwnerIndex));
        } else if (currOwnerIndex == 0 && !(historicalOwner.isEmpty()))
        {
            dfTemp = new DevilFruit(name, category, primaryAbility, historicalOwner);
        } else
        {
            dfTemp = new DevilFruit(name, category, primaryAbility, CharacterList.get(currOwnerIndex), historicalOwner);
        }

        // Add to the List
        DevilFruitList.add(dfTemp);

        System.out.println(dfTemp.GetFruitName() + " has been created.");

    }

    public static void ViewDF()
    {
        DevilFruit temp;
        int dfIndex;

        if (!(DevilFruitList.isEmpty()))
        {
            // List all existing devil fruits and gets the users input
            do {
                // Display all devil fruit in the DevilFruitList
                System.out.println("[ Devil Fruit ]");
                for (DevilFruit df : DevilFruitList)
                {
                    System.out.println("[" + (DevilFruitList.indexOf(df)+1) + "] - " + df.GetFruitName());
                }

                System.out.print("> ");
                dfIndex = getChoice();    // Get user input

                // Check if the input is within the range
                if (dfIndex < 1 || dfIndex > DevilFruitList.size())
                {
                    System.out.println("Invalid Index");
                }

            } while (dfIndex < 1 || dfIndex > DevilFruitList.size());
            dfIndex -= 1; // Decrement since the list index starts with 0

            temp = DevilFruitList.get(dfIndex);

            // Display all info about the devil fruit
            System.out.println("=[ " + temp.GetFruitName() + " ]=");
            System.out.println("Name: " + temp.GetFruitName());
            System.out.println("Category: " + temp.GetCategory());
            System.out.println("Primary Ability: " + temp.GetPrimaryAbility());
            
            // Check and outputs the correct if there is a current owner
            System.out.print("Current Owner: ");
            if (temp.GetCurrentOwner() != null)
            {
                System.out.println(temp.GetCurrentOwner().GetName());
            } else
            {
                System.out.println("None");
            }
            
            // Display all former owners if it exist
            for (Character c : temp.GetHistoricalOwners())
            {
                if (c != null)
                {
                    if (temp.GetHistoricalOwners().indexOf(c) == 0)
                    {
                        System.out.println("Historical Owner/s: " + c.GetName());
                    } else
                    {
                        System.out.printf("%20s%s\n", " ", c.GetName());
                    }
                } else
                {
                    System.out.println("Historical Owner: None");
                }
            }

        } else
        {
            System.out.println("No Existing Devil Fruit");
        }
    }

    public static void AssignDF()
    {
        int dfIndex, charIndex;

        if (!(DevilFruitList.isEmpty()))
        {
            // List all existing devil fruits and gets the users input
            do {
                // Display all devil fruit in the DevilFruitList
                System.out.println("[ Devil Fruit ]");
                for (DevilFruit df : DevilFruitList)
                {
                    System.out.println("[" + (DevilFruitList.indexOf(df)+1) + "] - " + df.GetFruitName());
                }

                System.out.print("> ");
                dfIndex = getChoice();    // Get user input

                // Check if the input is within the range
                if (dfIndex < 1 || dfIndex > DevilFruitList.size())
                {
                    System.out.println("Invalid Index");
                }

            } while (dfIndex < 1 || dfIndex > DevilFruitList.size());
            dfIndex -= 1; // Decrement since the list index starts with 0

            // Character Verification
            if (!(CharacterList.isEmpty()))
            {
                // List all existing character and gets the users input
                do {
                    // Display all character in the CharacterList
                    System.out.println("[ Character ]");
                    for (Character c : CharacterList)
                    {
                        System.out.println("[" + (CharacterList.indexOf(c)+1) + "] - " + c.GetName());
                    }

                    System.out.print("> ");
                    charIndex = getChoice();    // Get user input

                    // Check if the input is within the range
                    if (charIndex < 1 || charIndex > CharacterList.size())
                    {
                        System.out.println("Invalid Index");
                    }

                } while (charIndex < 1 || charIndex > CharacterList.size());
                charIndex -= 1; // Decrement since the list index starts with 0

                System.out.println("Assigning " + CharacterList.get(charIndex).GetName() + " " + DevilFruitList.get(dfIndex).GetFruitName());

                CharacterList.get(charIndex).SetDFPower(DevilFruitList.get(dfIndex));   // Set Devil Fruit of the Character Picked

            } else
            {
                System.out.println("No Existing Character");
            }
        } else
        {
            System.out.println("No Existing Devil Fruit");
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
