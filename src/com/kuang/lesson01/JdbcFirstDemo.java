package com.kuang.lesson01;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
   //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
//用户信息
       String url="jdbc:mysql://localhost:3306/jdbcStudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
       String username="root";
       String password="123456";
//链接成功，数据库对象  Connection代表数据库·
        Connection connection = DriverManager.getConnection(url, username, password);
//执行SQL的对象Statement 执行 sqk的对象
        Statement statement = connection.createStatement();
//执行SQL的对象
        String sql="select * from users";

//返回的结果
        ResultSet resultSet = statement.executeQuery(sql);
//

        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("NAME"));
            System.out.println("pwd="+resultSet.getObject("PASSWORD"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birth="+resultSet.getObject("birthday"));
        }
//释放链接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
