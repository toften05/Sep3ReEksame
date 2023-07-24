using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using Logic.DAOInterfaces;
using Logic.LogicInterfaces;


namespace Logic.Logic;

public class PlayerLogic : IPlayerLogic
{
    private readonly IFootballPlayerGrpcClient _footballPlayerGrpcClient;
    
    public PlayerLogic(IFootballPlayerGrpcClient footballPlayerGrpcClient)
    {
        _footballPlayerGrpcClient = footballPlayerGrpcClient ;
    }
    public async Task<Player> CreateAsync(PlayerCreationDTO playerToCreate)
    {
        Player? existing = await _footballPlayerGrpcClient.GetByPlayerNameAsync(playerToCreate.Name);
        
        if (existing != null)
            throw new Exception("Username already taken!");

        ValidateData(playerToCreate);

        Player created = await _footballPlayerGrpcClient.CreateAsync(playerToCreate);
    
        return created;
    }

    public Task<List<Player>> GetAsync()
    {
        return _footballPlayerGrpcClient.GetAsync();}


    private static void ValidateData(PlayerCreationDTO playerToCreate)
    {
        string playerName = playerToCreate.Name;

        if (playerName.Length < 3)
            throw new Exception("Username must be at least 3 characters!");

        if (playerName.Length > 15)
            throw new Exception("Username must be less than 16 characters!");
    }
}