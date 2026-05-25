package com.ftn.sbnz.model;

import com.ftn.sbnz.model.enums.ShotZone;
import org.kie.api.definition.type.PropertyReactive;

@PropertyReactive
public class Player {

    private String id;
    private String name;
    private String teamId;

    // template data
    private ShotZone preferredZone;
    private double minEfgPct; // minimum eFG% in preferred zone this game
    private double minDefenderDist; // minimum defender distance for advantage

    public Player() {
    }

    public Player(String id, String name, String teamId) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
    }

    public Player(String id, String name, String teamId,
            ShotZone preferredZone, double minEfgPct, double minDefenderDist) {
        this(id, name, teamId);
        this.preferredZone = preferredZone;
        this.minEfgPct = minEfgPct;
        this.minDefenderDist = minDefenderDist;
    }

    public boolean hasPreferredZone() {
        return preferredZone != null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public ShotZone getPreferredZone() {
        return preferredZone;
    }

    public void setPreferredZone(ShotZone preferredZone) {
        this.preferredZone = preferredZone;
    }

    public double getMinEfgPct() {
        return minEfgPct;
    }

    public void setMinEfgPct(double minEfgPct) {
        this.minEfgPct = minEfgPct;
    }

    public double getMinDefenderDist() {
        return minDefenderDist;
    }

    public void setMinDefenderDist(double minDefenderDist) {
        this.minDefenderDist = minDefenderDist;
    }

    @Override
    public String toString() {
        return "Player{" + name + " (" + teamId + ")" +
                (preferredZone != null ? ", preferred=" + preferredZone : "") + "}";
    }
}
