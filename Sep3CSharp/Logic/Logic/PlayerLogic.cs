using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using Logic.LogicInterfaces;


namespace Logic.Logic;

public class PlayerLogic : IPlayerLogic
{
    private readonly IFootballPlayerGrpcClient _footballPlayerGrpcClient;

    public PlayerLogic(IFootballPlayerGrpcClient footballPlayerGrpcClient)
    {
        _footballPlayerGrpcClient = footballPlayerGrpcClient;
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
        return _footballPlayerGrpcClient.GetAsync();
    }


    private static void ValidateData(PlayerCreationDTO playerToCreate)
    {
        string playerName = playerToCreate.Name;
        string playeremail = playerToCreate.Email;
        string playerRole = playerToCreate.Role;
        String playerPosition = playerToCreate.Position;

        if (playerName.Length < 3)
            throw new Exception("Name must be at least 3 characters!");

        if (playerName.Length >= 50)
            throw new Exception("Name must be less than or equal to 50 characters!");
        
        if (!playeremail.Contains("@"))
        {
            throw new Exception("Email must contain a @ in order to be valid.");
        }

        if (playeremail.Length >= 30)
        {
            throw new Exception("Email must be less than or equal to 30 characters");
        }

        if (playerRole.Length < 3)
        {
            throw new Exception("The role must be at least 3 characters");
        }

        if (playerRole.Length >= 30)
        {
            throw new Exception("The role must be less than or equal to 30 characters");
        }
        if (playerPosition.Length < 3)
        {
            throw new Exception("The position must be at least 3 characters");
        }

        if (playerPosition.Length >= 30)
        {
            throw new Exception("The position must be less than or equal 30 characters");
        }
        {
            
        }
    }

    public async Task<Player> EditAsync(PlayerCreationDTO dto)
    {
        ValidateData(dto);

        Player created = await _footballPlayerGrpcClient.EditAsync(dto);

        return created;
    }
}