package app.CookieImplementation;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8081);
    ServletContextHandler handler = new ServletContextHandler();
    TemplateEngine engine = TemplateEngine.folder("content");


    handler.addServlet(new ServletHolder(new MainServlet()), "/*");
    handler.addServlet(new ServletHolder(new RegisterServlet()), "/register/*");
    handler.addServlet(new ServletHolder(new LoginServlet()), "/login/*");
    handler.addServlet(new ServletHolder(new LogoutServlet()), "/logout/*");
    handler.addServlet(new ServletHolder(new HistoryServlet()), "/history/*");
    handler.addServlet(new ServletHolder(new CalculatorServlet(engine)), "/calculator/*");
    handler.addServlet(new ServletHolder(new LinkServlet("css")), "/css/*");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
