using Domain.DTOs;
using Domain.Model;
using Domain.DTOs;
using GrpcClient.ClientInterfaces;
using Logic.Logic;
using Logic.LogicInterfaces;
using Moq;
using NUnit.Framework;

namespace UnitTests;

public class FootballPlayerLogicTest
{
    private Mock<IFootballPlayerGrpcClient> _mockFootballPlayerGrpcClient;
    private PlayerLogic _playerLogic;

    [SetUp]
    public void SetUp()
    {
        _mockFootballPlayerGrpcClient = new Mock<IFootballPlayerGrpcClient>();

        _mockFootballPlayerGrpcClient
            .Setup(client => client.GetByPlayerNameAsync(It.IsAny<string>()))
            .ReturnsAsync((Player)null);

        _mockFootballPlayerGrpcClient
            .Setup(client => client.GetByPlayerNameAsync("Player2"))
            .ReturnsAsync((Player)null);

        _mockFootballPlayerGrpcClient
            .Setup(client => client.GetByPlayerNameAsync("Player1"))
            .ReturnsAsync(new Player { Name = "Player1" });

        _mockFootballPlayerGrpcClient
            .Setup(client => client.GetAsync())
            .ReturnsAsync(new List<Player> { new Player { Name = "Player1" } });

        _mockFootballPlayerGrpcClient
            .Setup(client => client.CreateAsync(It.IsAny<PlayerCreationDTO>()))
            .ReturnsAsync((PlayerCreationDTO dto) => new Player
            {
                Name = dto.Name, Email = dto.Email, Role = dto.Role, TeamName = dto.TeamName, Position = dto.Position,
                DateOfBirth = dto.DateOfBirth
            });

        _playerLogic = new PlayerLogic(_mockFootballPlayerGrpcClient.Object);
    }

    [Test]
    public async Task CreateAsync_ShouldCreatePlayer()
    {
        PlayerCreationDTO newPlayer =
            new PlayerCreationDTO("Player2", DateTime.Now, "player1@example.com", "Role1", "Team1", "Position1");
        Player createdPlayer = await _playerLogic.CreateAsync(newPlayer);
        Assert.That(createdPlayer.Name, Is.EqualTo(newPlayer.Name));
    }

    [Test]
    public async Task GetAsync_ShouldReturnAllPlayers()
    {
        List<Player> players = await _playerLogic.GetAsync();
        Assert.That(players.Count, Is.EqualTo(1));
    }
    
    
    [Test]
    public async Task GetAsync_ShouldReturnEmptyList_WhenNoPlayersExist()
    {
        _mockFootballPlayerGrpcClient
            .Setup(client => client.GetAsync())
            .ReturnsAsync(new List<Player>());

        List<Player> players = await _playerLogic.GetAsync();

        Assert.That(players, Is.Empty);
    }




    [Test]
    public void CreateAsync_ShouldThrowException_WhenPlayerNameIsTaken()
    {
        PlayerCreationDTO newPlayer =
            new PlayerCreationDTO("Player1", DateTime.Now, "playerrr@test.dk", "tester", "tean3", "Oppeforan");

        _mockFootballPlayerGrpcClient
            .Setup(client => client.GetByPlayerNameAsync("Player1"))
            .ReturnsAsync(new Player { Name = "Player1" });

        Assert.ThrowsAsync<Exception>(() => _playerLogic.CreateAsync(newPlayer));
    }

    [Test]
    public void CreateAsync_ShouldThrowException_WhenPlayerNameIsLessThanThreeCharacters()
    {
        PlayerCreationDTO newPlayer =
            new PlayerCreationDTO("Pl", DateTime.Now, "playerrr@test.dk", "tester", "team4", "påbanen");

        Exception? test = Assert.ThrowsAsync<Exception>(() => _playerLogic.CreateAsync(newPlayer));
        Assert.That(test.Message, Is.EqualTo("Username must be at least 3 characters!"));
    }
    
    [Test]
    public void CreateAsync_ShouldThrowException_WhenPlayerNameIsNull()
    {
        PlayerCreationDTO newPlayer =
            new PlayerCreationDTO(null, DateTime.Now, "player@test.com", "Role1", "Team1", "Position1");

        Assert.ThrowsAsync<NullReferenceException>(() => _playerLogic.CreateAsync(newPlayer));
    }
}