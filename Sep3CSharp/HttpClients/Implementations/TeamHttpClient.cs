using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Model;

namespace HttpClients.Implementations;

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


    public async Task<Team> CreateAsync(TeamCreationDTO creationDto)
    {
        Console.WriteLine($"Base address: {client.BaseAddress}");

        HttpResponseMessage response = await client.PostAsJsonAsync("/team", creationDto);
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

    public async Task<List<Team>> getALlTeamsAsync()
    {
        Console.Write("HttpCLientTest");

        string uri = "/Team";
        Console.Write(uri);
        HttpResponseMessage response = await client.GetAsync(uri);
        Console.Write(response + "repsonse");
        string result = await response.Content.ReadAsStringAsync();


        Console.WriteLine($"Response Status Code: {response.StatusCode}");
        Console.WriteLine($"Response Content: {result}");


        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        List<Team> teams = JsonSerializer.Deserialize<List<Team>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return teams;
    }
}