namespace Domain.DTOs;

public class GetAllPlayersDTO
{
    public int? PlayerId { get; }
    
    public GetAllPlayersDTO(int? playerExists)
    {
        PlayerId = playerExists;
    }
}