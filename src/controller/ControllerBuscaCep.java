
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaCep;
import model.bo.Cep;
import model.bo.Cidade;
import model.bo.Bairro;
import service.BairroService;
import service.CepService;
import service.CidadeService;
import utils.ControllerUtils;

public class ControllerBuscaCep implements ActionListener{
    
    TelaBuscaCep buscaCep = new TelaBuscaCep(null, true);
    
    public ControllerBuscaCep(TelaBuscaCep buscaCep){
        this.buscaCep = buscaCep;
        
        this.buscaCep.getjBotaoCarregar().addActionListener(this);
        this.buscaCep.getjBotaoDeletar().addActionListener(this);
        this.buscaCep.getjBotaoSair().addActionListener(this);
        
        List<Cep> listaCeps = new ArrayList<>();
        
        listaCeps = CepService.Buscar();
        
        DefaultTableModel tabela = (DefaultTableModel) this.buscaCep.getjTable1().getModel();
        
        for(Cep cepDaLista : listaCeps){
            Cidade cidade = new Cidade();
            cidade = CidadeService.Buscar(cepDaLista.getIdCidade());
            
            Bairro bairro = new Bairro();
            bairro = BairroService.Buscar(cepDaLista.getIdBairro());
            
            tabela.addRow(new Object[]{
                cepDaLista.getIdCep(), 
                ControllerUtils.formatString(cepDaLista.getCep(),"#####-###"), 
                cepDaLista.getLogradouro(), 
                cidade.getDescricao(), 
                bairro.getDescricao(), 
                cepDaLista.getObservacao()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaCep.getjBotaoCarregar()){
            ControllerCep.codigo = (int) this.buscaCep.getjTable1().getValueAt(this.buscaCep.getjTable1().getSelectedRow(), 0);
            this.buscaCep.dispose();
        }
        
        if(e.getSource() == this.buscaCep.getjBotaoDeletar()){
            int id = (int) this.buscaCep.getjTable1().getValueAt(this.buscaCep.getjTable1().getSelectedRow(), 0);
            CepService.Deletar(id);
            
            List<Cep> listaCeps = new ArrayList<>();
            
            listaCeps = service.CepService.Buscar();
        
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCep.getjTable1().getModel();
            
            tabela.setRowCount(0);
        
            for(Cep cepDaLista : listaCeps){
                Cidade cidade = new Cidade();
                cidade = CidadeService.Buscar(cepDaLista.getIdCidade());

                Bairro bairro = new Bairro();
                bairro = BairroService.Buscar(cepDaLista.getIdBairro());

                tabela.addRow(new Object[]{cepDaLista.getIdCep(), cepDaLista.getCep(), cepDaLista.getLogradouro(), cidade.getDescricao(), bairro.getDescricao(), cepDaLista.getObservacao()});
            }
            
        }
        
        if(e.getSource() == this.buscaCep.getjBotaoSair()){
            this.buscaCep.dispose();
        }
    }
}
