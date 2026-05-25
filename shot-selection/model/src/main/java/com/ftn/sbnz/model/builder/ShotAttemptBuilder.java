package com.ftn.sbnz.model.builder;

import com.ftn.sbnz.model.ShotAttempt;
import com.ftn.sbnz.model.enums.ActionType;
import com.ftn.sbnz.model.enums.ShotZone;

public class ShotAttemptBuilder {

    private final ShotAttempt shot;

    public ShotAttemptBuilder(String shotId, String playerId) {
        shot = new ShotAttempt();
        shot.setShotId(shotId);
        shot.setPlayerId(playerId);
        shot.setPlayerName(playerId);
        shot.setActionType(ActionType.JUMP_SHOT);
        shot.setDribbles(2);
        shot.setTouchTimeSec(3.0);
        shot.setShotClockSec(14.0);
        shot.setQuarter(1);
        shot.setGameClockSec(600);
        shot.setScoreDiff(0);
        shot.setDefenderDistFt(3.0);
        shot.setDistanceFt(15.0);
    }

    public ShotAttemptBuilder zone(ShotZone z) {
        shot.setZone(z);
        return this;
    }

    public ShotAttemptBuilder playerName(String n) {
        shot.setPlayerName(n);
        return this;
    }

    public ShotAttemptBuilder action(ActionType a) {
        shot.setActionType(a);
        return this;
    }

    public ShotAttemptBuilder distance(double ft) {
        shot.setDistanceFt(ft);
        return this;
    }

    public ShotAttemptBuilder defenderDist(double ft) {
        shot.setDefenderDistFt(ft);
        return this;
    }

    public ShotAttemptBuilder defenderId(String id) {
        shot.setDefenderId(id);
        return this;
    }

    public ShotAttemptBuilder dribbles(int n) {
        shot.setDribbles(n);
        return this;
    }

    public ShotAttemptBuilder touchTime(double sec) {
        shot.setTouchTimeSec(sec);
        return this;
    }

    public ShotAttemptBuilder shotClock(double sec) {
        shot.setShotClockSec(sec);
        return this;
    }

    public ShotAttemptBuilder quarter(int q) {
        shot.setQuarter(q);
        return this;
    }

    public ShotAttemptBuilder gameClock(double sec) {
        shot.setGameClockSec(sec);
        return this;
    }

    public ShotAttemptBuilder scoreDiff(int d) {
        shot.setScoreDiff(d);
        return this;
    }

    public ShotAttemptBuilder made(boolean m) {
        shot.setMade(m);
        return this;
    }

    public ShotAttemptBuilder shootingTeam(String id) {
        shot.setShootingTeamId(id);
        return this;
    }

    public ShotAttemptBuilder defendingTeam(String id) {
        shot.setDefendingTeamId(id);
        return this;
    }

    public ShotAttempt build() {
        return shot;
    }
}
