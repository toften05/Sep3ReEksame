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
    public async Task<ActionResult<Team>> createAsync(TeamCreationDTO creationDto)
    {
        try
        {
            Team team = await _teamLogic.createAsync(creationDto);
            return Created($"/team/{team.teamName}", team);
        }

        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet]
    public async Task<ActionResult<List<Team>>> getAsync()
    {
        try
        {
            List<Team> teams = await _teamLogic.getAsync();
            return Ok(teams);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}