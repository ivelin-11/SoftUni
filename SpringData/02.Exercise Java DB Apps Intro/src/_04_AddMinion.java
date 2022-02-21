import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _04_AddMinion {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();

        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);

        String[] minionInfo = scanner.nextLine().split("\\s+");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];

        String[] villainInfo = scanner.nextLine().split("\\s+");
        String villainName = villainInfo[1];


        int townId = addTownIfAbsentAndGetTownID(connection, minionTown);
        int villainID = addVillainIfAbsentAndGetVillainID(connection, villainName);
        int minionId = addMinionIfAbsentAndGetMinionID(connection, minionName, minionAge, townId);

        addMinionToItsVillain(connection, villainID, minionId, minionName, villainName);

        connection.close();
    }

    private static void addMinionToItsVillain(Connection connection, int villainID, int minionID, String minionName, String vilainName) throws SQLException {
        PreparedStatement addMinionToVillain = connection.prepareStatement("INSERT INTO  minions_villains VALUES (?,?)");
        addMinionToVillain.setInt(1, minionID);
        addMinionToVillain.setInt(2, villainID);
        addMinionToVillain.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, vilainName);
    }

    private static int addMinionIfAbsentAndGetMinionID(Connection connection, String minionName, int minionAge, int townId) throws SQLException {
        PreparedStatement selectMinion = connection.prepareStatement("SELECT id FROM minions WHERE `name` LIKE ? AND age = ? AND town_id = ?");
        selectMinion.setString(1, minionName);
        selectMinion.setInt(2, minionAge);
        selectMinion.setInt(3, townId);

        addMinionIfAbsent(connection, minionName, minionAge, townId, selectMinion);
        ResultSet minionResultSet = selectMinion.executeQuery();

        minionResultSet.next();
        return minionResultSet.getInt("id");
    }

    private static void addMinionIfAbsent(Connection connection, String minionName, int minionAge, int townId, PreparedStatement selectMinion) throws SQLException {
        ResultSet minionResultSet = selectMinion.executeQuery();
        if (!minionResultSet.next()) {
            PreparedStatement addMinionStatement = connection.prepareStatement("INSERT INTO minions(name,age,town_id) VALUES (?,?,?)");
            addMinionStatement.setString(1, minionName);
            addMinionStatement.setInt(2, minionAge);
            addMinionStatement.setInt(3, townId);
            addMinionStatement.executeUpdate();
        }
    }

    private static int addVillainIfAbsentAndGetVillainID(Connection connection, String villainName) throws SQLException {
        PreparedStatement selectVillain = connection.prepareStatement("SELECT id FROM villains WHERE name LIKE ?");
        selectVillain.setString(1, villainName);

        addVillainIfAbsent(connection, villainName, selectVillain);
        ResultSet villainResultSet = selectVillain.executeQuery();

        villainResultSet.next();
        return villainResultSet.getInt("id");
    }

    private static void addVillainIfAbsent(Connection connection, String villainName, PreparedStatement selectVillain) throws SQLException {
        ResultSet villainResultSet = selectVillain.executeQuery();
        if (!villainResultSet.next()) {
            PreparedStatement addVillainStatement = connection.prepareStatement("INSERT INTO villains(name,evilness_factor) VALUES (?,?)");
            addVillainStatement.setString(1, villainName);
            addVillainStatement.setString(2, "evil");
            addVillainStatement.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }
    }

    private static int addTownIfAbsentAndGetTownID(Connection connection, String townName) throws SQLException {
        PreparedStatement selectTown = connection.prepareStatement("SELECT id FROM towns WHERE name LIKE ? ");
        selectTown.setString(1, townName);

        addTownIfAbsent(connection, townName, selectTown);
        ResultSet townResultSet = selectTown.executeQuery();

        townResultSet.next();
        return townResultSet.getInt("id");

    }

    private static void addTownIfAbsent(Connection connection, String townName, PreparedStatement selectTown) throws SQLException {
        ResultSet townResultSet = selectTown.executeQuery();
        if (!townResultSet.next()) {
            PreparedStatement addTownStatement = connection.prepareStatement("INSERT INTO towns(name) VALUES (?)");
            addTownStatement.setString(1, townName);
            addTownStatement.executeUpdate();
            System.out.printf("Town %s was added to the database.%n", townName);
        }
    }
}
