package ru.levelp.project.module;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelp.project.dao.MatchDAO;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static ru.levelp.project.module.Match.SEARCH_BY_MATCH_ID;

public class MatchTest {
    private EntityManager em;
    private EntityManagerFactory emf;
    private MatchDAO dao;
    @Before
    public void setup() {
        emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = emf.createEntityManager();
        dao = new MatchDAO(em);
    }

    @After
    public void end() {
        em.close();
        emf.close();
    }




    @Test
    public void testCreateMatchWithTeam() throws Throwable {
        Match match;
        em.getTransaction().begin();

        try {
            match = dao.createMatch("123", "some match", dao.createTeam("some team"));
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
    public void createQuery() throws Throwable {
        testCreateMatchWithTeam();
        String searchKey = "123";


        List<Match> mst = dao.findByMatchId(searchKey);

        assertEquals(1, mst.size());
        Match found = mst.get(0);
        assertEquals(searchKey, found.getMatchId());


    }
}
