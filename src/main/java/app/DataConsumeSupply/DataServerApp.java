package app.DataConsumeSupply;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class DataServerApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(9000);
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(new ServletHolder(new SupplyServlet()), "/data/*");
    handler.addServlet(new ServletHolder(new ConsumeServlet()), "/consume/*");

    server.setHandler(handler);
    server.start();
    server.join();

  }
}
