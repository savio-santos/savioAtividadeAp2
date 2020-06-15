/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.infra.repositorios;

import frb.edu.br.savio.infra.data.DaoUtil;
import frb.edu.br.savio.dominio.contratos.IPais;
import frb.edu.br.savio.dominio.entidades.PaisDto;
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
public class PaisRepositorio extends DaoUtil implements IPais {

    public PaisRepositorio() {
        super();
    }

    @Override
    public boolean incluir(PaisDto pais) {

        String sql = "INSERT INTO pais (pais)"
                + " VALUES (?)";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, pais.getNome_pais());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret > 0;
    }

    @Override
    public boolean alterar(PaisDto pais) {

        String sql = "UPDATE pais SET pais=?"
                + "WHERE pais_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, pais.getNome_pais());
            ps.setInt(2, pais.getPais_id());
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret > 0;

    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM pais WHERE pais_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public PaisDto getRegistroPorId(int id) {
        PaisDto pais = null;
        String sql = "SELECT* FROM pais WHERE pais_id=?";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                pais = new PaisDto(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3));
            }
            rs.close();
            ps.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);

        }
        return pais;
    }

    @Override
    public List<PaisDto> getListaTodos() {
        List<PaisDto> paises = new LinkedList<PaisDto>();
        String sql = "SELECT* FROM pais";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paises.add(new PaisDto(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3)));
            }
            rs.close();
            ps.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
             
        }
        return paises;
    }
}
