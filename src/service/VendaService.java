
package service;
import model.DAO.VendaDAO;
import model.bo.Venda;
import java.util.List;

public class VendaService {
    public static void Incluir(Venda objeto){
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.Create(objeto);
    }
    
    public static void Atualizar(Venda objeto){
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.Update(objeto);
    }
    
    public static List<Venda> Buscar(){
        VendaDAO vendaDAO = new VendaDAO();
        return (vendaDAO.Retrieve());
    }
    
    public static Venda Buscar(int id){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.Retrieve(id);
    }
}
