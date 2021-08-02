package model.DAO;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import model.DAO.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.bo.Bairro;

public class BairroDAO implements InterfaceDAO<Bairro> {

    @Override
    public void Create(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO bairro (descricao) VALUES (?)";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Bairro> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idBairro, descricao FROM bairro";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Bairro> bairros = new ArrayList<Bairro>();
            
            while(rs.next()) {
                Bairro bairro = new Bairro();
                bairro.setIdBairro(rs.getInt("idBairro"));
                bairro.setDescricao(rs.getString("descricao"));
                bairros.add(bairro);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return bairros;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public Bairro Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idBairro, descricao FROM bairro WHERE IdBairro = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Bairro bairro = new Bairro();
                            
            while(rs.next()) {
                bairro.setIdBairro(rs.getInt("idBairro"));
                bairro.setDescricao(rs.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return bairro;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public void Update(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE bairro SET descricao = ? WHERE IdBairro = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getIdBairro());
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM bairro WHERE IdBairro = ?";
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
