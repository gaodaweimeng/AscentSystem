package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class TestServlet extends javax.servlet.http.HttpServlet {
    // Post与Get的具体区别
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html"); //设置返回文件类型
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        out.println("<html>");
        out.println("<head><title>HelloWorld</title><head>");
        out.println("<body>Hello" +name+ "</body>");
        out.println("</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void destroy(){
        super.destroy();
    }
}