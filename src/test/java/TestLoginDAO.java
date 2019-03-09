import JavaBean.Usr;
import JavaDao.LoginDAO;

public class TestLoginDAO {
    public static void main(String[] args){
        LoginDAO dao = new LoginDAO();
        Usr u = dao.logIn("ascent", "ascent");
        if(u!=null){
            System.out.println("登录成功！");
            String superuser = u.getSuperuser();
            if("3".equals(superuser)){
                System.out.println("你是管理员！");
            }else {
                System.out.println("你是普通用户！");
            }
        }else {
            System.out.println("登录失败！");
        }
    }
}
