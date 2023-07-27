using Domain.DTOs;
using Domain.Model;
using Grpc.Core;
using GrpcClient.ClientInterfaces;
using GrpcClient.GrpcClientTypeHandlers;
using GrpcServices;

namespace GrpcClient.ClientImplementations;

public class CoachGrpcClient : ICoachGrpcClient
{
    public CoachGrpcClient()
    {
    }

    public async Task<Coach> CreateAsync(CoachCreationDto coachDto)
    {
        var coachClient = CoachGrpcHandler.GetCoachClient();

        CoachMessage reply = await coachClient.CreateCoachAsync(CoachGrpcHandler.FromCoachCreationDtoToMessage(coachDto));
        Coach coachToReturn = CoachGrpcHandler.FromMessageToCoach(reply);
        return coachToReturn;
    }

    public async Task<List<Coach>> GetAsync()
    {
        var client = CoachGrpcHandler.GetCoachClient();
        ListCoachMessage replyMessage = await client.getAllCoachesAsync(new AllCoachesRequest());
        List<Coach> coachesToReturn = CoachGrpcHandler.FromMessageToCoaches(replyMessage);
        return coachesToReturn;
    }
    /*
    public async Task<Coach?> GetByCoachNameAsync(string coachName)
    {
        try
        {
            var client = CoachGrpcHandler.GetCoachClient();
            CoachMessage replyMessage = await client.getByNameAsync(new StringRequest() {String = coachName});
            Coach coachToReturn = CoachGrpcHandler.FromMessageToCoach(replyMessage);
            return coachToReturn;
        }
        catch (RpcException e) when (e.StatusCode == StatusCode.NotFound)
        {
            return null;
        }
    }
    */
}