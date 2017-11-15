/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBeans;

import java.sql.Date;

/**
 *
 * @author peterson
 */
public class BeansLocacao {

//REFERENTE AO CLIENTE
private Integer id_cliente;
private Integer id_cidade;

//REFERENTE AO FILME
private Integer id_filme;
//REFERENTE A LOCAÇAO
private Integer id_locacao;
private Integer id_itens_locacao;
private String cliente_locacao;
private Date data_locacao;
private Date data_devolucao;
private String total;

// ITENS LOCAÇAO

    /**
     * @return the id_cliente
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_cidade
     */
    public Integer getId_cidade() {
        return id_cidade;
    }

    /**
     * @param id_cidade the id_cidade to set
     */
    public void setId_cidade(Integer id_cidade) {
        this.id_cidade = id_cidade;
    }

    /**
     * @return the id_filme
     */
    public Integer getId_filme() {
        return id_filme;
    }

    /**
     * @param id_filme the id_filme to set
     */
    public void setId_filme(Integer id_filme) {
        this.id_filme = id_filme;
    }

    /**
     * @return the id_itens_locacao
     */
    public Integer getId_itens_locacao() {
        return id_itens_locacao;
    }

    /**
     * @param id_itens_locacao the id_itens_locacao to set
     */
    public void setId_itens_locacao(Integer id_itens_locacao) {
        this.id_itens_locacao = id_itens_locacao;
    }

    /**
     * @return the cliente_locacao
     */
    public String getCliente_locacao() {
        return cliente_locacao;
    }

    /**
     * @param cliente_locacao the cliente_locacao to set
     */
    public void setCliente_locacao(String cliente_locacao) {
        this.cliente_locacao = cliente_locacao;
    }

    /**
     * @return the data_locacao
     */
    public Date getData_locacao() {
        return data_locacao;
    }

    /**
     * @param data_locacao the data_locacao to set
     */
    public void setData_locacao(Date data_locacao) {
        this.data_locacao = data_locacao;
    }

    /**
     * @return the data_devolucao
     */
    public Date getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the id_locacao
     */
    public Integer getId_locacao() {
        return id_locacao;
    }

    /**
     * @param id_locacao the id_locacao to set
     */
    public void setId_locacao(Integer id_locacao) {
        this.id_locacao = id_locacao;
    }

}