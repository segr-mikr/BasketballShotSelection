package com.ftn.sbnz.model.facts;

import com.ftn.sbnz.model.enums.ShotQuality;
import org.kie.api.definition.type.PropertyReactive;
import java.util.ArrayList;
import java.util.List;

@PropertyReactive
public class ShotEvaluation {
    private String shotId;
    private String playerId;
    private String playerName;
    private int score = 50;
    private ShotQuality quality;
    private List<String> activeFactors = new ArrayList<>();

    public ShotEvaluation() {
    }

    public ShotEvaluation(String shotId, String playerId, String playerName) {
        this.shotId = shotId;
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public void addFactor(String f) {
        activeFactors.add(f);
    }

    public void capScore() {
        if (score > 100)
            score = 100;
        if (score < 0)
            score = 0;
        if (score >= 65)
            quality = ShotQuality.HIGH;
        else if (score >= 35)
            quality = ShotQuality.MEDIUM;
        else
            quality = ShotQuality.LOW;
    }

    public String getShotId() {
        return shotId;
    }

    public void setShotId(String s) {
        this.shotId = s;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String s) {
        this.playerId = s;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String s) {
        this.playerName = s;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int s) {
        this.score = s;
    }

    public ShotQuality getQuality() {
        return quality;
    }

    public void setQuality(ShotQuality q) {
        this.quality = q;
    }

    public List<String> getActiveFactors() {
        return activeFactors;
    }

    public void setActiveFactors(List<String> f) {
        this.activeFactors = f;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== EVALUACIJA: ").append(playerName).append(" ===\n");
        sb.append("Score: ").append(score).append("/100  Quality: ").append(quality).append("\n");
        for (String f : activeFactors)
            sb.append("  - ").append(f).append("\n");
        return sb.toString();
    }
}
