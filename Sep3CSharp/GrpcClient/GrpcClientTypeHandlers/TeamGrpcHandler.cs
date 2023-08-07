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
    
    public static TeamCreationDTOMessage FromTeamCreationDtoToMessage(TeamCreationDTO teamToCreate)
    {
        
        TeamCreationDTOMessage teamToReturn = new TeamCreationDTOMessage()
        {
            TeamName = teamToCreate.teamName,
            Initials = teamToCreate.initials,
            Division = teamToCreate.division
        };
        return teamToReturn;
    }
    
    public static Team FromMessageToTeam(TeamMessage team)
    {
        Team teamToReturn = new Team
        {
            teamName = team.TeamName,
            initials = team.Initials,
            division = team.Division,
        };
        return teamToReturn;
    }

    public static List<Team> FromMessageToTeams(ListTeamMessage listT)
    {
        List<Team> teamsToReturn = new List<Team>();
        foreach (TeamMessage teamMessage in listT.Teams)
        {
            teamsToReturn.Add(FromMessageToTeam(teamMessage));
        }

        return teamsToReturn;
    }


}