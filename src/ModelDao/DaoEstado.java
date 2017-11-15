/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.BeansEstado;
import ModelConection.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peterson
 */
public class DaoEstado {
    public static List<BeansEstado> buscarTodos(){
        ConexaoBD conectStatic = new ConexaoBD();
        conectStatic.conexao();
        
        List<BeansEstado> result = new ArrayList<>();
        
        try {
            ResultSet rsRetorno = conectStatic.executaSql("select * from estado");
            
            while(rsRetorno.next())
                result.add(new BeansEstado(rsRetorno.getInt("id_estado"),rsRetorno.getString("nome"),rsRetorno.getString("uf") ));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            conectStatic.desconecta();
        }
        
        return result;
    }
}
