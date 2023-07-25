using Domain;
using Domain.DTOs;
using Domain.Model;
using Google.Protobuf.WellKnownTypes;
using Grpc.Core;
using GrpcClient.ClientInterfaces;
using GrpcClient.GrpcClientTypeHandlers;
using GrpcServices;


namespace GrpcClient.ClientImplementations;

public class PlayerGrpcClient : IFootballPlayerGrpcClient
{
    public PlayerGrpcClient()
    {
    }

    public async Task<Player> CreateAsync(PlayerCreationDTO PlayerDto)
    {
        var client = FootballPlayerGrpcHandler.GetFootballPlayerClient();
        
        PlayerMessage reply = await client.CreatePlayerAsync(FootballPlayerGrpcHandler.FromPlayerCreationDtoToMessage(PlayerDto));
        Player userToReturn = FootballPlayerGrpcHandler.FromMessageToPlayer(reply);
        return userToReturn;
    }

    public async Task<Player?> GetByPlayerNameAsync(string playerName)
    {
        try
        {
            var client = FootballPlayerGrpcHandler.GetFootballPlayerClient();
            PlayerMessage replyMessage = await client.getByUsernameAsync(new StringRequest() {String = playerName});
            Player userToReturn = FootballPlayerGrpcHandler.FromMessageToPlayer(replyMessage);
            return userToReturn;
        }
        catch (RpcException e) when (e.StatusCode == StatusCode.NotFound)
        {
            return null;
        }
    }

    public async Task<List<Player>> GetAsync()
    {
        var client = FootballPlayerGrpcHandler.GetFootballPlayerClient();
        ListPlayerMessage replyMessage = await client.getAllPlayersAsync(new AllPlayersRequest());
        List<Player> playersToReturn = FootballPlayerGrpcHandler.FromMessageToPlayers(replyMessage);
        return playersToReturn;
    }

}




