using Domain.DTOs;
using Domain.Model;

namespace GrpcClient.ClientInterfaces;

public interface IFootballPlayerGrpcClient
{
    Task<Player> CreateAsync(PlayerCreationDTO PlayerDto);
    Task<Player?> GetByPlayerNameAsync(string playerName);
     Task<List<Player>> GetAsync();

     Task<Player> EditAsync(PlayerCreationDTO dto);

}