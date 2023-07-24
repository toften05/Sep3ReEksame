using Domain.DTOs;
using Domain.Model;
using Grpc.Net.Client;
using GrpcServices;

namespace GrpcClient.GrpcClientTypeHandlers;

public class CoachGrpcHandler
{
    public static GrpcServices.CoachService.CoachServiceClient GetCoachClient()
    {
        var channel = GrpcChannel.ForAddress("http://localhost:9090");
        var client = new GrpcServices.CoachService.CoachServiceClient(channel);
        return client;
        
    }


    public static CoachCreationDtoMessage FromCoachCreationDtoToMessage(CoachCreationDto coachCreate)
    {
        CoachCreationDtoMessage coachToReturn = new CoachCreationDtoMessage
        {
           Name = coachCreate.fullName,
        };
        return coachToReturn;
    }

    public static Coach FromMessageToCoach(CoachMessage coach)
    {
        Coach coachToReturn = new Coach
        {
            fullName = coach.Name,
            Id = coach.Id
        };
        return coachToReturn;
    }
}