namespace Domain.DTOs;

public class PlayerCreationDTO
{
    public string Name { get; set; }
   // public int Age { get; set; }
 
    
    public PlayerCreationDTO(string name)
    {
        Name = name;
        //Age = age;
    }
}