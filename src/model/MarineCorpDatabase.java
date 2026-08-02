package model;

import java.util.ArrayList;
import java.util.List;

public class MarineCorpDatabase {
    private List<MarineCorp> MCorpList;

    public MarineCorpDatabase() {
        this.MCorpList = new ArrayList<>();
    }

    public void addMCorp (MarineCorp newMCorp) {
        this.MCorpList.add(newMCorp);
    }

    public List<MarineCorp> getAllMCorp() {
        return this.MCorpList;
    }

}