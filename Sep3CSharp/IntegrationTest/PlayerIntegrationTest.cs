using DefaultNamespace;
using Domain.DTOs;
using Domain.Model;
using NUnit.Framework;
using HttpClients.ClientInterfaces;

namespace IntegrationTest;

public class PlayerIntegrationTest
{
   private readonly FootballPlayerHttpClient _footballPlayerHttpClient;
   
   public PlayerIntegrationTest()
   {
       _footballPlayerHttpClient = new FootballPlayerHttpClient( new HttpClient()
       {
         BaseAddress = new Uri("https://localhost:7091")  
       });
   }

   [Test]
   public async Task CreateAsync_ShouldCreatePlayer()
   {
       
       // idet vi ikke har en deletePlayer() på tidspunktet hvor denne test blev skrevet, så skal vi være opmærksomme på at vi skal ændre spillernavnet, for at få denne test til at lykkes.  /Anders
       PlayerCreationDTO newPlayer =
           new PlayerCreationDTO("Player3", DateTime.Now, "email@email.dk", "Role",
               "Team", "Position");

       Player createdPlayer = await _footballPlayerHttpClient.Create(newPlayer);

       Assert.That(createdPlayer.Name, Is.EqualTo(newPlayer.Name));
   }
   
   [Test]
   public async Task GetAllPlayersAsync_ShouldReturnAllPlayers()
   {
       List<Player> players = await _footballPlayerHttpClient.GetAllPlayersAsync();
       Assert.That(players.Count, Is.EqualTo(1));
   }
}