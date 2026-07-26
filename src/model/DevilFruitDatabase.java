package model;

import java.util.ArrayList;
import java.util.List;

public class DevilFruitDatabase {
    private List<DevilFruit> dftList;

    public DevilFruitDatabase() {
        this.dftList = new ArrayList<>();
    }

    public void addDF(DevilFruit newDF) {
        this.dftList.add(newDF);
    }

    public List<DevilFruit> getAllDF() {
        return this.dftList;
    }

}