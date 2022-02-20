import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_ChangeTownsNamesCasing {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scann = new Scanner(System.in);
        String countryName = scann.nextLine();

        PreparedStatement updateTownByCountry = connection.prepareStatement
                ("UPDATE towns SET name=UPPER(name) WHERE country LIKE ?");
        updateTownByCountry.setString(1, countryName);
        int countTownsUpdated = updateTownByCountry.executeUpdate();

        if (countTownsUpdated == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.println(countTownsUpdated + " town names were affected.");
        PreparedStatement selectTownsInCountry = connection.prepareStatement
                ("SELECT name FROM towns WHERE country LIKE ?");
        selectTownsInCountry.setString(1, countryName);

        //select updated towns
        ResultSet towns = selectTownsInCountry.executeQuery();

        List<String> names=new ArrayList<>();
        while(towns.next()){
            names.add(towns.getString("name"));
        }

        System.out.println(names);

        connection.close();
    }
}
