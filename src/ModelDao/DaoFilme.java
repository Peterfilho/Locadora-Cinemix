/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.BeansCadCliente;
import ModelBeans.BeansFilme;
import ModelConection.ConexaoBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author peterson
 */
public class DaoFilme {
    
    ConexaoBD conect = new ConexaoBD();
    
    public void salvar (BeansFilme mod){
        conect.conexao();
       
        try {
            
            PreparedStatement pst = conect.con.prepareStatement("insert into filme (nome, nome_original, lancamento, duracao, sinopse, elenco, estoque, valor_locacao, categoria, classificacao_etaria, status) values (?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getNome_original());
            java.sql.Date dateSQL = new java.sql.Date( mod.getLancamento().getTime() );
            pst.setDate(3, dateSQL);
            pst.setString(4, mod.getDuracao());
            pst.setString(5, mod.getSinopse());
            pst.setString(6, mod.getElenco());
            pst.setInt(7, mod.getEstoque());
            pst.setString(8, mod.getValor_locacao());
            pst.setString(9, mod.getCategoria());
            pst.setString(10, mod.getClassificacao_etaria());
            pst.setString(11, "s");
            // ESSE SELECT VAI RETORNAR O ID DA CIDADE QUE ESTA SELECIONADA NA COMBOBOX.
            
            // conect.executaSql("select id_cidade from cidade join estado using (id_estado) where cidade.nome like '%"+ mod.getCidade() +"%' and estado.nome like '%"+ mod.getEstado() +"%' ");
            //pst.setInt(11, mod.getId_cidade()); ///TODO: FAZER UM SELECT NA CIDADE E PEGAR O ID
            
            //executa
            pst.execute();
            //mensagem caso funcione
            JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!");
        } catch (SQLException ex) {
            //caso nao funcione
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Filme! "+ ex);
            ex.printStackTrace();
        }
        conect.desconecta();
    }
    
        public BeansFilme buscaFilme (String pesquisa){
        BeansFilme mod = new BeansFilme();
        
        conect.conexao();
            conect.executaSql("SELECT * FROM filme WHERE nome LIKE '%"+ pesquisa+"%' ORDER BY nome");
        try {
            conect.rs.first();
            mod.setId_filme(conect.rs.getInt("id_filme"));
            mod.setNome(conect.rs.getString("nome"));
            mod.setNome_original(conect.rs.getString("nome_original"));
            mod.setLancamento(conect.rs.getDate("lancamento"));
            mod.setDuracao(conect.rs.getString("duracao"));
            mod.setSinopse(conect.rs.getString("sinopse"));
            mod.setElenco(conect.rs.getString("elenco"));
            mod.setEstoque(conect.rs.getInt("estoque"));
            mod.setValor_locacao(conect.rs.getString("valor_locacao"));
            mod.setClassificacao_etaria(conect.rs.getString("classificacao_etaria"));
            mod.setCategoria(conect.rs.getString("categoria"));
            mod.setStatus(conect.rs.getString("status"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar filme!");
        }
        conect.desconecta();
    return mod;
    }
    
    public void editar (BeansFilme mod){
        conect.conexao();
        try {
            PreparedStatement pst = conect.con.prepareStatement("update filme set nome=?, nome_original=?, lancamento=?, categoria=?, classificacao_etaria=?, status=?, duracao=?, sinopse=?, elenco=?, estoque=?, valor_locacao=? where id_filme =?");
          //  
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getNome_original());
            pst.setDate(3, mod.getLancamento());
            pst.setString(4, mod.getCategoria());
            pst.setString(5, mod.getClassificacao_etaria());
            pst.setString(6, mod.getStatus());
            pst.setString(7, mod.getDuracao());
            pst.setString(8, mod.getSinopse());
            pst.setString(9, mod.getElenco());
            pst.setInt(10, mod.getEstoque());
            pst.setString(11, mod.getValor_locacao());
            pst.setInt(12, mod.getId_filme());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do Filme! Erro: "+ex);
        }
        
        conect.desconecta();
    }
    
    public void excluir (BeansFilme mod){
        conect.conexao();
        try {
            PreparedStatement pst = conect.con.prepareStatement("delete from filme where id_filme = ?");
            pst.setInt(1, mod.getId_filme());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Filme excluido com sucesso! ");        
                    
        } catch (SQLException ex) {
            //ex.printStackTrace();
            throw new RuntimeException("Erro ao excluir Filme!\n Podem existir locações em aberto para este filme!");
        }
        conect.desconecta();
    }
    
    public BeansFilme buscaFilmePorID (int id){
        BeansFilme mod = null;
        
        conect.conexao();
            conect.executaSql("SELECT * from filme WHERE id_filme = "+id);
        try {
            if(conect.rs.first()){
                mod = new BeansFilme();
            
                mod.setId_filme(conect.rs.getInt("id_filme"));
                mod.setNome(conect.rs.getString("nome"));
                mod.setNome_original(conect.rs.getString("nome_original"));
                mod.setCategoria(conect.rs.getString("categoria"));
                mod.setClassificacao_etaria(conect.rs.getString("classificacao_etaria"));
                mod.setStatus(conect.rs.getString("status"));
                mod.setLancamento(conect.rs.getDate("lancamento"));
                mod.setDuracao(conect.rs.getString("duracao"));
                mod.setSinopse(conect.rs.getString("sinopse"));
                mod.setElenco(conect.rs.getString("elenco"));
                mod.setEstoque(conect.rs.getInt("estoque"));
                mod.setValor_locacao(conect.rs.getString("valor_locacao"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar filme!");
        }
        conect.desconecta();
        return mod;
    }
}
    

