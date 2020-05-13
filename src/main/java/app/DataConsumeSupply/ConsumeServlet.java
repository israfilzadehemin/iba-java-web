package app.DataConsumeSupply;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class ConsumeServlet extends HttpServlet {
  private final static ObjectMapper mapper = new ObjectMapper();


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    BufferedReader br = req.getReader();
    Student student = mapper.readValue(br, Student.class);


//    List<Student> students = mapper.readValue(body_reader, new TypeReference<List<Student>>() {});
//    resp.setStatus(200);
  }
}
