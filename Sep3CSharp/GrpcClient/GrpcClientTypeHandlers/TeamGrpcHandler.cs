using Domain.DTOs;
using Domain.Model;
using Grpc.Net.Client;
using GrpcServices;

namespace GrpcClient.GrpcClientTypeHandlers;

public class TeamGrpcHandler
{
    public static GrpcServices.TeamService.TeamServiceClient GetTeamClient()
    {
        var channel = GrpcChannel.ForAddress("http://localhost:9090");
        var client = new TeamService.TeamServiceClient(channel);
        return client;
        
    }
    
    public static TeamCreationDTOMessage FromTeamCreationDtoToMessage(TeamDtos teamToCreate)
    {
        
        TeamCreationDTOMessage teamToReturn = new TeamCreationDTOMessage()
        {
            TeamName = teamToCreate.teamName,
            Division = teamToCreate.division,
            Initials = teamToCreate.initials
        };
        return teamToReturn;
    }
    
    public static Team FromMessageToTeam(TeamMessage team)
    {
        Team teamToReturn = new Team
        {
            teamName = team.TeamName,
            division = team.Division,
            initials = team.Initials,
            
            
        };
        return teamToReturn;
    }
    
    
}