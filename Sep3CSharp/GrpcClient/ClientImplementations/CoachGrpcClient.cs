using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using GrpcClient.GrpcClientTypeHandlers;
using GrpcServices;

namespace GrpcClient.ClientImplementations;

public class CoachGrpcClient : ICoachGrpcClient
{
    public async Task<Coach> CreateAsync(CoachCreationDto coachDto)
    {
        var coachClient = CoachGrpcHandler.GetCoachClient();

        CoachMessage reply =
            await coachClient.CreateCoachAsync(CoachGrpcHandler.FromCoachCreationDtoToMessage(coachDto));
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
}