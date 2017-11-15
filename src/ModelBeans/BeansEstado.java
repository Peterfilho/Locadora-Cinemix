/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBeans;

import ModelDao.DaoEstado;
import java.util.List;

/**
 *
 * @author peterson
 */
public class BeansEstado {
    private int id;
    private String nome;
    private String uf;

    public BeansEstado(int id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    /////////////////////// DAO
    
    public static List<BeansEstado> buscarTodos(){
        return DaoEstado.buscarTodos();
    }
    
}
