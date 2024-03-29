package app.DynamicWebpage;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class NewHelloServlet extends HttpServlet {
  private final TemplateEngine engine;

  public NewHelloServlet(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();
    String emin = "Emin";
    data.put("name", emin);

    engine.render("dynamicContent/index.ftl", data, resp);
  }
}
