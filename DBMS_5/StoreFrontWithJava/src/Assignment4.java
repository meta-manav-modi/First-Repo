import java.sql.ResultSet;
import java.sql.SQLException;


public class Assignment4 {
    public void printCategoryTable(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                Category category = new Category();
                category.setTitle(resultSet.getString(1));
                category.setCount(resultSet.getInt(2));
                System.out.println(category);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}