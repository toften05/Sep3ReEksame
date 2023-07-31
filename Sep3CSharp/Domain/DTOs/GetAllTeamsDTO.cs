namespace Domain.DTOs;

public class GetAllTeamsDTO
{
    public string teamName { get; set; }

    public GetAllTeamsDTO(string teamExists)
    {
        teamName = teamExists;
    }
}