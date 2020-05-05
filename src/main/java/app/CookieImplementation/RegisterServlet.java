package app.CookieImplementation;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegisterServlet extends HttpServlet {
  User user = new User();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get("content", "register.html"), os);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    user.fillUsers();

    String username = req.getParameter("username");
    String pass = req.getParameter("pass");
    String conpass = req.getParameter("conpass");

    if (user.userBase.containsKey(username)) {
      try (OutputStream os = resp.getOutputStream()) {
        Files.copy(Paths.get("content", "register2.html"), os);
      }
    } else if (!pass.equals(conpass)) {
      try (OutputStream os = resp.getOutputStream()) {
        Files.copy(Paths.get("content", "register3.html"), os);
      }
    } else {
      try (OutputStream os = resp.getOutputStream()) {
        user.addUser(username, pass);
        Files.copy(Paths.get("content", "index2.html"), os);
        user.userToFile();
      }
    }

  }
}
