package controller;

import java.sql.Connection;
import java.sql.*;

public class ConnectionJogos {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/LojaGames",
                    "root",
                    "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
