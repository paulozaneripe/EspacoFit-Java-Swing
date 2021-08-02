package model.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DAO.ConnectionFactory;
import model.bo.Personal;

public class PersonalDAO implements InterfaceDAO<Personal> {

    private Connection con = null;
    
    public PersonalDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    @Override
    public void Create(Personal objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO personal (nome, rg, "
                           + "cpf, dtNascimento, compleEndereco, "
                           + "fone1, fone2, email, "
                           + "observacao, Cep_idCep, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getRg());
            pstm.setString(3, objeto.getCpf());
            pstm.setDate(4, (Date) objeto.getDtNascimento());
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
    public List<Personal> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idPersonal, nome, rg, cpf, "
                           + "dtNascimento, compleEndereco, fone1, "
                           + "fone2, email, observacao, Cep_idCep FROM personal ";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Personal> personais = new ArrayList<Personal>();
            
            while(rs.next()) {
                Personal personal = new Personal();
                personal.setId(rs.getInt("idPersonal"));
                personal.setNome(rs.getString("nome"));
                personal.setRg(rs.getString("rg"));
                personal.setCpf(rs.getString("cpf"));
                personal.setDtNascimento(rs.getDate("dtNascimento"));
                personal.setCompleEndereco(rs.getString("compleEndereco"));
                personal.setFone1(rs.getString("fone1"));
                personal.setFone2(rs.getString("fone2"));
                personal.setEmail(rs.getString("email"));
                personal.setObservacao(rs.getString("observacao"));
                personal.setCep_idCep(rs.getInt("Cep_idCep"));
                
                personais.add(personal);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return personais;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public Personal Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idPersonal, nome, rg, cpf, "
                           + "dtNascimento, compleEndereco, fone1, "
                           + "fone2, email, observacao, Cep_idCep FROM personal "
                           + "WHERE idPersonal = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Personal personal = new Personal();
            
            while(rs.next()) {
                personal.setId(rs.getInt("idPersonal"));
                personal.setNome(rs.getString("nome"));
                personal.setRg(rs.getString("rg"));
                personal.setCpf(rs.getString("cpf"));
                personal.setDtNascimento(rs.getDate("dtNascimento"));
                personal.setCompleEndereco(rs.getString("compleEndereco"));
                personal.setFone1(rs.getString("fone1"));
                personal.setFone2(rs.getString("fone2"));
                personal.setEmail(rs.getString("email"));
                personal.setObservacao(rs.getString("observacao"));
                personal.setCep_idCep(rs.getInt("Cep_idCep"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return personal;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public void Update(Personal objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE personal SET nome = ?, rg = ?, "
                           + "cpf = ?, dtNascimento = ?, compleEndereco = ?, "
                           + "fone1 = ?, fone2 = ?, email = ?, "
                           + "observacao = ?, Cep_idCep = ? WHERE idPersonal = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getRg());
            pstm.setString(3, objeto.getCpf());
            pstm.setDate(4, (Date) objeto.getDtNascimento());
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
        String sqlExecutar = "DELETE FROM personal WHERE IdPersonal = ?";
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
