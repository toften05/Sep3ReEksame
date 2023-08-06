using Domain.DTOs;
using Domain.Model;
using Logic.LogicInterfaces;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Mvc;


namespace WebAPI.Controllers;

[ApiController]
[Microsoft.AspNetCore.Mvc.Route("[controller]")]
public class PlayerController : ControllerBase
{
    private readonly IPlayerLogic playerLogic;

    public PlayerController(IPlayerLogic playerLogic)
    {
        this.playerLogic = playerLogic;
    }


    [HttpPost]
    public async Task<ActionResult<Player>> CreateAsync(PlayerCreationDTO dto)
    {
        try
        {
            Player player = await playerLogic.CreateAsync(dto);
            return Created($"/player/{player.Id}", player);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet]
    public async Task<ActionResult<List<Player>>> GetAsync()
    {
        try
        {
            List<Player> players = await playerLogic.GetAsync();
            return Ok(players);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpPut]
    public async Task<ActionResult<Player>> EditAsync(PlayerCreationDTO dto)
    {
        try
        {
            Player player = await playerLogic.EditAsync(dto);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}