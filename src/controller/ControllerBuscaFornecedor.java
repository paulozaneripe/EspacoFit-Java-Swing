package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import view.TelaBuscaFornecedor;
import model.bo.Fornecedor;
import model.bo.Cep;
import service.FornecedorService;
import service.CepService;
import utils.ControllerUtils;

public class ControllerBuscaFornecedor implements ActionListener {
    
    TelaBuscaFornecedor buscaFornecedor = new TelaBuscaFornecedor(null, true);
    
    public ControllerBuscaFornecedor(TelaBuscaFornecedor buscaFornecedor){
        this.buscaFornecedor = buscaFornecedor;
        
        this.buscaFornecedor.getjBotaoCarregar().addActionListener(this);
        this.buscaFornecedor.getjBotaoDeletar().addActionListener(this);
        this.buscaFornecedor.getjBotaoSair().addActionListener(this);
        
        List<Fornecedor> listaFornecedors = new ArrayList<>();
        
        listaFornecedors = FornecedorService.Buscar();
        
        DefaultTableModel tabela = (DefaultTableModel) this.buscaFornecedor.getjTable1().getModel();
        
        for(Fornecedor fornecedorDaLista : listaFornecedors){
            Cep cep = new Cep();
            cep = CepService.Buscar(fornecedorDaLista.getCep_idCep());
            
            tabela.addRow(new Object[]{
                fornecedorDaLista.getId(),
                fornecedorDaLista.getNome(),
                ControllerUtils.formatString(fornecedorDaLista.getCnpj(),"##.###.###/####-##"),
                ControllerUtils.formatString(fornecedorDaLista.getInscEstadual(),"###.###.###.###"),
                fornecedorDaLista.getRazaoSocial(),
                ControllerUtils.formatString(cep.getCep(),"#####-###"),
                fornecedorDaLista.getCompleEndereco(),
                fornecedorDaLista.getEmail(),
                ControllerUtils.formatString(fornecedorDaLista.getFone1(),"(##) #####-####"),
                ControllerUtils.formatString(fornecedorDaLista.getFone2(),"(##) #####-####"),
                fornecedorDaLista.getObservacao()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buscaFornecedor.getjBotaoCarregar()){
            ControllerFornecedor.codigo = (int) this.buscaFornecedor.getjTable1().getValueAt(this.buscaFornecedor.getjTable1().getSelectedRow(), 0);
            this.buscaFornecedor.dispose();
        }
        
        if(e.getSource() == this.buscaFornecedor.getjBotaoDeletar()){
            int id = (int) this.buscaFornecedor.getjTable1().getValueAt(this.buscaFornecedor.getjTable1().getSelectedRow(), 0);
            FornecedorService.Deletar(id);
            
            List<Fornecedor> listaFornecedors = new ArrayList<>();
            
            listaFornecedors = service.FornecedorService.Buscar();
        
            DefaultTableModel tabela = (DefaultTableModel) this.buscaFornecedor.getjTable1().getModel();
            
            tabela.setRowCount(0);
        
            for(Fornecedor fornecedorDaLista : listaFornecedors){
                Cep cep = new Cep();
                cep = CepService.Buscar(fornecedorDaLista.getCep_idCep());

                tabela.addRow(new Object[]{
                    fornecedorDaLista.getId(),
                    fornecedorDaLista.getNome(),
                    ControllerUtils.formatString(fornecedorDaLista.getCnpj(),"##.###.###/####-##"),
                    ControllerUtils.formatString(fornecedorDaLista.getInscEstadual(),"###.###.###.###"),
                    fornecedorDaLista.getRazaoSocial(),
                    ControllerUtils.formatString(cep.getCep(),"#####-###"),
                    fornecedorDaLista.getCompleEndereco(),
                    fornecedorDaLista.getEmail(),
                    ControllerUtils.formatString(fornecedorDaLista.getFone1(),"(##) #####-####"),
                    ControllerUtils.formatString(fornecedorDaLista.getFone2(),"(##) #####-####"),
                    fornecedorDaLista.getObservacao()
                });
            }
        }
        
        if(e.getSource() == this.buscaFornecedor.getjBotaoSair()){
            this.buscaFornecedor.dispose();
        }
    }
}
