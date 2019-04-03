package JavaDao;

import JavaBean.Usr;
import util.DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManagerDAO {

    public List<Usr> getAllProductUser(){
        DataAccess dataAccess = new DataAccess();
        Connection connection = dataAccess.getConnection();
        String sql = "select * from usr p order by p.id";
        List<Usr> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Usr pu = new Usr(); //创建一个新Usr类
                pu.setId(resultSet.getInt("id"));
                pu.setUsername(resultSet.getString("username"));
                pu.setPassword(resultSet.getString("password"));
                pu.setFullname(resultSet.getString("fullname"));
                pu.setTitle(resultSet.getString("title"));
                pu.setCompanyname(resultSet.getString("companyname"));
                pu.setCompanyaddress(resultSet.getString("companyaddress"));
                pu.setCity(resultSet.getString("city"));
                pu.setJob(resultSet.getString("job"));
                pu.setTel(resultSet.getString("tel"));
                pu.setEmail(resultSet.getString("email"));
                pu.setCountry(resultSet.getString("country"));
                pu.setZip(resultSet.getString("zip"));
                pu.setSuperuser(resultSet.getString("superuser"));
                pu.setDelsoft(resultSet.getString("delsoft"));
                pu.setNote(resultSet.getString("note"));
                list.add(pu);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
}
