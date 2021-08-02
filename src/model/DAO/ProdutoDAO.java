package model.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.bo.Produto;

public class ProdutoDAO implements InterfaceDAO<Produto> {

    @Override
    public void Create(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "INSERT INTO produto(descricao, valor, quantidadeEstoque, barra, observacao, status) VALUES (?,?,?,?,?,?)";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setFloat(2, objeto.getValor());
            pstm.setInt(3, objeto.getQuantidadeEstoque());
            pstm.setString(4, objeto.getBarra());
            pstm.setString(5, objeto.getObservacao());
            pstm.setBoolean(6, true);
            pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Produto> Retrieve() {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "SELECT idProduto, descricao, valor, quantidadeEstoque, barra, status, observacao FROM produto";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rs = pstm.executeQuery();

            List<Produto> produtos = new ArrayList();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setBarra(rs.getString("barra"));
                produto.setObservacao(rs.getString("observacao"));
                produto.setStatus(rs.getBoolean("status"));

                produtos.add(produto);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return produtos;
        } catch (Exception ex) {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public Produto Retrieve(int id) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "SELECT idProduto, descricao, undCompra, undVenda, " + 
                "correlacaoUnd, valor, quantidadeEstoque, barra, observacao, status" + 
                " FROM produto WHERE idProduto = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Produto produto = new Produto();

            while (rs.next()) {

                produto.setId(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setUndCompra(rs.getString("undCompra"));
                produto.setUndVenda(rs.getString("undVenda"));
                produto.setCorrelacaoUnd(rs.getInt("correlacaoUnd"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setBarra(rs.getString("barra"));
                produto.setObservacao(rs.getString("observacao"));
                produto.setStatus(rs.getBoolean("status"));
            }

            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return produto;

        } catch (Exception ex) {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }
    
        public Produto Retrieve(String barra) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "SELECT * FROM produto WHERE barra = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, barra);
            rs = pstm.executeQuery();
            Produto produto = new Produto();

            while (rs.next()) {

                produto.setId(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                produto.setBarra(rs.getString("barra"));
                produto.setObservacao(rs.getString("observacao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return produto;

        } catch (Exception ex) {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
            return null;
        }
    }

    @Override
    public void Update(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "UPDATE produto SET descricao = ?, valor = ?, quantidadeEstoque = ?, barra = ?, observacao = ?, status = ? WHERE IdProduto = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setFloat(2, objeto.getValor());
            pstm.setInt(3, objeto.getQuantidadeEstoque());
            pstm.setString(4, objeto.getBarra());
            pstm.setString(5, objeto.getObservacao());
            pstm.setBoolean(6, objeto.isStatus());
            pstm.setInt(7, objeto.getId());
            pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void Delete(int id) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "DELETE FROM produto WHERE IdProduto = ? ";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(0, id);
            pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(conexao, pstm);
    }
}
