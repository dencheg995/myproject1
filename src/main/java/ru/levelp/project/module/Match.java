package ru.levelp.project.module;

import javax.persistence.*;
import java.util.Objects;

import static ru.levelp.project.module.Match.SEARCH_BY_MATCH_ID;

@Entity
@NamedQueries(
        @NamedQuery(name = SEARCH_BY_MATCH_ID, query = "from Match where matchId = :matchId")
)
public class Match {
    public static final String SEARCH_BY_MATCH_ID = "MyQuery";
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "match_Id", unique = true, nullable = false)
    private String matchId;

    @Column
    private String title;


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team;


    public Match(String matchId, String title) {
        this.matchId = matchId;
        this.title = title;
    }

    public Match() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return id == match.id &&
                Objects.equals(matchId, match.matchId) &&
                Objects.equals(title, match.title) &&
                Objects.equals(team, match.team);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, matchId, title, team);
    }
}
