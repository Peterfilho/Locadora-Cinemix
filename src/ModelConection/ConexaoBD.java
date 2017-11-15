package ModelConection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author peterson
 */
public class ConexaoBD {

    public Statement stmt;
    public ResultSet rs;
    public Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost/cinemix2";
    private String usuario = "root";
    private String senha = "mysql";

    // MÉTODO SÓ PARA TESTAR SE DEU CERTO CONEXÃO
    public void conexao() {
        try {
            System.setProperty("jdbc.Driver", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            // JOptionPane.showMessageDialog(null, "Conexao estabelecida com sucesso \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados:\n" + ex.getMessage());
        }
    }

    // MÉTODO PARA DESCONECTAR O BANCO
    public void desconecta() {
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com banco de dados \n" + ex.getMessage());
        }
    }

    public ResultSet executaSql(String sql) {
        ResultSet rsRetorno = null;
        try {
            stmt = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            rsRetorno = rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar sql \n" + ex.getMessage());

        }
        return rsRetorno;
    }

}
