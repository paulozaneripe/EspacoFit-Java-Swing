
package service;
import model.DAO.ReceberDAO;
import model.bo.Receber;
import java.util.List;

public class ReceberService {
    public static void Incluir(Receber objeto){
        ReceberDAO receberDAO = new ReceberDAO();
        receberDAO.Create(objeto);
    }
    
    public static void Atualizar(Receber objeto){
        ReceberDAO receberDAO = new ReceberDAO();
        receberDAO.Update(objeto);
    }
    
    public static List<Receber> Buscar(){
        ReceberDAO receberDAO = new ReceberDAO();
        return (receberDAO.Retrieve());
    }
    
    public static Receber Buscar(int id){
        ReceberDAO receberDAO = new ReceberDAO();
        return receberDAO.Retrieve(id);
    }
}
