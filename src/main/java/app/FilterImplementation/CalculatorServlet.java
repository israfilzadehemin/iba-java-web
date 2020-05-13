package app.FilterImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CalculatorServlet extends HttpServlet {
  private final Calculator c;

  public CalculatorServlet(Calculator c) {
    this.c = c;
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String result = new BufferedReader(new FileReader(new File(
            "content/calculator.ftl"
    ))).lines().collect(Collectors.joining("\n"));

    try (PrintWriter w = resp.getWriter()) {
      w.write(result);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String value1 = req.getParameter("value1");
    String value2 = req.getParameter("value2");
    String op = req.getParameter("operation");

    String result = c.doOperation(value1, value2, op);

    try (PrintWriter w = resp.getWriter()) {
      w.write(result);
    }

  }
}
