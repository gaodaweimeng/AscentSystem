package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class TestServlet extends javax.servlet.http.HttpServlet {
    // Post与Get的具体区别
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {}

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html"); //设置返回文件类型
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>HelloWorld</title><head>");
        out.println("<body>Hello World</body>");
        out.println("</html>");
    }

    @Override
    public void destroy(){
        super.destroy();
    }
}
