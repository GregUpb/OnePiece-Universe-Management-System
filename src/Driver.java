import java.util.List;
import java.util.Locale.Category;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    
    private static final List<Character> CharacterList = new ArrayList<>();
    private static final List<DevilFruit> DevilFruitList = new ArrayList<>();
    private static final List<PirateCrew> PirateCrewList = new ArrayList<>();
    private static final List<MarineCorp> MarineCorpList = new ArrayList<>();

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
        "Crew Member",
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

    final static List<String> CivRoles = new ArrayList<>(List.of(
        "None",
        "Boatswain", 
        "Cook", 
        "Cleric",
        "Clerk",
        "Doctor", 
        "Navigator", 
        "Shipwright",  
        "Archaeologist", 
        "Assassin", 
        "Barber", 
        "Beast Tamer", 
        "Blacksmith", 
        "Instructor", 
        "Janitor", 
        "Martial Artist", 
        "Merchant", 
        "Musician", 
        "Scholar", 
        "Scientist",
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
        int choice;

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
    // Displays the Character management menu and directs its program flow
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

        } while (input < 1 || input > 5);


    }
    // Displays the Devil Fruit management menu and directs its program flow
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

    // Displays the Pirate Crews management menu and directs its program flow
    public static void PirateCrews()
    {
        int input;

        do {
            System.out.println("===[ Pirate Crew ]===");
            System.out.println("[1] - Create Pirate Crew");
            System.out.println("[2] - View Pirate Crew");
            System.out.println("[3] - Modify Pirate Crew");
            System.out.println("[4] - Disband Pirate Crew");
            System.out.println("[5] - Return");

            input = getChoice();

            switch (input) {
                case 1:
                    CreatePirateCrew();
                    break;
                case 2:
                    ViewPirateCrew();
                    break;
                case 3:
                    ModifyPirateCrew();
                    break;
                case 4:
                    DeletePirateCrew();/*AddRemovePirateFromCrew();*/
                    break;
                case 5:
                    break;
            
                default:
                    System.out.println("Invalid Input");
                    break;
            }


        } while (input < 1 || input > 4);

    }

    // Displays the Marine Corps management menu and directs its program flow
    public static void MarineCorps()
    {
        int input;

        do {
            System.out.println("===[ Marine Corp ]===");
            System.out.println("[1] - Create Marine Corp");
            System.out.println("[2] - View Marine Corp");
            System.out.println("[3] - Modify Marine Corp");
            System.out.println("[4] - Disband Marine Corp");
            System.out.println("[5] - Return");

            System.out.print("> ");
            input = getChoice();

            switch (input) {
                case 1:
                    CreateMCorp();
                    break;
                case 2:
                    ViewMCorp();
                    break;
                case 3:
                    ModifyMCorp();
                    break;
                case 4:
                    DeleteMCorp();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (input != 5);
    }

    /* CHARACTER MANAGEMENT OPERATIONS */

    // Handles the creation and data entry for a new character
    public static void CreateCharacter(String type)
    {
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

                    if (RoleIndex < 0 || RoleIndex > (Roles.size() - 1))
                    {
                        System.out.println("Invalid Index");
                    }
                } while (RoleIndex < 0 || RoleIndex > (Roles.size() - 1));

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
                } else if (dfIndex == 0)
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

                    if (rankIndex < 0 || rankIndex > (Ranks.size() - 1)) {
                        System.out.println("Invalid Index");
                    }
                } while (rankIndex < 0 || rankIndex > (Ranks.size() - 1));

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
                } else if (dfIndex == 0) {
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
                String residence;
                int civRoleIndex;

                // Profession Verification
                do {
                    displayCivRole();
                    System.out.print("> ");
                    civRoleIndex = getChoice();

                    if (civRoleIndex < 0 || civRoleIndex > (CivRoles.size() - 1 ))
                    {
                        System.out.println("Invalid Index");
                    }

                } while (civRoleIndex < 0 || civRoleIndex > (CivRoles.size() - 1 ));

                residence = getInput("Residence");

                Civilian tempCiv;

                if (dfIndex == 0) {
                    tempCiv = new Civilian(name, alias, origin, status, wallet, CivRoles.get(civRoleIndex), residence);
                } else {
                    tempCiv = new Civilian(name, alias, origin, status, DevilFruitList.get(dfIndex - 1), wallet, CivRoles.get(civRoleIndex), residence);
                }

                CharacterList.add(tempCiv);
                System.out.println("\nCivilian successfully registered.");
                break;
        
            default:
                break;
        }
    }

    // Handles the retrieval and display of character profiles
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

    // Handles the selection and updating of character attributes
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
                    System.out.print("> ");
                    int roleIndex = getChoice();
                    if (roleIndex > 0 && roleIndex < Roles.size()) {
                        p.SetPirateRole(Roles.get(roleIndex));
                    }
                } else if (choice == 9) {
                    displayCrew();
                    System.out.print("> ");
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
                    System.out.print("> ");
                    int rankIndex = getChoice();
                    if (rankIndex > 0 && rankIndex < Ranks.size()) m.SetRank(Ranks.get(rankIndex));
                } else if (choice == 8) {
                    displayCorp();
                    System.out.print("> ");
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
                    
                    int civRoleIndex;

                    displayCivRole();
                    System.out.print("> ");
                    civRoleIndex = getChoice();

                    if (civRoleIndex >= 0 && civRoleIndex < CivRoles.size())
                    {
                        c.SetProfession(CivRoles.get(civRoleIndex));
                    }


                } else if (choice == 8) {
                    c.SetResidence(getInput("New Residence"));
                }
            }
        }

        System.out.println("Modification complete!");
    }

    // Handles the unlinking and removal of a character from the system
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

    /* DEVIL FRUIT MANAGEMENT OPERATIONS */

    // Handles the creation and data entry for a new devil fruit
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
        } else if (currOwnerIndex == 0)
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

    // Handles the retrieval and display of devil fruit profiles
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
            System.out.print("Historical Owner: ");
            if (temp.GetHistoricalOwners().isEmpty())
            {
                System.out.println("None");
            } else
            {
                for (Character c : temp.GetHistoricalOwners())
                {
                    if (temp.GetHistoricalOwners().indexOf(c) == 0)
                    {
                        System.out.println(c.GetName());
                    } else
                    {
                        System.out.printf("%20s%s\n", " ", c.GetName());
                    }
                }
            }

        } else
        {
            System.out.println("No Existing Devil Fruit");
        }
    }
    // Handles assignment of devil fruit to character
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
    /* PIRATE CREW MANAGEMENT OPERATIONS */

    // Handles the creation and data entry for a new pirate crew
    public static void CreatePirateCrew()
    {
        String crewName, shipName;
        int capIndex, crewIndex;
        int i;
        List<Pirate> members = new ArrayList<>();
        List<Integer> pirateIndex = new ArrayList<>();

        System.out.println("=[ Create Pirate Crew ]=");

        // Crew Name Verification
        do {
            crewName = getInput("Name of the Pirate Crew");
            if (crewName.isBlank())
            {
                System.out.println("Pirate Crew Name cannot be empty");
            }
        } while (crewName.isBlank());

        // Ship Name Verification
        do {
            shipName = getInput("Name of the ship");
            if (shipName.isBlank())
            {
                System.out.println("Ship's Name cannot be empty");
            }
        } while (shipName.isBlank());

        // Captain Verification
        do {
            System.out.println("[ Pirate Captain ]");
            System.out.println("[0] - None");
            if (!(pirateIndex.contains(0)))
            {
                pirateIndex.add(0);
            }

            // List all pirate existed in the CharacterList
            i = 0;
            for (Character c : CharacterList)
            {
                if (c instanceof Pirate && ((Pirate)c).GetPirateCrew() == null)
                {
                    i++;
                    System.out.println("[" + i + "] - " + c.GetName());

                    if (!(pirateIndex.contains(CharacterList.indexOf(c))))
                    {
                        pirateIndex.add(CharacterList.indexOf(c));
                    }
                }
            }

            System.out.print("> ");
            capIndex = getChoice();

            if (capIndex < 0 || capIndex > i)
            {
                System.out.println("Invalid Index");
            }
        } while ((capIndex < 0 || capIndex > i));

        // Members Verification
        pirateIndex.clear();
        do {
            System.out.println("[ Pirate Members ]");

            if (members.isEmpty())
            {
                System.out.println("[0] - None");
            } else
            {
                System.out.println("[0] - Done");
            }

            if (!(pirateIndex.contains(0)))
            {
                pirateIndex.add(0);
            }

            // List all pirates existing in the CharacterList not in a crew
            i = 0;
            for (Character c : CharacterList)
            {
                if (c instanceof Pirate && ((Pirate)c).GetPirateCrew() == null)
                {
                    // Prevent displaying the pirate already selected as Captain
                    if (capIndex != 0 && CharacterList.indexOf(c) == pirateIndex.get(capIndex)) {
                        continue;
                    }

                    i++;
                    System.out.println("[" + i + "] - " + c.GetName());

                    if (!(pirateIndex.contains(CharacterList.indexOf(c))))
                    {
                        pirateIndex.add(CharacterList.indexOf(c));
                    }
                }
            }

            System.out.print("> ");
            crewIndex = getChoice();

            if (crewIndex < 0 || crewIndex > i)
            {
                System.out.println("Invalid Index");
            } else if (crewIndex > 0)
            {
                Pirate selectedPirate = (Pirate)CharacterList.get(pirateIndex.get(crewIndex));
                if (!members.contains(selectedPirate)) {
                    members.add(selectedPirate);
                    System.out.println(selectedPirate.GetName() + " added to the crew roster.");
                } else {
                    System.out.println(selectedPirate.GetName() + " is already selected.");
                }
            }
        } while (crewIndex != 0);
        PirateCrew crew;

        // Create Pirate Crew based on the inputs
        if (capIndex == 0 && members.isEmpty())
        {
            crew = new PirateCrew(crewName, shipName);
        } else if (capIndex != 0 && members.isEmpty())
        {
            crew = new PirateCrew(crewName, shipName, (Pirate)CharacterList.get(pirateIndex.get(capIndex)));
        } else if (capIndex == 0)
        {
            crew = new PirateCrew(crewName, shipName, members);
        } else 
        {
            crew = new PirateCrew(crewName, shipName, (Pirate)CharacterList.get(pirateIndex.get(capIndex)), members);
        }

        PirateCrewList.add(crew);
        
    }

    // Handles the retrieval and display of pirate crew profiles
    public static void ViewPirateCrew()
    {
        int input;
        String name;

        // List Pirate Crew to view
        do {

            System.out.println("[ View Pirate Crew ]");
            System.out.println("[0] - Return");
            for (PirateCrew pc : PirateCrewList)
            {
                System.out.println("[" + (PirateCrewList.indexOf(pc)+1) + "] - " + pc.GetCrewName());
            }

            System.out.print("> ");
            input = getChoice();

            if (input < 0 || input > PirateCrewList.size())
            {
                System.out.println("Invalid Index");
            }

        } while (input < 0 || input > PirateCrewList.size());

        if (input > 0)
        {
            do {
                displayCrewInfo(PirateCrewList.get(input-1));

                name = getInput("Pirate Name to display info (or \"exit\" to exit)");

                if (!(name.equalsIgnoreCase("exit")))
                {
                    for (Pirate p : PirateCrewList.get(input-1).GetCrewMembers())
                    {
                        if (p.GetName().equalsIgnoreCase(name))
                        {
                            p.displayProfile();
                            scanner.nextLine();
                        }
                    }
                }
            } while (!(name.equalsIgnoreCase("exit")));
        }
    }

    // Handles the selection and updating of pirate crew attributes
    public static void ModifyPirateCrew()
    {
        int input;
        //Checks if there are any existing Pirate Crews
        if (PirateCrewList.isEmpty()) {
            System.out.println("No Pirate Crews available to modify.");
            return;
        }
        //Lists all existing Pirate Crew
        do {
            System.out.println("[ Modify Pirate Crew ]");
            System.out.println("[0] - Return");
            for (PirateCrew pc : PirateCrewList)
            {
                System.out.println("[" + (PirateCrewList.indexOf(pc)+1) + "] - " + pc.GetCrewName());
            }

            System.out.print("> ");
            input = getChoice();

            if (input < 0 || input > PirateCrewList.size())
            {
                System.out.println("Invalid Index");
            }
        } while (input < 0 || input > PirateCrewList.size());
        // After choosing a Pirate Crew to modify, user is asked to choose which attribute will be modified
        if (input > 0) {
            PirateCrew selectedCrew = PirateCrewList.get(input - 1);
            int modChoice;

            do {
                System.out.println("\nModifying: " + selectedCrew.GetCrewName());
                System.out.println("[1] - Crew Name");
                System.out.println("[2] - Ship's Name");
                System.out.println("[3] - Assign Captain");
                System.out.println("[4] - Add/Remove Member");
                System.out.println("[5] - Return");
                System.out.print("> ");

                modChoice = getChoice();

                switch (modChoice) {
                    case 1:
                        String newCrewName;
                        do {
                            newCrewName = getInput("New Crew Name");
                            if (newCrewName.isBlank()) {
                                System.out.println("Crew Name cannot be empty.");
                            }
                        } while (newCrewName.isBlank());
                        selectedCrew.SetCrewName(newCrewName);
                        break;
                    case 2:
                        String newShipName;
                        do {
                            newShipName = getInput("New Ship's Name");
                            if (newShipName.isBlank()) {
                                System.out.println("Ship's Name cannot be empty.");
                            }
                        } while (newShipName.isBlank());
                        selectedCrew.SetShipsName(newShipName);
                        break;
                    case 3:
                        if (selectedCrew.GetCrewMembers().isEmpty()) {
                            System.out.println("This Crew has no members to promote to Captain.");
                        } else {
                            System.out.println("[ Assign Captain ]");
                            System.out.println("[0] - Cancel");
                            for (int j = 0; j < selectedCrew.GetCrewMembers().size(); j++) {
                                System.out.println("[" + (j + 1) + "] - " + selectedCrew.GetCrewMembers().get(j).GetName());
                            }
                            System.out.print("> ");
                            int cmdChoice = getChoice();

                            if (cmdChoice > 0 && cmdChoice <= selectedCrew.GetCrewMembers().size()) {
                                selectedCrew.SetCaptain(selectedCrew.GetCrewMembers().get(cmdChoice - 1));
                                System.out.println("Captain updated.");
                            } else if (cmdChoice != 0) {
                                System.out.println("Invalid selection.");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("\n[ Add / Remove Member ]");
                        System.out.println("[1] - Add Member");
                        System.out.println("[2] - Remove Member");
                        System.out.println("[0] - Cancel");
                        System.out.print("> ");

                        int action = getChoice();
                        if (action == 1) { // Add
                            List<Pirate> availablePirates = new ArrayList<>();
                            for (Character c : CharacterList) {
                                // Find pirates not currently in this specific crew
                                if (c instanceof Pirate && ((Pirate)c).GetPirateCrew() != selectedCrew) {
                                    availablePirates.add((Pirate)c);
                                }
                            }
                            if (availablePirates.isEmpty()) {
                                System.out.println("No available Pirates to add.");
                            } else {
                                System.out.println("[ Select Pirate to Add ]");
                                System.out.println("[0] - Cancel");
                                for (int p = 0; p < availablePirates.size(); p++) {
                                    System.out.println("[" + (p + 1) + "] - " + availablePirates.get(p).GetName());
                                }
                                System.out.print("> ");
                                int addChoice = getChoice();
                                if (addChoice > 0 && addChoice <= availablePirates.size()) {
                                    selectedCrew.AddCrewMember(availablePirates.get(addChoice - 1));
                                    System.out.println("Pirate successfully added to the crew.");
                                }
                            }
                        } else if (action == 2) { // Remove
                            if (selectedCrew.GetCrewMembers().isEmpty()) {
                                System.out.println("This crew has no members to remove.");
                            } else {
                                System.out.println("[ Select Pirate to Remove ]");
                                System.out.println("[0] - Cancel");
                                for (int p = 0; p < selectedCrew.GetCrewMembers().size(); p++) {
                                    System.out.println("[" + (p + 1) + "] - " + selectedCrew.GetCrewMembers().get(p).GetName());
                                }
                                System.out.print("> ");
                                int remChoice = getChoice();
                                if (remChoice > 0 && remChoice <= selectedCrew.GetCrewMembers().size()) {
                                    selectedCrew.RemoveCrewMember(selectedCrew.GetCrewMembers().get(remChoice - 1));
                                    System.out.println("Pirate successfully removed from the crew.");
                                }
                            }
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } while (modChoice != 5);
        }
    }

    // Handles the unlinking and removal of a pirate crew from the system
    public static void DeletePirateCrew()
    {
        int input;

        if (PirateCrewList.isEmpty()) {
            System.out.println("No Pirate Crews available to delete.");
            return;
        }

        do {
            System.out.println("[ Disband Pirate Crew ]");
            System.out.println("[0] - Return");
            for (PirateCrew pc : PirateCrewList)
            {
                System.out.println("[" + (PirateCrewList.indexOf(pc)+1) + "] - " + pc.GetCrewName());
            }

            System.out.print("> ");
            input = getChoice();

            if (input < 0 || input > PirateCrewList.size())
            {
                System.out.println("Invalid Index");
            }
        } while (input < 0 || input > PirateCrewList.size());

        if (input > 0) {
            PirateCrew selectedCrew = PirateCrewList.get(input - 1);


            List<Pirate> membersToUnlink = new ArrayList<>(selectedCrew.GetCrewMembers());
            for (Pirate p : membersToUnlink) {
                selectedCrew.RemoveCrewMember(p);
            }

            PirateCrewList.remove(selectedCrew);
            System.out.println("Pirate Crew successfully disbanded.");
        }
    }

    /* MARINE CORP MANAGEMENT OPERATIONS */

    // Handles the creation and data entry for a new marine corp
    public static void CreateMCorp()
    {
        String baseLocation;
        int funds;
        int commIndex, corpIndex;
        int i;
        List<Marine> members = new ArrayList<>();
        List<Integer> marineIndex = new ArrayList<>();

        System.out.println("=[ Create Marine Corp ]=");

        // Base Location Verification
        do {
            baseLocation = getInput("Base Location");
            if (baseLocation.isBlank())
            {
                System.out.println("Base Location cannot be empty");
            }
        } while (baseLocation.isBlank());

        // Operational Funds Verification
        do {
            System.out.print("Enter Operational Funds: ");
            funds = getChoice();

            if (funds < 0)
            {
                System.out.println("Operational Funds cannot be negative");
            }
        } while (funds < 0);

        // Commander Verification
        do {
            System.out.println("[ Corps Commander ]");
            System.out.println("[0] - None");
            if (!(marineIndex.contains(0)))
            {
                marineIndex.add(0);
            }

            // List all marines existing in the CharacterList not in a corp
            i = 0;
            for (Character c : CharacterList)
            {
                if (c instanceof Marine && ((Marine)c).GetMCorps() == null)
                {
                    i++;
                    System.out.println("[" + i + "] - " + c.GetName());

                    if (!(marineIndex.contains(CharacterList.indexOf(c))))
                    {
                        marineIndex.add(CharacterList.indexOf(c));
                    }
                }
            }

            System.out.print("> ");
            commIndex = getChoice();

            if (commIndex < 0 || commIndex > i)
            {
                System.out.println("Invalid Index");
            }
        } while (commIndex < 0 || commIndex > i);

        // Members Verification
        marineIndex.clear();
        do {
            System.out.println("[ Marine Members ]");

            if (members.isEmpty())
            {
                System.out.println("[0] - None");
            } else
            {
                System.out.println("[0] - Done");
            }

            if (!(marineIndex.contains(0)))
            {
                marineIndex.add(0);
            }

            // List all marines existing in the CharacterList not in a corp
            i = 0;
            for (Character c : CharacterList)
            {
                if (c instanceof Marine && ((Marine)c).GetMCorps() == null)
                {
                    i++;
                    System.out.println("[" + i + "] - " + c.GetName());

                    if (!(marineIndex.contains(CharacterList.indexOf(c))))
                    {
                        marineIndex.add(CharacterList.indexOf(c));
                    }
                }
            }

            System.out.print("> ");
            corpIndex = getChoice();

            if (corpIndex < 0 || corpIndex > i)
            {
                System.out.println("Invalid Index");
            } else if (corpIndex > 0)
            {
                Marine selectedMarine = (Marine)CharacterList.get(marineIndex.get(corpIndex));
                if (!members.contains(selectedMarine)) {
                    members.add(selectedMarine);
                } else {
                    System.out.println(selectedMarine.GetName() + " is already selected.");
                }
            }
        } while (corpIndex != 0);

        MarineCorp corp;

        // Create Marine Corp based on the inputs
        if (commIndex == 0 && members.isEmpty())
        {
            corp = new MarineCorp(baseLocation, null, funds);
        } else if (commIndex != 0 && members.isEmpty())
        {
            Marine commander = (Marine)CharacterList.get(marineIndex.get(commIndex));
            corp = new MarineCorp(baseLocation, commander, funds);
        } else if (commIndex == 0)
        {
            corp = new MarineCorp(baseLocation, null, funds, members);
        } else
        {
            Marine commander = (Marine)CharacterList.get(marineIndex.get(commIndex));
            corp = new MarineCorp(baseLocation, commander, funds, members);
        }

        MarineCorpList.add(corp);
        System.out.println("Marine Corp successfully registered.");
    }

    // Handles the retrieval and display of marine corp profiles
    public static void ViewMCorp()
    {
        int input;
        String name;

        // List Marine Corps to view
        do {
            System.out.println("[ View Marine Corp ]");
            System.out.println("[0] - Return");
            for (MarineCorp mc : MarineCorpList)
            {
                System.out.println("[" + (MarineCorpList.indexOf(mc)+1) + "] - " + mc.GetBaseLocation());
            }

            System.out.print("> ");
            input = getChoice();

            if (input < 0 || input > MarineCorpList.size())
            {
                System.out.println("Invalid Index");
            }

        } while (input < 0 || input > MarineCorpList.size());

        if (input > 0)
        {
            do {
                displayCorpInfo(MarineCorpList.get(input-1));

                name = getInput("Marine Name to display info (or \"exit\" to exit)");

                if (!(name.equalsIgnoreCase("exit")))
                {
                    for (Marine m : MarineCorpList.get(input-1).GetCorpMembers())
                    {
                        if (m.GetName().equalsIgnoreCase(name))
                        {
                            m.displayProfile();
                            System.out.print("Press Enter to continue...");
                            scanner.nextLine();
                        }
                    }
                }
            } while (!(name.equalsIgnoreCase("exit")));
        }
    }

    // Handles the selection and updating of marine corp attributes
    public static void ModifyMCorp()
    {
        int input;
        //Checks if there are any existing Marine Corps
        if (MarineCorpList.isEmpty()) {
            System.out.println("No Marine Corps available to modify.");
            return;
        }
        //Lists all existing Marine Corps
        do {
            System.out.println("[ Modify Marine Corp ]");
            System.out.println("[0] - Return");
            for (MarineCorp mc : MarineCorpList)
            {
                System.out.println("[" + (MarineCorpList.indexOf(mc)+1) + "] - " + mc.GetBaseLocation());
            }

            System.out.print("> ");
            input = getChoice();

            if (input < 0 || input > MarineCorpList.size())
            {
                System.out.println("Invalid Index");
            }
        } while (input < 0 || input > MarineCorpList.size());
        // After choosing a Marine Corp to modify, user is asked to choose which attribute will be modified
        if (input > 0) {
            MarineCorp selectedCorp = MarineCorpList.get(input - 1);
            int modChoice;

            do {
                System.out.println("\nModifying: " + selectedCorp.GetBaseLocation());
                System.out.println("[1] - Base Location");
                System.out.println("[2] - Operational Funds");
                System.out.println("[3] - Assign Corps Commander");
                System.out.println("[4] - Add/Remove Member");
                System.out.println("[5] - Return");
                System.out.print("> ");

                modChoice = getChoice();

                switch (modChoice) {
                    case 1:
                        String newLocation;
                        do {
                            newLocation = getInput("New Base Location");
                            if (newLocation.isBlank()) {
                                System.out.println("Base Location cannot be empty.");
                            }
                        } while (newLocation.isBlank());
                        selectedCorp.SetBaseLocation(newLocation);
                        break;
                    case 2:
                        int newFunds;
                        do {
                            System.out.print("Enter New Operational Funds: ");
                            newFunds = getChoice();
                            if (newFunds < 0) {
                                System.out.println("Funds cannot be negative.");
                            }
                        } while (newFunds < 0);
                        selectedCorp.SetOperationalFunds(newFunds);
                        break;
                    case 3:
                        if (selectedCorp.GetCorpMembers().isEmpty()) {
                            System.out.println("This Corp has no members to promote.");
                        } else {
                            System.out.println("[ Assign Commander ]");
                            System.out.println("[0] - Remove Current Commander");
                            for (int j = 0; j < selectedCorp.GetCorpMembers().size(); j++) {
                                System.out.println("[" + (j + 1) + "] - " + selectedCorp.GetCorpMembers().get(j).GetName());
                            }
                            System.out.print("> ");
                            int cmdChoice = getChoice();

                            if (cmdChoice == 0) {
                                selectedCorp.SetCorpsCommander(null);
                            } else if (cmdChoice > 0 && cmdChoice <= selectedCorp.GetCorpMembers().size()) {
                                selectedCorp.SetCorpsCommander(selectedCorp.GetCorpMembers().get(cmdChoice - 1));
                            } else {
                                System.out.println("Invalid selection.");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("\n[ Add / Remove Member ]");
                        System.out.println("[1] - Add Member");
                        System.out.println("[2] - Remove Member");
                        System.out.println("[0] - Cancel");
                        System.out.print("> ");

                        int action = getChoice();
                        if (action == 1) { // Add
                            List<Marine> availableMarines = new ArrayList<>();
                            for (Character c : CharacterList) {
                                // Find marines not currently in this specific corp
                                if (c instanceof Marine && ((Marine)c).GetMCorps() != selectedCorp) {
                                    availableMarines.add((Marine)c);
                                }
                            }
                            if (availableMarines.isEmpty()) {
                                System.out.println("No available Marines to add.");
                            } else {
                                System.out.println("[ Select Marine to Add ]");
                                System.out.println("[0] - Cancel");
                                for (int p = 0; p < availableMarines.size(); p++) {
                                    System.out.println("[" + (p + 1) + "] - " + availableMarines.get(p).GetName());
                                }
                                System.out.print("> ");
                                int addChoice = getChoice();
                                if (addChoice > 0 && addChoice <= availableMarines.size()) {
                                    selectedCorp.AddCorpMember(availableMarines.get(addChoice - 1));
                                    System.out.println("Marine successfully enlisted to the corp.");
                                }
                            }
                        } else if (action == 2) { // Remove
                            if (selectedCorp.GetCorpMembers().isEmpty()) {
                                System.out.println("This corp has no members to remove.");
                            } else {
                                System.out.println("[ Select Marine to Remove ]");
                                System.out.println("[0] - Cancel");
                                for (int p = 0; p < selectedCorp.GetCorpMembers().size(); p++) {
                                    System.out.println("[" + (p + 1) + "] - " + selectedCorp.GetCorpMembers().get(p).GetName());
                                }
                                System.out.print("> ");
                                int remChoice = getChoice();
                                if (remChoice > 0 && remChoice <= selectedCorp.GetCorpMembers().size()) {
                                    selectedCorp.RemoveCorpMember(selectedCorp.GetCorpMembers().get(remChoice - 1));
                                    System.out.println("Marine successfully removed from the corp.");
                                }
                            }
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } while (modChoice != 5);
        }
    }

    // Handles the unlinking and removal of a marine corp from the system
    public static void DeleteMCorp()
    {
        int input;

        if (MarineCorpList.isEmpty()) {
            System.out.println("No Marine Corps available to delete.");
            return;
        }

        do {
            System.out.println("[ Disband Marine Corp ]");
            System.out.println("[0] - Return");
            for (MarineCorp mc : MarineCorpList)
            {
                System.out.println("[" + (MarineCorpList.indexOf(mc)+1) + "] - " + mc.GetBaseLocation());
            }

            System.out.print("> ");
            input = getChoice();

            if (input < 0 || input > MarineCorpList.size())
            {
                System.out.println("Invalid Index");
            }
        } while (input < 0 || input > MarineCorpList.size());

        if (input > 0) {
            MarineCorp selectedCorp = MarineCorpList.get(input - 1);

            List<Marine> membersToUnlink = new ArrayList<>(selectedCorp.GetCorpMembers());
            for (Marine m : membersToUnlink) {
                selectedCorp.RemoveCorpMember(m);
            }

            selectedCorp.SetCorpsCommander(null);
            MarineCorpList.remove(selectedCorp);
            System.out.println("Marine Corp successfully disbanded.");
        }
    }

    public static void displayCorpInfo(MarineCorp mc)
    {
        Boolean first = true;

        System.out.println("\n[ " + mc.GetBaseLocation() + " ]");
        System.out.println("Corp ID: " + mc.GetCorpID());
        System.out.println("Base Location: " + mc.GetBaseLocation());
        System.out.println("Operational Funds: " + mc.GetOperationalFunds());

        if (mc.GetCorpsCommander() != null)
        {
            System.out.println("Commander: " + mc.GetCorpsCommander().GetName());
        } else
        {
            System.out.println("Commander: None");
        }

        System.out.print("Members: ");
        if (mc.GetCorpMembers().isEmpty())
        {
            System.out.println("None");
        } else
        {
            for (Marine m : mc.GetCorpMembers())
            {
                if (m != mc.GetCorpsCommander())
                {
                    if (first)
                    {
                        System.out.println(m.GetName());
                        first = false;
                    } else
                    {
                        System.out.printf("%9s%s\n", " ", m.GetName());
                    }
                }
            }
        }
    }

    public static void displayCrewInfo(PirateCrew pc)
    {
        Boolean first = true;

        System.out.println("[ " + pc.GetCrewName() + " ]");
        System.out.println("Crew ID: " + pc.GetCrewID());
        System.out.println("Crew Name: " + pc.GetCrewName());
        System.out.println("Ship's Name: " + pc.GetShipsName());

        if (pc.GetCaptain() != null)
        {
            System.out.println("Captain: " + pc.GetCaptain().GetName());
        } else
        {
            System.out.println("Captain: None");
        }
        System.out.print("Members: ");
        if (pc.GetCrewMembers().isEmpty())
        {
            System.out.println("None");
        } else
        {
            for (Pirate p : pc.GetCrewMembers())
            {
                if (p != pc.GetCaptain())
                {
                    if (first)
                    {
                        System.out.println(p.GetName());
                        first = false;
                    } else
                    {
                        System.out.printf("%9s%s\n", " ", p.GetName());
                    }
                }
            }
        }

        System.out.println("Total Crew Bounty: " + pc.GetTotalCrewBounty());
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

    public static void displayCivRole()
    {
        System.out.println("[ Profession ]");
  
        for (String s : CivRoles)
        {
            System.out.println("[" + CivRoles.indexOf(s) + "] - " + s);
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
