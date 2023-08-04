﻿using Domain.DTOs;
using Domain.Model;
using GrpcClient.ClientInterfaces;
using Logic.LogicInterface;

namespace Logic.Logic;

public class CoachLogic : ICoachLogic
{
    
    private readonly ICoachGrpcClient _coachGrpcClient;

    public CoachLogic(ICoachGrpcClient coachGrpcClient)
    {
        _coachGrpcClient = coachGrpcClient;
    }
/*
    public async Task<Coach> CreateCoachAsync(CoachCreationDto createCoach)
    {
        Coach? existing = await _coachGrpcClient.GetByCoachNameAsync(createCoach.fullName);
        
        if (existing != null)
            throw new Exception("Name already taken!");

        ValidateData(createCoach);

        Coach created = await _coachGrpcClient.CreateAsync(createCoach);
    
        return created;
    }
    */
    public async Task<Coach> CreateCoachAsync(CoachCreationDto dto)
    {
        Coach result = await _coachGrpcClient.CreateAsync(dto);

        return result;
    }

    public Task<List<Coach>> GetAsync()
    {
        return _coachGrpcClient.GetAsync();}


    private static void ValidateData(CoachCreationDto coachCreate)
    {
        string coachName = coachCreate.fullName;
        string coachEmail = coachCreate.email;
        string coachRole = coachCreate.role;
        //string coachTeam = coachCreate.teamName;
        string coachInitials = coachCreate.initials;
        

        if (coachName.Length < 3)
            throw new Exception("Name must be at least 3 characters!");

        if (coachName.Length > 50)
            throw new Exception("Name must be less than 16 characters!");
        
        if (!coachEmail.Contains("@"))
        {
            throw new Exception("Email must contain a @ in order to be valid.");
        }

        if (coachEmail.Length > 30)
        {
            throw new Exception("Email must be less than 30 characters!");
        }

        if (coachRole.Length > 30)
        {
            throw new Exception("Role must be less than 30 characters!");
            
        }

        if (coachInitials.Length >= 3 )
        {
            throw new Exception("Initials must be a maximum of 3 characters!");
        }
    }
}