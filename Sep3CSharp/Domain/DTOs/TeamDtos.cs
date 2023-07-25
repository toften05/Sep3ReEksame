using Domain.Model;

namespace Domain.DTOs;

public class TeamDtos
{
    public string teamName { get; set; }
    public string division { get; set; }
    
    public string initials { get; set; }
    public List<Player> playersOnTeam { get; set; }
    
    public List<Coach> CoachesOnTeam { get; set; }

    public TeamDtos(string teamName, string division, string initials)
    {
        this.teamName = teamName;
        this.division = division;
        this.initials = initials;
        playersOnTeam = new List<Player>();
        CoachesOnTeam = new List<Coach>();
    }
}