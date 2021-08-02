
package model.DAO;
import java.util.List;
import model.bo.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemVendaDAO implements InterfaceDAO<ItemVenda> {

    @Override
    public void Create(ItemVenda objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = "INSERT INTO itemvenda (Venda_idVendas, Produto_idProduto, qtdItem, valorUnitario, status) VALUES(?,?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getIdVenda());
            pstm.setInt(2, objeto.getIdProduto());
            pstm.setInt(3, objeto.getQtdItemVenda());
            pstm.setFloat(4, objeto.getValorUnitario());
            pstm.setBoolean(5, true);
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<ItemVenda> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        
      String sqlExecutar = "SELECT idItemVenda, Venda_idVendas, Produto_idProduto, " 
                           + "qtdItem, valorUnitario, status, observacao FROM itemvenda";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
          pstm = conexao.prepareStatement(sqlExecutar);
          rs = pstm.executeQuery();
          
          List<ItemVenda> Itens = new ArrayList();
          
          while(rs.next()){
              ItemVenda itemVenda = new ItemVenda ();
              itemVenda.setId(rs.getInt("idItemVenda"));
              itemVenda.setQtdItemVenda(rs.getInt("qtdItem"));
              itemVenda.setValorUnitario(rs.getInt("valorUnitario"));
              itemVenda.setStatus(rs.getString("status"));
              itemVenda.setObservacao(rs.getString("observacao"));                      
              itemVenda.setIdVenda(rs.getInt("Venda_idVendas"));           
              itemVenda.setIdProduto(rs.getInt("Produto_idProduto"));
              
              Itens.add(itemVenda);
          }
          
          ConnectionFactory.closeConnection(conexao, pstm, rs);
          return Itens;
          
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
    }

    @Override
    public ItemVenda Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();
        
      String sqlExecutar = "SELECT idItemVenda, qtdItem, valorUnitario, status, observacao FROM ITEMVENDA WHERE idItemVenda = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
          pstm = conexao.prepareStatement(sqlExecutar);
          pstm.setInt(0, id);
          rs = pstm.executeQuery();
          ItemVenda itemVenda = new ItemVenda();
                   
          while(rs.next()){
              
              itemVenda.setId(rs.getInt("idItemVenda"));
              itemVenda.setQtdItemVenda(rs.getInt("qtdItem"));
              itemVenda.setValorUnitario(rs.getInt("valorUnitario"));
              itemVenda.setStatus(rs.getString("status"));
              itemVenda.setObservacao(rs.getString("observacao"));  
          }
          
          ConnectionFactory.closeConnection(conexao, pstm, rs);
          return itemVenda;
          
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
    }

    @Override
    public void Update(ItemVenda objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = "UPDATE itemvenda SET qtdItem = ?, valorUnitario = ?, status = ?, observacao = ? WHERE idItemVenda = ?";
        
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getQtdItemVenda());
            pstm.setFloat(2, objeto.getValorUnitario());
            pstm.setString(3, objeto.getStatus());
            pstm.setString(4, objeto.getObservacao());
            pstm.setInt(5, objeto.getId());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
       Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = "DELETE FROM itemvenda WHERE idItemVenda = ? ";
        
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
