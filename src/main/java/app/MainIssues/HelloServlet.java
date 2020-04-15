package app.MainIssues;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try(PrintWriter w = resp.getWriter()) {
      w.write(String.format("req.getContextPath: %s \n", req.getContextPath()));
      w.write(String.format("req.getQueryString: %s \n", req.getQueryString()));
      w.write(String.format("req.getQueryString: %s \n", req.getParameter("a")));
    }
  }
}
