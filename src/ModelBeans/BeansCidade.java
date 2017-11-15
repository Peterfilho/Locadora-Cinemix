/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBeans;

import ModelDao.DaoCidade;
import java.util.List;

/**
 *
 * @author peterson
 */
public class BeansCidade {
    private Integer id;
    private String nome;

    public BeansCidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    //////////////////////
    
    private static DaoCidade dao = new DaoCidade();
    
    public static BeansCidade buscarPorNome(String nomeCidade, String nomeEstado){
        return DaoCidade.buscarPorNome(nomeCidade, nomeEstado);
    }
    
    public static List<BeansCidade> buscarTodos(String nomeEstado){
        return DaoCidade.buscarTodos(nomeEstado);
    }
}
