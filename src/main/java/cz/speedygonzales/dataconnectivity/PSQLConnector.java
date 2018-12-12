package cz.speedygonzales.dataconnectivity;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @author vondracek
 * @since 25.10.2015 12:58
 */
@Slf4j
public class PSQLConnector {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            //do nothing
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mkyong", "postgres", "root");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from time_test");
            while (rs.next()) {
                Date date = rs.getDate("created");
                log.info(date.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
