using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Model;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

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

    public async Task<List<Player>> GetAllPlayersAsync()
    {
        string uri = "/player";
        HttpResponseMessage response = await _httpClient.GetAsync(uri);
        string result = await response.Content.ReadAsStringAsync();
        Console.WriteLine(result);

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        List<Player> users = JsonSerializer.Deserialize<List<Player>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return users;
    }

    public async Task<Player> Edit(PlayerCreationDTO dto)
    {
        Console.WriteLine($"Base address: {_httpClient.BaseAddress}");

        HttpResponseMessage response = await _httpClient.PutAsJsonAsync("/player", dto);
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