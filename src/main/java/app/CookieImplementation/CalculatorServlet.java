package app.CookieImplementation;

import app.DynamicWebpage.Student;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CalculatorServlet extends HttpServlet {
  private final TemplateEngine engine;

  public CalculatorServlet(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();
    String emin = "Emin";
    data.put("name", emin);

    if (req.getCookies() != null) {
      Cookie[] cookies = req.getCookies();
      int logged = (int) Arrays.stream(cookies).filter(c -> c.getName().equals("login")).count();

      if (logged == 1) {
        engine.render("calculator.ftl", data, resp);
      } else {
        resp.sendRedirect("/login");
      }
    } else resp.sendRedirect("/login");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Calculator calc = new Calculator();

    String value1 = req.getParameter("value1");
    String value2 = req.getParameter("value2");
    String op = req.getParameter("operation");
    String result = calc.doOperation(value1, value2, op);

    String user = Arrays.stream(req.getCookies())
            .filter(c -> c.getName().equals("login"))
            .findFirst().get().getValue();

    String resCookie = calc.doOperationCookie(value1, value2, op);

    Cookie historyCookie = new Cookie(resCookie, user);
    resp.addCookie(historyCookie);

    HashMap<String, Object> resMap = new HashMap<>();
    resMap.put("emin", result);

    engine.render("calculator2.ftl", resMap, resp);

  }
}
