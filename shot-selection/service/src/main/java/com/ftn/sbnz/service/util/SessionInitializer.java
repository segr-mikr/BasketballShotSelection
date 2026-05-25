package com.ftn.sbnz.service.util;

import com.ftn.sbnz.model.Player;
import com.ftn.sbnz.model.PlayerMatchStats;
import com.ftn.sbnz.model.Team;
import com.ftn.sbnz.model.ZoneProfile;
import com.ftn.sbnz.model.enums.ShotZone;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class SessionInitializer {

    public static void init(KieSession session, List<Team> teams, List<Player> players) {
        System.out.println("\n[INIT] Loading working memory...");

        // zone profiles
        for (ShotZone zone : ShotZone.values()) {
            ZoneProfile profile = new ZoneProfile(zone, zone.getHistoricalEfgPct());
            session.insert(profile);
        }
        System.out.println("[INIT] " + ShotZone.values().length + " ZoneProfile facts loaded");

        // teams
        for (Team team : teams) {
            session.insert(team);
        }
        System.out.println("[INIT] " + teams.size() + " Team facts loaded");

        // players + playerMatchStats
        for (Player player : players) {
            session.insert(player);
            session.insert(new PlayerMatchStats(player.getId()));
        }
        System.out.println("[INIT] " + players.size() + " Player + PlayerMatchStats facts loaded\n");
    }
}
