using Domain.DTOs;
using Domain.Model;

namespace GrpcClient.ClientInterface;

public interface ITeamClient
{
    Task<Team> Create(TeamDtos.TeamCreationDto dto);
}