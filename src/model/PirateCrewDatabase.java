package model;

import java.util.ArrayList;
import java.util.List;

public class PirateCrewDatabase {
    private List<PirateCrew> PCrewList;

    public PirateCrewDatabase() {
        this.PCrewList = new ArrayList<>();
    }

    public void addPCrew (PirateCrew newPCrew) {
        this.PCrewList.add(newPCrew);
    }

    public List<PirateCrew> getAllPCrew() {
        return this.PCrewList;
    }

}