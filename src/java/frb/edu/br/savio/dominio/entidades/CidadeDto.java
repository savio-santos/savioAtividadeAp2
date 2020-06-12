/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.dominio.entidades;

import java.util.Date;

/**
 *
 * @author SAVIO
 */
public class CidadeDto {
    private int cidade_id;
    private String nome_cidade;
    private PaisDto pais;
    private Date ultima_atualizacao;

    public CidadeDto() {
        pais= new PaisDto();
    }
    public CidadeDto(int cidade_id) {
        this.cidade_id = cidade_id; 
        pais= new PaisDto();
    }

    
    public CidadeDto(int cidade_id, String nome_cidade, PaisDto pais, Date ultima_atualizacao) {
        this.cidade_id = cidade_id;
        this.nome_cidade = nome_cidade;
        this.pais = pais;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public int getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public String getNomeCidade() {
        return nome_cidade;
    }

    public void setNOmeCidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    public Date getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Date ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }
    
    
}
