package app.LoginImplementation;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LinkServlet extends HttpServlet {

  private final String subPath;


  public LinkServlet(String subPath) {
    this.subPath = subPath;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String fileName = req.getPathInfo();
    String fileLoc = "content";
    Path path = Paths.get(fileLoc, subPath, fileName);

    try(OutputStream os = resp.getOutputStream()) {
      Files.copy(path,os);
    }
  }
}
