package com.kuang.lesson04.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils_DBCP {
private static DataSource dataSource=null;

    static {
        try{
            InputStream in = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(in);

            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   //获取链接·
    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
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
