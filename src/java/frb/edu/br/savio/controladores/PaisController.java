/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.controladores;

import frb.edu.br.savio.dominio.contratos.IPais;
import frb.edu.br.savio.dominio.entidades.PaisDto;
import frb.edu.br.savio.infra.repositorios.PaisRepositorio;
import java.util.List;

/**
 *
 * @author SAVIO
 */
public class PaisController {

    private PaisDto pais;
    private List<PaisDto> paises = null;
    private IPais paisRepositorio = new PaisRepositorio();

    public PaisController() {
    }

    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    public List<PaisDto> getPaises() {
        if (paises == null) {
            paises = paisRepositorio.getListaTodos();

        }
        return paises;
    }

    public String prepararInclusao() {
        pais = new PaisDto();
        return "vaiParaIncluir";
    }

    public String finalizaInclusao() {

        paisRepositorio.incluir(pais);
        paises = null;
        return "voltaParaListagem";
    }
    public String finalizaEdicao(){
        paisRepositorio.alterar(pais);
        pais = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        paisRepositorio.deletar(pais.getPais_id());
        paises = null;
        return "refresh";
    }
}
