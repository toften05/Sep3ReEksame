using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using GrpcClient.GrpcClientTypeHandlers;
using GrpcServices;

namespace GrpcClient.ClientImplementations;

public class TeamGrpcClient : ITeamClient
{
    public async Task<Team> Create(TeamDtos dto)
    {
        var client = TeamGrpcHandler.GetTeamClient();

        TeamMessage reply = 
            await client.CreateTeamAsync
                (
                    TeamGrpcHandler.FromTeamCreationDtoToMessage(dto)
                );

        Team teamToReturn = TeamGrpcHandler.FromMessageToTeam(reply);

        return teamToReturn;
        
    }
}