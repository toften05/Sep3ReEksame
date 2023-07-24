using Domain.DTOs;
using Domain.Model;

namespace GrpcClient.ClientInterfaces;

public interface ITeamClient
{
    Task<Team> Create(TeamDtos dto);
}