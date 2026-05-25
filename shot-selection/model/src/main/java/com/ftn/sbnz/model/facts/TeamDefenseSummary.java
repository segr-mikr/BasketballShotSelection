package com.ftn.sbnz.model.facts;

import com.ftn.sbnz.model.enums.ShotZone;

public class TeamDefenseSummary {

    private String teamId;
    private ShotZone zone;
    private double avgDefenderDistFt;
    private int shotCount;
    private int quarter;

    public TeamDefenseSummary() {
    }

    public TeamDefenseSummary(String teamId, ShotZone zone,
            double avgDefenderDistFt, int shotCount, int quarter) {
        this.teamId = teamId;
        this.zone = zone;
        this.avgDefenderDistFt = avgDefenderDistFt;
        this.shotCount = shotCount;
        this.quarter = quarter;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public ShotZone getZone() {
        return zone;
    }

    public void setZone(ShotZone zone) {
        this.zone = zone;
    }

    public double getAvgDefenderDistFt() {
        return avgDefenderDistFt;
    }

    public void setAvgDefenderDistFt(double avgDefenderDistFt) {
        this.avgDefenderDistFt = avgDefenderDistFt;
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
        return String.format("TeamDefenseSummary{team='%s', zone=%s, avgDist=%.1fft, shots=%d, Q%d}",
                teamId, zone, avgDefenderDistFt, shotCount, quarter);
    }
}
