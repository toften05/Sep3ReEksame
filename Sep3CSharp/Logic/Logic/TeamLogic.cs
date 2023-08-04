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
        validateData(creationDto);
        Team result = await _teamClient.Create(creationDto);

        return result;
    }

    public Task<List<Team>> getAsync()
    {
        return _teamClient.getAsync();
    }

    private static void validateData(TeamCreationDTO teamCreationDto)
    {
        string teamName = teamCreationDto.teamName;
        string division = teamCreationDto.division;
        string initials = teamCreationDto.initials;

        if (initials.Length > 3)
        {
            throw new Exception("Initial must be 3 characters or less");
        }

        if (teamName.Length > 30)
        {
            throw new Exception("Teamname must be below 30 chracters");
        }

        if (division.Length > 30)
        {
            throw new Exception("division must be below 30 characters");
        }
    }
}