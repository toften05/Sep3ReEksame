namespace Domain.DTOs;

public class CoachCreationDto
{
    public int Id { get; set; }
    public string fullName { get; set; }
    public DateTime birthday { get; set; }
    public string initials { get; set; }
    public string email { get; set; }
    public string role { get; set; }
    public string teamName { get; set; }

    public CoachCreationDto(string fullName, DateTime birthday, string initials, string email, string role, string teamName)
    {
        this.fullName = fullName;
        this.birthday = birthday;
        this.initials = initials;
        this.email = email;
        this.role = role;
        this.teamName = teamName;
    }
}