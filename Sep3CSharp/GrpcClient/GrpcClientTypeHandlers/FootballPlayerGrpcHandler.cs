using Domain;
using Domain.DTOs;
using Domain.Model;
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
        };
        return playerToReturn;
    }

    public static Player FromMessageToPlayer(PlayerMessage player)
    {
        Player playerToReturn = new Player
        {
            Name = player.Name,
            Id = player.Id
        };
        return playerToReturn;
    }
}

