namespace Domain.DTOs;

public class TeamDtos
{
    public record TeamCreationDto(
        string teamName, string division, List<PLayer>? playersOnTeam, List<Coach>? coachesOnTeam
    );
}