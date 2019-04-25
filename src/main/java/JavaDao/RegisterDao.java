package JavaDao;

import JavaBean.Usr;
import util.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDao {
    public int register(Usr user){
        int flag = 0;
        PreparedStatement pst;
        DataAccess dataAccess = new DataAccess();
        Connection con = dataAccess.getConnection();
        ResultSet rs;
        try{
            con.setAutoCommit(false);
            ArrayList<String> user_names = new ArrayList<>();
            String sql_search = "select username from usr";
            pst = con.prepareStatement(sql_search);
            rs = pst.executeQuery();
            while(rs.next()){
                user_names.add(rs.getString("username"));
            }
            if(!user_names.contains(user.getUsername())){
                String sql_update = "insert into usr(username,password,city,email,superuser,delsoft) values (?,?,?,?,'1','0')";
                pst = con.prepareStatement(sql_update);
                pst.setString(1,user.getUsername());
                pst.setString(2,user.getPassword());
                pst.setString(3,user.getCity());
                pst.setString(4,user.getEmail());
                flag = pst.executeUpdate();
                con.commit();
            }
            pst.close();
            con.close();
        }catch (SQLException |NullPointerException ex){
            ex.printStackTrace();
        }
        return flag;
    }

}
