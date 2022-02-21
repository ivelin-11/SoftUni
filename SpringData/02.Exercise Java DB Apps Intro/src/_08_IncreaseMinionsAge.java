import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class _08_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Scanner scanner = new Scanner(System.in);
        String[] minionsIDs = (scanner.nextLine().split("\\s+"));


        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/minions_db", properties);


        String updateMinionAgeQuery = String.format("UPDATE minions SET name=lower(name),age=age+1 WHERE id IN (%s)",
                String.join(", ", minionsIDs));
        PreparedStatement updateMinionAge = connection.prepareStatement(
                updateMinionAgeQuery
        );

        updateMinionAge.executeUpdate();


        PreparedStatement selectMinionsById = connection.prepareStatement(
                "SELECT name,age FROM minions"
        );

        ResultSet minionsSet = selectMinionsById.executeQuery();

        while (minionsSet.next()) {
            String name = minionsSet.getString("name");
            int age = minionsSet.getInt("age");
            System.out.println(name + " " + age);

        }

        connection.close();
    }
}
