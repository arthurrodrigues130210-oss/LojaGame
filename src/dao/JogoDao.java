
package dao;

import controller.ConnectionJogos;
import model.JogoModel;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class JogoDao {
    
     private Connection connection;

    public JogoDao(Connection connection) {
        this.connection = new ConnectionJogos().getConnection();
    }
    
    public void cadastrar(JogoModel jogo) {
        String sql = "INSERT INTO jogos(nome,plataforma,preco)VALUES(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getPlataforma());
            ps.setDouble(3, jogo.getPreco());
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Player Preparado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "But Error");
            throw new RuntimeException(e);
        }
    }

}
