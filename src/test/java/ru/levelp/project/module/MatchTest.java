package ru.levelp.project.module;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

public class MatchTest {
    private EntityManager em;
    private EntityManagerFactory emf;

    @Before
    public void setup() {
        emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = emf.createEntityManager();
    }

    @After
    public void end() {
        em.close();
        emf.close();
    }

    @Test
    public void testCreateMatch() throws Throwable {
        Match match = new Match("123", "some match");

        em.getTransaction().begin();

        try {
            em.persist(match);
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;

        } finally {
            em.getTransaction().commit();
        }
    }


    @Test
    public void testCreateMatchWithTeam() throws Throwable {
        Match match = new Match("123", "some match");
        Team team = new Team();
        team.setName("some team");
        match.setTeam(team);
        em.getTransaction().begin();

        try {
            em.persist(team);
            em.persist(match);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;

        }

        Match found = em.find(Match.class, match.getId());
        assertNotNull(found);
        assertNotNull(found.getTeam());
    }

    @Test
    public void createQuery() {
        List<Match> mst = (List<Match>) em.createQuery("from Match where matchId = 84 ").getResultList();
        try {
            Match match = (Match) em.createQuery("from Match where id = 0-0").getSingleResult();

        } catch (NonUniqueResultException e) {

        } catch (NoResultException no)

        {

        }
    }
}