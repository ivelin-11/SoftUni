import java.sql.*;
import java.util.ArrayDeque;
import java.util.Properties;

public class _07_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement getAllMinions = connection.prepareStatement(
                "SELECT name FROM minions");

        ResultSet minionsSet = getAllMinions.executeQuery();

        ArrayDeque<String> minionsNames = new ArrayDeque<>();

        while(minionsSet.next()){
            minionsNames.add(minionsSet.getString("name"));
        }


        //case with even count of rows, odd count is not considered in the task condition
        while(!minionsNames.isEmpty()){
            System.out.println(minionsNames.pollFirst());
            System.out.println(minionsNames.pollLast());
        }
    }
}
