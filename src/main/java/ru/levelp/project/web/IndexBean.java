package ru.levelp.project.web;

import ru.levelp.project.dao.MatchDAO;
import ru.levelp.project.module.Match;
import ru.levelp.project.module.Team;

import javax.persistence.EntityManager;
import java.util.List;

public class IndexBean {
    private final EntityManager em;
    private final MatchDAO dao;

    public  IndexBean(EntityManager em){
        this.em = em;
        dao = new MatchDAO(em);

    }


    public List<Match> getMatches() {
        return new MatchDAO(em).findAllMatches();
    }
}
