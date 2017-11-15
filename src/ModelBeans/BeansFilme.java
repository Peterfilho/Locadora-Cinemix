/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBeans;

import ModelDao.DaoFilme;
import java.sql.Date;

/**
 *
 * @author peterson
 */
public class BeansFilme {
    
    private Integer id_filme;
    private String classificacao_etaria;
    private String status;
    private String nome;
    private String nome_original;
    private String categoria;
    private Date lancamento;
    private String duracao;
    private String sinopse;
    private String elenco;
    private int estoque;
    private String valor_locacao;
    private String pesquisa;

    /**
     * @return the id_filme
     */
    public int getId_filme() {
        return id_filme;
    }

    /**
     * @param id_filme the id_filme to set
     */
    public void setId_filme(int id_filme) {
        this.id_filme = id_filme;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nome_original
     */
    public String getNome_original() {
        return nome_original;
    }

    /**
     * @param nome_original the nome_original to set
     */
    public void setNome_original(String nome_original) {
        this.nome_original = nome_original;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the lancamento
     */
    public Date getLancamento() {
        return lancamento;
    }

    /**
     * @param lancamento the lancamento to set
     */
    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    /**
     * @return the duracao
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the sinopse
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @param sinopse the sinopse to set
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * @return the elenco
     */
    public String getElenco() {
        return elenco;
    }

    /**
     * @param elenco the elenco to set
     */
    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    /**
     * @return the classificacao_etaria
     */
    public String getClassificacao_etaria() {
        return classificacao_etaria;
    }

    /**
     * @param classificacao_etaria the classificacao_etaria to set
     */
    public void setClassificacao_etaria(String classificacao_etaria) {
        this.classificacao_etaria = classificacao_etaria;
    }

    /**
     * @return the valor_locacao
     */
    public String getValor_locacao() {
        return valor_locacao;
    }

    /**
     * @param valor_locacao the valor_locacao to set
     */
    public void setValor_locacao(String valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
     //------------------ AtiveRecord
    
    private DaoFilme dao = new DaoFilme();
    
  
    public void salvar(){
        if(id_filme!=null && dao.buscaFilmePorID(id_filme)!=null)
            dao.editar(this);
        else
            dao.salvar(this);
    }
    
    public void excluir(){
        dao.excluir(this);
    }
    
}
