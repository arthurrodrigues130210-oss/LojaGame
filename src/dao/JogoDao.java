
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

            //JOptionPane.showMessageDialog(null, "Player Preparado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "But Error");
            throw new RuntimeException(e);
        }
    }

    public List<JogoModel> leitura() {
        connection = new ConnectionJogos().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<JogoModel> jogoArray = new ArrayList<>();

        try {
            ps = connection.prepareStatement("SELECT * FROM jogos");

            rs = ps.executeQuery();

            while (rs.next()) {
                JogoModel j = new JogoModel();
                j.setIdJogo(rs.getInt("idJogo"));
                j.setNome(rs.getString("nome"));
                j.setPlataforma(rs.getString("plataforma"));
                j.setPreco(rs.getDouble("Preco"));
                jogoArray.add(j);
            }
            //JOptionPane.showMessageDialog(null, "Lista DAO Funcionou");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Listar DAO");
            throw new RuntimeException(e);
        }
        return jogoArray;

    }

    public void excluir(JogoModel jogo) {
        String sql = "DELETE FROM jogos WHERE idJogo = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, jogo.getIdJogo());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Excluir DAO com exelencia!");

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir  - CLASE DAO");
            throw new RuntimeException(e);
        }
    }

    public void editar(JogoModel jogo) {
        String sql = "UPDATE jogos SET nome = ?, plataforma = ?, preco = ? WHERE idJogo = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getPlataforma());
            ps.setDouble(3, jogo.getPreco());
            ps.setInt(4, jogo.getIdJogo());

            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Edição do Jogo concluida");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Classe DAO");
            throw new RuntimeException(e);
        }
    }

}
