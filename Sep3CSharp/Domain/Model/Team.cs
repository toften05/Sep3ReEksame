namespace Domain.Model;

public class Team
{
    public string teamName { get; set; }
    public string division { get; set; }
    public List<Players>? PlayersOnTeam { get; set; }
    public List<Coach>? CoachesOnTeam { get; set; }

    public Team(string teamName, string division, List<Players>? playersOnTeam, List<Coach>? coachesOnTeam)
    {
        this.teamName = teamName;
        this.division = division;
        PlayersOnTeam = playersOnTeam;
        CoachesOnTeam = coachesOnTeam;
    }
}