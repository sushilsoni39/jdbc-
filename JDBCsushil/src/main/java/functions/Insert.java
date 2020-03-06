package functions;
import connection.JDBCConnection;
import model.Employee;
import java.sql.*;
import java.util.Scanner;

public class Insert implements CRUD {
    int id;
    String name;
    String city;
    int age;
    String deptName;

    private void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id : ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name : ");
        name = sc.nextLine();
        System.out.println("Enter the city : ");
        city = sc.nextLine();
        System.out.println("Enter the age : ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the deptName: ");
        deptName = sc.nextLine();
    }

    @Override
    public void performFunction() throws SQLException {
        Connection myConn = JDBCConnection.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;

        sql = "INSERT INTO sushil.employee(id, name, city, age, deptName) VALUES (?, ?, ?, ?,?)";
        statement = myConn.prepareStatement(sql);
        System.out.println("Enter the Values");
        takeInput();
        Employee employee = new Employee(id, name, city, age, deptName);

        statement.setString(1, Integer.toString(employee.id));
        statement.setString(2, employee.name);
        statement.setString(3, employee.city);
        statement.setString(4, Integer.toString(employee.age));
        statement.setString(5, employee.deptName);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }
}
