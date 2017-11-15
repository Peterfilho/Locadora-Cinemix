/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import Exceptions.ModelException;
import ModelBeans.BeansCadCliente;
import ModelBeans.BeansFilme;
import ModelBeans.BeansLocacao;
import ModelConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author peterson
 */
public class DaoLocacao {

    ConexaoBD conect = new ConexaoBD();

    public BeansFilme buscaFilme(String pesquisa) {
        BeansFilme mod = new BeansFilme();

        conect.conexao();
        conect.executaSql("SELECT * FROM filme WHERE nome LIKE '%" + pesquisa + "%' ORDER BY nome ");

        try {
            conect.rs.first();
            mod.setId_filme(conect.rs.getInt("id_filme"));
            mod.setNome(conect.rs.getString("nome"));
            mod.setNome_original(conect.rs.getString("nome_original"));
            mod.setClassificacao_etaria(conect.rs.getString("classificacao_etaria"));
            mod.setCategoria(conect.rs.getString("categoria"));
            mod.setDuracao(conect.rs.getString("duracao"));
            mod.setElenco(conect.rs.getString("elenco"));
            mod.setEstoque(conect.rs.getInt("estoque"));
            mod.setLancamento(conect.rs.getDate("lancamento"));
            mod.setSinopse(conect.rs.getString("sinopse"));
            mod.setStatus(conect.rs.getString("status"));
            mod.setValor_locacao(conect.rs.getString("valor_locacao"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
        }
        conect.desconecta();
        return mod;
    }
    
    public Integer salvarlocacao (BeansLocacao mod){
        
        Integer generatedId = null;
        
        conect.conexao();
        
        try {
            PreparedStatement pst = conect.con.prepareStatement(
                    "INSERT INTO locacao (id_cliente, "
                            + "data_locacao, "
                            + "data_devolucao, "
                            + "Status, "
                            + "valor_total) "
                            + "VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            //'id_cliente', 'data_locacao', 'data_devolucao', 'Status', 'valor_total') VALUES '
            
            pst.setInt(1, mod.getId_cliente());
            pst.setDate(2, mod.getData_locacao());
            pst.setDate(3, mod.getData_devolucao());
            pst.setString(4, "Em aberto");
            pst.setString(5, mod.getTotal());
            
            //executa
            pst.execute();
            
            ResultSet rsGen = pst.getGeneratedKeys();
            if(rsGen.next())
                generatedId = rsGen.getInt(1);
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
            ex.printStackTrace();
            throw new ModelException("Erro ao salvar locação!");
        } finally{
            conect.desconecta();
        }
        
        return generatedId;
        
    }
    public void salvarItensLocacao (Integer idLocacao, Integer idFilme){
        BeansLocacao mod = new BeansLocacao();
        conect.conexao();
            PreparedStatement pst;
        try {
            pst = conect.con.prepareStatement("INSERT INTO itens_locacao (id_locacao, id_filme) VALUES (?,?)");
            
            pst.setInt(1, idLocacao);
            pst.setInt(2, idFilme);
            //executa
            pst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conect.desconecta();
    }
    
    public BeansLocacao buscaClientePorNome (String pesquisa){
        BeansLocacao mod = new BeansLocacao();
        
        conect.conexao();
            conect.executaSql("SELECT * , cidade.nome, estado.nome FROM cliente JOIN cidade USING ( id_cidade ) JOIN estado USING ( id_estado ) WHERE primeiro_nome LIKE '%"+ pesquisa+"%' ORDER BY primeiro_nome ");
        try {
            conect.rs.first();
            mod.setId_cliente(conect.rs.getInt("id_cliente"));
            mod.setCliente_locacao(conect.rs.getString("primeiro_nome"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
        }
        conect.desconecta();
    return mod;
    }


}
