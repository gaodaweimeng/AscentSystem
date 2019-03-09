package JavaDao;

import JavaBean.Usr;
import util.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public Usr logIn(String user, String password){
        DataAccess access = new DataAccess();
        Connection con = access.getConnection();
        String sql = "select * from usr where username=?and password=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usr pu = null;
        try{
            pst=con.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, password);
            rs=pst.executeQuery();
            if(rs.next()){
                pu = new Usr();
                pu.setId(rs.getInt("id"));
                pu.setSuperuser(rs.getString("superuser"));
                pu.setUsername(rs.getString("username"));
                pu.setEmail(rs.getString("email"));
                pu.setTel(rs.getString("tel"));
                pu.setCompanyname(rs.getString("companyName"));
                pu.setCompanyaddress(rs.getString("companyAddress"));
                pu.setDelsoft(rs.getString("delsoft"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null){
                    rs.close();
                }
                if(pst!=null){
                    pst.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return pu;
    }
}
