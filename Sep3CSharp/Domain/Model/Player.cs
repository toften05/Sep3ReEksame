using System.Globalization;
using Microsoft.VisualBasic;

namespace Domain.Model;

public class Player
{
    public int? Id { get; set; }
    public string? Name { get; set; }
    public DateTime? DateOfBirth { get; set; }
    public String? Email { get; set; }
    public String? TeamName { get; set; }
    public String? Role { get; set; }
    public string? Position { get; set; }
    
    
    public Team? Team { get; set; }
    
}