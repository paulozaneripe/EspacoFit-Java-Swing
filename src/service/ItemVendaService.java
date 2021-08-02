
package service;
import java.util.List;
import model.bo.ItemVenda;
import model.DAO.ItemVendaDAO;


public class ItemVendaService {
    public static void Incluir(ItemVenda objeto) {
        ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
        itemVendaDAO.Create(objeto);
    }
    
    public static void Atualizar(ItemVenda objeto) {
        ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
        itemVendaDAO.Update(objeto);
    }
    
    public static List<ItemVenda> Buscar(){
        ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
        return itemVendaDAO.Retrieve();
    }
    
    public static ItemVenda Buscar(int id){
        ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
        return itemVendaDAO.Retrieve(id);
    }
    
    public static void Deletar(int id) {
        ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
        itemVendaDAO.Delete(id);
    }
}
