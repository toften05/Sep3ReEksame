using Domain.DTOs;
using Domain.Model;


namespace Logic.DAOInterfaces;

public interface IPlayerDAO
{
    Task<Player> CreateAsync(Player player);
    Task<Player?> GetByPlayerNameAsync(string playerName);
   // public Task<IEnumerable<Player>> GetAllPlayersAsync(GetAllPlayersDTO searchParameters);

}