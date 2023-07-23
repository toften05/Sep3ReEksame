using Domain.Model;

namespace Domain.DTOs;

public class TeamDtos
{
    public record TeamCreationDto(
        string teamName, string division, List<Player> playersOnTeam, List<Coach> coachesOnTeam
    );
}