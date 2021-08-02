package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.TelaBuscaPersonal;
import model.bo.Personal;
import model.bo.Cep;
import service.PersonalService;
import service.CepService;
import utils.ControllerUtils;

public class ControllerBuscaPersonal implements ActionListener {
    
    TelaBuscaPersonal buscaPersonal = new TelaBuscaPersonal(null, true);
    
    public ControllerBuscaPersonal(TelaBuscaPersonal buscaPersonal){
        this.buscaPersonal = buscaPersonal;
        
        this.buscaPersonal.getjBotaoCarregar().addActionListener(this);
        this.buscaPersonal.getjBotaoDeletar().addActionListener(this);
        this.buscaPersonal.getjBotaoSair().addActionListener(this);
        
        List<Personal> listaPersonals = new ArrayList<>();
        
        listaPersonals = PersonalService.Buscar();
        
        DefaultTableModel tabela = (DefaultTableModel) this.buscaPersonal.getjTable1().getModel();
        
        for(Personal personalDaLista : listaPersonals){
            Cep cep = new Cep();
            cep = CepService.Buscar(personalDaLista.getCep_idCep());
            
            tabela.addRow(new Object[]{
                personalDaLista.getId(),
                personalDaLista.getNome(),
                ControllerUtils.formatString(personalDaLista.getRg(),"##.###.###-#"),
                ControllerUtils.formatString(personalDaLista.getCpf(),"###.###.###-##"),
                ControllerUtils.filtrarData(personalDaLista.getDtNascimento()),
                ControllerUtils.formatString(cep.getCep(),"#####-###"),
                personalDaLista.getCompleEndereco(),
                personalDaLista.getEmail(),
                ControllerUtils.formatString(personalDaLista.getFone1(),"(##) #####-####"),
                ControllerUtils.formatString(personalDaLista.getFone2(),"(##) #####-####"),
                personalDaLista.getObservacao()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaPersonal.getjBotaoCarregar()){
            ControllerPersonal.codigo = (int) this.buscaPersonal.getjTable1().getValueAt(this.buscaPersonal.getjTable1().getSelectedRow(), 0);
            ControllerFaturamento.codigo = (int) this.buscaPersonal.getjTable1().getValueAt(this.buscaPersonal.getjTable1().getSelectedRow(), 0);
            this.buscaPersonal.dispose();
        }
        
        if(e.getSource() == this.buscaPersonal.getjBotaoDeletar()){
            int id = (int) this.buscaPersonal.getjTable1().getValueAt(this.buscaPersonal.getjTable1().getSelectedRow(), 0);
            PersonalService.Deletar(id);
            
            List<Personal> listaPersonals = new ArrayList<>();
            
            listaPersonals = service.PersonalService.Buscar();
        
            DefaultTableModel tabela = (DefaultTableModel) this.buscaPersonal.getjTable1().getModel();
            
            tabela.setRowCount(0);
        
            for(Personal personalDaLista : listaPersonals){
                Cep cep = new Cep();
                cep = CepService.Buscar(personalDaLista.getCep_idCep());

                tabela.addRow(new Object[]{
                    personalDaLista.getId(),
                    personalDaLista.getNome(),
                    ControllerUtils.formatString(personalDaLista.getRg(),"##.###.###-#"),
                    ControllerUtils.formatString(personalDaLista.getCpf(),"###.###.###-##"),
                    ControllerUtils.filtrarData(personalDaLista.getDtNascimento()),
                    ControllerUtils.formatString(cep.getCep(),"#####-###"),
                    personalDaLista.getCompleEndereco(),
                    personalDaLista.getEmail(),
                    ControllerUtils.formatString(personalDaLista.getFone1(),"(##) #####-####"),
                    ControllerUtils.formatString(personalDaLista.getFone2(),"(##) #####-####"),
                    personalDaLista.getObservacao()
                });
            }
            
        }
        
        if(e.getSource() == this.buscaPersonal.getjBotaoSair()){
            this.buscaPersonal.dispose();
        }
    }
}
