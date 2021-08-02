package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;
import model.bo.Bairro;
import service.BairroService;
import view.TelaBuscaBairro;

public class ControllerBuscaBairro implements ActionListener {

    TelaBuscaBairro buscaBairro = new TelaBuscaBairro(null, true);
    public static int codigo;
    
    public ControllerBuscaBairro(TelaBuscaBairro telaCid) {
        this.buscaBairro = telaCid;
        
        this.buscaBairro.getjBotaoCarregar().addActionListener(this);
        this.buscaBairro.getjBotaoDeletar().addActionListener(this);
        this.buscaBairro.getjBotaoSair().addActionListener(this);
        
        List<Bairro> listaBairros = new ArrayList<>();
        
        listaBairros = service.BairroService.Buscar();
        
        DefaultTableModel tabela = (DefaultTableModel) this.buscaBairro.getjTable1().getModel();
        
        for(Bairro bairroAtual : listaBairros) {
            tabela.addRow(new Object[]{bairroAtual.getIdBairro(),bairroAtual.getDescricao()});
        }
        
        this.buscaBairro.getjTable1().setModel(tabela);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaBairro.getjBotaoCarregar()) {
            ControllerBairro.codigo = (int) this.buscaBairro.getjTable1().getValueAt(this.buscaBairro.getjTable1().getSelectedRow(), 0);
            this.buscaBairro.dispose();
        }
        
        if(e.getSource() == this.buscaBairro.getjBotaoDeletar()){
            int id = (int) this.buscaBairro.getjTable1().getValueAt(this.buscaBairro.getjTable1().getSelectedRow(), 0);
            BairroService.Deletar(id);
            
            List<Bairro> listaBairros = new ArrayList<>();
        
            listaBairros = service.BairroService.Buscar();
            
            DefaultTableModel tabela = (DefaultTableModel) this.buscaBairro.getjTable1().getModel();
            
            tabela.setRowCount(0);
            
            for(Bairro bairroAtual : listaBairros) {
                tabela.addRow(new Object[]{bairroAtual.getIdBairro(),bairroAtual.getDescricao()});
            }
        }
        
        if(e.getSource() == this.buscaBairro.getjBotaoSair()) {
            this.buscaBairro.dispose();
        }
    }
   
}
