using Domain.DTOs;
using Domain.Model;
using Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;


namespace WebAPI.Controllers;



[ApiController]
[Route("[controller]")]
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
}