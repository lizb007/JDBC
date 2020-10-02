package com.kuang.lesson02;


import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            conn = JdbcUtils.getConnection();
            st=conn.createStatement();
            String sql="insert into users(id,NAME,PASSWORD,email,birthday) values (4,'kuangshen','123456','12312313@qq.com','2020-01-01')";


            int i = st.executeUpdate(sql);
            if(i>0){
                System.out.println("successfully");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
          JdbcUtils.release(conn,st,rs);


        }


    }


}
