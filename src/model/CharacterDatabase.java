package model;

import java.util.ArrayList;
import java.util.List;

public class CharacterDatabase {
    private List<Character> characterList;

    public CharacterDatabase() {
        this.characterList = new ArrayList<>();
    }
    public void addCharacter(Character newCharacter) {
        this.characterList.add(newCharacter);
    }

    public List<Character> getAllCharacters() {
        return this.characterList;
    }

}