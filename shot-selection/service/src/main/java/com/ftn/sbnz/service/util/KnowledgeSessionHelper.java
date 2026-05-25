package com.ftn.sbnz.service.util;

import com.ftn.sbnz.model.Player;
import com.ftn.sbnz.model.PlayerMatchStats;
import com.ftn.sbnz.model.Team;
import com.ftn.sbnz.model.ZoneProfile;
import com.ftn.sbnz.model.enums.ShotZone;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class KnowledgeSessionHelper {

    public static KieContainer createKieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }

    public static KieSession getStatefulSession(KieContainer kc) {
        return kc.newKieSession("shot-selection-ksession");
    }
}
