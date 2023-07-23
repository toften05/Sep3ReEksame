using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using Logic.LogicInterface;

namespace Logic.Logic;

public class CoachLogic : ICoachLogic
{
    
    private readonly ICoachGrpcClient _coachGrpcClient;

    public CoachLogic(ICoachGrpcClient coachGrpcClient)
    {
        _coachGrpcClient = coachGrpcClient;
    }

    public async Task<Coach> CreateCoachAsync(CoachCreationDto createCoach)
    {
        Coach? existing = await _coachGrpcClient.GetByCoachNameAsync(createCoach.fullName);
        
        if (existing != null)
            throw new Exception("Name already taken!");

        ValidateData(createCoach);

        Coach created = await _coachGrpcClient.CreateAsync(createCoach);
    
        return created;
    }
    
    
    private static void ValidateData(CoachCreationDto coachCreate)
    {
        string coachName = coachCreate.fullName;

        if (coachName.Length < 3)
            throw new Exception("Username must be at least 3 characters!");

        if (coachName.Length > 50)
            throw new Exception("Username must be less than 16 characters!");
    }
}