import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _06_RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scann = new Scanner(System.in);

        int villainId = Integer.parseInt(scann.nextLine());

        connection.setAutoCommit(false);

        PreparedStatement selectVillainByID = connection.prepareStatement(
                "SELECT name FROM villains WHERE id=?");

        selectVillainByID.setInt(1, villainId);
        ResultSet villainSet = selectVillainByID.executeQuery();

        if (!villainSet.next()) {
            System.out.println("No such villain was found");
            return;
        }

        PreparedStatement getMinionsCountByVillain = connection.prepareStatement(
                "SELECT COUNT(minion_id) as minions_count FROM minions_villains" +
                        " WHERE villain_id=?");

        getMinionsCountByVillain.setInt(1, villainId);
        ResultSet minionsCountSet = getMinionsCountByVillain.executeQuery();


        try {
            PreparedStatement releaseMinionFromVillain = connection.prepareStatement(
                    "DELETE FROM minions_villains WHERE villain_id=?");

            releaseMinionFromVillain.setInt(1, villainId);

            releaseMinionFromVillain.executeUpdate();

            PreparedStatement deleteVillain = connection.prepareStatement(
                    "DELETE FROM villains WHERE id=?");

            deleteVillain.setInt(1, villainId);

            deleteVillain.executeUpdate();

            connection.commit();

            System.out.println(villainSet.getString("name") + " was deleted");
            minionsCountSet.next();
            System.out.println(minionsCountSet.getString("minions_count") + " minions released");

        } catch (SQLException e) {
            connection.rollback();
        }

        connection.close();
    }
}
