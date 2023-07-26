namespace Domain.DTOs;

public class PlayerCreationDTO
{
    public string Name { get; set; }

    public DateTime DateOfBirth { get; set; }

    public String Email { get; set; }

    public string Role { get; set; }
    
    public string TeamName { get; set; }
    public string Position { get; set; }

    

    public PlayerCreationDTO(string name, DateTime dateOfBirth, string email, string role, string teamName, string position)
    {
        Name = name;
        DateOfBirth = dateOfBirth;
        Email = email;
        Role = role;
        Position = position;
        TeamName = teamName;
    }
}