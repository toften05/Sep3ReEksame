namespace Domain.DTOs;

public class CoachCreationDto
{
    public string fullName { get; set; }

    public CoachCreationDto(string fullName)
    {
        this.fullName = fullName;
    }
}