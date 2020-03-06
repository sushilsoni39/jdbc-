package functions;

import connection.JDBCConnection;

import java.sql.*;

public class Select implements CRUD {
    @Override
    public void performFunction() throws SQLException {
        Connection connection = JDBCConnection.createConnection();
        Statement myStmt = connection.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "select * from sushil.employee";
        ResultSet rs = myStmt.executeQuery(sql);

        while (rs.next()){
            String id = rs.getString("id");
            String name = rs.getString("name");
            String city = rs.getString("city");
            String age = rs.getString("age");
            String deptName = rs.getString("deptName");
            System.out.println("Record " + id + " is " + name + " " + city + " " + age + " " + deptName);
        }
    }
}
