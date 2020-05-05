package app.CookieImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getCookies() != null) {
      Cookie[] cookies = req.getCookies();
      int logged = (int) Arrays.stream(cookies).filter(c -> c.getName().equals("login")).count();

      if (logged == 1) {
        try (PrintWriter pw = resp.getWriter()) {
          List<Cookie> history = Arrays.stream(cookies).filter(c -> !c.getName().equals("login")).collect(Collectors.toList());

          List<String> historyToPrint =
                  history.stream()
                          .map(h -> h.getName()
                                  .replace("add", " + ")
                                  .replace("mul", " x ")
                                  .replace("sub", "-")
                                  .replace("div", "/")
                                  .replace("equal", " = ")).collect(Collectors.toList());
          historyToPrint.forEach(h -> pw.write(h + "\n"));

        }
      } else {
        resp.sendRedirect("/login");
      }
    } else resp.sendRedirect("/login");
  }
}
