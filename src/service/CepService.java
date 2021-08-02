package service;

import java.util.List;
import model.bo.Cep;
import model.DAO.CepDAO;

public class CepService {
    public static void Incluir(Cep objeto) {
        CepDAO cepDAO = new CepDAO();
        cepDAO.Create(objeto);
    }
    
    public static void Atualizar(Cep objeto) {
        CepDAO cepDAO = new CepDAO();
        cepDAO.Update(objeto);
    }
    
    public static List<Cep> Buscar(){
        CepDAO cepDAO = new CepDAO();
        return cepDAO.Retrieve();
    }
    
    public static Cep Buscar(int id){
        CepDAO cepDAO = new CepDAO();
        return cepDAO.Retrieve(id);
    }
    
    public static void Deletar(int id) {
        CepDAO cepDAO = new CepDAO();
        cepDAO.Delete(id);
    }
}
