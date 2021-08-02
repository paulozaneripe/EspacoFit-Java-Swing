package model.DAO;

import java.sql.Connection;
import java.util.List;
import model.DAO.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.bo.Cep;

public class CepDAO implements InterfaceDAO<Cep>{

    private Connection con = null;
    
    public CepDAO() {
        con = ConnectionFactory.getConnection();
    }

    @Override
    public void Create(Cep objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cep (Cidade_idCidade, "
                           + "Bairro_idBairro, cep, logradouro, "
                           + "observacao, status) VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getIdCidade());
            pstm.setInt(2, objeto.getIdBairro());
            pstm.setString(3, objeto.getCep());
            pstm.setString(4, objeto.getLogradouro());
            pstm.setString(5, objeto.getObservacao());
            pstm.setBoolean(6, objeto.isStatus());
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace(); 
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Cep> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idCep, Cidade_idCidade, "
                           + "Bairro_idBairro, cep, logradouro, "
                           + "observacao, status FROM cep";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Cep> ceps = new ArrayList<Cep>();
            
            while(rs.next()) {
                Cep cep = new Cep();
                cep.setIdCep(rs.getInt("idCep"));
                cep.setLogradouro(rs.getString("logradouro"));
                cep.setObservacao(rs.getString("observacao"));
                cep.setStatus(rs.getBoolean("status"));
                cep.setCep(rs.getString("cep"));
                cep.setIdBairro(rs.getInt("Bairro_idBairro"));
                cep.setIdCidade(rs.getInt("Cidade_idCidade"));
                
                ceps.add(cep);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return ceps;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public Cep Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idCep, cep, logradouro, "
                           + "Cidade_idCidade, Bairro_idBairro, "
                           + "observacao, status FROM cep WHERE idCep = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Cep cep = new Cep();
            
            while(rs.next()) {
                cep.setIdCep(rs.getInt("idCep"));
                cep.setCep(rs.getString("cep"));
                cep.setLogradouro(rs.getString("logradouro"));
                cep.setIdBairro(rs.getInt("Bairro_idBairro"));
                cep.setIdCidade(rs.getInt("Cidade_idCidade"));
                cep.setObservacao(rs.getString("observacao"));
                cep.setStatus(rs.getBoolean("status"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return cep;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public void Update(Cep objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE cep SET cep = ?, logradouro = ?, "
                           + "Cidade_idCidade = ?, Bairro_idBairro = ?, "
                           + "observacao = ?, status = ? WHERE idCep = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setInt(3, objeto.getIdCidade());
            pstm.setInt(4, objeto.getIdBairro());
            pstm.setString(5, objeto.getObservacao());
            pstm.setBoolean(6, objeto.isStatus());
            pstm.setInt(7, objeto.getIdCep());
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM cep WHERE IdCep = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }
}
