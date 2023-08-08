using Domain.DTOs;
using Domain.Model;
using Google.Protobuf.WellKnownTypes;
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
           Birthday = Timestamp.FromDateTime(coachCreate.birthday.ToUniversalTime()),
           Initials = coachCreate.initials,
           Email = coachCreate.email,
           Role = coachCreate.role,
           TeamName = coachCreate.teamName

        };
        return coachToReturn;
    }

    public static Coach FromMessageToCoach(CoachMessage coach)
    {
        Coach coachToReturn = new Coach
        {
            fullName = coach.Name,
            birthday = coach.Birthday?.ToDateTime() ?? DateTime.MinValue,
            initials = coach.Initials,
            email = coach.Email,
            role = coach.Role,
            Id = coach.Id,
            teamName = coach.TeamName
        };
        return coachToReturn;
    }
    
    public static List<Coach> FromMessageToCoaches(ListCoachMessage ListP)
    {
        List<Coach> coachesToReturn = new List<Coach>();
        foreach (CoachMessage coachMessage in ListP.Coaches)
        {
            coachesToReturn.Add(FromMessageToCoach(coachMessage));
        }
        return coachesToReturn;
    }
}