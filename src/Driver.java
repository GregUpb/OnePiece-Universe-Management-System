import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    
    private List<Character> CharacterList = new ArrayList<>();
    private List<DevilFruit> DevilFruitList = new ArrayList<>();
    private List<PirateCrew> PirateCrewList = new ArrayList<>();
    private List<MarineCorp> MarineCorpList = new ArrayList<>();

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
                    break;
            }

        } while (choice != 5);

    }

    public static void Characters()
    {
        // NOT FINAL
        DevilFruit df = new DevilFruit("Sex Sex no Mi", "Logia", "Sex");
        Pirate pirate1 = new Pirate("F", "f", "home", "dead", df, 555, 1, "AAAA", true);
        pirate1.SetPirateRole("captain");
        pirate1.displayProfile();
        pirate1.performDuty();
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

    /* HELPER */
    public static int getChoice()
    {
        if (scanner.hasNextInt())
        {
            return scanner.nextInt();
        } else
        {
            return -1;
        }
    }

    

}
