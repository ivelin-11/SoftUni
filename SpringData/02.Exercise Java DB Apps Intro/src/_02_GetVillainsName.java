import java.sql.*;
import java.util.Properties;


public class _02_GetVillainsName {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();

        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT v.`name`,COUNT(DISTINCT mv.`minion_id`) AS `minion_count` " +
                " FROM `villains` AS v\n" +
                " JOIN `minions_villains` AS mv ON mv.`villain_id`=v.`id`\n" +
                " GROUP BY v.`id`\n" +
                " HAVING `minion_count`>? ORDER BY `minion_count` DESC;");

        statement.setInt(1, 15);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {

            String name = resultSet.getString("name");
            int minion_count = resultSet.getInt("minion_count");
            System.out.println(name + " " + minion_count);
        }
        connection.close();
    }
}
