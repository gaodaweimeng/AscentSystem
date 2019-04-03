package Servlet;

import JavaBean.Usr;
import JavaDao.UserManagerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindAllUsrServlet")
public class FindAllUsrServlet extends HttpServlet {

    public FindAllUsrServlet(){
        super();
    }

    public void init() throws ServletException{

    }

    public void destroy(){
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>A Servlet</title></head>");
        out.println("<body><center><table border=1");
        out.println("<tr><td>编号</td> <td>用户名</td> <td>公司名称</td> <td>公司地址</td> <td>电话</td> <td>电子邮件</td> </tr>");
        UserManagerDAO dao = new UserManagerDAO();
        List<Usr> usrs = dao.getAllProductUser();
        for(Usr u: usrs){
            out.println("<tr><td>"+ u.getId() +"</td><td>" + u.getUsername() + "</td><td>" + u.getCompanyname() + "</td><td>" + u.getCompanyaddress() + "</td><td>" + u.getTel() + "</td><td>" + u.getEmail() + "</td></tr>");
        }
        out.println("</table></center></body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    //在对数据库中的数据进行查询过后，在网页中产生了数据缓存
    //com.mysql.jdbc.AbandonedConnectionCleanupThread该线程在Tomcat关闭时出现异常
    //解决方案
}
