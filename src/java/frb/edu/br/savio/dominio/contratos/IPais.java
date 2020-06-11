/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.dominio.contratos;

import frb.edu.br.savio.dominio.entidades.PaisDto;
import java.util.List;

/**
 *
 * @author SAVIO
 */
public interface IPais {

    boolean incluir(PaisDto pais);

    boolean alterar(PaisDto pais);

    boolean deletar(int id);

    PaisDto getRegistroPorId(int id);

    List<PaisDto> getListaTodos();
}
