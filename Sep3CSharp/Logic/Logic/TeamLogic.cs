using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using Logic.Teams;

namespace Logic.Logic;

public class TeamLogic : ITeamLogic
{
    private ITeamClient _teamClient;

    public TeamLogic(ITeamClient teamClient)
    {
        _teamClient = teamClient;
    }

    public async Task<Team> createAsync(TeamCreationDTO creationDto)
    {
        Team result = await _teamClient.Create(creationDto);

        return result;
    }

    public Task<List<Team>> getAsync()
    {
        return _teamClient.getAsync();
    }
}