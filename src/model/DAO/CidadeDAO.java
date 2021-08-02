package model.DAO;

import static java.lang.System.out;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import model.DAO.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.bo.Cidade;

public class CidadeDAO implements InterfaceDAO<Cidade> {

    @Override
    public void Create(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cidade (descricao) VALUES (?)";
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
    public List<Cidade> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idCidade, descricao FROM cidade";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Cidade> cidades = new ArrayList<Cidade>();
            
            while(rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setDescricao(rs.getString("descricao"));
                cidades.add(cidade);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return cidades;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public Cidade Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idCidade, descricao FROM cidade WHERE IdCidade = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Cidade cidade = new Cidade();
                            
            while(rs.next()) {
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setDescricao(rs.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return cidade;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public void Update(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE cidade SET descricao = ? WHERE IdCidade = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getIdCidade());
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM cidade WHERE IdCidade = ?";
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
