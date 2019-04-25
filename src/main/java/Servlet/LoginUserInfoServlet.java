package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginUserInfoServlet")
public class LoginUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int uid;
        String username = (String)session.getAttribute("username");
        String result;
        if(username==null){
            result="您没有登录或已经注销";
        }else {
            uid= (Integer) session.getAttribute("uid");
            result="您已经登录，信息为：ID：" + uid + " USERNAME: " + username + "&nbsp;&nbsp;<a href='/logoutServlet.do'>注销</a>";
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>A Servlet</title></head>");
        out.println("<body>");
        out.println(result);
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
