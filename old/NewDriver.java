import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewDriver
{
    // Array List
    private static final List<Character> CharacterList = new ArrayList<>();
    private static final List<DevilFruit> DevilFruitList = new ArrayList<>();
    private static final List<PirateCrew> PirateCrewList = new ArrayList<>();
    private static final List<MarineCorp> MarineCorpList = new ArrayList<>();
    // Scanner
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        int choice;

        /*
            Replace with the window
        */
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


    /* Characters */
    public static void Characters()
    {

        int input;

        do {

            System.out.println("====[ Characters ]====");
            System.out.println("[1] - Create a new Character");
            System.out.println("[2] - View Character");
            System.out.println("[3] - Modify Character");
            System.out.println("[4] - Delete Character");
            System.out.println("[5] - Return");

            System.out.print("> ");
            input = getChoice();

            switch (input) {
                case 1:
                    CreateCharacter();
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

        } while (input != 5);

    }
    
    public static void CreateCharacter()
    {
        /* Choose between pirate, marine, pirate hunter, civilian */
        int type;

        do { 
            System.out.println("[ Type of Character ]");
            System.out.println("[1] - Pirate");
            System.out.println("[2] - Marine");
            System.out.println("[3] - Pirate Hunter");
            System.out.println("[4] - Civilian");
            type = getChoice();
        } while (type < 0 || type > 4);


        /* Character Creation */
        String name, alias, origin, status;
        DevilFruit df;
        int wallet;

        int index;

        // Name Verification
        name = stringVerify("Name");

        // Alias
        alias = getInput("Alias");

        // Origin Verification
        origin = stringVerify("Origin");

        // Status Verification
        do { 
            
            status = stringVerify("Status");

        } while ((!(status.equalsIgnoreCase("alive") || status.equalsIgnoreCase("captured") || status.equalsIgnoreCase("dead")) && type == 1) ||
                (!(status.equalsIgnoreCase("alive") || status.equalsIgnoreCase("dead")) && type != 1));
    
        // Devil Fruit
        if (DevilFruitList.isEmpty())
        {
            System.out.println("Skipping Devil Fruit Selection... (No Devil Fruit)");
            index = 0;
        } else
        {
            do {
                displayDF();
                index = getChoice();
            } while (index < 0 || index > (DevilFruitList.size() - 1));
        }
        if (index != 0)
        {
            df = DevilFruitList.get(index-1);
        } else
        {
            df = null;
        }

        // Wallet Verification
        wallet = numberVerify("Wallet");

        /* Type specific */
        switch (type) {
            case 1:
                int bounty;
                String pirateRole;
                boolean IsCaptain = false;
                PirateCrew crew;

                int minus = 0;

                // Bounty
                bounty = numberVerify("Bounty");

                // Crew Verification
                if (PirateCrewList.isEmpty())
                {
                    System.out.println("Skipping Pirate Crew Selection (No Pirate Crew Available)...");
                    index = 0;
                } else
                {
                    do { 
                        displayCrew();
                        index = getChoice();
                    } while (index < 0 || index > (PirateCrewList.size() -1));
                }
                if (index == 0)
                {
                    crew = null;
                } else
                {
                    crew = PirateCrewList.get(index-1);
                }

                // PirateRole
                do { 
                    System.out.println("[Roles]");
                    for (int i = 0; i < Pirate.ROLES.size()-4; i++)
                    {
                        if (i > 0 && crew != null)
                        {
                            minus = 2;
                            System.out.println("[" + i + "] - " + Pirate.ROLES.get(i+1)[0]);
                        } else if (i > 0 && crew == null)
                        {
                            minus = 5;
                            System.out.println("[" + i + "] - " + Pirate.ROLES.get(i+4)[0]);
                        } else
                        {
                            System.out.println("[" + i + "] - " + Pirate.ROLES.get(i)[0]);
                        }
                    }
                    index = getChoice();
                } while (index < 0 || index > (Pirate.ROLES.size() - minus));

                if (index != 0 && crew != null)
                {
                    pirateRole = Pirate.ROLES.get(index+1)[0];
                } else if (index != 0 && crew == null)
                {
                    pirateRole = Pirate.ROLES.get(index+4)[0];
                } else
                {
                    pirateRole = Pirate.ROLES.get(index)[0];
                }

                Pirate pirate = new Pirate(name, alias, origin, status, df, wallet, bounty, pirateRole, IsCaptain, crew);
                CharacterList.add(pirate);
                pirate.displayProfile();
                System.out.println("New Pirate has been created");
                break;

            case 2:
                String Rank;
                MarineCorp mCorps;
                boolean isCorpCommander = false;

                // Marine Corps
                if (MarineCorpList.isEmpty())
                {
                    System.out.println("Skipping Marine Corps Selection (No Marine Corp)...");
                    index = 0;
                } else
                {
                    do { 
                        displayCorp();
                        index = getChoice();
                    } while (index < 0 || index > (MarineCorpList.size() -1));
                }
                if (index != 0)
                {
                    mCorps = MarineCorpList.get(index-1);
                } else
                {
                    mCorps = null;
                }

                // Rank Verification
                do { 
                    displayRank();
                    index = getChoice();
                } while (index < 0 || index > Marine.RANKS.size()-1);
                Rank = Marine.RANKS.get(index)[0];

                Marine marine = new Marine(name, alias, origin, status, df, wallet, Rank, mCorps, isCorpCommander);
                CharacterList.add(marine);
                marine.displayProfile();
                System.out.println("New Marine has been created");

                break;
            case 3:
                String combatStyle;
                int captures;

                // Combat Style
                combatStyle = stringVerify("Combat Style");

                // Captures
                captures = numberVerify("Captures");

                PirateHunter piratehunter = new PirateHunter(name, alias, origin, status, df, wallet, combatStyle, captures);
                CharacterList.add(piratehunter);
                piratehunter.displayProfile();
                System.out.println("New Pirate Hunter has been created");
                
                break;
            case 4:
                String profession, residence;

                // Profession
                profession = stringVerify("Profession");

                // Residence
                residence = stringVerify("Residence");

                Civilian civilian = new Civilian(name, alias, origin, status, df, wallet, profession, residence);
                CharacterList.add(civilian);
                civilian.displayProfile();
                System.out.println("New Civilian has been created");
                
                break;
            default:
                break;
        }
    }

    public static void ViewCharacter()
    {
        if (!(CharacterList.isEmpty()))
        {
            int index;
            do { 
                System.out.println("[ Character ]");
                for (Character c : CharacterList)
                {
                    System.out.println("[" + (CharacterList.indexOf(c)+1) + "] - " + c.GetName());
                }
    
                index = getChoice();
    
            } while (index < 1 || index > CharacterList.size());
    
            CharacterList.get(index-1).displayProfile();
            scanner.nextLine();
        } else
        {
            System.out.println("No Character Exist");
        }
    }

    public static void ModifyCharacter()
    {
        if (!(CharacterList.isEmpty()))
        {
            int index;
            Character selectedChar;
            do { 
                System.out.println("[ Character ]");
                for (Character c : CharacterList)
                {
                    System.out.println("[" + (CharacterList.indexOf(c)+1) + "] - " + c.GetName());
                }
    
                index = getChoice();
    
            } while (index < 1 || index > CharacterList.size());
            selectedChar = CharacterList.get(index-1);

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

            System.out.print("> ");
            int choice = getChoice();

            if (choice < 1 || choice > maxOptions) {
                System.out.println("Invalid option.");
            } else
            {
                // 4. Process Universal Edits
                switch (choice) {
                    case 1:
                        selectedChar.SetName(stringVerify("New Name"));
                        break;
                    case 2:
                        selectedChar.SetAlias(getInput("New Alias"));
                        break;
                    case 3:
                        selectedChar.SetOrigin(stringVerify("New Origin"));
                        break;
                    case 4:
                        String newStatus;
                        do {
                            if (selectedChar instanceof Pirate)
                            {
                                newStatus = getInput("New Status (Alive/Captured/Dead)");
                                if (!(newStatus.equalsIgnoreCase("alive") || newStatus.equalsIgnoreCase("captured") || newStatus.equalsIgnoreCase("dead"))) {
                                    System.out.println("Invalid status.");
                                }
                            } else
                            {
                                newStatus = getInput("New Status (Alive/Dead)");
                                if (!(newStatus.equalsIgnoreCase("alive") || newStatus.equalsIgnoreCase("dead"))) {
                                    System.out.println("Invalid status.");
                                }
                            }
                        } while ((!(newStatus.equalsIgnoreCase("alive") || newStatus.equalsIgnoreCase("captured") || newStatus.equalsIgnoreCase("dead")) && selectedChar instanceof Pirate) ||
                                (!(newStatus.equalsIgnoreCase("alive") || newStatus.equalsIgnoreCase("dead")) && !(selectedChar instanceof Pirate)));
                        selectedChar.SetStatus(newStatus);
                        break;
                    case 5:
                        selectedChar.SetWallet(numberVerify("New Wallet"));
                        break;
                    case 6:
                        if (DevilFruitList.isEmpty())
                        {
                            System.out.println("No Devil Fruit Exist");
                        } else
                        {
                            // "One Fruit, One Soul" Rule
                            if (selectedChar.GetDFPower() != null) {
                                System.out.println("Cannot reassign. Character already has a Devil Fruit. They must be 'Dead' to relinquish it.");
                            } else {
                                displayDF();
                                System.out.print("> ");
                                int dfIndex = getChoice();
    
                                if (dfIndex > 0 && dfIndex <= DevilFruitList.size()) {
                                    DevilFruit selectedFruit = DevilFruitList.get(dfIndex - 1);
                                    if (selectedFruit.HasCurrentOwner()) {
                                        System.out.println("This Devil Fruit is already owned by another character.");
                                    } else {
                                        selectedFruit.SetCurrentOwner(selectedChar);
                                        System.out.println("Devil Fruit successfully assigned.");
                                    }
                                } else
                                {
                                    System.out.println("Invalid Index");
                                }
                            }
                        }
                        break;
                }

                // Sub-class Specific Modifications
                if (choice > 6) {
                    if (selectedChar instanceof Pirate) {
                        Pirate p = (Pirate) selectedChar; //Downcasting, ChildClass <var_name> = (ChildClass) ParenClass
                        if (choice == 7) {
                            p.SetBounty(numberVerify("New Bounty"));
                        } else if (choice == 8) {
                            int minus = 0;
                            System.out.println("[Roles]");
                            for (int i = 0; i < Pirate.ROLES.size()-4; i++)
                            {
                                if (i > 0 && p.GetPirateCrew() != null)
                                {
                                    minus = 2;
                                    System.out.println("[" + i + "] - " + Pirate.ROLES.get(i+1)[0]);
                                } else if (i > 0 && p.GetPirateCrew() == null)
                                {
                                    minus = 5;
                                    System.out.println("[" + i + "] - " + Pirate.ROLES.get(i+4)[0]);
                                } else
                                {
                                    System.out.println("[" + i + "] - " + Pirate.ROLES.get(i)[0]);
                                }
                            }
                            index = getChoice();

                            if (index < 0 || index > (Pirate.ROLES.size() - minus))
                            {
                                System.out.println("Invalid Index");
                            } else if (index != 0 && p.GetPirateCrew() != null)
                            {
                                p.SetPirateRole(Pirate.ROLES.get(index+1)[0]);
                            } else if (index != 0 && p.GetPirateCrew() == null)
                            {
                                p.SetPirateRole(Pirate.ROLES.get(index+4)[0]);
                            } else
                            {
                                p.SetPirateRole(Pirate.ROLES.get(index)[0]);
                            }

                        } else if (choice == 9) {
                            if (PirateCrewList.isEmpty())
                            {
                                System.out.println("No Pirate Crew Exist");
                            } else
                            {
                                displayCrew();
                                System.out.print("> ");
                                int crewIndex = getChoice();
                                if (crewIndex == 0) {
                                    p.SetPirateCrew(null);
                                } else if (crewIndex > 0 && crewIndex <= PirateCrewList.size()) {
                                    p.SetPirateCrew(PirateCrewList.get(crewIndex - 1));
                                }
                            }
                        }
                    } else if (selectedChar instanceof Marine) {
                        Marine m = (Marine) selectedChar; //Downcasting, ChildClass <var_name> = (ChildClass) ParenClass
                        if (choice == 7) {
                            displayRank();
                            System.out.print("> ");
                            int rankIndex = getChoice();
                            if (rankIndex > 0 && rankIndex < Marine.RANKS.size())
                            {
                                m.SetRank(Marine.RANKS.get(rankIndex)[0]);
                            } else
                            {
                                System.out.println("Invalid Index");
                            }
                        } else if (choice == 8) {
                            if (MarineCorpList.isEmpty())
                            {
                                System.out.println("No Marine Corp exist");
                            } else
                            {
                                displayCorp();
                                System.out.print("> ");
                                int corpIndex = getChoice();
                                if (corpIndex == 0) {
                                    m.SetMCorps(null);
                                } else if (corpIndex > 0 && corpIndex < MarineCorpList.size()) {
                                    m.SetMCorps(MarineCorpList.get(corpIndex - 1));
                                }
                            }
                        }
                    } else if (selectedChar instanceof PirateHunter) {
                        PirateHunter ph = (PirateHunter) selectedChar; //Downcasting, ChildClass <var_name> = (ChildClass) ParenClass
                        if (choice == 7) {
                            ph.SetCombatStyle(getInput("New Combat Style"));
                        } else if (choice == 8) {
                            ph.SetCaptures(numberVerify("New Captures"));
                        }
                    } else if (selectedChar instanceof Civilian) {
                        Civilian c = (Civilian) selectedChar;//Downcasting, ChildClass <var_name> = (ChildClass) ParenClass
                        if (choice == 7) {
                            
                            int civRoleIndex;

                            displayCivRole();
                            System.out.print("> ");
                            civRoleIndex = getChoice();

                            if (civRoleIndex >= 0 && civRoleIndex < Civilian.CIVPROFESSIONS.size())
                            {
                                c.SetProfession(Civilian.CIVPROFESSIONS.get(civRoleIndex)[0]);
                            }

                        } else if (choice == 8) {
                            c.SetResidence(getInput("New Residence"));
                        }
                    }
                }

                System.out.println("Modification complete!");
            }

        } else
        {
            System.out.println("No Character Exist");
        }
    }

    public static void DeleteCharacter()
    {
        if (CharacterList.isEmpty()) {
            System.out.println("No characters available to delete.");
        } else
        {
            System.out.println("[ Character ]");
            for (int i = 0; i < CharacterList.size(); i++) {
                System.out.println("[" + (i + 1) + "] - " + CharacterList.get(i).GetName() + " (" + CharacterList.get(i).getClass().getSimpleName() + ")");
            }
            int charIndex = getChoice();
    
            if (charIndex < 1 || charIndex > CharacterList.size()) {
                System.out.println("Invalid selection.");
            } else
            {
                Character selectedChar = CharacterList.get(charIndex - 1);
        
                // Set to dead to Trigger reincarnation to remove fruit
                selectedChar.SetStatus("dead");
        
                // Delete affiliation connections
                if (selectedChar instanceof Pirate) {
                    Pirate p = (Pirate) selectedChar;
                    if (p.GetPirateCrew() != null) {
                        p.GetPirateCrew().RemoveCrewMember(p);
                    }
                }
                if (selectedChar instanceof Marine) {
                    Marine m = (Marine) selectedChar;
                    if (m.GetMCorps() != null) {
                        m.GetMCorps().RemoveCorpMember(m);
                    }
                }
        
                // Remove from Global list
                CharacterList.remove(selectedChar);
                System.out.println("Character successfully deleted and unlinked from all systems.");
            }
        }
    }


    /* Devil Fruit */
    public static void DevilFruits()
    {
        int input;

        do {
            System.out.println("====[ Characters ]====");
            System.out.println("[1] - Create a new Devil Fruit");
            System.out.println("[2] - View Devil Fruit Info");
            System.out.println("[3] - Assign Devil Fruit to Character");
            System.out.println("[4] - Return");

            System.out.print("> ");
            input = getChoice();

            switch (input) {
                case 1:
                    CreateDevilFruit();
                    break;
                case 2:
                    ViewDevilFruit();
                    break;
                case 3:
                    AssignDevilFruit();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }

        } while (input != 4);
    }

    public static void CreateDevilFruit()
    {
        // Variables
        String name, primaryAbility;
        String category;
        int temp;
        Character currOwner; // current owner in the CharacterList
        List<Character> historicalOwner = new ArrayList<>(); // A list of the former owner in the CharacterList

        System.out.println("[ Devil Fruit ]");

        // Name Verification
        name = stringVerify("Devil Fruit Name");

        // Category Verification
        do {
            // Choices
            System.out.println("[ Category ]");
            System.out.println("[1] - Paramecia");
            System.out.println("[2] - Logia");
            System.out.println("[3] - Zoan");

            System.out.print("> ");
            temp = getChoice();

        } while (temp < 1 || temp > 3);
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
                return;
        }

        // Primary Ability
        primaryAbility = stringVerify("Primary Ability of the Devil Fruit");    // Get the Primary Ability

        // Current Owner & Historical Owner/s Verification
        if (CharacterList.isEmpty())
        {
            currOwner = null;
        } else
        {
            do {
                System.out.println("[ Current Owner ]");
                System.out.println("[0] - None");
    
                for (Character c : CharacterList)
                {
                    System.out.println("[" + (CharacterList.indexOf(c) + 1) + "] - " + c.GetName());
                }
    
                System.out.print("> ");
                temp = getChoice();
    
                if (temp < 0 || temp > CharacterList.size())
                {
                    System.out.println("Invalid Index");
                } else if (temp > 0)
                {
                    if (CharacterList.get(temp-1).GetDFPower() != null)
                    {
                        System.out.println(CharacterList.get(temp-1).GetName() + " already have a devil fruit");
                    }
                }
    
            } while (temp < 0 || temp > (CharacterList.size()-1));
            if (temp != 0)
            {
                currOwner = CharacterList.get(temp-1);
            } else
            {
                currOwner = null;
            }
    
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
                        if (currOwner != null)
                        {
                            if (CharacterList.get(CharacterList.indexOf(currOwner)) == CharacterList.get(temp-1))
                            {
                                System.out.println("Current Owner cannot be a Historical Owner");
                            } else if (historicalOwner.contains(CharacterList.get(temp-1)))
                            {
                                System.out.println(CharacterList.get(temp-1).GetName() + " is already added");
                            } else
                            {
                                historicalOwner.add(CharacterList.get(temp-1));
                            }
                        } else
                        {
                            if (historicalOwner.contains(CharacterList.get(temp-1)))
                            {
                                System.out.println(CharacterList.get(temp-1).GetName() + " is already added");
                            } else
                            {
                                historicalOwner.add(CharacterList.get(temp-1));
                            }
                        }
                        
                    }
                } else
                {
                    System.out.println("Invalid Index");
                }
    
            } while (temp != 0);
        }

        // Creation
        DevilFruit devilfruit = new DevilFruit(name, category, primaryAbility, currOwner, historicalOwner);
        DevilFruitList.add(devilfruit);
        System.out.println("New Devil Fruit has been created.");
    }

    public static void ViewDevilFruit()
    {
        if (!(DevilFruitList.isEmpty()))
        {
            DevilFruit temp;
            int dfIndex;
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

    public static void AssignDevilFruit()
    {
        if (!(DevilFruitList.isEmpty()))
        {
            int dfIndex, charIndex;
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

                if (CharacterList.get(charIndex).GetDFPower() == null)
                {
                    System.out.println("Assigning " + CharacterList.get(charIndex).GetName() + " " + DevilFruitList.get(dfIndex).GetFruitName());

                    CharacterList.get(charIndex).SetDFPower(DevilFruitList.get(dfIndex));   // Set Devil Fruit of the Character Picked
                } else if (CharacterList.get(charIndex).GetDFPower() == DevilFruitList.get(dfIndex))
                {
                    System.out.println(CharacterList.get(charIndex).GetName() + " already have " + DevilFruitList.get(dfIndex).GetFruitName());
                } else
                {
                    System.out.println(CharacterList.get(charIndex).GetName() + " already have a devil fruit");
                }


            } else
            {
                System.out.println("No Existing Character");
            }
        } else
        {
            System.out.println("No Existing Devil Fruit");
        }
    }


    /* Pirate Crew */
    public static void PirateCrews()
    {
        int input;

        do {
            System.out.println("====[ Pirate Crew ]====");
            System.out.println("[1] - Create Pirate Crew");
            System.out.println("[2] - View Pirate Crew");
            System.out.println("[3] - Modify Pirate Crew");
            System.out.println("[4] - Disband Pirate Crew");
            System.out.println("[5] - Return");

            System.out.print("> ");
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
                    DeletePirateCrew();
                    break;
                case 5:
                    break;
            
                default:
                    System.out.println("Invalid Input");
                    break;
            }


        } while (input != 5);
    }

    public static void CreatePirateCrew()
    {
        String crewName, shipName;
        int capIndex = 0;
        int crewIndex = 0;
        Pirate captain = null;
        List<Pirate> members = new ArrayList<>();
        
        int i;
        List<Integer> pirateIndex = new ArrayList<>();
        boolean pirateExist = false;

        for (Character charac : CharacterList)
        {
            if (charac instanceof Pirate)
            {
                pirateExist = true;
                break;
            }
        }

        System.out.println("=[ Create Pirate Crew ]=");

        // Crew Name Verification
        crewName = stringVerify("Pirate Crew Name");

        // Ship Name Verification
        shipName = stringVerify("Pirate Ship's Name");

        // Captain Verification
        if (CharacterList.isEmpty() || !(pirateExist))
        {
            System.out.println("Skipping Character Selection (No Pirate Exists)...");
        } else
        {
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
            if (capIndex > 0)
            {
                captain = (Pirate)CharacterList.get(pirateIndex.get(capIndex-1));
            }
    
            // Members Verification
            do {
                pirateIndex.clear();
                System.out.println("[ Pirate Members ]");
    
                if (members.isEmpty())
                {
                    System.out.println("[0] - None");
                } else
                {
                    System.out.println("[0] - Done");
                }
    
                pirateIndex.add(0);
    
                // List all pirates existing in the CharacterList not in a crew
                i = 0;
                for (Character c : CharacterList)
                {
                    if (capIndex > 0)
                    {
                        if (c instanceof Pirate && ((Pirate)c).GetPirateCrew() == null && c != CharacterList.get(capIndex-1))
                        {
                            i++;
                            System.out.println("[" + i + "] - " + c.GetName());
                            pirateIndex.add(CharacterList.indexOf(c));
                        }
                    } else
                    {
                        if (c instanceof Pirate && ((Pirate)c).GetPirateCrew() == null)
                        {
                            i++;
                            System.out.println("[" + i + "] - " + c.GetName());
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
        }
        PirateCrew crew = new PirateCrew(crewName, shipName, captain, members);
        PirateCrewList.add(crew);

        System.out.println("New Pirate Crew has been created");
    }

    public static void ViewPirateCrew()
    {
        if (PirateCrewList.isEmpty())
        {
            System.out.println("No Pirate Crew exist");
        } else
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
    }

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


    /* Marine Corp */
    public static void MarineCorps()
    {
        int input;

        do {
            System.out.println("====[ Marine Corp ]====");
            System.out.println("[1] - Create Marine Corp");
            System.out.println("[2] - View Marine Corp");
            System.out.println("[3] - Modify Marine Corp");
            System.out.println("[4] - Disband Marine Corp");
            System.out.println("[5] - Return");

            System.out.print("> ");
            input = getChoice();

            switch (input) {
                case 1:
                    CreateMarineCorp();
                    break;
                case 2:
                    ViewMarineCorp();
                    break;
                case 3:
                    ModifyMarineCorp();
                    break;
                case 4:
                    DeleteMarineCorp();
                    break;
                case 5:
                    break;
            
                default:
                    System.out.println("Invalid Input");
                    break;
            }


        } while (input != 5);
    }

    public static void CreateMarineCorp()
    {
        String baseLocation;
        int funds;
        int commIndex = 0;
        int corpIndex = 0;
        int i;
        Marine corpCommander = null;
        List<Marine> members = new ArrayList<>();
        List<Integer> marineIndex = new ArrayList<>();

        boolean marineExist = false;

        for (Character charac : CharacterList)
        {
            if (charac instanceof Marine)
            {
                marineExist = true;
                break;
            }
        }

        System.out.println("[ Create Marine Corp ]");

        // Base Location Verification
        baseLocation = stringVerify("Base Location");

        // Operational Funds Verification
        funds = numberVerify("Operational Funds");

        // Commander Verification
        if (CharacterList.isEmpty() || !(marineExist))
        {
            System.out.println("Skipping Commander Selection (No Marine Character exist)");
            corpCommander = null;
        } else
        {
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
            if (commIndex > 0)
            {
                corpCommander = (Marine)CharacterList.get(marineIndex.get(commIndex-1));
            }
        }

        // Members Verification
        if (CharacterList.isEmpty() || !(marineExist))
        {
            System.out.println("Skipping Member Selection (No Marine Character exist)");
        } else
        {
            do {
                marineIndex.clear();
                System.out.println("[ Marine Members ]");
    
                if (members.isEmpty())
                {
                    System.out.println("[0] - None");
                } else
                {
                    System.out.println("[0] - Done");
                }
    
                marineIndex.add(0);
    
                // List all marines existing in the CharacterList not in a corp
                i = 0;
                for (Character c : CharacterList)
                {
                    if (commIndex > 0)
                    {
                        if (c instanceof Marine && ((Marine)c).GetMCorps() == null && c != CharacterList.get(commIndex-1))
                        {
                            i++;
                            System.out.println("[" + i + "] - " + c.GetName());
                            marineIndex.add(CharacterList.indexOf(c));
                        }
                    } else
                    {
                        if (c instanceof Marine && ((Marine)c).GetMCorps() == null)
                        {
                            i++;
                            System.out.println("[" + i + "] - " + c.GetName());
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
        }

        // Marine Corp Creation
        MarineCorp corp = new MarineCorp(baseLocation, corpCommander, funds, members);
        MarineCorpList.add(corp);
        System.out.println("Marine Corp successfully registered.");
    }

    public static void ViewMarineCorp()
    {
        if (MarineCorpList.isEmpty())
        {
            System.out.println("No Marine Corp exist");
        } else
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
    }

    public static void ModifyMarineCorp()
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
                                selectedCorp.SetCorpCommander(null);
                            } else if (cmdChoice > 0 && cmdChoice <= selectedCorp.GetCorpMembers().size()) {
                                selectedCorp.SetCorpCommander(selectedCorp.GetCorpMembers().get(cmdChoice - 1));
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

    public static void DeleteMarineCorp()
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

            MarineCorpList.remove(selectedCorp);
            System.out.println("Marine Corp successfully disbanded.");
        }
    }



    /* HELPER */
    public static void displayCorpInfo(MarineCorp mc)
    {
        boolean first = true;

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
                } else
                {
                    System.out.println("None");
                }
            }
        }
    }

    public static void displayCrewInfo(PirateCrew pc)
    {
        boolean first = true;

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
                } else
                {
                    System.out.println("None");
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
        for (int i = 0; i < Pirate.ROLES.size(); i++)
        {
            System.out.println("[" + i + "] - " + Pirate.ROLES.get(i)[0]);
        }
    }

    public static void displayCivRole()
    {
        System.out.println("[ Profession ]");
        for (int i = 0; i < Civilian.CIVPROFESSIONS.size(); i++)
        {
            System.out.println("[" + i + "] - " + Civilian.CIVPROFESSIONS.get(i)[0]);
        }
    }

    public static void displayRank()
    {
        System.out.println("[ Rank ]");
        for (int i = 0; i < Marine.RANKS.size(); i++)
        {
            System.out.println("[" + i + "] - " + Marine.RANKS.get(i)[0]);
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

    public static String stringVerify(String text)
    {
        String input;

        do {

            input = getInput(text);
            if (input.isBlank())
            {
                System.out.println(text + " cannot be empty");
            }

        } while (input.isBlank());

        return input;
    }

    public static int numberVerify(String text)
    {
        int input;

        do {

            System.out.print("Enter " + text + ": ");
            input = getChoice();

            if (input < 0)
            {
                System.out.println(text + " cannot be negative");
            }

        } while (input < 0);

        return input;
    }
}