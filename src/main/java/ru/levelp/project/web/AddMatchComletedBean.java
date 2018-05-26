package ru.levelp.project.web;

public class AddMatchComletedBean {
    private String MatchId;
    private String Tittle;
    private String teamBean;

    public AddMatchComletedBean(String matchId, String tittle, String team) {
        MatchId = matchId;
        Tittle = tittle;
        teamBean = team;
    }

    public String getMatchId() {
        return MatchId;
    }

    public void setMatchId(String matchId) {
        MatchId = matchId;
    }

    public String getTeam() {
        return teamBean;
    }

    public void setTeamBean(String teamBean) {
        this.teamBean = teamBean;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }


}
