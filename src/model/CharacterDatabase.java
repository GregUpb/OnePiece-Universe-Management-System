package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CharacterDatabase {
    private List<Character> characterList;
    private File database;

    public CharacterDatabase() {
        this.characterList = new ArrayList<>();

        try {
            database = new File("characterdatabase.dat");
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
    public void addCharacter(Character newCharacter) {
        this.characterList.add(newCharacter);
    }

    public List<Character> getAllCharacters() {
        return this.characterList;
    }

    public void writeDatabase()
    {
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(database)))
        {
            objOutput.writeObject(characterList);

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readDatabase()
    {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(database)))
        {
            
            characterList = (List<Character>) objInput.readObject();

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}