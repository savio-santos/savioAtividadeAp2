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
public class PaisDto {

    private int pais_id;
    private String nome_pais;
    private Date ultima_atualizacao;

    public PaisDto() {
    }

    public PaisDto(int pais_id, String nome_pais, Date ultima_atualizacao) {
        this.pais_id = pais_id;
        this.nome_pais = nome_pais;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getNome_pais() {
        return nome_pais;
    }

    public void setNome_pais(String nome_pais) {
        this.nome_pais = nome_pais;
    }

    public Date getUltima_atualizacao() {

        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Date ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

}
