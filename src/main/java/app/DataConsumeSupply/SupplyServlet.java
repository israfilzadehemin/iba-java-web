package app.DataConsumeSupply;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class SupplyServlet extends HttpServlet {

  private final static ObjectMapper mapper = new ObjectMapper(); //XmlMapper()

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Student> students = Arrays.asList(
            new Student("Alex", 30, "BE1"),
            new Student("Jacky", 33, "BE2"),
            new Student("Sergio", 25, "BE3")
    );

    Student s1 = new Student("Alex2", 30, "BE1");
    s1.setResponsibilities(Arrays.asList("A", "Z", "T"));

    String representation = mapper.writeValueAsString(s1);
    //String representation =mapper.writeValueAsString(students);

    try(PrintWriter pw = resp.getWriter()) {
      pw.write(representation);
    }

    //resp.setStatus(201);

  }
}
