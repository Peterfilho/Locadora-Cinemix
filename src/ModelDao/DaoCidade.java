/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.BeansCidade;
import ModelConection.ConexaoBD;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author peterson
 */
public class DaoCidade {
   
    public static BeansCidade buscarPorNome(String nomeCidade, String nomeEstado){
        ConexaoBD conectStatic = new ConexaoBD();
        conectStatic.conexao();
        
        try {
            ResultSet rsRetorno = conectStatic.executaSql("select id_cidade, cidade.nome from cidade join estado using (id_estado) where cidade.nome like '%"+ nomeCidade +"%' and estado.nome like '%"+ nomeEstado +"%' ");
            rsRetorno.first();
            return new BeansCidade(rsRetorno.getInt("id_cidade"),rsRetorno.getString("cidade.nome") );
            
        } catch (SQLException ex) {
            return null;
        } finally{
            conectStatic.desconecta();
        }
    }
    
    public static List<BeansCidade> buscarTodos(String nomeEstado){
        ConexaoBD conectStatic = new ConexaoBD();
        conectStatic.conexao();
        
        List<BeansCidade> result = new ArrayList<>();
        
        try {
            ResultSet rsRetorno = conectStatic.executaSql("select * from cidade join estado using (id_estado) where estado.nome like '%"+ nomeEstado +"%' ");
            
            while(rsRetorno.next())
                result.add(new BeansCidade(rsRetorno.getInt("id_cidade"),rsRetorno.getString("cidade.nome") ));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            conectStatic.desconecta();
        }
        
        return result;
    }
}
