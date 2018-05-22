package ru.levelp.project.web;

import ru.levelp.project.dao.MatchDAO;
import ru.levelp.project.module.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    private EntityManagerFactory emf;
    private EntityManager em;



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        emf = Persistence.createEntityManagerFactory("ProductionPersistenceUnit");
        em = emf.createEntityManager();


        createTestMatches();

        servletContextEvent.getServletContext().setAttribute("indexBean", new IndexBean(em));


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        em.close();
        emf.close();

    }

    private void createTestMatches(){

        em.getTransaction().begin();
        MatchDAO dao = new MatchDAO(em);
        Team myTeam = dao.createTeam("My team");

        for(int i = 0; i < 3; i++){
            dao.createMatch("000 - "+ i, "Match - " + i, myTeam );
        }

        em.getTransaction().commit();
    }
}
