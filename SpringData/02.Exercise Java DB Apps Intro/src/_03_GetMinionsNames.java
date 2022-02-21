import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _03_GetMinionsNames {
    public static void main(String[] args) throws SQLException {

        Scanner scann = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        int villianId = Integer.parseInt(scann.nextLine());
        PreparedStatement villainStatement = connection.prepareStatement("SELECT name FROM " +
                " villains WHERE id=?");

        villainStatement.setInt(1, villianId);

        ResultSet villain = villainStatement.executeQuery();
        if (villain.next()) {
            String villainName = villain.getString(1);
            System.out.printf("Villain: %s%n", villainName);

            PreparedStatement minionsStatement = connection.prepareStatement("SELECT m.`name`,m.`age` FROM `villains` AS v\n" +
                    " JOIN `minions_villains` AS mv ON mv.`villain_id`=v.`id`\n" +
                    " JOIN `minions` AS m ON mv.`minion_id`=m.`id`\n" +
                    " WHERE  v.`id`=?;");

            minionsStatement.setInt(1, villianId);
            ResultSet minions = minionsStatement.executeQuery();
            for (int i = 1; minions.next(); i++) {

                String minionName = minions.getString("name");
                String minionAge = minions.getString("age");

                System.out.println(i + ". " + minionName + " " + minionAge);
            }
        } else {
            System.out.printf("No villain with ID %d exists in the database.%n", villianId);
        }

        connection.close();
    }
}
