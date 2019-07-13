package filter;

import bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        // User information stored in the Session.
        // (After successful login).

        if (servletPath.equals("/login")) {
            chain.doFilter(request, response);
            return;
        }
        User user=(User) request.getSession().getAttribute("user");
        if(user!=null){
            chain.doFilter(request, response);

        }else
        {
            String errorMessage = "please login first";
            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect("/login");

            return;
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
