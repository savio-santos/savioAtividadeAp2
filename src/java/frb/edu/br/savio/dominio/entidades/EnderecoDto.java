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
public class EnderecoDto {
    private int entereco_id;
    private String endereco;
    private String endereco2;
    private String bairro;
    private CidadeDto cidade;
    private String cep;
    private String telefone;
    private Date ultima_atualização;

    public EnderecoDto() {
    }

    
    
    public EnderecoDto(int entereco_id, String endereco, String endereco2, String bairro, CidadeDto cidade, String cep, String telefone, Date ultima_atualização) {
        this.entereco_id = entereco_id;
        this.endereco = endereco;
        this.endereco2 = endereco2;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.ultima_atualização = ultima_atualização;
    }

    public int getEntereco_id() {
        return entereco_id;
    }

    public void setEntereco_id(int entereco_id) {
        this.entereco_id = entereco_id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public CidadeDto getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDto cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getUltima_atualização() {
        return ultima_atualização;
    }

    public void setUltima_atualização(Date ultima_atualização) {
        this.ultima_atualização = ultima_atualização;
    }

}
