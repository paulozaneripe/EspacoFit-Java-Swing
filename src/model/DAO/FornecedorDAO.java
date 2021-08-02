package model.DAO;

import java.sql.Connection;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DAO.ConnectionFactory;
import model.bo.Fornecedor;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    private Connection con = null;
    
    public FornecedorDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    @Override
    public void Create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO fornecedor (nome, razaoSocial, "
                           + "cnpj, inscEstadual, compleEndereco, "
                           + "fone1, fone2, email, "
                           + "observacao, Cep_idCep, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getRazaoSocial());
            pstm.setString(3, objeto.getCnpj());
            pstm.setString(4, objeto.getInscEstadual());
            pstm.setString(5, objeto.getCompleEndereco());
            pstm.setString(6, objeto.getFone1());
            pstm.setString(7, objeto.getFone2());
            pstm.setString(8, objeto.getEmail());
            pstm.setString(9, objeto.getObservacao());
            pstm.setInt(10, objeto.getCep_idCep());
            pstm.setBoolean(11, true);
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace(); 
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Fornecedor> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idFornecedor, nome, razaoSocial, cnpj, "
                           + "inscEstadual, compleEndereco, fone1, "
                           + "fone2, email, observacao, Cep_idCep FROM fornecedor ";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
            
            while(rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("idFornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setInscEstadual(rs.getString("inscEstadual"));
                fornecedor.setCompleEndereco(rs.getString("compleEndereco"));
                fornecedor.setFone1(rs.getString("fone1"));
                fornecedor.setFone2(rs.getString("fone2"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setObservacao(rs.getString("observacao"));
                fornecedor.setCep_idCep(rs.getInt("Cep_idCep"));
                
                fornecedores.add(fornecedor);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return fornecedores;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public Fornecedor Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idFornecedor, nome, razaoSocial, cnpj, "
                           + "inscEstadual, compleEndereco, fone1, "
                           + "fone2, email, observacao, Cep_idCep FROM fornecedor "
                           + "WHERE idFornecedor = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Fornecedor fornecedor = new Fornecedor();
            
            while(rs.next()) {
                fornecedor.setId(rs.getInt("idFornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setInscEstadual(rs.getString("inscEstadual"));
                fornecedor.setCompleEndereco(rs.getString("compleEndereco"));
                fornecedor.setFone1(rs.getString("fone1"));
                fornecedor.setFone2(rs.getString("fone2"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setObservacao(rs.getString("observacao"));
                fornecedor.setCep_idCep(rs.getInt("Cep_idCep"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return fornecedor;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public void Update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE fornecedor SET nome = ?, razaoSocial = ?, "
                           + "cnpj = ?, inscEstadual = ?, compleEndereco = ?, "
                           + "fone1 = ?, fone2 = ?, email = ?, "
                           + "observacao = ?, Cep_idCep = ? WHERE idFornecedor = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getRazaoSocial());
            pstm.setString(3, objeto.getCnpj());
            pstm.setString(4, objeto.getInscEstadual());
            pstm.setString(5, objeto.getCompleEndereco());
            pstm.setString(6, objeto.getFone1());
            pstm.setString(7, objeto.getFone2());
            pstm.setString(8, objeto.getEmail());
            pstm.setString(9, objeto.getObservacao());
            pstm.setInt(10, objeto.getCep_idCep());
            pstm.setInt(11, objeto.getId());
            pstm.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace(); 
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM fornecedor WHERE IdFornecedor = ?";
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
