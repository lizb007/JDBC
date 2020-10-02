package com.kuang.lesson02.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testselect {

    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            conn = JdbcUtils.getConnection();
            st=conn.createStatement();
            String sql="select * from users where id=1";

              rs=st.executeQuery(sql);
              while(rs.next()){
                  System.out.println(rs.getString("NAME"));
              }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);


        }


    }


}
