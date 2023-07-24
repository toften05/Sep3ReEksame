using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Model;

namespace HttpClients;

public class TeamHttpClient : ITeamService
{
    private readonly HttpClient client;

    public TeamHttpClient(HttpClient client)
    {
        var handler = new HttpClientHandler()
        {
            ServerCertificateCustomValidationCallback = HttpClientHandler.DangerousAcceptAnyServerCertificateValidator
        };
        this.client = new HttpClient(handler);
        this.client.BaseAddress = new Uri("https://localhost:7091");
    }

   

    public async Task<Team> CreateAsync(TeamDtos dto)
    {

        HttpResponseMessage response = await client.PostAsJsonAsync("/team",dto);
        string result = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        Team team = JsonSerializer.Deserialize<Team>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return team;

    }

   
}