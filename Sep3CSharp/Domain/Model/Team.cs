namespace Domain.Model;

public class Team
{
    public string teamName { get; set; }
    public string division { get; set; }

    public string initials { get; set; }

    public List<Player>? PlayersOnTeam { get; set; }
    public List<Coach>? CoachesOnTeam { get; set; }
}