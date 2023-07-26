using Domain.DTOs;
using Domain.Model;

namespace HttpClients;

public interface ITeamService
{
    Task<Team> CreateAsync(TeamCreationDTO creationDto);

    Task<List<Team>> getALlTeamsAsync();
}