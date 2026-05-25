package com.ftn.sbnz.model;

import com.ftn.sbnz.model.enums.ActionType;
import com.ftn.sbnz.model.enums.ShotZone;
import org.kie.api.definition.type.PropertyReactive;

@PropertyReactive
public class ShotAttempt {

    private String shotId;
    private String playerId;
    private String playerName;
    private String shootingTeamId;
    private String defendingTeamId;

    private ShotZone zone;
    private ActionType actionType;
    private double distanceFt;

    private double defenderDistFt;
    private String defenderId;

    private int dribbles;
    private double touchTimeSec;
    private double shotClockSec;

    private int quarter;
    private double gameClockSec;
    private int scoreDiff;

    private boolean made;

    public ShotAttempt() {
    }

    public String getShotId() {
        return shotId;
    }

    public void setShotId(String shotId) {
        this.shotId = shotId;
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

    public String getShootingTeamId() {
        return shootingTeamId;
    }

    public void setShootingTeamId(String shootingTeamId) {
        this.shootingTeamId = shootingTeamId;
    }

    public String getDefendingTeamId() {
        return defendingTeamId;
    }

    public void setDefendingTeamId(String defendingTeamId) {
        this.defendingTeamId = defendingTeamId;
    }

    public ShotZone getZone() {
        return zone;
    }

    public void setZone(ShotZone zone) {
        this.zone = zone;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public double getDistanceFt() {
        return distanceFt;
    }

    public void setDistanceFt(double distanceFt) {
        this.distanceFt = distanceFt;
    }

    public double getDefenderDistFt() {
        return defenderDistFt;
    }

    public void setDefenderDistFt(double defenderDistFt) {
        this.defenderDistFt = defenderDistFt;
    }

    public String getDefenderId() {
        return defenderId;
    }

    public void setDefenderId(String defenderId) {
        this.defenderId = defenderId;
    }

    public int getDribbles() {
        return dribbles;
    }

    public void setDribbles(int dribbles) {
        this.dribbles = dribbles;
    }

    public double getTouchTimeSec() {
        return touchTimeSec;
    }

    public void setTouchTimeSec(double touchTimeSec) {
        this.touchTimeSec = touchTimeSec;
    }

    public double getShotClockSec() {
        return shotClockSec;
    }

    public void setShotClockSec(double shotClockSec) {
        this.shotClockSec = shotClockSec;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public double getGameClockSec() {
        return gameClockSec;
    }

    public void setGameClockSec(double gameClockSec) {
        this.gameClockSec = gameClockSec;
    }

    public int getScoreDiff() {
        return scoreDiff;
    }

    public void setScoreDiff(int scoreDiff) {
        this.scoreDiff = scoreDiff;
    }

    public boolean isMade() {
        return made;
    }

    public void setMade(boolean made) {
        this.made = made;
    }

    @Override
    public String toString() {
        return String.format("ShotAttempt{id='%s', player=%s, zone=%s, defender=%.1fft, dribbles=%d, clock=%.0fs, Q%d}",
                shotId, playerId, zone, defenderDistFt, dribbles, shotClockSec, quarter);
    }
}
