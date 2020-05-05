package app.DynamicWebpage;

import app.MainIssues.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;

public class ServerApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler();

    TemplateEngine engine = TemplateEngine.folder("content");

    handler.addServlet(new ServletHolder(new NewHelloServlet(engine)), "/hello/*");
    handler.addServlet(new ServletHolder(new NewByeServlet(engine)), "/bye/*");
    handler.addServlet(UploadServlet.class, "/upload/*").getRegistration()
            .setMultipartConfig(new MultipartConfigElement("./files"));

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
