using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Model;
using HttpClients.ClientInterfaces;

namespace DefaultNamespace;

public class FootballPlayerHttpClient : IFootballPlayerService
{
    private readonly HttpClient _httpClient;

    public FootballPlayerHttpClient(HttpClient httpClient)
    {
        var handler = new HttpClientHandler()
        {
            ServerCertificateCustomValidationCallback = HttpClientHandler.DangerousAcceptAnyServerCertificateValidator
        };
        _httpClient = new HttpClient(handler);
        _httpClient.BaseAddress = new Uri("https://localhost:7091");
    }


    public async Task<Player> Create(PlayerCreationDTO dto)
    {
        
        Console.WriteLine($"Base address: {_httpClient.BaseAddress}"); 
        
        HttpResponseMessage response = await _httpClient.PostAsJsonAsync("/player", dto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        Player player = JsonSerializer.Deserialize<Player>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return player;
    }
    
}