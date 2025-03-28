import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Scanner;

public class MainClass {
    private static final String url = "jdbc:mysql://localhost:3306/StoreFront";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            boolean run = true;
            int choice;
            while (run) {
                System.out.println("1. Performin assignment 1");
                System.out.println("2. Performin assignment 2");
                System.out.println("3. Performin assignment 3");
                System.out.println("4. Performin assignment 4");
                System.out.println("5. Exit");
                System.out.println("Enter your choice");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        performAssignment1(connection,scanner);
                        break;
                    case 2:
                        performAssignment2(connection);
                        break;
                    case 3:
                        performAssignment3(connection);
                        break;
                    case 4:
                        performAssignment4(connection);
                        break;
                    case 5:
                        run = false;
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            scanner.close();
        }

    }

    public static void performAssignment1(Connection connection, Scanner scanner) {
        String getOrderTable = "select o.id,o.shopping_date,o.total \n" +
                "FROM orders o JOIN order_detail od ON o.id = od.order_id \n" +
                "WHERE o.shopper_id = ? AND od.shipped = TRUE \n" +
                "GROUP BY o.id, o.shopping_date, o.total ORDER BY o.shopping_date ASC";
        try {
            System.out.println("Enter the shooper id");
            int shopperId = scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement(getOrderTable);
            {
                preparedStatement.setInt(1, shopperId);

                ResultSet resultSet = preparedStatement.executeQuery();
                Assignment1 ass1 = new Assignment1();
                ass1.printOrderTable(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void performAssignment2(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            String getImageTable = "SELECT * FROM image";
            ResultSet resultSet = stmt.executeQuery(getImageTable);
            String queryToInsertImages = "INSERT INTO image(product_id,image_url) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(queryToInsertImages);
            Assignment2 ass2 = new Assignment2();
            ass2.insertIntoImages(preparedStatement);
            ass2.printImageTable(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void performAssignment3(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            String deletedFromProductTable = "DELETE FROM product WHERE product_id NOT IN \n" +
                    "(SELECT od.product_id FROM order_detail od JOIN orders o \n" +
                    "ON o.id = od.order_id WHERE o.shopping_date >= NOW() - INTERVAl 1 YEAR)";
            int numOfRowsDeletedFromProductTable = stmt.executeUpdate(deletedFromProductTable);
            if (numOfRowsDeletedFromProductTable > 0) {
                System.out.println(numOfRowsDeletedFromProductTable + " rows deleted");
            } else {
                System.out.println("No deleteion");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void performAssignment4(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            String getCategoryTable = "SELECT c.title,COUNT(pc.category_id)FROM category c \n" +
                    "JOIN category pc ON c.category_id = pc.parent_category_id \n" +
                    "WHERE c.parent_category_id IS NULL GROUP BY c.category_id ORDER BY c.title";
            ResultSet resultSet = stmt.executeQuery(getCategoryTable);

            Assignment4 ass4 = new Assignment4();
            ass4.printCategoryTable(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
