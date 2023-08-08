using Domain;
using Domain.DTOs;
using Domain.Model;
using Google.Protobuf.WellKnownTypes;
using Grpc.Net.Client;
using GrpcServices;


namespace GrpcClient.GrpcClientTypeHandlers;

public class FootballPlayerGrpcHandler
{

    public static GrpcServices.FootballPlayerService.FootballPlayerServiceClient GetFootballPlayerClient()
    {
        var channel = GrpcChannel.ForAddress("http://localhost:9090");
            var client = new GrpcServices.FootballPlayerService.FootballPlayerServiceClient(channel);
            return client;
            
    }
    
    public static List<Player> FromMessageToPlayers(ListPlayerMessage ListP)
    {
        List<Player> playersToReturn = new List<Player>();
        foreach (PlayerMessage playerMessage in ListP.Players)
        {
            playersToReturn.Add(FromMessageToPlayer(playerMessage));
        }
        return playersToReturn;
    }
    


    public static PlayerCreationDTOMessage FromPlayerCreationDtoToMessage(PlayerCreationDTO playerToCreate)
    {
        PlayerCreationDTOMessage playerToReturn = new PlayerCreationDTOMessage
        {
            Name = playerToCreate.Name,
            Birthday = Timestamp.FromDateTime(playerToCreate.DateOfBirth.ToUniversalTime()),
            Email = playerToCreate.Email,
            Rolle = playerToCreate.Role,
            TeamName = playerToCreate.TeamName,
            Position = playerToCreate.Position
        };
        return playerToReturn;
    }

    public static Player FromMessageToPlayer(PlayerMessage player)
    {
        Player playerToReturn = new Player
        {
            Id = player.Id,
            Name = player.Name ?? "",
            DateOfBirth = player.Birthday?.ToDateTime() ?? DateTime.MinValue,
            Email = player.Email ?? "",
            Role = player.Rolle ?? "",
            TeamName = player.TeamName ?? "teamname",
            Position = player.Position ?? ""
        };
        return playerToReturn;
    }
    
    public static PlayerMessage FromPlayerToMessage(PlayerCreationDTO playerToCreate)
    {
        PlayerMessage playerToReturn = new PlayerMessage
        {
            Id = playerToCreate.Id,
            Name = playerToCreate.Name,
            Birthday = Timestamp.FromDateTime(playerToCreate.DateOfBirth.ToUniversalTime()),
            Email = playerToCreate.Email,
            Rolle = playerToCreate.Role,
            TeamName = playerToCreate.TeamName,
            Position = playerToCreate.Position
        };
        return playerToReturn;
    }
    
}

