package Servlet;

import util.DataAccess;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean flag = false;
        String superuser = "";
        int uid = 0;

        try{
            //Context context = new InitialContext();
            //DataSource ds = (DataSource)context.lookup("com.mysql.jdbc.Driver");
            DataAccess da = new DataAccess();
            Connection con = da.getConnection();
            da.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from usr where username=? and password=? and delsoft='0'");
            ps.setString(1, username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
                uid = rs.getInt("id");
                superuser = rs.getString("superuser");
            }
            rs.close();
            ps.close();
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>A Servlet</title></head>");
        out.println("<body>");

        if(flag){
            HttpSession session = request.getSession();
            session.setAttribute("uid", uid);
            session.setAttribute("username",username);

            if("1".equals(superuser)){
                out.println("恭喜，登陆成功！您是普通用户，信息已经保存在会话Session中，请打开userInfo.html查看！");
            }else{
                out.println("恭喜，登录成功！您是管理员！信息已经保存在了会话Session中，请打开userInfo.html查看！");
            }
        }else{
            out.println("用户名或密码错误，登录失败！");
        }
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
