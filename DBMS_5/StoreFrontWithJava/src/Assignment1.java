import java.sql.ResultSet;
import java.sql.SQLException;


public class Assignment1 {
    public void printOrderTable(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setDate(resultSet.getString(2));
                order.setTotal(resultSet.getDouble(3));
                
                System.out.println(order);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}