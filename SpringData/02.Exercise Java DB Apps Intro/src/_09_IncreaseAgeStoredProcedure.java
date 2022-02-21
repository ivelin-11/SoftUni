import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _09_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Scanner scanner = new Scanner(System.in);

        int minionID=Integer.parseInt(scanner.nextLine());

        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/minions_db", properties);

        CallableStatement callUspGetOlder= connection.prepareCall(
                "CALL usp_get_older(?);");
        callUspGetOlder.setInt(1,minionID);

        callUspGetOlder.executeUpdate();

        PreparedStatement selectMinionByID=connection.prepareStatement(
                "SELECT name,age FROM minions " +
                        " WHERE id=?");

        selectMinionByID.setInt(1,minionID);

        ResultSet minionSet = selectMinionByID.executeQuery();

        minionSet.next();
        String name = minionSet.getString("name");
        int age = minionSet.getInt("age");

        System.out.println(name + " " + age);

        connection.close();
    }
}
