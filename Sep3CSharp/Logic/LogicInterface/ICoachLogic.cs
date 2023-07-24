using Domain.DTOs;
using Domain.Model;

namespace Logic.LogicInterface;

public interface ICoachLogic
{
    Task<Coach> CreateCoachAsync(CoachCreationDto createCoach);
}