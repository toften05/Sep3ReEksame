using Domain.DTOs;
using Domain.Model;

namespace HttpClients.ClientInterfaces;

public interface ICoachService
{
    Task<Coach> CreateAsync(CoachCreationDto coachDto);
}