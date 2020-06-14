/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.controladores;

import frb.edu.br.savio.dominio.contratos.ICidade;
import frb.edu.br.savio.dominio.entidades.CidadeDto;
import frb.edu.br.savio.infra.repositorios.CidadeRepositorio;
import java.util.List;

/**
 *
 * @author SAVIO
 */
public class CidadeController {
private CidadeDto cidade;
private ICidade cidadeRepositorio = new CidadeRepositorio();  
private List<CidadeDto> cidades = null;

    public CidadeController() {
    }

    public CidadeDto getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDto cidade) {
        this.cidade = cidade;
    }

    public List<CidadeDto> getCidades() {
        if(cidades == null){
        cidades=cidadeRepositorio.getListaTodos();
        }
        
        return cidades;
    }
public String prepararInclusao(){
        cidade = new CidadeDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        
        cidadeRepositorio.incluir(cidade);
        cidades = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        cidadeRepositorio.alterar(cidade);
        cidades = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        cidadeRepositorio.deletar( cidade.getCidade_id());
        cidades = null;
        return "refresh";
    }
}
