/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.savio.infra.repositorios;

import frb.edu.br.savio.dominio.contratos.IEndereco;
import frb.edu.br.savio.dominio.entidades.EnderecoDto;
import frb.edu.br.savio.dominio.entidades.CidadeDto;
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
public class EnderecoRepositorio extends DaoUtil implements IEndereco {

    public EnderecoRepositorio() {
        super();
    }

    @Override
    public boolean incluir(EnderecoDto endereco) {
        String sql = "INSERT INTO endereco (endereco_id, endereco, endereco2, bairro, cidade_id, cep, telefone) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?) ";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, endereco.getEndereco_id());
            ps.setString(2, endereco.getEndereco());
            ps.setString(3, endereco.getEndereco2());
            ps.setString(4, endereco.getBairro());
            ps.setInt(5, endereco.getCidade().getCidade_id());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getTelefone());

            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;

    }

    @Override
    public boolean alterar(EnderecoDto endereco) {
        String sql = "UPDATE endereco SET endereco=?, endereco2=?, bairro=?, cidade_id=?, cep=?, telefone=?"
                + " WHERE endereco_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);

            ps.setString(1, endereco.getEndereco());
            ps.setString(2, endereco.getEndereco2());
            ps.setString(3, endereco.getBairro());
            ps.setInt(4, endereco.getCidade().getCidade_id());
            ps.setString(5, endereco.getCep());
            ps.setString(6, endereco.getTelefone());
            ps.setInt(7, endereco.getEndereco_id());
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM endereco "
                + " WHERE endereco_id= ?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public EnderecoDto getRegistroPorId(int id) {
        EnderecoDto endereco = new EnderecoDto();
        String sql = "SELECT endereco_id, endereco, endereco2, bairro, cidade_id, cep, telefone, ultima_atualizacao"
                + " FROM endereco WHERE endereco_id =?";
        CidadeRepositorio cid = new CidadeRepositorio();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                    CidadeDto cidade = cid.getRegistroPorId(rs.getInt(5));            
                endereco = new EnderecoDto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        cidade,
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8));
            }
            ps.close();
            rs.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

    @Override
    public List<EnderecoDto> getListaTodos() {
        List<EnderecoDto> enderecos = new LinkedList<EnderecoDto>();
        String sql = "SELECT endereco_id, endereco, endereco2, bairro, cidade_id, cep, telefone, ultima_atualizacao"
                + " FROM endereco";
        CidadeRepositorio cid = new CidadeRepositorio();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                    CidadeDto cidade = cid.getRegistroPorId(rs.getInt(5));
                enderecos.add(new EnderecoDto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        cidade,
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8))
                );
            }
            ps.close();
            rs.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enderecos;
    }

}