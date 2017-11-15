/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import Exceptions.ModelException;
import ModelConection.ConexaoBD;
import ModelBeans.BeansCadCliente;
import ModelBeans.BeansLocacao;
import View.TelaCadCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author peterson
 */
public class DaoCadCliente {

    ConexaoBD conect = new ConexaoBD();
    //ModelBeans.BeansCadCliente cliente = new BeansCadCliente();
    
    
    public Integer selectIdCidade(String nomeCidade, String nomeEstado){
        ResultSet rsRetorno = conect.executaSql("select id_cidade from cidade join estado using (id_estado) where cidade.nome like '%"+ nomeCidade +"%' and estado.nome like '%"+ nomeEstado +"%' ");
        try {
            return rsRetorno.getInt("id_cidade");
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void salvar (BeansCadCliente mod){
        conect.conexao();
       
        try {
            
            PreparedStatement pst = conect.con.prepareStatement("insert into cliente (primeiro_nome, sobrenome, cpf, rg, rua, bairro, numero, cep, referencia, telefone, id_cidade) values (?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSobrenome());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getRg());
            pst.setString(5, mod.getEndereco());
            pst.setString(6, mod.getBairro());
            pst.setInt(7, mod.getNumero());
            pst.setString(8, mod.getCep());
            pst.setString(9, mod.getReferencia());
            pst.setString(10, mod.getTelefone());
            pst.setInt(11, mod.getId_cidade());
            //executa
            pst.execute();
            //mensagem caso funcione
            //JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
            ex.printStackTrace();
            throw new ModelException("Erro ao cadastrar cliente!");
        } finally{
            conect.desconecta();
        }
    }
    
    public void editar (BeansCadCliente mod){
        conect.conexao();
        try {
            PreparedStatement pst = conect.con.prepareStatement("update cliente set primeiro_nome=?, id_cidade=?, sobrenome=?, telefone=?, cpf=?, rg=?, rua=?, numero=?, referencia=?, bairro=?, cep=? where id_cliente =?");
          //  
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getId_cidade());
            pst.setString(3, mod.getSobrenome());
            pst.setString(4, mod.getTelefone());
            pst.setString(5, mod.getCpf());
            pst.setString(6, mod.getRg());
            pst.setString(7, mod.getEndereco());
            pst.setInt(8, mod.getNumero());
            pst.setString(9, mod.getReferencia());
            pst.setString(10, mod.getBairro());
            pst.setString(11, mod.getCep());
            pst.setInt(12, mod.getId());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do cliente! Erro: "+ex);
        }
        
        conect.desconecta();
    }
    
    public void excluir (BeansCadCliente mod){
        conect.conexao();
        try {
            PreparedStatement pst = conect.con.prepareStatement("delete from cliente where id_cliente = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso! ");        
                    
        } catch (SQLException ex) {
            //ex.printStackTrace();
            throw new RuntimeException("Erro ao excluir Cliente!\n Podem existir locações em aberto para este cliente!");
        }
        conect.desconecta();
    }
    
    public BeansCadCliente buscaCliente (String pesquisa){
        BeansCadCliente mod = new BeansCadCliente();
        
        conect.conexao();
            conect.executaSql("SELECT * , cidade.nome, estado.nome FROM cliente JOIN cidade USING ( id_cidade ) JOIN estado USING ( id_estado ) WHERE primeiro_nome LIKE '%"+ pesquisa+"%' ORDER BY primeiro_nome ");
        try {
            conect.rs.first();
            mod.setId(conect.rs.getInt("id_cliente"));
            mod.setNome(conect.rs.getString("primeiro_nome"));
            mod.setRg(conect.rs.getString("rg"));
            mod.setCpf(conect.rs.getString("cpf"));
            mod.setCidade(conect.rs.getString("cidade.nome"));
            mod.setEstado(conect.rs.getString("estado.nome"));
            mod.setTelefone(conect.rs.getString("telefone"));
            mod.setEndereco(conect.rs.getString("rua"));
            mod.setSobrenome(conect.rs.getString("sobrenome"));
            mod.setBairro(conect.rs.getString("bairro"));
            mod.setCep(conect.rs.getString("cep"));
            mod.setReferencia(conect.rs.getString("referencia"));
            mod.setNumero(conect.rs.getInt("numero"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
        }
        conect.desconecta();
    return mod;
    }
    
    public BeansCadCliente buscaClientePorID (int id){
        BeansCadCliente mod = null;
        
        conect.conexao();
            conect.executaSql("SELECT *, cidade.nome, estado.nome FROM cliente JOIN cidade USING ( id_cidade ) JOIN estado USING ( id_estado ) WHERE id_cliente = "+id);
        try {
            if(conect.rs.first()){
                mod = new BeansCadCliente();
            
                mod.setId(conect.rs.getInt("id_cliente"));
                mod.setNome(conect.rs.getString("primeiro_nome"));
                mod.setRg(conect.rs.getString("rg"));
                mod.setCpf(conect.rs.getString("cpf"));
                mod.setCidade(conect.rs.getString("cidade.nome"));
                mod.setEstado(conect.rs.getString("estado.nome"));
                mod.setTelefone(conect.rs.getString("telefone"));
                mod.setEndereco(conect.rs.getString("rua"));
                mod.setSobrenome(conect.rs.getString("sobrenome"));
                mod.setBairro(conect.rs.getString("bairro"));
                mod.setCep(conect.rs.getString("cep"));
                mod.setReferencia(conect.rs.getString("referencia"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
        }
        conect.desconecta();
        return mod;
    }
}
