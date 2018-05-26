package ru.levelp.project.web;

import ru.levelp.project.dao.MatchDAO;
import ru.levelp.project.module.Match;
import ru.levelp.project.module.Team;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;


@WebServlet(urlPatterns = "/Add-Matches")
public class AddMatchesServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matchId = req.getParameter("matchId");
        String title = req.getParameter("title");
        String teamID = req.getParameter("team");



        MatchDAO dao = (MatchDAO) getServletContext().getAttribute("MatchDAO");
        AddMatchBean addMatchBean = (AddMatchBean) getServletContext().getAttribute("addMatchBean");

        Match match;
        dao.getEm().getTransaction().begin();
        try {
            Team TEAM = addMatchBean.teamFind(Integer.parseInt(teamID));


            match = dao.createMatch(matchId, title, TEAM);
            dao.getEm().getTransaction().commit();
        }   catch (Throwable t){
            dao.getEm().getTransaction().rollback();
            t.printStackTrace();

            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Falled add to Match " + t.getMessage());
            return;
        }

        AddMatchComletedBean bean = new AddMatchComletedBean(match.getMatchId(), match.getTitle(), match.getTeam().getName());

        req.setAttribute("bean", bean);
        req.getRequestDispatcher("/MatchedComleteAdd.jsp").forward(req,resp);

    }
}
