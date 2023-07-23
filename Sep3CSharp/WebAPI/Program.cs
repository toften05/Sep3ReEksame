using GrpcClient.ClientImplementations;
using GrpcClient.ClientInterfaces;
using Logic.Logic;
using Logic.LogicInterface;
using Logic.LogicInterfaces;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


builder.Services.AddScoped<IPlayerLogic, PlayerLogic>();
builder.Services.AddScoped<IFootballPlayerGrpcClient, PlayerGrpcClient>();
builder.Services.AddScoped<ICoachLogic, CoachLogic>();
builder.Services.AddScoped<ICoachGrpcClient, CoachGrpcClient>();

var app = builder.Build();

app.UseCors(x => x
    .AllowAnyMethod()
    .AllowAnyHeader()
    .SetIsOriginAllowed(origin => true)
    .AllowCredentials());


// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();