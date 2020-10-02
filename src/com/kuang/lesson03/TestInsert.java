package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;

         conn = JdbcUtils.getConnection();

         String sql="insert into users(id,NAME,PASSWORD,email,birthday) values (?,?,?,?,?)";


         st=conn.prepareStatement(sql);

         st.setInt(1,4);
         st.setString(2,"qingjiang");
         st.setString(3,"111111");
         st.setString(4,"32112312@qq.com");
         st.setDate(5, new java.sql.Date(new Date().getTime()));


        int i = st.executeUpdate(sql);
        if(i>0){
            System.out.println("successful");
        }

        JdbcUtils.release(conn,st,null);


    }

}
