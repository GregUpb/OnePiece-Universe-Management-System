package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CaptureRecord implements Serializable{
    private long ID;
    private Pirate nahuli;
    private Character nanghuli;

    public CaptureRecord(Character nanghuli, Pirate nahuli)
    {
        this.GenerateID();
        if (!validateCaptor(nanghuli)) {
            throw new IllegalArgumentException("Illegal capture! " + nanghuli.GetName() + " is not authorized to claim official bounties.");
        }
        this.setCaptor(nanghuli);
        this.setCaptured(nahuli);
        this.routeFinancialRewards();
    }
    public long getCaptureID() {return this.ID;}
    public Pirate getCaptured() {return this.nahuli;}
    public Character getCaptor() {return this.nanghuli;}

    public void setCaptured(Pirate nahuli)
    {
        this.nahuli = nahuli;
        updateCapturedStatus();
    }

    public void setCaptor(Character nanghuli)
    {
        this.nanghuli = nanghuli;
        if (this.nanghuli instanceof PirateHunter)
        {
            PirateHunter hunterCaptor = (PirateHunter) this.nanghuli;
            hunterCaptor.AddCaptures(1);
        }
    }

    public void routeFinancialRewards()
    {
        int bountyReward = this.nahuli.GetBounty();

        // Check if the captor is a Marine
        if (this.nanghuli instanceof Marine) {
            // Downcast the Character to a Marine
            Marine marineCaptor = (Marine) this.nanghuli;

            if (marineCaptor.GetMCorps() != null) {
                marineCaptor.GetMCorps().AddOperationalFunds(bountyReward);
                System.out.println(bountyReward + " Berries added to " + marineCaptor.GetMCorps().GetBaseLocation() + " operational funds.");
            } else {
                System.out.println("Marine has no Corps to receive the funds.");
            }
        }
        // Check if the captor is a PirateHunter or Civilian
        else if (this.nanghuli instanceof PirateHunter || this.nanghuli instanceof Civilian) {
            int newWalletBalance = this.nanghuli.GetWallet() + bountyReward;
            this.nanghuli.SetWallet(newWalletBalance);
            System.out.println(bountyReward + " Berries added to " + this.nanghuli.GetName() + "'s wallet.");
        }

        this.nahuli.SetBounty(0);
    }

    public void updateCapturedStatus()
    {
        this.nahuli.SetStatus("captured");
    }

    public Boolean validateCaptor (Character nanghuli)
    {
        if (nanghuli instanceof Marine || nanghuli instanceof Civilian || nanghuli instanceof PirateHunter)
        {
            return true;
        }
        return false;
    }




    protected void GenerateID()
    {
        LocalDateTime rn = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss"); //Year-Month-Day-Hours-Minutes-Seconds
        this.ID = Long.parseLong(rn.format(formatter));
    }
}
