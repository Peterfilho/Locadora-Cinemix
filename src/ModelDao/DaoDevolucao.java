/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.BeansDevolucao;
import ModelConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author peterson
 */

public class DaoDevolucao {
    
    ConexaoBD conect = new ConexaoBD();
    
    public void devolver (BeansDevolucao mod){
        conect.conexao();
        try {
            PreparedStatement pst = conect.con.prepareStatement("UPDATE locacao SET Status= 'Devolvido' WHERE locacao.id_locacao =?");
          //  
            pst.setInt(1, mod.getIdLocacao());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Filme devolvido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao devolver filme! Erro: "+ex);
        }
        
        conect.desconecta();
    }
    
    
}
