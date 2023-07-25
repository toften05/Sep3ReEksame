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

    public async Task<Team> createAsync(TeamDtos dto)
    {
        Team result = await _teamClient.Create(dto);

        return result;
    }
}