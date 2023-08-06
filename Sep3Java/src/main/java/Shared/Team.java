package Shared;

import java.util.*;

public class Team {
    private String teamName;
    private String division;
    private String initials;
    private List<FootballPlayer> PlayersOnTeam;

    public Team(String teamName, String division, String initials) {
        this.teamName = teamName;
        this.division = division;
        this.initials = initials;
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
