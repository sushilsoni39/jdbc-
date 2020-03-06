package functions;

import connection.JDBCConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update implements CRUD {

    private int id;
    private String name;
    private String city;
    private int age;
    private String deptName;

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
        Connection connection = JDBCConnection.createConnection();
        Statement myStmt = connection.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "UPDATE sushil.employee SET name=?, city=?, age=?, deptName=? WHERE id=?";
        System.out.println("Enter the ID to update");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Enter the new values\n");
        takeInput();
        Employee employee = new Employee(id, name, city, age, deptName);

        statement = connection.prepareStatement(sql);
        statement.setString(1, employee.name);
        statement.setString(2, employee.city);
        statement.setString(3, Integer.toString(employee.age));
        statement.setString(4, employee.deptName);
        statement.setString(5, Integer.toString(employee.id));


        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
}
