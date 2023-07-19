using Domain.Model;
using Domain.DTOs;
namespace Logic.Teams;

public interface ITeamLogic
{
    Task<Team> createAsync(TeamDtos.TeamCreationDto dto);
   
}