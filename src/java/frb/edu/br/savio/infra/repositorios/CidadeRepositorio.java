/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.infra.repositorios;

import frb.edu.br.savio.dominio.contratos.ICidade;
import frb.edu.br.savio.dominio.entidades.CidadeDto;
import frb.edu.br.savio.dominio.entidades.PaisDto;
import frb.edu.br.savio.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAVIO
 */
public class CidadeRepositorio extends DaoUtil implements ICidade {

    public CidadeRepositorio() {
        super();
    }

    @Override
    public boolean incluir(CidadeDto cidade) {
        String sql = "INSERT INTO cidade (cidade_id, cidade, pais_id) "
                + " VALUES (?, ?, ?) ";

        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, cidade.getCidade_id());
            ps.setString(2, cidade.getNomeCidade());
            ps.setInt(3, cidade.getPais().getPais_id());
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;

    }

    @Override
    public boolean alterar(CidadeDto cidade) {
        String sql = "UPDATE cidade SET cidade=?, pais_id=?"
                + " WHERE cidade_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, cidade.getNomeCidade());
            ps.setInt(2, cidade.getPais().getPais_id());
            ps.setInt(3, cidade.getCidade_id());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM cidade "
                + " WHERE cidade_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public CidadeDto getRegistroPorId(int id) {
        CidadeDto cidade = new CidadeDto();
        
        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao FROM cidade WHERE cidade_id=?";
        PaisRepositorio p = new PaisRepositorio();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cidade = new CidadeDto(rs.getInt("cidade_id"),
                        rs.getString("cidade"),
                        p.getRegistroPorId(rs.getInt("pais_id")),
                        rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidade;
    }

    @Override
    public List<CidadeDto> getListaTodos() {
        List<CidadeDto> cidades = new LinkedList<CidadeDto>();
        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao FROM cidade";
        PaisDto pais = null;
        PaisRepositorio p = new PaisRepositorio();
        try {
            
            PreparedStatement ps = getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
              pais= new PaisDto(rs.getInt("pais_id"));
                
                cidades.add(new CidadeDto(
                        rs.getInt("cidade_id"),
                        rs.getString("cidade"),
                        pais,
                        rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidades;
    }
}
