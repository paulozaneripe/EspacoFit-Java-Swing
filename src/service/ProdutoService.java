package service;

import model.DAO.ProdutoDAO;
import model.bo.Produto;
import java.util.List;

public class ProdutoService {

    public static void Incluir(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.Create(objeto);
    }

    public static void Atualizar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.Update(objeto);
    }

    public static List<Produto> Buscar() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return (produtoDAO.Retrieve());
    }

    public static Produto Buscar(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.Retrieve(id);
    }

    public static Produto Buscar(String barra) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.Retrieve(barra);
    }
    
    public static void Deletar(int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.Delete(id);
    }
}