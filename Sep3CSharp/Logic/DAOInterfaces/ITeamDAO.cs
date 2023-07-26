using Domain.Model;

namespace Logic.DAOInterfaces;

public interface ITeamDAO
{
    Task<Team> CreateAsync(Team team);
}