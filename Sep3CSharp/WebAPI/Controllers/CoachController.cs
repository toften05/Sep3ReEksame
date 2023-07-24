using Domain.DTOs;
using Domain.Model;
using Logic.LogicInterface;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;


[ApiController]
[Route("[controller]")]
public class CoachController : ControllerBase
{
    private readonly ICoachLogic coachLogic;
    
    public CoachController(ICoachLogic coachLogic)
    {
        this.coachLogic = coachLogic;
    }
    
[HttpPost]
    public async Task<ActionResult<Coach>> CreateCoachAsync(CoachCreationDto dto)
    {
        try
        {
            Coach coach = await coachLogic.CreateCoachAsync(dto);
            return Created($"/coach/{coach.Id}", coach);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    
}