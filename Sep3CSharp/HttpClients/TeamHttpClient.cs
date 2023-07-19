using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Model;

namespace HttpClients;

public class TeamHttpClient : ITeamService
{
    private HttpClient client;

    public TeamHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<Team> CreateAsync(TeamDtos.TeamCreationDto dto)
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