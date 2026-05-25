package com.ftn.sbnz.model.facts;

import com.ftn.sbnz.model.enums.ShotZone;

public class ZoneSummary {

    private String playerId;
    private String playerName;
    private ShotZone zone;
    private double efgPct;
    private int shotCount;
    private int quarter;

    public ZoneSummary() {
    }

    public ZoneSummary(String playerId, String playerName, ShotZone zone,
            double efgPct, int shotCount, int quarter) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.zone = zone;
        this.efgPct = efgPct;
        this.shotCount = shotCount;
        this.quarter = quarter;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ShotZone getZone() {
        return zone;
    }

    public void setZone(ShotZone zone) {
        this.zone = zone;
    }

    public double getEfgPct() {
        return efgPct;
    }

    public void setEfgPct(double efgPct) {
        this.efgPct = efgPct;
    }

    public int getShotCount() {
        return shotCount;
    }

    public void setShotCount(int shotCount) {
        this.shotCount = shotCount;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    @Override
    public String toString() {
        return String.format("ZoneSummary{player='%s', zone=%s, eFG%%=%.0f%%, shots=%d, Q%d}",
                playerName, zone, efgPct * 100, shotCount, quarter);
    }
}
