using Domain.DTOs;
using Domain.Model;

namespace GrpcClient.ClientInterfaces;

public interface ICoachGrpcClient
{
    Task<Coach> CreateAsync(CoachCreationDto coachDto);
    //Task<Coach?> GetByCoachNameAsync(string coachName);
}