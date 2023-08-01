namespace Domain.Model;

public class Coach
{
   public int Id { get; set; }
    public string fullName { get; set; }
    public DateTime birthday { get; set; }
    public string initials { get; set; }
    public string email { get; set; }
    public string role { get; set; }
    
    public string teamName { get; set; }
    
   // public Team Team { get; set; }

}