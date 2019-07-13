package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class logout extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null)
            session.invalidate();

        System.out.println("working");

        String errorMessage = "you are logged out";
        request.getSession().setAttribute("errorMessage", errorMessage);
        //response.sendRedirect("login");
        request.getRequestDispatcher("login").forward(request,response);
        return;


    }
}
