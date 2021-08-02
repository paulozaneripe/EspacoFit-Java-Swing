package model.DAO;

import java.beans.Statement;
import java.util.List;
import model.bo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

public class VendaDAO implements InterfaceDAO<Venda> {

    @Override
    public void Create(Venda objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        String hour = hours + ":" + minutes;
        String sqlExecutar = "INSERT INTO `venda`(`Personal_idPersonal`, `Aluno_idAluno`, `data`, `hora`, `valorTotal`, `cidadeAluno`, `bairroAluno`, `emailAluno`, `status`) VALUES (?,?,?,?,?,?,?,?,?)";

        PreparedStatement pstm = null;

        try {
            Venda venda = new Venda();
            pstm = conexao.prepareStatement(sqlExecutar, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, objeto.getIdPersonal());
            pstm.setInt(2, objeto.getIdAluno());
            pstm.setString(3, date.toString());
            pstm.setString(4, hour);
            pstm.setFloat(5, objeto.getValorTotal());
            pstm.setString(6, objeto.getCidadeAluno());
            pstm.setString(7, objeto.getBairroAluno());
            pstm.setString(8, objeto.getEmailAluno());
            pstm.setBoolean(9, true);
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
                objeto.setId(generatedKey);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Venda> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "SELECT idVendas, Aluno_idAluno, Personal_idPersonal, data, hora, valorTotal, observacao FROM VENDA";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();

            List<Venda> vendas = new ArrayList();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("idVendas"));
                venda.setData(rs.getString("data"));
                venda.setHora(rs.getString("hora"));
                venda.setValorTotal(rs.getFloat("valorTotal"));
                venda.setObservacao(rs.getString("observacao"));

                venda.setIdAluno(rs.getInt("Aluno_idAluno"));

                venda.setIdPersonal(rs.getInt("Personal_idPersonal"));

                vendas.add(venda);
            }

            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return vendas;

        } catch (Exception ex) {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Venda Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "SELECT idVendas, data, hora, valorTotal, observacao FROM VENDA WHERE idVenda = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(0, id);
            rs = pstm.executeQuery();
            Venda venda = new Venda();

            while (rs.next()) {

                venda.setId(rs.getInt("id"));
                venda.setData(rs.getString("data"));
                venda.setHora(rs.getString("hora"));
                venda.setValorTotal(rs.getFloat("valorTotal"));
                venda.setObservacao(rs.getString("observacao"));
            }

            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return venda;

        } catch (Exception ex) {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public void Update(Venda objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "UPDATE Venda SET data = ?, hora = ?, valorTotal = ?, observacao = ? WHERE IDVENDA = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getData());
            pstm.setString(2, objeto.getHora());
            pstm.setFloat(3, objeto.getValorTotal());
            pstm.setString(4, objeto.getObservacao());
            pstm.setInt(5, objeto.getId());
            pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
                Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM venda WHERE IdVendas = ?";
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
