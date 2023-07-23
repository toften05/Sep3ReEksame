using Domain.DTOs;
using Domain.Model;


namespace Logic.LogicInterfaces;

public interface IPlayerLogic
{
    Task<Player> CreateAsync(PlayerCreationDTO playerToCreate);
}