package ru.levelp.project.web;

import ru.levelp.project.module.Team;

import javax.persistence.EntityManager;
import java.util.List;

public class AddMatchBean {
    private final EntityManager em;

    public AddMatchBean(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Team> getTeam(){
        return em.createQuery("from Team").getResultList();
    }

    public Team teamFind(int  id){
        return em.find(Team.class, id);
    }
}
