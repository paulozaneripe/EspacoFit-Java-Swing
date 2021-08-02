package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.*;
import model.bo.Cidade;
import service.CidadeService;
import view.TelaBuscaCidade;

public class ControllerBuscaCidade implements ActionListener {

    TelaBuscaCidade buscaCidade = new TelaBuscaCidade(null, true);
    public static int codigo;
    
    public ControllerBuscaCidade(TelaBuscaCidade telaCid) {
        this.buscaCidade = telaCid;
        
        this.buscaCidade.getjBotaoCarregar().addActionListener(this);
        this.buscaCidade.getjBotaoDeletar().addActionListener(this);
        this.buscaCidade.getjBotaoSair().addActionListener(this);
        
        List<Cidade> listaCidades = new ArrayList<>();
        
        listaCidades = service.CidadeService.Buscar();
        
        DefaultTableModel tabela = (DefaultTableModel) this.buscaCidade.getjTable1().getModel();
        
        for(Cidade cidadeAtual : listaCidades) {
            tabela.addRow(new Object[]{cidadeAtual.getIdCidade(),cidadeAtual.getDescricao()});
        }
        
        this.buscaCidade.getjTable1().setModel(tabela);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaCidade.getjBotaoCarregar()){
            ControllerCidade.codigo = (int) this.buscaCidade.getjTable1().getValueAt(this.buscaCidade.getjTable1().getSelectedRow(), 0);
            this.buscaCidade.dispose();
        }
        
        if(e.getSource() == this.buscaCidade.getjBotaoDeletar()){
            int id = (int) this.buscaCidade.getjTable1().getValueAt(this.buscaCidade.getjTable1().getSelectedRow(), 0);
            CidadeService.Deletar(id);
            
            List<Cidade> listaCidades = new ArrayList<>();
        
            listaCidades = service.CidadeService.Buscar();
            
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCidade.getjTable1().getModel();
            
            tabela.setRowCount(0);
            
            for(Cidade cidadeAtual : listaCidades) {
                tabela.addRow(new Object[]{cidadeAtual.getIdCidade(),cidadeAtual.getDescricao()});
            }
        }
        
        if(e.getSource() == this.buscaCidade.getjBotaoSair()) {
            this.buscaCidade.dispose();
        }
    }
   
}
