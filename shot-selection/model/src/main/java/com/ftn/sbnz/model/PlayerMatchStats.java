package com.ftn.sbnz.model;

import org.kie.api.definition.type.PropertyReactive;
import java.util.ArrayList;
import java.util.List;

@PropertyReactive
public class PlayerMatchStats {

    private String playerId;
    private int consecutiveMisses;
    private List<Double> recentMadeShots; // gameClockSec of last made shots (last 5 min window)

    public PlayerMatchStats() {
        this.recentMadeShots = new ArrayList<>();
        this.consecutiveMisses = 0;
    }

    public PlayerMatchStats(String playerId) {
        this();
        this.playerId = playerId;
    }

    public void recordMade(double gameClockSec) {
        consecutiveMisses = 0;
        recentMadeShots.add(gameClockSec);
        // keep only shots within last 5 minutes (300 seconds)
        recentMadeShots.removeIf(t -> (gameClockSec - t) > 300.0 || t < gameClockSec);
    }

    public void recordMissed() {
        consecutiveMisses++;
    }

    public boolean isHotHand() {
        return recentMadeShots.size() >= 3;
    }

    public boolean isColdStreak() {
        return consecutiveMisses >= 3;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getConsecutiveMisses() {
        return consecutiveMisses;
    }

    public void setConsecutiveMisses(int consecutiveMisses) {
        this.consecutiveMisses = consecutiveMisses;
    }

    public List<Double> getRecentMadeShots() {
        return recentMadeShots;
    }

    public void setRecentMadeShots(List<Double> recentMadeShots) {
        this.recentMadeShots = recentMadeShots;
    }

    @Override
    public String toString() {
        return String.format("PlayerMatchStats{player=%s, misses=%d, recentMakes=%d, hotHand=%s, cold=%s}",
                playerId, consecutiveMisses, recentMadeShots.size(), isHotHand(), isColdStreak());
    }
}
