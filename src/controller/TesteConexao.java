package controller;

import model.JogoModel;
import dao.JogoDao;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        Connection connection = new ConnectionJogos().getConnection();
        JOptionPane.showMessageDialog(null, "Hora do Jogo Baby!");

        connection.close();
        
    }
}
