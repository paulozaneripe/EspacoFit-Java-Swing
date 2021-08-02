package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import model.bo.Fornecedor;
import model.bo.Cep;
import view.TelaBuscaFornecedor;
import view.TelaCadastroFornecedor;
import service.CepService;
import service.FornecedorService;
import utils.ControllerUtils;

public class ControllerFornecedor implements ActionListener, DocumentListener {
    TelaCadastroFornecedor telaFornecedor = new TelaCadastroFornecedor();
    public static int codigo;
    
    public ControllerFornecedor(TelaCadastroFornecedor telaCid) {
        this.telaFornecedor = telaCid;
        
        codigo = 0;
        
        Document doc = this.telaFornecedor.getjFormattedTextFieldCEP().getDocument();
        doc.addDocumentListener(this);
        
        this.telaFornecedor.getjBotaoNovo().addActionListener(this);
        this.telaFornecedor.getjBotaoCancelar().addActionListener(this);
        this.telaFornecedor.getjBotaoGravar().addActionListener(this);
        this.telaFornecedor.getjBotaoBuscar().addActionListener(this);
        this.telaFornecedor.getjBotaoSair().addActionListener(this);
        
        ControllerUtils.Ativa(true, this.telaFornecedor.getjPanelBotoes().getComponents());
        ControllerUtils.LimpaEstadoComponentes(false, this.telaFornecedor.getjPanelDados().getComponents());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaFornecedor.getjBotaoNovo()) {
            codigo = 0;
            ControllerUtils.Ativa(false, this.telaFornecedor.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(true, this.telaFornecedor.getjPanelDados().getComponents());
            this.telaFornecedor.getjTextFieldID().setEnabled(false);
            this.telaFornecedor.getjTextFieldCidade().setEnabled(false);
            this.telaFornecedor.getjTextFieldBairro().setEnabled(false);
            this.telaFornecedor.getjTextFieldLogradouro().setEnabled(false);
        }
        
        if(e.getSource() == this.telaFornecedor.getjBotaoCancelar()) {
            ControllerUtils.Ativa(true, this.telaFornecedor.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaFornecedor.getjPanelDados().getComponents());
            codigo = 0;
        }
        
        if(e.getSource() == this.telaFornecedor.getjBotaoGravar()) {
            
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome(this.telaFornecedor.getjTextFieldNome().getText());
            fornecedor.setRazaoSocial(this.telaFornecedor.getjTextFieldRazaoSocial().getText());
            fornecedor.setCnpj(this.telaFornecedor.getjFormattedTextFieldCNPJ().getText());
            fornecedor.setInscEstadual(this.telaFornecedor.getjFormattedTextFieldInscEstadual().getText());
            
            List<Cep> listaCeps = new ArrayList<>();
        
            listaCeps = CepService.Buscar();
            
            String cep = this.telaFornecedor.getjFormattedTextFieldCEP().getText();
            
            for(Cep cepDaLista : listaCeps){
                cep = cep.replaceAll("[^0-9]", "");
                if(cepDaLista.getCep().equals(cep)) {
                    fornecedor.setCep_idCep(cepDaLista.getIdCep());
                }
            }
            
            fornecedor.setCompleEndereco(this.telaFornecedor.getjTextFieldComplemento().getText());
            fornecedor.setEmail(this.telaFornecedor.getjTextFieldEmail().getText());
            fornecedor.setFone1(this.telaFornecedor.getjFormattedTextFieldTelefone1().getText());
            fornecedor.setFone2(this.telaFornecedor.getjFormattedTextFieldTelefone2().getText());
            fornecedor.setObservacao(this.telaFornecedor.getjTextFieldObservacao().getText());
            
            
            if(codigo == 0) {
                FornecedorService.Incluir(fornecedor);
            } else {
                fornecedor.setId(Integer.parseInt(this.telaFornecedor.getjTextFieldID().getText()));
                FornecedorService.Atualizar(fornecedor);
                codigo = 0;
            }
            
            ControllerUtils.Ativa(true, this.telaFornecedor.getjPanelBotoes().getComponents());
            ControllerUtils.LimpaEstadoComponentes(false, this.telaFornecedor.getjPanelDados().getComponents());
        }
        
        if(e.getSource() == this.telaFornecedor.getjBotaoBuscar()) {
            codigo = 0;
            TelaBuscaFornecedor buscaFornecedor = new TelaBuscaFornecedor(null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(buscaFornecedor);
            buscaFornecedor.setVisible(true);
            
             if(codigo != 0){
                ControllerUtils.Ativa(false, this.telaFornecedor.getjPanelBotoes().getComponents());
                ControllerUtils.LimpaEstadoComponentes(true, this.telaFornecedor.getjPanelDados().getComponents());
                Fornecedor fornecedor = FornecedorService.Buscar(codigo);
                this.telaFornecedor.getjTextFieldID().setText(fornecedor.getId() + "");
                this.telaFornecedor.getjTextFieldNome().setText(fornecedor.getNome());
                this.telaFornecedor.getjTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial());
                this.telaFornecedor.getjFormattedTextFieldCNPJ().setText(fornecedor.getCnpj());
                this.telaFornecedor.getjFormattedTextFieldInscEstadual().setText(fornecedor.getInscEstadual());
                
                Cep cep = CepService.Buscar(fornecedor.getCep_idCep());
                this.telaFornecedor.getjFormattedTextFieldCEP().setText(cep.getCep());
                
                this.telaFornecedor.getjTextFieldComplemento().setText(fornecedor.getCompleEndereco());
                this.telaFornecedor.getjTextFieldEmail().setText(fornecedor.getEmail());
                this.telaFornecedor.getjFormattedTextFieldTelefone1().setText(fornecedor.getFone1());
                this.telaFornecedor.getjFormattedTextFieldTelefone2().setText(fornecedor.getFone2());
                this.telaFornecedor.getjTextFieldObservacao().setText(fornecedor.getObservacao());
                
                this.telaFornecedor.getjTextFieldID().setEnabled(false);
            }
        }
        
        if(e.getSource() == this.telaFornecedor.getjBotaoSair()) {
            this.telaFornecedor.dispose();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent d) {
       ControllerUtils.checarCEP(
            this.telaFornecedor.getjFormattedTextFieldCEP().getText(),
            this.telaFornecedor.getjFormattedTextFieldCEP(),
            this.telaFornecedor.getjTextFieldCidade(),
            this.telaFornecedor.getjTextFieldBairro(),
            this.telaFornecedor.getjTextFieldLogradouro()
       );
    }

    @Override
    public void removeUpdate(DocumentEvent d) {
        ControllerUtils.checarCEP(
            this.telaFornecedor.getjFormattedTextFieldCEP().getText(),
            this.telaFornecedor.getjFormattedTextFieldCEP(),
            this.telaFornecedor.getjTextFieldCidade(),
            this.telaFornecedor.getjTextFieldBairro(),
            this.telaFornecedor.getjTextFieldLogradouro()
       );
    }

    @Override
    public void changedUpdate(DocumentEvent d) {}
}
