package app.MainIssues;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class CalcServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String a = req.getParameter("a");
      String b = req.getParameter("b");
      String op = req.getParameter("op");


    try(PrintWriter w = resp.getWriter()) {
      w.write(operate(a, b, op));
    }

  }

  static String operate (String x, String y, String op) {
    try{
      int a = Integer.parseInt(x);
      int b = Integer.parseInt(y);

      String operation = "";

      switch(op) {
        case "add": return String.format("a + b = %s", String.valueOf(a+b));
        case "sub": return String.format("a - b = %s", String.valueOf(a-b));
        case "mul": return String.format("a * b = %s", String.valueOf(a*b));
        case "div":
          try{
            return String.format("a / b = %s", String.valueOf(a/b));
          }
          catch (ArithmeticException ae) {
            return "Division by zero";
          }

        default: return "Wrong operation";
      }

    }
    catch (NumberFormatException pe) {
      return "Wrong number format";
    }
  }
}
