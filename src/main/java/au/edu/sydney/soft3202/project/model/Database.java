package au.edu.sydney.soft3202.project.model;

import java.io.File;
import java.sql.*;

public class Database {

    private static final String dbName = "Cache.db";
    private static final String dbURL = "jdbc:sqlite:" + dbName;

    /**
     *  create a new database if not exists.
     */
    public static void createDB() {
        File dbFile = new File(dbName);
        if(dbFile.exists()) {
            System.out.println("Database already created");
            return;
        }
        try(Connection ignored = DriverManager.getConnection(dbURL)) {
            System.out.println("A new database has been created");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * create new tables for database if not exists.
     */
    public static void setupDB() {

        String createTableSQL =
                """
                CREATE TABLE IF NOT EXISTS Cache (
                    entryname TEXT, 
                    webimage TEXT,
                    longtitle TEXT,
                    yearearly INTEGER,
                    plaquedescription TEXT,
                    principalmakername TEXT
                );
                        """;

        String createFavouriteListSQL =
                """
                CREATE TABLE IF NOT EXISTS Favourite (
                    shorttitle TEXT,
                    longtitle TEXT,
                    yearearly INTEGER,
                    plaquedescription TEXT,
                    principalmakername TEXT
                );
                        """;

        try (Connection conn = DriverManager.getConnection(dbURL); Statement statement = conn.createStatement()) {
            statement.execute(createTableSQL);
            statement.execute(createFavouriteListSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * add cache into cache table.
     * @param entryName add an entry name under database cache table entryname column.
     * @param image add an image url under database cache table webimage column.
     * @param longTitle add a long title under database cache table longtitle column.
     * @param yearEarly add a year under database cache table yearearly column.
     * @param plaqueDescription add a plaque description under database cache table plaquedescription column.
     * @param principalMakerName add a principal maker name under database cache table principalmakername column.
     */
    private static void addData(String entryName, String image, String longTitle, int yearEarly, String plaqueDescription, String principalMakerName) {
        String addDataSQL =
                """
                INSERT INTO Cache(entryname, webimage, longtitle, yearearly, plaquedescription, principalmakername) VALUES
                (?, ?, ?, ?, ?, ?)
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(addDataSQL)) {
            preparedStatement.setString(1, entryName);
            preparedStatement.setString(2, image);
            preparedStatement.setString(3, longTitle);
            preparedStatement.setInt(4, yearEarly);
            preparedStatement.setString(5, plaqueDescription);
            preparedStatement.setString(6, principalMakerName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * look for webimage with the specific entry name under table Cache.
     * @param entryName the specific entry name
     * @return webimage with the specific entry name
     */
    public static String findEntryWebimage(String entryName) {
        String findEntrySQL =
                """
                SELECT *
                FROM Cache
                WHERE entryname = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findEntrySQL)) {
            preparedStatement.setString(1, entryName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getString("webimage");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * look for long title with the specific entry name under table Cache.
     * @param entryName the specific entry name
     * @return long title with the specific entry name
     */
    public static String findEntryLongTitle(String entryName) {
        String findEntrySQL =
                """
                SELECT *
                FROM Cache
                WHERE entryname = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findEntrySQL)) {
            preparedStatement.setString(1, entryName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getString("longtitle");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * look for year with the specific entry name under table Cache.
     * @param entryName the specific entry name
     * @return year value with the specific entry name
     */
    public static int findEntryYearEarly(String entryName) {
        String findEntrySQL =
                """
                SELECT *
                FROM Cache
                WHERE entryname = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findEntrySQL)) {
            preparedStatement.setString(1, entryName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getInt("yearearly");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * look for plaque description with the specific entry name under table Cache.
     * @param entryName the specific entry name
     * @return plaque description with the specific entry name
     */
    public static String findEntryPlaqueDescription(String entryName) {
        String findEntrySQL =
                """
                SELECT *
                FROM Cache
                WHERE entryname = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findEntrySQL)) {
            preparedStatement.setString(1, entryName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getString("plaquedescription");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * look for principal maker name with the specific entry name under table Cache.
     * @param entryName the specific entry name
     * @return principal maker name with the specific entry name
     */
    public static String findEntryPrincipalMakerName(String entryName) {
        String findEntrySQL =
                """
                SELECT *
                FROM Cache
                WHERE entryname = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findEntrySQL)) {
            preparedStatement.setString(1, entryName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getString("principalmakername");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * look for cache it with the specific entry name under table Cache.
     * @param entryName the specific entry name
     * @return a boolean to show whether cache hit or not.
     */
    public static boolean isExistEntry(String entryName) {
        String findEntrySQL =
                """
                SELECT *
                FROM Cache
                WHERE entryname = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findEntrySQL)) {
            preparedStatement.setString(1, entryName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * clear data under Cache table.
     */
    public static void clear() {
        String dropTableSQL =
                """
                DROP TABLE Cache;
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); Statement statement = conn.createStatement()) {
            statement.execute(dropTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setupDB();
    }

    /**
     * add no duplicate data in Cache table.
     */
    public void addDataNotExist(String entryName, String image, String longTitle, int yearEarly, String plaqueDescription, String principalMakerName) {
        boolean isExistEntry = isExistEntry(entryName);
        if(!isExistEntry) {
            addData(entryName, image, longTitle, yearEarly, plaqueDescription, principalMakerName);
        }
    }

    /**
     * add data in table Favourite.
     */
    public static void addFavouriteList(String shortTitle, String longTitle, int yearEarly, String plaqueDescription, String principalMakerName) {
        String addFavouriteSQL =
                """
                INSERT INTO Favourite(shorttitle, longtitle, yearearly, plaquedescription, principalmakername) VALUES
                (?, ?, ?, ?, ?)
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(addFavouriteSQL)) {
            preparedStatement.setString(1, shortTitle);
            preparedStatement.setString(2, longTitle);
            preparedStatement.setInt(3, yearEarly);
            preparedStatement.setString(4, plaqueDescription);
            preparedStatement.setString(5, principalMakerName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * look for long title with the specific short title under table Favourite.
     * @param shortTitle the specific short title
     * @return
     */
    public static String findFavouriteLongTitle(String shortTitle) {
        String findLongSQL =
                """
                SELECT *
                FROM Favourite
                WHERE shorttitle = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findLongSQL)) {
            preparedStatement.setString(1, shortTitle);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getString("longtitle");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * look for year value with the specific short title under table Favourite.
     * @param shortTitle the specific short title
     * @return
     */
    public static int findFavouriteYear(String shortTitle) {
        String findYearEarlySQL =
                """
                SELECT *
                FROM Favourite
                WHERE shorttitle = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findYearEarlySQL)) {
            preparedStatement.setString(1, shortTitle);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getInt("yearearly");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * look for plaque description with the specific short title under table Favourite.
     * @param shortTitle the specific short title
     * @return plaque description
     */
    public static String findFavouritePlaqueDescription(String shortTitle) {
        String findPlaqueSQL =
                """
                SELECT *
                FROM Favourite
                WHERE shorttitle = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findPlaqueSQL)) {
            preparedStatement.setString(1, shortTitle);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getString("plaquedescription");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * look for principal make rname with the specific short title under table Favourite.
     * @param shortTitle the specific short title
     * @return principal maker name
     */
    public static String findFavouritePrincipalMakerName(String shortTitle) {
        String findLongSQL =
                """
                SELECT *
                FROM Favourite
                WHERE shorttitle = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(findLongSQL)) {
            preparedStatement.setString(1, shortTitle);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                return rs.getString("principalmakername");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * clear all data under Favourite table.
     */
    public static void clearFavourite() {
        String clearFavourite =
                """
                DROP TABLE Favourite;
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); Statement statement = conn.createStatement()) {
            statement.execute(clearFavourite);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setupDB();
    }

    /**
     * remove one data with the specific short title.
     * @param shortTitle the specific short title
     */
    public static void removeFavourite(String shortTitle) {
        String removeFavourite =
                """
                DELETE FROM Favourite
                WHERE shorttitle = ?
                        """;
        try(Connection conn = DriverManager.getConnection(dbURL); PreparedStatement preparedStatement = conn.prepareStatement(removeFavourite)) {
            preparedStatement.setString(1, shortTitle);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
