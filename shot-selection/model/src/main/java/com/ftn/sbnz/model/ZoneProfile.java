package com.ftn.sbnz.model;

import com.ftn.sbnz.model.enums.ShotZone;

public class ZoneProfile {

    private ShotZone zone;
    private double efgPct;
    private boolean highValue;

    public ZoneProfile() {
    }

    public ZoneProfile(ShotZone zone, double efgPct) {
        this.zone = zone;
        this.efgPct = efgPct;
        this.highValue = efgPct > 0.55;
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
        this.highValue = efgPct > 0.55;
    }

    public boolean isHighValue() {
        return highValue;
    }

    public void setHighValue(boolean highValue) {
        this.highValue = highValue;
    }

    @Override
    public String toString() {
        return String.format("ZoneProfile{zone=%s, eFG%%=%.0f%%, highValue=%s}",
                zone, efgPct * 100, highValue);
    }
}
