
import Domain.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;


public class StartServer
{
  public static void main(String[] args)
      throws IOException, InterruptedException
  {
    Server server = ServerBuilder
            .forPort(9090)
            .addService(new FootballPlayerServiceImpl())
            .build()
            .start();
    System.out.println("Server Started");
    server.awaitTermination();
  }
}
