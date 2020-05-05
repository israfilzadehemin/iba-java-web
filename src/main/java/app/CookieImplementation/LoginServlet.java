package app.CookieImplementation;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginServlet extends HttpServlet {
  User user = new User();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get("content", "login.html"), os);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    user.fillUsers();

    String username = req.getParameter("username");
    String pass = req.getParameter("pass");

    if (user.userBase.containsKey(username) && user.userBase.get(username).equals(pass)) {
      Cookie loginCookie = new Cookie("login", String.format("%s_%s", username, pass));
      loginCookie.setMaxAge(60 * 60 * 24);
      resp.addCookie(loginCookie);
      resp.sendRedirect("/calculator");
    } else {
      try (OutputStream os = resp.getOutputStream()) {
        Files.copy(Paths.get("content", "login2.html"), os);
      }
    }
  }
}
