package model.DAO;
import java.util.List;
import model.bo.Receber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReceberDAO implements InterfaceDAO<Receber>{

    @Override
    public void Create(Receber objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        
        String sqlExecutar = "INSERT INTO receber (Venda_idVendas, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, status) VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getIdVenda());
            pstm.setString(2, date.toString());
            pstm.setString(3, objeto.getDataVencimento());
            pstm.setString(4, objeto.getDataPagamento());
            pstm.setFloat(5, objeto.getValorEmitido());
            pstm.setFloat(6, objeto.getValorDesconto());
            pstm.setFloat(7, objeto.getValorAcrescimo());
            pstm.setFloat(8, objeto.getValorPago());
            pstm.setBoolean(9, true);
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Receber> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        
      String sqlExecutar = "SELECT (idReceber, Venda_idVendas, dataEmissao, valorEmitido, dataVencimento, dataPagamento, valorDesconto, valorAcrescimo, valorPago) FROM receber";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
          pstm = conexao.prepareStatement(sqlExecutar);
          rs = pstm.executeQuery();
          
          List<Receber> Recebimentos = new ArrayList();
          
          while(rs.next()){
              Receber receber = new Receber();
              
              receber.setId(rs.getInt("idReceber"));
              receber.setIdVenda(rs.getInt("Venda_idVendas"));
              receber.setDataEmissao(rs.getString("dataEmissao"));
              receber.setDataVencimento(rs.getString("dataVencimento"));
              receber.setDataPagamento(rs.getString("dataPagamento"));
              receber.setValorEmitido(rs.getFloat("valorEmitido"));
              receber.setValorDesconto(rs.getFloat("valorDesconto"));
              receber.setValorAcrescimo(rs.getFloat("valorAcrescimo"));
              receber.setValorPago(rs.getFloat("valorPago"));          
              
              Recebimentos.add(receber);
          }
          
          ConnectionFactory.closeConnection(conexao, pstm, rs);
          return Recebimentos;
          
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
    }

    @Override
    public Receber Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        
      String sqlExecutar = "SELECT (idReceber, Venda_idVendas, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, observacao) FROM receber WHERE idReceber = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
          pstm = conexao.prepareStatement(sqlExecutar);
          pstm.setInt(0, id);
          rs = pstm.executeQuery();
          Receber receber = new Receber();
                   
          while(rs.next()){
              
              receber.setId(rs.getInt("idReceber"));
              receber.setIdVenda(rs.getInt("Venda_idVendas"));
              receber.setDataEmissao(rs.getString("dataEmissao"));
              receber.setDataVencimento(rs.getString("dataVencimento"));
              receber.setDataPagamento(rs.getString("dataPagamento"));
              receber.setValorEmitido(rs.getFloat("valorEmitido"));
              receber.setValorDesconto(rs.getFloat("valorDesconto"));
              receber.setValorAcrescimo(rs.getFloat("valorAcrescimo"));
              receber.setValorPago(rs.getFloat("valorPago"));
              receber.setObservacao(rs.getString("observacao"));
              
          }
          
          ConnectionFactory.closeConnection(conexao, pstm, rs);
          return receber;
          
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
    }

    @Override
    public void Update(Receber objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = "UPDATE receber SET (Venda_idVendas, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, observacao) WHERE IdReceber = ?";
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getIdVenda());
            pstm.setString(2, objeto.getDataEmissao());
            pstm.setString(3, objeto.getDataVencimento());
            pstm.setString(4, objeto.getDataPagamento());
            pstm.setFloat(5, objeto.getValorEmitido());
            pstm.setFloat(6, objeto.getValorDesconto());
            pstm.setFloat(7, objeto.getValorAcrescimo());
            pstm.setFloat(8, objeto.getValorPago());
            pstm.setString(9, objeto.getObservacao());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = "DELETE FROM receber WHERE IdReceber = ? ";
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }
    
}
