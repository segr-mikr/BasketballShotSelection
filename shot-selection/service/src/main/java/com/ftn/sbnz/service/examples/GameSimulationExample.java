package com.ftn.sbnz.service.examples;

import com.ftn.sbnz.model.Player;
import com.ftn.sbnz.model.Team;
import com.ftn.sbnz.model.ShotAttempt;
import com.ftn.sbnz.model.builder.ShotAttemptBuilder;
import com.ftn.sbnz.model.enums.ActionType;
import com.ftn.sbnz.model.enums.ShotZone;
import com.ftn.sbnz.model.facts.QuarterEndSignal;
import com.ftn.sbnz.model.facts.ShotEvaluation;
import com.ftn.sbnz.model.facts.ZoneSummary;
import com.ftn.sbnz.model.facts.TeamDefenseSummary;
import com.ftn.sbnz.service.util.KnowledgeSessionHelper;
import com.ftn.sbnz.service.util.SessionInitializer;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Arrays;
import java.util.Collection;

public class GameSimulationExample {

    public static void main() {
        System.out.println(
                "\n╔══════════════════════════════════════════════════╗\n" +
                        "║  NBA Shot Selection - SBNZ Forward Chaining     ║\n" +
                        "║  Golden State Warriors vs Denver Nuggets         ║\n" +
                        "╚══════════════════════════════════════════════════╝");

        KieContainer kc = KnowledgeSessionHelper.createKieContainer();
        KieSession session = KnowledgeSessionHelper.getStatefulSession(kc);

        SessionInitializer.init(session,
                Arrays.asList(
                        new Team("GSW", "Golden State Warriors"),
                        new Team("DEN", "Denver Nuggets")),
                Arrays.asList(
                        new Player("curry", "Stephen Curry", "GSW",
                                ShotZone.LEFT_CORNER_3, 0.58, 4.0),
                        new Player("jokic", "Nikola Jokic", "DEN",
                                ShotZone.RESTRICTED_AREA, 0.65, 2.0)));

        System.out.println("════════  KVARTAL 1  ════════");

        processShot(session, new ShotAttemptBuilder("s1", "curry")
                .zone(ShotZone.LEFT_CORNER_3).distance(22.0)
                .defenderDist(5.5).dribbles(0).touchTime(1.2)
                .shotClock(18.0).quarter(1).gameClock(600)
                .scoreDiff(0).shootingTeam("GSW").defendingTeam("DEN")
                .made(true).build());

        processShot(session, new ShotAttemptBuilder("s2", "jokic")
                .zone(ShotZone.RESTRICTED_AREA).distance(3.0)
                .action(ActionType.LAYUP)
                .defenderDist(4.5).dribbles(2).touchTime(3.0)
                .shotClock(14.0).quarter(1).gameClock(560)
                .scoreDiff(0).shootingTeam("DEN").defendingTeam("GSW")
                .made(true).build());

        System.out.println("\n════════  KRAJ KVARTALA 1 - ACCUMULATE  ════════");
        session.insert(new QuarterEndSignal(1));
        session.getAgenda().getAgendaGroup("accumulate").setFocus();
        session.fireAllRules();

        printSummaries(session);
        session.dispose();
    }

    private static void processShot(KieSession session, ShotAttempt shot) {
        session.insert(shot);
        session.getAgenda().getAgendaGroup("init").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("level1").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("level2").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("level3").setFocus();
        session.fireAllRules();
    }

    @SuppressWarnings("unchecked")
    private static void printSummaries(KieSession session) {
        System.out.println("\n── Zone Summaries ──");
        ((Collection<ZoneSummary>) session.getObjects(o -> o instanceof ZoneSummary))
                .forEach(z -> System.out.println("  " + z));
        System.out.println("── Team Defense Summaries ──");
        ((Collection<TeamDefenseSummary>) session.getObjects(o -> o instanceof TeamDefenseSummary))
                .forEach(d -> System.out.println("  " + d));
        System.out.println("\n── Shot Evaluations ──");
        ((Collection<ShotEvaluation>) session.getObjects(o -> o instanceof ShotEvaluation))
                .forEach(e -> System.out.printf("  %s -> %d/100 %s%n  Faktori: %s%n%n",
                        e.getPlayerName(), e.getScore(), e.getQuality(), e.getActiveFactors()));
    }
}
