package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MarineCorpDatabase {
    private List<MarineCorp> MCorpList;
    private File database;

    public MarineCorpDatabase() {
        this.MCorpList = new ArrayList<>();

        try {
            database = new File("marinecorpdatabase.dat");
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

    public void addMCorp (MarineCorp newMCorp) {
        this.MCorpList.add(newMCorp);
    }

    public List<MarineCorp> getAllMCorp() {
        return this.MCorpList;
    }

    public void writeDatabase()
    {
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(database)))
        {
            objOutput.writeObject(MCorpList);

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readDatabase()
    {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(database)))
        {
            
            MCorpList = (List<MarineCorp>) objInput.readObject();

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}