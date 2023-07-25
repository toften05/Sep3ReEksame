using Domain.DTOs;
using Domain.Model;
using Logic.Teams;
using Microsoft.AspNetCore.Mvc;


namespace WebAPI.Controllers;


[ApiController]
[Route("[Controller]")]
public class TeamController : ControllerBase
{
    private ITeamLogic _teamLogic;


    public TeamController(ITeamLogic teamLogic)
    {
        _teamLogic = teamLogic;
    }

    [HttpPost]
    public async Task<ActionResult<Team>> createAsync(TeamDtos dto)
    {
        try
        {
            Team team = await _teamLogic.createAsync(dto);
            return Created($"/team/{team.teamName}", team);
        }

        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}