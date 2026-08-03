package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BountyManager implements Serializable {

    private List<CaptureRecord> captureHistory;
    private File database;

    public BountyManager() {
        this.captureHistory = new ArrayList<>();

        try {
            database = new File("bountydatabase.dat");
            if (database.createNewFile())
            {
                System.out.println("Database Created");
            } else 
            {
                System.out.println("Database Already exists");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void registerCapture(Character captor, Pirate target, String targetState) {
        if (target.GetStatus().equalsIgnoreCase("dead")) {
            throw new IllegalStateException("Cannot capture a pirate that is already dead");
        }
        CaptureRecord record = new CaptureRecord(captor,target);
        this.captureHistory.add(record);
    }

    public List<CaptureRecord> getCaptureHistory() {
        return this.captureHistory;
    }

    public void writeDatabase()
    {
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(database)))
        {
            objOutput.writeObject(captureHistory);

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readDatabase()
    {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(database)))
        {
            
            captureHistory = (List<CaptureRecord>) objInput.readObject();

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}