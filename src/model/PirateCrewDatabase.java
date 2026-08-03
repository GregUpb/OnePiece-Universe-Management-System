package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PirateCrewDatabase {
    private List<PirateCrew> PCrewList;
    private File database;

    public PirateCrewDatabase() {
        this.PCrewList = new ArrayList<>();

        try {
            database = new File("piratecrewdatabase.dat");
            if (database.createNewFile())
            {
                System.out.println("Database Created");
            } else 
            {
                System.out.println("Database Already exists");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addPCrew (PirateCrew newPCrew) {
        this.PCrewList.add(newPCrew);
    }

    public List<PirateCrew> getAllPCrew() {
        return this.PCrewList;
    }

    public void writeDatabase()
    {
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(database)))
        {
            objOutput.writeObject(PCrewList);

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readDatabase()
    {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(database)))
        {
            
            PCrewList = (List<PirateCrew>) objInput.readObject();

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}