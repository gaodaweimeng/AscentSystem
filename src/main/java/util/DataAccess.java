package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataAccess {
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;

    static {
        DataBaseConfigParser dataBaseConfig = new DataBaseConfigParser();
        try{
            dataBaseConfig.parse("database.conf.xml");
            Properties dbProps = dataBaseConfig.getProps();
            driver=dbProps.getProperty("driver");
            url=dbProps.getProperty("url");
            user=dbProps.getProperty("user");
            pwd=dbProps.getProperty("password");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DataAccess() throws Exception{

    }

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url, user, pwd);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}
