package ru.levelp.project.dao;

import ru.levelp.project.module.Match;
import ru.levelp.project.module.Team;

import javax.persistence.EntityManager;
import java.util.List;

import static ru.levelp.project.module.Match.SEARCH_BY_MATCH_ID;

public class MatchDAO {

    private final EntityManager em;

    public MatchDAO(EntityManager em) {
        this.em = em;
    }

    public Match createMatch(String matchId, String tittle, Team team){
        Match match = new Match(matchId, tittle);
        match.setTeam(team);

        em.persist(match);
        return match;
    }

    public Team createTeam(String name){
        Team team = new Team();
        team.setName(name);

        em.persist(team);
        return team;
    }
    @SuppressWarnings("unchecked")
    public List<Match> findByMatchId(String matchId) {
        return em.createNamedQuery(SEARCH_BY_MATCH_ID)
                .setParameter("matchId", matchId)
                .getResultList();
    }


}
