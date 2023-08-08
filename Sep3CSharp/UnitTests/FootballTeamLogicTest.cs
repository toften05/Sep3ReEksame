namespace DefaultNamespace;

public class FootballTeamLogicTest
{
    
        private Mock<ITeamClient> _mockTeamClient;
    private TeamLogic _teamLogic;

    [SetUp]
    public void SetUp()
    {
        _mockTeamClient = new Mock<ITeamClient>();
        
        _mockFootballPlayerGrpcClient
            .Setup(client => client.CreateAsync(It.IsAny<TeamCreationDTO>()))
            .ReturnsAsync((TeamDTO dto) => new Team
            {
                teamName = dto.TeamName, Division = dto.division, initials = dto.initials
            });

        _teamLogic = new TeamLogic(_mockTeamClient.Object);
    }

    [Test]
    public async Task CreateAsync_ShouldCreateTeam()
    {
        TeamCreationDTO newTeam =
            new TeamCreationDTO("test1", "test1", "ts1");
        Team createdTeam = await _teamLogic.CreateAsync(newTeam);
        Assert.That(createdteam.teamName, Is.EqualTo(newTeam.teamName));
        Assert.That(createdteam.division, Is.EqualTo(newTeam.division));
        Assert.That(createdteam.initials, Is.EqualTo(newTeam.initials));
    }

    [Test]
    public async Task GetAsync_ShouldReturnAllPlayers()
    {
        List<Team> teams = await _teamLogic.GetAsync();
        Assert.That(teams.Count, Is.EqualTo(1));
    }
    
    
    [Test]
    public async Task GetAsync_ShouldReturnEmptyList_WhenNoTeamsExist()
    {
        _mockTeamClient
            .Setup(client => client.GetAsync())
            .ReturnsAsync(new List<Team>());

        List<Team> teams = await _teamLogic.GetAsync();

        Assert.That(teams, Is.Empty);
    }
    

    [Test]
    public void CreateAsync_ShouldThrowException_WhenPlayerNameIsLongerThanthirtyCharacters()
    {
        TeamCreationDTO newTeam =
            new TeamCreationDTO("test4", "test4", "ts4");

        Exception? test = Assert.ThrowsAsync<Exception>(() => _teamLogic.CreateAsync(newTeam));
        Assert.That(test.Message, Is.EqualTo("Teamname must be below 30 chracters"));
    }
    
    [Test]
    public void CreateAsync_ShouldThrowException_WhenTeamNameIsNull()
    {
        TeamCreationDTO newTeam =
            new TeamCreationDTO("test5", "test5", "ts5");

        Assert.ThrowsAsync<NullReferenceException>(() => _teamLogic.CreateAsync(newTeam));
    }
}
}
