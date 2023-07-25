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
           Birthday = coachCreate.birthday,
           Initials = coachCreate.initials,
           Email = coachCreate.email,
           Role = coachCreate.role
        };
        return coachToReturn;
    }

    public static Coach FromMessageToCoach(CoachMessage coach)
    {
        Coach coachToReturn = new Coach
        {
            fullName = coach.Name,
            birthday = coach.Birthday,
            initials = coach.Initials,
            email = coach.Email,
            role = coach.Role,
            Id = coach.Id
        };
        return coachToReturn;
    }
}