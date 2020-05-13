package app.FilterImplementation;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements Filter {

  private boolean isHttp(ServletRequest req) {
    return req instanceof HttpServletRequest;
  }

  public boolean isCookieOk(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null) return false;
    for (Cookie c : cookies) {
      if (c.getName().equals("aaa") && c.getValue().equals("bbb")) {
        return true;
      }
    }

    return false;
  }


  @Override

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if (isHttp(servletRequest) && isCookieOk((HttpServletRequest)servletRequest)) {
      filterChain.doFilter(servletRequest, servletResponse);
    }
    else((HttpServletResponse)servletResponse).sendRedirect("/login");
  }

  @Override
  public void destroy() {

  }
}
