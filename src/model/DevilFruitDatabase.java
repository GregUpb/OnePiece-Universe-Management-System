package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DevilFruitDatabase {
    private List<DevilFruit> dftList;
    private File database;

    public DevilFruitDatabase() {
        this.dftList = new ArrayList<>();

        try {
            database = new File("devilfruitdatabase.dat");
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

    public void addDF(DevilFruit newDF) {
        this.dftList.add(newDF);
    }

    public List<DevilFruit> getAllDF() {
        return this.dftList;
    }

    public void writeDatabase()
    {
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(database)))
        {
            objOutput.writeObject(dftList);

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readDatabase()
    {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(database)))
        {
            
            dftList = (List<DevilFruit>) objInput.readObject();

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}