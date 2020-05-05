package app.DynamicWebpage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NewByeServlet extends HttpServlet {
  private final TemplateEngine engine;

  public NewByeServlet(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();
    String emin = "Emin";
    data.put("name", emin);

    List<Student> students = Arrays.asList(
            new Student("Emin", 25, "be3"),
            new Student("Shafa", 20, "be3"),
            new Student("Kamran", 21, "be3")
    );

    data.put("students", students);
    data.put("students", students);
    data.put("count", students.size());

    engine.render("dynamicContent/index2.ftl", data, resp);
  }
}
