﻿using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Model;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class CoachHttpClient : ICoachService
{
    private readonly HttpClient _httpClient;

    public CoachHttpClient(HttpClient httpClient)
    {
        var handler = new HttpClientHandler()
        {
            ServerCertificateCustomValidationCallback = HttpClientHandler.DangerousAcceptAnyServerCertificateValidator
        };
        _httpClient = new HttpClient(handler);
        _httpClient.BaseAddress = new Uri("https://localhost:7091");
    }


    public async Task<Coach> CreateAsync(CoachCreationDto coachDto)
    {
        Console.WriteLine($"Base address: {_httpClient.BaseAddress}");

        HttpResponseMessage response = await _httpClient.PostAsJsonAsync("/coach", coachDto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        Coach coach = JsonSerializer.Deserialize<Coach>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return coach;
    }

    public async Task<List<Coach>> GetAllCoachesAsync()
    {
        string uri = "/coach";
        HttpResponseMessage response = await _httpClient.GetAsync(uri);
        string result = await response.Content.ReadAsStringAsync();
        Console.WriteLine(result);
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        List<Coach> coaches = JsonSerializer.Deserialize<List<Coach>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return coaches;
    }
}