package app.LoginImplementation;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8081);
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(new ServletHolder(new LoginServlet()), "/login/*");
    handler.addServlet(new ServletHolder(new RegisterServlet()), "/register/*");
    handler.addServlet(new ServletHolder(new MainServlet()), "/");
    handler.addServlet(new ServletHolder(new LinkServlet("css")), "/css/*");

    server.setHandler(handler);
    server.start();
    server.join();

  }
}
