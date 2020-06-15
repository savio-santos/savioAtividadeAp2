/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.controladores;

import frb.edu.br.savio.dominio.entidades.EnderecoDto;
import frb.edu.br.savio.dominio.contratos.IEndereco;
import frb.edu.br.savio.infra.repositorios.EnderecoRepositorio;
import java.util.List;

/**
 *
 * @author SAVIO
 */
public class EnderecoController {

    private EnderecoDto endereco;
    private IEndereco enderecoRepositorio = new EnderecoRepositorio();
    private List<EnderecoDto> enderecos = null;

    public EnderecoController() {

    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<EnderecoDto> getEnderecos() {
        if (enderecos == null) {
            enderecos = enderecoRepositorio.getListaTodos();
        }

        return enderecos;
    }

    public String prepararInclusao() {
        endereco = new EnderecoDto();
        return "vaiParaIncluir";
    }

    public String finalizaInclusao() {

        enderecoRepositorio.incluir(endereco);
        enderecos = null;
        return "voltaParaListagem";
    }

    public String finalizaEdicao() {
        enderecoRepositorio.alterar(endereco);
        enderecos = null;
        return "voltaParaListagem";
    }

    public String finalizaDelecao() {
        enderecoRepositorio.deletar(endereco.getEndereco_id());
        enderecos = null;
        return "refresh";
    }

}
