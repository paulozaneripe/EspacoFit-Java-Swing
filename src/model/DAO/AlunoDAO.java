package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DAO.ConnectionFactory;
import model.bo.Aluno;

public class AlunoDAO implements InterfaceDAO<Aluno> {

    private Connection con = null;
    
    public AlunoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    @Override
    public void Create(Aluno objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO aluno (nome, rg, "
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
    public List<Aluno> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idAluno, nome, rg, cpf, "
                           + "dtNascimento, compleEndereco, fone1, "
                           + "fone2, email, observacao, Cep_idCep FROM aluno ";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();
            
            List<Aluno> alunos = new ArrayList<Aluno>();
            
            while(rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDtNascimento(rs.getDate("dtNascimento"));
                aluno.setCompleEndereco(rs.getString("compleEndereco"));
                aluno.setFone1(rs.getString("fone1"));
                aluno.setFone2(rs.getString("fone2"));
                aluno.setEmail(rs.getString("email"));
                aluno.setObservacao(rs.getString("observacao"));
                aluno.setCep_idCep(rs.getInt("Cep_idCep"));
                
                alunos.add(aluno);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return alunos;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public Aluno Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT idAluno, nome, rg, cpf, "
                           + "dtNascimento, compleEndereco, fone1, "
                           + "fone2, email, observacao, Cep_idCep FROM aluno "
                           + "WHERE idAluno = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Aluno aluno = new Aluno();
            
            while(rs.next()) {
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDtNascimento(rs.getDate("dtNascimento"));
                aluno.setCompleEndereco(rs.getString("compleEndereco"));
                aluno.setFone1(rs.getString("fone1"));
                aluno.setFone2(rs.getString("fone2"));
                aluno.setEmail(rs.getString("email"));
                aluno.setObservacao(rs.getString("observacao"));
                aluno.setCep_idCep(rs.getInt("Cep_idCep"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return aluno;
            
        } catch(Exception ex) {
                ConnectionFactory.closeConnection(conexao, pstm, rs);
                return null;
        }
    }

    @Override
    public void Update(Aluno objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE aluno SET nome = ?, rg = ?, "
                           + "cpf = ?, dtNascimento = ?, compleEndereco = ?, "
                           + "fone1 = ?, fone2 = ?, email = ?, "
                           + "observacao = ?, Cep_idCep = ? WHERE idAluno = ?";
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
        String sqlExecutar = "DELETE FROM aluno WHERE IdAluno = ?";
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
