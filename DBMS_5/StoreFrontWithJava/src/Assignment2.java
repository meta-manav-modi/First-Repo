import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assignment2 {
    public void printImageTable(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                Image image = new Image();
                image.setId(resultSet.getInt(1));
                image.setProductId(resultSet.getInt(2));
                image.setImageurl(resultSet.getString(3));
                System.out.println(image);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertIntoImages(PreparedStatement preparedStatement) {
        try{
        String[] urlArray1 = new String[] { "iphone15mini.jpg", "iphone15.jpg", "iphone15pro.jpg", "iphone15proMax.jpg",
                "iphone15gold.jpg" };

        for (int index = 0; index < 5; index++) {
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, urlArray1[index]);
            preparedStatement.addBatch();
        }

        int[] rowAffected = preparedStatement.executeBatch();
        if (rowAffected.length > 0) {
            System.out.println("Inserted Successfully : " + rowAffected.length + " rows inserted");
        } else {
            System.err.println("No data inserted");
        }
    } catch (SQLException e) {
    System.out.println(e.getMessage());
}

}
}
