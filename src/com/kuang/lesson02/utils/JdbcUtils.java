package com.kuang.lesson02.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
             private static String driver=null;
             private static String url=null;
             private static String username=null;
               private static String password=null;

    static {
        try{
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");


            Class.forName(driver);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   //获取链接·
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    //释放连接资源
     public static void release(Connection conn, Statement st, ResultSet rs) throws SQLException {
        if(rs !=null){
            rs.close();
        }

         if(st !=null){
             st.close();
         }

         if(conn !=null){
             conn.close();
         }
     }




}
