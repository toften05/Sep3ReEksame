package Shared;

import java.util.*;

public class FootballTeam {
    private String teamName;
    private String initials;
    private String division;
    private List<FootballPlayer> PlayersOnTeam;

    public FootballTeam(String teamName, String initials, String division) {
        this.teamName = teamName;
        this.initials = initials;
        this.division = division;
        PlayersOnTeam = new ArrayList<>();

    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public List<FootballPlayer> getPlayersOnTeam() {
        return PlayersOnTeam;
    }

    public void setPlayersOnTeam(List<FootballPlayer> playersOnTeam) {
        PlayersOnTeam = playersOnTeam;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", division='" + division + '\'' +
                ", initials='" + initials + '\'' +
                ", PlayersOnTeam=" + PlayersOnTeam +
                '}';
    }
}
