package servlet;

import bean.User;

import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher //
                = request.getRequestDispatcher("/loginView.jsp");
 
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String check=request.getParameter("check");


        if ("sam".equals(userName) && "007".equals(password) ) {
            User userOb=new User(userName,password);
            HttpSession session=request.getSession();
            session.setAttribute("user",userOb);
            if(check!=null) {
                Cookie cookie = new Cookie("name", userName);
                cookie.setMaxAge(60*60*3600); //in seconds
                response.addCookie(cookie);
            }else{
                Cookie cookie = new Cookie("name", "null");
                cookie.setMaxAge(0); //in seconds
                response.addCookie(cookie);
            }
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request,response);
            return;
        }
        else {
            String errorMessage = "Invalid userName or Password please try again";

            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect("login");
 

            return;
        }
 

 
    }
 
}
