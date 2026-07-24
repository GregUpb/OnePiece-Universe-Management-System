package model;

import java.util.ArrayList;
import java.util.List;

public class BountyManager {

    private List<CaptureRecord> captureHistory;

    public BountyManager() {
        this.captureHistory = new ArrayList<>();
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
}