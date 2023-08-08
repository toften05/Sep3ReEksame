using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using GrpcClient.GrpcClientTypeHandlers;
using GrpcServices;

namespace GrpcClient.ClientImplementations;

public class TeamGrpcClient : ITeamClient
{
    public async Task<Team> Create(TeamCreationDTO creationDto)
    {
        var client = TeamGrpcHandler.GetTeamClient();

        TeamMessage reply =
            await client.CreateTeamAsync
            (
                TeamGrpcHandler.FromTeamCreationDtoToMessage(creationDto)
            );

        Team teamToReturn = TeamGrpcHandler.FromMessageToTeam(reply);

        return teamToReturn;
    }


    public async Task<List<Team>> getAsync()
    {
        var client = TeamGrpcHandler.GetTeamClient();
        ListTeamMessage replyMessage = await client.getAllTeamsAsync(new AllTeamsRequest());
        List<Team> teamsToReturn = TeamGrpcHandler.FromMessageToTeams(replyMessage);
        return teamsToReturn;
    }
}