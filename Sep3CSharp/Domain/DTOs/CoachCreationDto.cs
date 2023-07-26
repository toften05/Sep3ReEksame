namespace Domain.DTOs;

public class CoachCreationDto
{
    public int Id { get; set; }
    public string fullName { get; set; }
    public string birthday { get; set; }
    public string initials { get; set; }
    public string email { get; set; }
    public string role { get; set; }

    public CoachCreationDto(string fullName, string birthday, string initials, string email, string role)
    {
        this.fullName = fullName;
        this.birthday = birthday;
        this.initials = initials;
        this.email = email;
        this.role = role;
    }
}