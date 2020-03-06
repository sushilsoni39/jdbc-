package main;

import functions.Delete;
import functions.Insert;
import functions.Select;
import functions.Update;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int choice;

        while(true) {

            System.out.println("Press for the appropriate functionality\n 1.Insert\n 2.Select\n 3.Update\n 4.Delete\n 5.Stop\n");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Insert i = new Insert();
                    i.performFunction();
                    break;
                case 2:
                    Select s = new Select();
                    s.performFunction();
                    break;
                case 3:
                    Update u = new Update();
                    u.performFunction();
                    break;
                case 4:
                    Delete d = new Delete();
                    d.performFunction();
                    break;
                case 5:
                    return;

            }

        }

    }
}
