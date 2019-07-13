import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.getWriter().println("Hello, World!");


        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print("Name: <input type='text' name='name' /><br>");
        out.print("Email: <input type='email' name='email'/><br>");
        out.print("problem: <input type='text' name='problem'/><br>");
        out.print("Problem Description: <textarea name='pdescription'  rows='10' cols='80'></textarea><br>");
        out.print("<input type='submit' value='Help'/>");
        out.print("</form>");
        out.print("</body></html>");
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        String supEmail=sc.getInitParameter("support-email");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        PrintWriter out = resp.getWriter();
        Random random = new Random();
        int x=random.nextInt(1000000);
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Thank you! "+ name +" for contacting us. We should receive reply" +
                " from us with in 24 hrs in your email address "+ email +".");
        out.print("Let us know in our support email "+ supEmail +" if you " +
                "don’t receive reply within 24 hrs. Please be sure to attach your"+x+"</p>");
        out.print("</body></html>");



    }

}
