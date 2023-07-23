using Domain.Model;


namespace Logic.DAOInterfaces;

public interface IPlayerDAO
{
    Task<Player> CreateAsync(Player player);
    Task<Player?> GetByPlayerNameAsync(string playerName);
}