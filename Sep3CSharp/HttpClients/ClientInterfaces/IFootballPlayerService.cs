    using Domain.DTOs;
    using Domain.Model;

    namespace HttpClients.ClientInterfaces;

    public interface IFootballPlayerService
    {
        Task<Player> Create(PlayerCreationDTO dto);
        Task<List<Player>> GetAllPlayersAsync();
        Task<Player> Edit(PlayerCreationDTO dto);

    }   