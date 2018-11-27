package org.everest.cosmos.repository;

import org.everest.cosmos.entity.Nebular;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NebularRepository{

    private SessionFactory sessionFactory;

    public NebularRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private List<Nebular> data = new ArrayList<Nebular>();

    public void addNebular(Nebular nebular){
        data.add(nebular);
    }

    public List<Nebular> getData() {
        return data;
    }

    public NebularRepository() {

        Nebular orion = new Nebular();
        orion.setConstellation("orion");
        orion.setName("orion");
        orion.setDistance(1344);
        addNebular(orion);

        Nebular crabe = new Nebular();
        crabe.setConstellation("Taureau");
        crabe.setName("Crabe");
        crabe.setDistance(6300);
        addNebular(crabe);

        Nebular aigle = new Nebular();
        aigle.setConstellation("Serpent");
        aigle.setName("Aigle");
        aigle.setDistance(7000);
        addNebular(aigle);

    }
}
